package com.example.demo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        intent.setClass(this, SecondActivity.class);
        startActivity(intent);
    }

    private static final int PHONE_PERMISSION_CHECK = 9999;

    public void doCall(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "permission not set", Toast.LENGTH_LONG).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {
                showPromptDialog();
            } else {
                askForPermission();
            }
        } else {
            callAction();
        }
    }

    private void askForPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE},
                PHONE_PERMISSION_CHECK);
    }

    private void showPromptDialog() {
        new AlertDialog.Builder(this).setTitle("Ask call phone permission")
                .setMessage("for verification ID")
                .setPositiveButton("OK", (d, w) -> askForPermission())
                .setNegativeButton("No", (d, w) -> finish())
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PHONE_PERMISSION_CHECK:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callAction();
                } else {
                    TextView textView = findViewById(R.id.textView1);
                    textView.setText("oops");
                }
        }
    }

    private void callAction() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:022222222"));
        try {
            startActivity(intent);
        } catch (SecurityException se) {
            TextView textView = findViewById(R.id.textView1);
            textView.setText(se.getMessage());
        }
    }
}