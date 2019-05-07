package com.example.student.qnatest;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class q2 extends AppCompatActivity {

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
        no.setText("Q2");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            q.setText(Html.fromHtml(getString(R.string.question2),Html.FROM_HTML_MODE_LEGACY));
            r1.setText(Html.fromHtml(getString(R.string.q2selection1),Html.FROM_HTML_MODE_LEGACY));
            r2.setText(Html.fromHtml(getString(R.string.q2selection2),Html.FROM_HTML_MODE_LEGACY));
            r3.setText(Html.fromHtml(getString(R.string.q2selection3),Html.FROM_HTML_MODE_LEGACY));
            r1.setTag(Html.fromHtml(getString(R.string.q2selection1),Html.FROM_HTML_MODE_LEGACY));
            r2.setTag(Html.fromHtml(getString(R.string.q2selection2),Html.FROM_HTML_MODE_LEGACY));
            r3.setTag(Html.fromHtml(getString(R.string.q2selection3),Html.FROM_HTML_MODE_LEGACY));
        }else{
            q.setText(Html.fromHtml(getString(R.string.question2)));
            r1.setText(Html.fromHtml(getString(R.string.q2selection1)));
            r2.setText(Html.fromHtml(getString(R.string.q2selection2)));
            r3.setText(Html.fromHtml(getString(R.string.q2selection3)));
            r1.setTag(Html.fromHtml(getString(R.string.q2selection1)));
            r2.setTag(Html.fromHtml(getString(R.string.q2selection2)));
            r3.setTag(Html.fromHtml(getString(R.string.q2selection3)));
        }

    }

    public void next(View next){
        Intent in = new Intent();
        in.setClass(this, q3.class);
        in.putExtra("a2",myanswer);
        in.putExtra("a1",getIntent().getStringExtra("a1"));
        startActivity(in);
    }

    //用這個做法就可以不用if或switch去判斷哪個按鈕被點選，只要被點的那個就會抓自己的tag
    //這邊不能用getText()，因為View下面沒有這個method
    public void click(View view){
        myanswer=view.getTag().toString();
        System.out.println(myanswer);
    }

}
