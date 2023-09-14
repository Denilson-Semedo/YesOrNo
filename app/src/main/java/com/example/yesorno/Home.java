package com.example.yesorno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        LinearLayout background = findViewById(R.id.background);
        color = 1;

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (color == 1){
                    background.setBackgroundColor(getResources().getColor(R.color.red));
                    color = 0;
                } else {
                    background.setBackgroundColor(getResources().getColor(R.color.green));
                    color = 1;
                }

            }
        });
    }
}