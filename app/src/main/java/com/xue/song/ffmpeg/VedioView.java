package com.xue.song.ffmpeg;

import android.Manifest;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class VedioView extends SurfaceView implements SurfaceHolder.Callback {
    private Context context;
    public VedioView(Context context) {
        super(context);
        this.context=context;

    }

    public VedioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public VedioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        holder.setFormat(PixelFormat.RGBA_8888);
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        String input = root + "/vedio.mp4";
        String out = root + "/vedio.yuv";
        FPlayer.doOutput(input, holder.getSurface());
       // FPlayer.createSurface(holder.getSurface());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        getHolder().addCallback(VedioView.this);
    }

    public void start(){
        getHolder().addCallback(this);
    }
}
