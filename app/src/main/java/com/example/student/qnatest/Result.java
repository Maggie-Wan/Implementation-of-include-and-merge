package com.example.student.qnatest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView ans1;
    private TextView ans2;
    private TextView ans3;

    private String text1;
    private String text2;
    private String text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initTextView();
        setAnswer();
    }


    public void initTextView() {
        ans1 = (TextView) findViewById(R.id.ans1);
        ans2 = (TextView) findViewById(R.id.ans2);
        ans3 = (TextView) findViewById(R.id.ans3);

        text1 = getIntent().getStringExtra("a1");
        text2 = getIntent().getStringExtra("a2");
        text3 = getIntent().getStringExtra("a3");
    }

    //顯示作答紀錄與做答結果
    private void setAnswer() {
        if (text1.equals("味覺")) {
            ans1.setText("1." + text1 + "(恭喜您答對了!)");
        } else {
            ans1.setTextColor(0xFFFF0000);
            ans1.setText("1." + text1 + "(正確答案為:味覺)");
        }
        if (text2.equals("肝")) {
            ans2.setText("2." + text2 + "(恭喜您答對了!)");
        } else {
            ans2.setTextColor(0xFFFF0000);
            ans2.setText("2." + text2 + "(正確答案為:肝臟)");
        }
        if (text3.equals("血小板")) {
            ans3.setText("3." + text3 + "(恭喜您答對了!)");
        } else {
            ans3.setTextColor(0xFFFF0000);
            ans3.setText("3." + text3 + "(正確答案為:血小板)");
        }
    }

    public void back(View view) {
        Intent in = new Intent();
        in.setClass(this, MainActivity.class);
        startActivity(in);
    }
}
