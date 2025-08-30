package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceDetectListConf;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.model.BDFaceSDKConfig;
import com.baidu.idl.main.facesdk.utils.FileUitls;
import java.util.concurrent.locks.ReentrantLock;

public class FaceDetect {
    /* access modifiers changed from: private */
    public static final String TAG = "FaceDetect";
    /* access modifiers changed from: private */
    public BDFaceInstance bdFaceInstance;
    private ReentrantLock lock = null;

    public FaceDetect(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance != null) {
            this.bdFaceInstance = bDFaceInstance;
            this.lock = new ReentrantLock();
        }
    }

    /* access modifiers changed from: private */
    public native int nativeAlignModelInit(long j, int i, int i2, byte[] bArr);

    /* access modifiers changed from: private */
    public native int nativeAttributeModelInit(long j, byte[] bArr);

    private native BDFaceImageInstance nativeCropFace(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    private native FaceInfo[] nativeDetect(long j, int i, int i2, BDFaceImageInstance bDFaceImageInstance);

    /* access modifiers changed from: private */
    public native int nativeDetectModelInit(long j, byte[] bArr, int i);

    /* access modifiers changed from: private */
    public native int nativeEmotionsModelInit(long j, byte[] bArr);

    /* access modifiers changed from: private */
    public native int nativeFaceCloseModelInit(long j, byte[] bArr, int i);

    private native FaceInfo[] nativeFastTrack(long j, int i, int i2, BDFaceImageInstance bDFaceImageInstance);

    private native FaceInfo[] nativeFlexibleDetect(long j, int i, int i2, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf);

    private native void nativeLoadConfig(long j, BDFaceSDKConfig bDFaceSDKConfig);

    /* access modifiers changed from: private */
    public native int nativeLoadTrack(long j, int i, int i2);

    /* access modifiers changed from: private */
    public native int nativeQualityModelInit(long j, byte[] bArr, int i);

    private native FaceInfo[] nativeTrack(long j, int i, BDFaceImageInstance bDFaceImageInstance);

    private native int nativeUninitModel(long j);

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (bDFaceImageInstance == null || fArr == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFace(index, bDFaceImageInstance, fArr);
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || !this.lock.tryLock()) {
            return null;
        }
        FaceInfo[] nativeDetect = nativeDetect(index, detectType.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), bDFaceImageInstance);
        this.lock.unlock();
        return nativeDetect;
    }

    public void initAttrEmo(Context context, String str, String str2, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str3 = str;
        final String str4 = str2;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i;
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str3);
                    int i2 = -1;
                    if (modelContent.length != 0) {
                        i = FaceDetect.this.nativeAttributeModelInit(index, modelContent);
                        if (i != 0) {
                            callback2.onResponse(i, "属性模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str4);
                    if (modelContent2.length == 0 || (i2 = FaceDetect.this.nativeEmotionsModelInit(index, modelContent2)) == 0) {
                        if (i == 0 || i2 == 0) {
                            callback2.onResponse(0, "属性模型加载成功");
                        } else {
                            callback2.onResponse(1, "属性模型加载失败");
                        }
                        Log.e("bdface", "FaceAttributes initModel");
                        return;
                    }
                    callback2.onResponse(i2, "情绪模型加载失败");
                }
            }
        });
    }

    public void initFaceClose(Context context, String str, String str2, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str3 = str;
        final String str4 = str2;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i;
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str3);
                    int i2 = -1;
                    if (modelContent.length != 0) {
                        i = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent, 0);
                        if (i != 0) {
                            callback2.onResponse(i, "眼睛闭合模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str4);
                    if (modelContent2.length == 0 || (i2 = FaceDetect.this.nativeFaceCloseModelInit(index, modelContent2, 1)) == 0) {
                        if (i == 0 || i2 == 0) {
                            callback2.onResponse(0, "闭眼闭嘴模型加载成功");
                        } else {
                            callback2.onResponse(1, "闭眼闭嘴模型加载失败");
                        }
                        Log.e("bdface", "FaceClose initModel");
                        return;
                    }
                    callback2.onResponse(i2, "嘴巴闭合模型加载失败");
                }
            }
        });
    }

    public void initModel(Context context, String str, String str2, String str3, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i;
                int i2;
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str4);
                    int i3 = -1;
                    if (modelContent.length != 0) {
                        i = FaceDetect.this.nativeDetectModelInit(index, modelContent, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal());
                        if (i != 0) {
                            callback2.onResponse(i, "Vis检测模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str5);
                    if (modelContent2.length != 0) {
                        int access$100 = FaceDetect.this.nativeDetectModelInit(index, modelContent2, BDFaceSDKCommon.DetectType.DETECT_NIR.ordinal());
                        if (access$100 != 0) {
                            callback2.onResponse(access$100, "Nir检测模型加载失败");
                            return;
                        }
                        i2 = access$100;
                    } else {
                        i2 = -1;
                    }
                    byte[] modelContent3 = FileUitls.getModelContent(context2, str6);
                    if (modelContent3.length == 0 || (i3 = FaceDetect.this.nativeAlignModelInit(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), modelContent3)) == 0) {
                        int access$300 = FaceDetect.this.nativeLoadTrack(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal());
                        if (access$300 != 0) {
                            callback2.onResponse(access$300, "跟踪能力加载失败");
                            return;
                        }
                        if ((i == 0 || i2 == 0) && i3 == 0) {
                            callback2.onResponse(0, "检测对齐模型加载成功");
                        } else {
                            callback2.onResponse(1, "检测对齐模型加载失败");
                        }
                        Log.e(FaceDetect.TAG, "FaceDetect initModel");
                        return;
                    }
                    callback2.onResponse(i3, "对齐模型加载失败");
                }
            }
        });
    }

    public void initQuality(Context context, String str, String str2, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str3 = str;
        final String str4 = str2;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i;
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str3);
                    int i2 = -1;
                    if (modelContent.length != 0) {
                        i = FaceDetect.this.nativeQualityModelInit(index, modelContent, BDFaceSDKCommon.FaceQualityType.BLUR.ordinal());
                        if (i != 0) {
                            callback2.onResponse(i, "模糊模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str4);
                    if (modelContent2.length == 0 || (i2 = FaceDetect.this.nativeQualityModelInit(index, modelContent2, BDFaceSDKCommon.FaceQualityType.OCCLUSION.ordinal())) == 0) {
                        if (i == 0 || i2 == 0) {
                            callback2.onResponse(0, "质量模型加载成功");
                        } else {
                            callback2.onResponse(1, "质量模型加载失败");
                        }
                        Log.e(FaceDetect.TAG, "FaceDetect initQuality");
                        return;
                    }
                    callback2.onResponse(i2, "遮挡模型加载失败");
                }
            }
        });
    }

    public void loadConfig(BDFaceSDKConfig bDFaceSDKConfig) {
        BDFaceInstance bDFaceInstance = this.bdFaceInstance;
        if (bDFaceInstance != null) {
            long index = bDFaceInstance.getIndex();
            if (index != 0) {
                nativeLoadConfig(index, bDFaceSDKConfig);
            }
        }
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || !this.lock.tryLock()) {
            return null;
        }
        FaceInfo[] nativeTrack = nativeTrack(index, detectType.ordinal(), bDFaceImageInstance);
        this.lock.unlock();
        return nativeTrack;
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }

    public void initModel(Context context, String str, String str2, BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str3 = str;
        final BDFaceSDKCommon.DetectType detectType2 = detectType;
        final String str4 = str2;
        final BDFaceSDKCommon.AlignType alignType2 = alignType;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i;
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceDetect.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str3);
                    int i2 = -1;
                    if (modelContent.length != 0) {
                        i = FaceDetect.this.nativeDetectModelInit(index, modelContent, detectType2.ordinal());
                        if (i != 0) {
                            callback2.onResponse(i, "检测模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str4);
                    if (modelContent2.length == 0 || (i2 = FaceDetect.this.nativeAlignModelInit(index, detectType2.ordinal(), alignType2.ordinal(), modelContent2)) == 0) {
                        int access$300 = FaceDetect.this.nativeLoadTrack(index, detectType2.ordinal(), alignType2.ordinal());
                        if (access$300 != 0) {
                            callback2.onResponse(access$300, "跟踪能力加载失败");
                            return;
                        }
                        if (i == 0 && i2 == 0) {
                            callback2.onResponse(0, "检测对齐模型加载成功");
                        } else {
                            callback2.onResponse(1, "检测对齐模型加载失败");
                        }
                        Log.e(FaceDetect.TAG, "FaceDetect initModel");
                        return;
                    }
                    callback2.onResponse(i2, "对齐模型加载失败");
                }
            }
        });
    }

    public FaceDetect() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
        this.lock = new ReentrantLock();
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance) {
        if (detectType == null || bDFaceImageInstance == null || alignType == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeFastTrack(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance);
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf) {
        if (detectType == null || bDFaceImageInstance == null || alignType == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0 || !this.lock.tryLock()) {
            return null;
        }
        FaceInfo[] nativeFlexibleDetect = nativeFlexibleDetect(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance, faceInfoArr, bDFaceDetectListConf);
        this.lock.unlock();
        return nativeFlexibleDetect;
    }
}
