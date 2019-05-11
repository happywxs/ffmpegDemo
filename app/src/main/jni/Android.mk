# 构建系统提供的宏函数 my-dir 将返回当前目录（包含 Android.mk 文件本身的目录）的路径，基本上是固定的，不需要去动
LOCAL_PATH := $(call my-dir)
#libavutil.so
include $(CLEAR_VARS)
LOCAL_MODULE := avutil
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libavutil.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

#libswresample.so
include $(CLEAR_VARS)
LOCAL_MODULE := swresample
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libswresample.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

#libavcodec.so
include $(CLEAR_VARS)
LOCAL_MODULE :=avcodec
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libavcodec.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

#libavformat.so
include $(CLEAR_VARS)
LOCAL_MODULE :=avformat
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libavformat.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

#libswscale.so
include $(CLEAR_VARS)
LOCAL_MODULE :=swscale
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libswscale.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

#libpostproc.so
include $(CLEAR_VARS)
LOCAL_MODULE :=postproc
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libpostproc.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

#libavfilter.so
include $(CLEAR_VARS)
LOCAL_MODULE :=avfilter
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libavfilter.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

#libavdevice.so
include $(CLEAR_VARS)
LOCAL_MODULE :=avdevice
LOCAL_SRC_FILES :=$(TARGET_ARCH_ABI)/libavdevice.so
TARGET_PRELINK_MODULES := false
include $(PREBUILT_SHARED_LIBRARY)

# 会清除很多 LOCAL_XXX 变量，不会清除 LOCAL_PATH，基本上是固定的，不需要去动
include $(CLEAR_VARS)
# 需要构建模块的名称，会自动生成相应的 libNDKSample.so 文件，每个模块名称必须唯一，且不含任何空格
LOCAL_MODULE := myffpeg
# 包含要构建到模块中的 C 或 C++ 源文件列表
LOCAL_SRC_FILES :=com_xue_song_ffmpeg_FPlayer.c
#链接动态库
LOCAL_SHARED_LIBRARIES := avutil swresample avcodec avformat swscale postproc avfilter avdevice
# 指定这个模块里会用到哪些原生 API，详见：https://developer.android.google.cn/ndk/guides/stable_apis.html
LOCAL_LDLIBS := -llog
LOCAL_LDLIBS += -landroid -lz -lm
LOCAL_CPP_FEATURES := exceptions
# 帮助系统将所有内容连接到一起，固定的，不需要去动
include $(BUILD_SHARED_LIBRARY)