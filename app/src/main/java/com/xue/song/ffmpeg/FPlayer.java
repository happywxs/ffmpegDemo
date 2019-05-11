package com.xue.song.ffmpeg;

import android.view.Surface;

public class FPlayer {
    static {
      System.loadLibrary("avutil");
      System.loadLibrary("swresample");
      System.loadLibrary("avcodec");
      System.loadLibrary("avformat");
      System.loadLibrary("swscale");
      System.loadLibrary("postproc");
      System.loadLibrary("avfilter");
      System.loadLibrary("avdevice");
      System.loadLibrary("myffpeg");
    }
    /**
     * 输入
     * 输出
     * @param input
     * @param ouput
     */
    public static native void doOutput(String input,Surface surface);

    /**
     * @param surface
     */
    public static native void createSurface(Surface surface);

    public static native void resumePlayer();

    public static native void pausePlayer();

    public static native void stopPlayer();
}
