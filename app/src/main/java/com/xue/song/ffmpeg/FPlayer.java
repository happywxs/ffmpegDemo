package com.xue.song.ffmpeg;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
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
     * 创建AudioTrack  供 jni调用
     * @return
     */
    public static AudioTrack createAudioTraker(){
        int sampleRateInHz = 44100;
        int channelConfig = AudioFormat.CHANNEL_OUT_STEREO;
        int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
        int minBufferSize = AudioTrack.getMinBufferSize(sampleRateInHz,
                channelConfig, audioFormat);
        AudioTrack audioTrack=new AudioTrack(AudioManager.STREAM_MUSIC,// 指定流的类型
                sampleRateInHz,// 设置音频数据的采样率 32k，如果是44.1k就是44100
                channelConfig,// 设置输出声道为双声道立体声，而CHANNEL_OUT_MONO类型是单声道
                audioFormat,// 设置音频数据块是8位还是16位，这里设置为16位。好像现在绝大多数的音频都是16位的了
                minBufferSize,
                AudioTrack.MODE_STREAM);// 设置模式类型，在这里设置为流类型，另外一种MODE_STATIC貌似没有什么效果// audio.play(); // 启动音频设备，下面就可以真正开始音频数据的播放了
       // audioTrack.play();// 启动音频设备，下面就可以真正开始音频数据的播放了
      //  audioTrack.write()
        return audioTrack;

    }

    /**
     * 输入
     * 输出
     * @param input
     *
     */
    public static native void doOutput(String input,Surface surface);

    /**
     * 声音输出
     * @param input
     */

    public static native void doOutputAudio(String input);

    /**
     * @param surface
     */
    public static native void createSurface(Surface surface);

    public static native void resumePlayer();

    public static native void pausePlayer();

    public static native void stopPlayer();
}
