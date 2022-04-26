package com.example.demo3;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Bundle bundle = getIntent().getExtras();
        String id1String = bundle.getString(MainActivity.ID1);
        Button button1 = findViewById(R.id.button1);
        button1.setText(id1String);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new MyClickListener());
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new OuterClickListener(this));
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,
                        "button5 clicked", Toast.LENGTH_LONG).show();
            }
        });
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener((v) -> {
            Toast.makeText(this, "button6 clicked",
                    Toast.LENGTH_LONG).show();
        });
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener((v) ->
                Toast.makeText(this, "button7", Toast.LENGTH_LONG).show());
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(v ->
                Toast.makeText(this, "button8", Toast.LENGTH_LONG).show());
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(v ->
                v.setBackgroundColor(Color.argb(255, 128, 255, 128)));

    }

    @Override
    public void onClick(View view) {
        String message = "";
        switch (view.getId()) {
            case R.id.button1:
                message = "button1";
                break;
            case R.id.button2:
                message = "button2";
                break;
        }
        Toast.makeText(this, String.format("%s clicked", message), Toast.LENGTH_LONG).show();
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(SecondActivity.this,"button3 clicked", Toast.LENGTH_LONG).show();
        }
    }
}
