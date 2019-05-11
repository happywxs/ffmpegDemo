package com.xue.song.ffmpeg;

import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDecode = findViewById(R.id.btn_deoode);
       // final FrameLayout fl_content= findViewById(R.id.fl_content);
     //   LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //   final FrameLayout vedioView= (FrameLayout) inflater.inflate(R.layout.viedio,null);
     //   final VedioView vedioView=new VedioView(MainActivity.this);
     //   vedioView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
   //     vedioView.setBackgroundColor(Color.YELLOW);
        final String root = Environment.getExternalStorageDirectory().getAbsolutePath();
       final VedioView vedioView= findViewById(R.id.vedio);
        btnDecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
                rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE).observeOn(Schedulers.io()).subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            //fl_content.removeAllViews();
                         //   fl_content.addView(vedioView);
                            String input = root + "/vedio.mp4";
                            Surface surface= vedioView.getHolder().getSurface();
                            FPlayer.doOutput(input,surface);
                        }
                    }
                });
            }
        });

    }
}
