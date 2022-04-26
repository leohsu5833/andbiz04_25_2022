package com.example.demo3;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class OuterClickListener implements View.OnClickListener {
    private Context context;
    public OuterClickListener(SecondActivity secondActivity) {
        context = secondActivity;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "other click listener", Toast.LENGTH_LONG).show();
    }
}
