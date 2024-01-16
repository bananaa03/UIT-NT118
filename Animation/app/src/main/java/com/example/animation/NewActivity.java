package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent iNewActivity_back = new Intent(NewActivity.this, MainActivity.class);
            startActivity(iNewActivity_back);
            createPendingResult(R.anim.right_out,iNewActivity_back,R.layout.activity_main);
            ActivityOptionsCompat.makeCustomAnimation(NewActivity.this, R.anim.right_in, R.anim.right_out);
            finish();
        });
    }
}