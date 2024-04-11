package com.example.happify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class GuidedBreathing extends AppCompatActivity {
    TextView countdownTimer;
    CountDownTimer timer;
    Button start;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guided_breathing);

        countdownTimer=findViewById(R.id.displayCount);
        start=findViewById(R.id.startCountBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime();
            }
        });
    }

    private void startTime() {
        timer=new CountDownTimer(10000, 10000) {

            @Override
            public void onTick(long l) {
                long hours=(l/1000)/3600;
                long minutes=((l/1000)%3600)/60;
                long seconds=(l/1000)%60;
                String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d:%02d", hours,minutes,seconds);
                countdownTimer.setText(timeFormatted);

            }

            @Override
            public void onFinish() {
                countdownTimer.setText("00:00:00");

            }
        }.start();
    }

    public void onBackPressedGB(View v){
        finish();
    }
}