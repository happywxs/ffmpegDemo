package com.xue.song.ffmpeg;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

public class VedioView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private Context context;
   // VideoView
    boolean isPlaying =false;

    public VedioView(Context context) {
        super(context);
        this.context = context;
        //   getHolder().addCallback(this);

    }

    public VedioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        Log.i("wang","===vedioView==create");
        getHolder().addCallback(this);
    }

    public VedioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        // getHolder().addCallback(this);
    }


    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        Log.i("wang", "===surface===create");
        if(!isPlaying){
            new Thread(this).start();
        }
       /* String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        String input = root + "/vedio.mp4";
        String out = root + "/vedio.yuv";
        getHolder().setFormat(PixelFormat.RGBA_8888);//设置格式zz
        FPlayer.doOutput(input, getHolder().getSurface());*/
    }


    // FPlayer.createSurface(holder.getSurface());

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }


    @Override
    public void run() {
        isPlaying=true;
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        String input = root + "/vedio.mp4";
        String out = root + "/vedio.yuv";
        getHolder().setFormat(PixelFormat.RGBA_8888);//设置格式zz
      //  FPlayer.doOutput(input, getHolder().getSurface());
          FPlayer.doOutputAudio(input);
    }
}
