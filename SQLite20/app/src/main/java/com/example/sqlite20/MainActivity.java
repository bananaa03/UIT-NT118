package com.example.sqlite20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtId, edtName, edtScore;
    Button btnAdd, btnDelete, btnEdit, btnSave;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId=findViewById(R.id.edtId);
        edtName=findViewById(R.id.edtName);
        edtScore=findViewById(R.id.edtScore);
        btnAdd=findViewById(R.id.btnAdd);
        btnDelete=findViewById(R.id.btnDelete);
        btnEdit=findViewById(R.id.btnEdit);
        btnSave=findViewById(R.id.btnSave);

        lv =findViewById(R.id.listView);
        arrayList= new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(myadapter);
        //Tạo và mở cơ sở dử liệu
        mydatabase = openOrCreateDatabase("QLSV.db", MODE_PRIVATE, null);
        //Tạo Table chứa dữ liệu
        try {
            String sql ="CREATE TABLE tbllop(malop TEXT primary key,tenlop TEXT, siso INTEGER)";
            mydatabase.execSQL(sql);
        }
        catch (Exception e)
        {
            Log.e("Error","Table đã tồn tại");
        }

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Cursor cursor = mydatabase.rawQuery("SELECT * FROM "+"tbllop", null);
            cursor.moveToPosition(position);
            edtId.setText(cursor.getString(0));
            edtName.setText(cursor.getString(1));
            edtScore.setText(cursor.getString(2));
            cursor.close();
        });

        btnAdd.setOnClickListener(v -> {
            String malop = edtId.getText().toString();
            String tenlop= edtName.getText().toString();
            int siso= Integer.parseInt(edtScore.getText().toString());

            ContentValues myvalue= new ContentValues();
            myvalue.put("malop", malop);
            myvalue.put("tenlop", tenlop);
            myvalue.put("siso", siso);
            String msg="";
            if(mydatabase.insert("tbllop", null, myvalue) == -1)
            {
                msg = "FAIL TO INSERT RECORD!";
            } else{
                msg="Thêm thành công!";
                edtId.setText("");
                edtName.setText("");
                edtScore.setText("");
            }
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
        btnDelete.setOnClickListener(v -> {
            String malop=edtId.getText().toString();
            int n= mydatabase.delete("tbllop", "malop = ?",new String[]{malop});
            String msg="";
            if(n==0){
                msg="No record to Update";
            }else
                msg="Xóa thành công!";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
        btnEdit.setOnClickListener(v -> {
            int siso= Integer.parseInt(edtScore.getText().toString());
            String tenlop=edtName.getText().toString();
            String malop=edtId.getText().toString();
            ContentValues myvalue = new ContentValues();
            myvalue.put("siso", siso);
            myvalue.put("tenlop", tenlop);
            int n= mydatabase.update("tbllop", myvalue, "malop = ?", new String[]{malop});
            String msg="";
            if(n == 0){
                msg = "No record to Update";
            }
            else {
                msg = "Update thành công!";
                edtId.setText("");
                edtName.setText("");
                edtScore.setText("");
            }
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
        btnSave.setOnClickListener(v -> {
            arrayList.clear();
            Cursor c = mydatabase.query("tbllop", null,null,null,null,null, null);
            c.moveToNext();
            String data="";
            while (c.isAfterLast() == false)
            {
                data=c.getString(0)+ " - "+c.getString(1)+" - "+c.getString(2);
                c.moveToNext();
                arrayList.add(data);
            }
            c.close();
            myadapter.notifyDataSetChanged();
        });
    }
}