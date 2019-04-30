package com.xue.song.ffmpeg;

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
    }
    /**
     * 输入
     * 输出
     * @param input
     * @param ouput
     */
    public static native void doOutput(String input,String ouput);
}
