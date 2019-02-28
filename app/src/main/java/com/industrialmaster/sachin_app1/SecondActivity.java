package com.industrialmaster.sachin_app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    EditText et1,et2,et3,et4;
    TextView tv1;

    String sname1, sname2;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn1 = (Button) findViewById(R.id.btn4);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn5);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        tv1 = (TextView) findViewById(R.id.tv1);

        sname1 = et1.getText().toString();
        sname2 = et3.getText().toString();
        num1 = Integer.parseInt(et2.getText().toString());
//        num2 = Integer.valueOf(et4.getText().toString());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(lucky_num(num1,num2));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SecondActivity.this,backMusic.class);
                stopService(intent1);

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
    public int lucky_num(int a, int b){
        int tot1 = 0, tot2 = 0;
        int tot3 = 0, tot4 = 0;
        int total;
        int[] array = {50, 62, 43, 18, 29, 80, 85, 98, 90, 72, 35, 42, 56, 66, 70, 22, 43, 88};

        while(tot2 > 9){
            tot1 = a%10 + tot1;
            tot2 = a/10;
            a = tot2;
        }
        while (tot4 > 9){
            tot3 = b%10 + tot3;
            tot4 = b/10;
            b = tot4;
        }
        total = tot2 + tot4;
        return(array[total]);
    }
}
