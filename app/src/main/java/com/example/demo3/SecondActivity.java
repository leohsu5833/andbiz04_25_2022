package com.example.demo3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Bundle bundle = getIntent().getExtras();
        String id1String = bundle.getString(MainActivity.ID1);
        Button button1 = findViewById(R.id.button1);
        button1.setText(id1String);
    }
}
