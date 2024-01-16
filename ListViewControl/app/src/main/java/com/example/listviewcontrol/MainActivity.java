package com.example.listviewcontrol;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvPerson = (ListView)
                findViewById(R.id.lvperson);

        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);

        lvPerson.setAdapter(adapter);
        final TextView tvSelection=(TextView) findViewById(R.id.txtselection);

        lvPerson.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        tvSelection.setText("position :" + arg2 + "; value =" + arr[arg2]);
                    }
                });

    }
}
