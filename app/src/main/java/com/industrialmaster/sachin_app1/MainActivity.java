package com.industrialmaster.sachin_app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox ckb1;
    Button btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent(MainActivity.this,backMusic.class);
        startService(intent1);

        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        ckb1 = (CheckBox) findViewById(R.id.ckb1);

        ckb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ckb1.isChecked()){
                    Intent intent1 = new Intent(MainActivity.this,backMusic.class);
                    stopService(intent1);
                    ckb1.setText("Unmute");
                }
                else {
                    Intent intent1 = new Intent(MainActivity.this,backMusic.class);
                    startService(intent1);
                    ckb1.setText("Mute");
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,backMusic.class);
                stopService(intent1);

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}
