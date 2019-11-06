package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    EditText h;                //宣告全域變數
    EditText w;                //宣告全域變數

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = (EditText)findViewById(R.id.et1);                            // 取得身高物件
        w = (EditText)findViewById(R.id.et2);                           // 取得體重物件
        Button submit = (Button)findViewById(R.id.button1); // 取得按鈕物件


        // 按下按鈕 觸發事件
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行
                if ( !("".equals(h.getText().toString())
                        || "".equals(w.getText().toString())) )
                {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("height",h.getText().toString());
                    bundle.putString("width",w.getText().toString());
                    intent.putExtras(bundle);   // 記得put進去，不然資料不會帶過去哦

                    startActivity(intent);
                }
            }
        });

    }
}
