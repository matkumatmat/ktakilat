package com.baidu.idl.main.facesdk;

import android.content.Context;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.model.Feature;
import com.baidu.idl.main.facesdk.utils.FileUitls;
import java.util.ArrayList;
import java.util.List;

public class FaceFeature {
    /* access modifiers changed from: private */
    public static final String TAG = "FaceFeature";
    /* access modifiers changed from: private */
    public BDFaceInstance bdFaceInstance;

    public FaceFeature(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance != null) {
            this.bdFaceInstance = bDFaceInstance;
        }
    }

    private native float nativeFeature(long j, int i, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr);

    private native float nativeFeatureCompare(long j, int i, byte[] bArr, byte[] bArr2, int i2);

    /* access modifiers changed from: private */
    public native int nativeFeatureModelInit(long j, byte[] bArr, int i);

    private native ArrayList<Feature> nativeFeatureSearch(long j, byte[] bArr, int i, int i2, int i3);

    private native float nativeRGBDFeature(long j, int i, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr);

    private native int nativeUninitModel(long j);

    private native int nativefeaturePush(List<? extends Feature> list);

    public float feature(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr) {
        if (featureType == null || fArr == null || bArr == null || bDFaceImageInstance == null || fArr.length < 0) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeFeature(index, featureType.ordinal(), bDFaceImageInstance, fArr, bArr);
    }

    public float featureCompare(BDFaceSDKCommon.FeatureType featureType, byte[] bArr, byte[] bArr2, boolean z) {
        if (featureType == null || bArr == null || bArr2 == null) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeFeatureCompare(index, featureType.ordinal(), bArr, bArr2, z ? 1 : 0);
    }

    public int featurePush(List<? extends Feature> list) {
        return -1;
    }

    public float featureRGBD(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr) {
        if (featureType == null || fArr == null || bArr == null || bDFaceImageInstance == null || bDFaceImageInstance2 == null || fArr.length < 0) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeRGBDFeature(index, featureType.ordinal(), bDFaceImageInstance, bDFaceImageInstance2, fArr, bArr);
    }

    public ArrayList<Feature> featureSearch(byte[] bArr, BDFaceSDKCommon.FeatureType featureType, int i, boolean z) {
        return null;
    }

    public void initModel(Context context, String str, String str2, String str3, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str4 = str;
        final String str5 = str2;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i;
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceFeature.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str4);
                    int i2 = -1;
                    if (modelContent.length != 0) {
                        i = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                        if (i != 0) {
                            callback2.onResponse(i, "证件照识别模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str5);
                    if (modelContent2.length == 0 || (i2 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal())) == 0) {
                        if (i == 0 || i2 == 0) {
                            callback2.onResponse(0, "识别模型加载成功");
                        } else {
                            callback2.onResponse(1, "识别模型加载失败");
                        }
                        String unused = FaceFeature.TAG;
                        return;
                    }
                    callback2.onResponse(i2, "Vis 识别模型加载失败");
                }
            }
        });
    }

    public int uninitModel() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUninitModel(index);
    }

    public FaceFeature() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public void initModel(Context context, String str, String str2, String str3, String str4, Callback callback) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final Callback callback2 = callback;
        final Context context2 = context;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                if (str5.length() == 0 && str6.length() == 0 && str7.length() == 0 && str8.length() == 0) {
                    String unused = FaceFeature.TAG;
                    callback2.onResponse(1, "FaceFeature未设置模型路径");
                } else if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                } else {
                    long index = FaceFeature.this.bdFaceInstance.getIndex();
                    if (index != 0) {
                        if (str5.length() != 0) {
                            byte[] modelContent = FileUitls.getModelContent(context2, str5);
                            if (modelContent.length == 0) {
                                String unused2 = FaceFeature.TAG;
                                callback2.onResponse(-1, "证件照识别模型读取失败");
                                return;
                            }
                            int access$100 = FaceFeature.this.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                            if (access$100 != 0) {
                                String unused3 = FaceFeature.TAG;
                                callback2.onResponse(access$100, "证件照识别模型加载失败");
                                return;
                            }
                        }
                        if (str6.length() != 0) {
                            byte[] modelContent2 = FileUitls.getModelContent(context2, str6);
                            if (modelContent2.length == 0) {
                                String unused4 = FaceFeature.TAG;
                                callback2.onResponse(-1, "生活照识别模型读取失败");
                                return;
                            }
                            int access$1002 = FaceFeature.this.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal());
                            if (access$1002 != 0) {
                                String unused5 = FaceFeature.TAG;
                                callback2.onResponse(access$1002, "生活照识别模型加载失败");
                                return;
                            }
                        }
                        if (str7.length() != 0) {
                            byte[] modelContent3 = FileUitls.getModelContent(context2, str7);
                            if (modelContent3.length == 0) {
                                String unused6 = FaceFeature.TAG;
                                callback2.onResponse(-1, "Nir识别模型读取失败");
                                return;
                            }
                            int access$1003 = FaceFeature.this.nativeFeatureModelInit(index, modelContent3, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_NIR.ordinal());
                            if (access$1003 != 0) {
                                String unused7 = FaceFeature.TAG;
                                callback2.onResponse(access$1003, "Nir识别模型加载失败");
                                return;
                            }
                        }
                        if (str8.length() != 0) {
                            byte[] modelContent4 = FileUitls.getModelContent(context2, str8);
                            if (modelContent4.length == 0) {
                                String unused8 = FaceFeature.TAG;
                                callback2.onResponse(-1, "rgbd识别模型读取失败");
                                return;
                            }
                            int access$1004 = FaceFeature.this.nativeFeatureModelInit(index, modelContent4, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_RGBD.ordinal());
                            if (access$1004 != 0) {
                                String unused9 = FaceFeature.TAG;
                                callback2.onResponse(access$1004, "rgbd识别模型加载失败");
                                return;
                            }
                        }
                        String unused10 = FaceFeature.TAG;
                        callback2.onResponse(0, "识别模型加载成功");
                    }
                }
            }
        });
    }
}
