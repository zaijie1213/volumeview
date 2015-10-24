package com.example.szg.volumeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.autonavi.map.voice.widget.VolumeAnimateView;


public class MainActivity extends AppCompatActivity {
    VolumeAnimateView volumeAnimateView;
    SeekBar seekBar;
    boolean play = false;
    private int cur_progress;
    WkVolumeView mWkVolumeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volumeAnimateView = (VolumeAnimateView) findViewById(R.id.anim);
        seekBar = (SeekBar) findViewById(R.id.test);
        mWkVolumeView= (WkVolumeView) findViewById(R.id.volume_view);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                volumeAnimateView.a(progress);
//                cur_progress=progress;
//                mWkVolumeView.start(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                volumeAnimateView.a();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                volumeAnimateView.b();
//                volumeAnimateView.a(cur_progress);
            }
        });
    }

    public void start(View view) {
        mWkVolumeView.start();
        if (play) {
            volumeAnimateView.b();
            play = false;
        } else {
            volumeAnimateView.a();
            play = true;
        }
    }
}
