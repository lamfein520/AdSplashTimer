package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

//广告页面,启动页
public class SplashActivity extends AppCompatActivity {
    Button tvSkip;
    TextView tvTime;
    private static final String TAG = "SplashActivity";
    private int time = 10;
    private Handler handler = new Handler();
    private Runnable runnable;
    private Timer timer = new Timer();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //打印

        Log.i(TAG,"onCreate");
        setContentView(R.layout.activity_splash);
        //绑定textiew和button
        tvSkip = findViewById(R.id.skip);
        tvTime = findViewById(R.id.countdown);
        //tvTime每隔1秒减少1,直到为0
        timer.schedule(task, 1000, 1000);
        handler=new Handler();
        handler.postDelayed(runnable = () -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 10000);




        //点击跳过按钮直接跳转到主页面
        tvSkip.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        });
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(() -> {
                time--;
                tvTime.setText(time+"s");
                if (time < 0) {
                    timer.cancel();
                    tvTime.setVisibility(TextView.GONE);

                }
            });
        }
    };
    //touch事件
    @Override
    public boolean onTouchEvent(android.view.MotionEvent event) {
        Log.i("test3","onTouchEvent",new Exception());
        return super.onTouchEvent(event);
    }
    //dispatchTouchEvent事件
    @Override
    public boolean dispatchTouchEvent(android.view.MotionEvent ev) {
        Log.i(TAG,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }
}
