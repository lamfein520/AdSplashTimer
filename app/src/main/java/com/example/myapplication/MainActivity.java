package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private static final String TAG = "MainActivity";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"MainActivity");
        //绑定button
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.example.myapplication", "com.example.myapplication.SplashActivity"));
            startActivity(intent);
        });

    }

    //touch
    @Override
    public boolean onTouchEvent(android.view.MotionEvent event) {
        Log.i("test3","onTouchEvent",new Exception());
        return super.onTouchEvent(event);
    }

}
