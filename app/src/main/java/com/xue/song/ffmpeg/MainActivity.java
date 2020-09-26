package com.xue.song.ffmpeg;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDecode = findViewById(R.id.btn_deoode);
        Button btnMixAudio = findViewById(R.id.btn_mix_audio);
        // final FrameLayout fl_content= findViewById(R.id.fl_content);
        //   LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //   final FrameLayout vedioView= (FrameLayout) inflater.inflate(R.layout.activity_viedio,null);
        //   final VedioView vedioView=new VedioView(VedioActivity.this);
        //   vedioView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        //     vedioView.setBackgroundColor(Color.YELLOW);
        final String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        final String[] audioPath = new String[]{
                root + "/Music/" + "D-Push-3.wav",
                /*  root+"/Music/"+"D-Push-2-3.wav",
                  root+"/Music/"+"D-Push-4.wav",*/
                root + "/Music/" + "D-Push-4.wav"
        };

        btnDecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
                rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            Intent intent = new Intent(MainActivity.this, VedioActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });

        btnMixAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
                rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            FPlayer.mixAudio(audioPath, 2);
                        }
                    }
                });
            }
        });

    }
}
