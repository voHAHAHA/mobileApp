package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TrafficLight extends AppCompatActivity {
    private LinearLayout linearLayout;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private Button btnMain;
    private boolean startAndStop = true;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_light);

        linearLayout = findViewById(R.id.linearLayout);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        btnMain = findViewById(R.id.button);

    }
    public void onClickStart(View view) {
        if (!startAndStop) {
            startAndStop = true;
            btnMain.setText("Stop");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (startAndStop) {
                        count++;
                        switch(count) {
                            case 1:
                                linearLayout.setBackgroundColor(getColor(R.color.Green));
                                linearLayout2.setBackgroundColor(getColor(R.color.black));
                                linearLayout3.setBackgroundColor(getColor(R.color.black ));
                                break;
                            case 2:
                                linearLayout.setBackgroundColor(getColor(R.color.black));
                                linearLayout2.setBackgroundColor(getColor(R.color.Yellow));
                                linearLayout3.setBackgroundColor(getColor(R.color.black ));
                                break;
                            case 3:
                                linearLayout.setBackgroundColor(getColor(R.color.black));
                                linearLayout2.setBackgroundColor(getColor(R.color.black));
                                linearLayout3.setBackgroundColor(getColor(R.color.Red ));
                                count = 0;
                                break;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();
        } else {
            startAndStop = false;
            btnMain.setText("Start");
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        startAndStop = false;
    }
}