package com.example.student.qnatest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class q1 extends AppCompatActivity {

    //用include/merge只要設定一次id

    private TextView no;
    private TextView q;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private CharSequence myanswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);
        init();
    }

    private void init(){
        no=(TextView)findViewById(R.id.no);
        q=(TextView)findViewById(R.id.q);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        no.setText("Q1");

        //android版本是N(api23)執行Html.fromHtml()會閃退，所以要判斷android版本
        //api 23以下使用Html.fromHtml(String);
        //api 24以上使用Html.fromHtml(String,int);已棄用Html.fromHtml(String);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { //如果目前執行的android版本是N以上
            q.setText(Html.fromHtml(getString(R.string.question1),Html.FROM_HTML_MODE_LEGACY));
            r1.setText(Html.fromHtml(getString(R.string.q1selection1),Html.FROM_HTML_MODE_LEGACY));
            r2.setText(Html.fromHtml(getString(R.string.q1selection2),Html.FROM_HTML_MODE_LEGACY));
            r3.setText(Html.fromHtml(getString(R.string.q1selection3),Html.FROM_HTML_MODE_LEGACY));

            r1.setTag(Html.fromHtml(getString(R.string.q1selection1),Html.FROM_HTML_MODE_LEGACY));
            r2.setTag(Html.fromHtml(getString(R.string.q1selection2),Html.FROM_HTML_MODE_LEGACY));
            r3.setTag(Html.fromHtml(getString(R.string.q1selection3),Html.FROM_HTML_MODE_LEGACY));
        }else{
            q.setText(Html.fromHtml(getString(R.string.question1)));
            r1.setText(Html.fromHtml(getString(R.string.q1selection1)));
            r2.setText(Html.fromHtml(getString(R.string.q1selection2)));
            r3.setText(Html.fromHtml(getString(R.string.q1selection3)));

            //因為後面要抓tag,所以這邊要設定每個radio button的tag，但因為radio button的layout是共用的，所以要用javacode分別設定
            //因為在strings resources中有html語法，所以要再轉換一次
            r1.setTag(Html.fromHtml(getString(R.string.q1selection1)));
            r2.setTag(Html.fromHtml(getString(R.string.q1selection2)));
            r3.setTag(Html.fromHtml(getString(R.string.q1selection3)));
        }

    }
    //按下next時，帶入Button next
    public void next(View next){
        Intent in = new Intent();
        in.setClass(this, q2.class);
        in.putExtra("a1",myanswer);
        startActivity(in);
    }

    //用這個做法就可以不用if或switch去判斷哪個按鈕被點選，只要被點的那個就會抓自己的tag
    //這邊不能用getText()，因為View下面沒有這個method
    public void click(View view){
        myanswer=view.getTag().toString();
        System.out.println(myanswer);
    }

}
