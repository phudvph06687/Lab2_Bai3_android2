package com.example.proz.lab2_bai3_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvOutput;
    public static final String ACTION_TEST = "abc";
    private EditText edt_nhap;
    private Button btn_check;
    private TextView tv_thongbao;
    private String input;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_nhap = (EditText)findViewById(R.id.edt_nhap);
        btn_check = (Button)findViewById(R.id.btn_check);
        tv_thongbao = (TextView)findViewById(R.id.tv_thongbao);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = edt_nhap.getText().toString();

                if (input.length() == 9){
                    if (input.contains("MEM537128")){
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Bạn được giảm giá 10%");
                        sendBroadcast(intent);

                    }
                    else if( input.contains("MEM537129")){
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output", "BẠn được giảm giá 20%");
                        sendBroadcast(intent);
                    }
                    else  if ( input.contains("VIP537128")){
                        Intent inten = new Intent(ACTION_TEST);
                        inten.putExtra("output","Bạn được giảm giá 30%");
                        sendBroadcast(inten);
                    }
                    else  if ( input.contains("VIP537129")){
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Bạn được giảm giá 50%");
                        sendBroadcast(intent);
                    }
                    else {
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Mã giảm giá sai, vui lòng nhập lại");
                        sendBroadcast(intent);
                    }
                }
                else {
                    Intent intent = new Intent(ACTION_TEST);
                    intent.putExtra("output","Mã giảm giá gồm 9 kí tự, bạn vui lòng nhập lại");
                    sendBroadcast(intent);
                }


            }
        });
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String text = intent.getStringExtra("output");
                if (text!= null) tv_thongbao.setText(text);

            }
        };
        IntentFilter intentFilter = new IntentFilter(ACTION_TEST);
        registerReceiver(broadcastReceiver,intentFilter);
    }
}
