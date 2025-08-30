package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.utils.FileUitls;

public class FaceLive {
    private static final String TAG = "FaceLive";
    /* access modifiers changed from: private */
    public BDFaceInstance bdFaceInstance;

    public FaceLive(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance != null) {
            this.bdFaceInstance = bDFaceInstance;
        }
    }

    private native float nativeSilentLive(long j, int i, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* access modifiers changed from: private */
    public native int nativeSilentLiveModelInit(long j, byte[] bArr, int i);

    private native int nativeUninitModel(long j);

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
                long index = FaceLive.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context2, str4);
                    int i3 = -1;
                    if (modelContent.length != 0) {
                        i = FaceLive.this.nativeSilentLiveModelInit(index, modelContent, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_RGB.ordinal());
                        if (i != 0) {
                            callback2.onResponse(i, "Vis 活体模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    byte[] modelContent2 = FileUitls.getModelContent(context2, str5);
                    if (modelContent2.length != 0) {
                        i2 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent2, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_NIR.ordinal());
                        if (i2 != 0) {
                            callback2.onResponse(i2, "Nir 活体模型加载失败");
                            return;
                        }
                    } else {
                        i2 = -1;
                    }
                    byte[] modelContent3 = FileUitls.getModelContent(context2, str6);
                    if (modelContent3.length == 0 || (i3 = FaceLive.this.nativeSilentLiveModelInit(index, modelContent3, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_DEPTH.ordinal())) == 0) {
                        if (i == 0 || i2 == 0 || i3 == 0) {
                            callback2.onResponse(0, "活体模型加载成功");
                        } else {
                            callback2.onResponse(1, "活体模型加载失败");
                        }
                        Log.e("bdface", "FaceLive initModel");
                        return;
                    }
                    callback2.onResponse(i3, "Deep 活体模型加载失败");
                }
            }
        });
    }

    public float silentLive(BDFaceSDKCommon.LiveType liveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        if (liveType == null || bDFaceImageInstance == null || fArr == null) {
            return -1.0f;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1.0f;
        }
        return nativeSilentLive(index, liveType.ordinal(), bDFaceImageInstance, fArr);
    }

    public int uninitModel() {
        if (this.bdFaceInstance.getIndex() == 0) {
            return -1;
        }
        return nativeUninitModel(this.bdFaceInstance.getIndex());
    }

    public FaceLive() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
