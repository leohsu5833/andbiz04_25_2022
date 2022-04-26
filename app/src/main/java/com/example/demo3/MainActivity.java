package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static final String ID1 = "id";
    public void doActivity(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(ID1, "54321");
        intent.putExtras(bundle);
        intent.setClass(this,SecondActivity.class);
        startActivity(intent);
    }

    public void doCall(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:022222222"));
        try {

            startActivity(intent);
        }catch (SecurityException se) {
            TextView textView = findViewById(R.id.textView1);
            textView.setText(se.getMessage());
        }
    }
}