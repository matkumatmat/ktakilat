package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.utils.FileUitls;

public class FaceMouthMask {
    private static final String TAG = "FaceMouthMask";
    /* access modifiers changed from: private */
    public BDFaceInstance bdFaceInstance;

    public FaceMouthMask(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance != null) {
            this.bdFaceInstance = bDFaceInstance;
        }
    }

    private native float[] nativeCheckMask(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr);

    /* access modifiers changed from: private */
    public native int nativeInitModel(long j, byte[] bArr);

    private native int nativeUninitModel(long j);

    public float[] checkMask(BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr) {
        if (bDFaceImageInstance == null || faceInfoArr == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCheckMask(index, bDFaceImageInstance, faceInfoArr);
    }

    public void initModel(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                int i;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                long index = FaceMouthMask.this.bdFaceInstance.getIndex();
                if (index != 0) {
                    byte[] modelContent = FileUitls.getModelContent(context, str);
                    if (modelContent.length != 0) {
                        i = FaceMouthMask.this.nativeInitModel(index, modelContent);
                        if (i != 0) {
                            callback.onResponse(i, "口罩检测模型加载失败");
                            return;
                        }
                    } else {
                        i = -1;
                    }
                    if (i == 0) {
                        callback.onResponse(0, "口罩检测模型加载成功");
                    } else {
                        callback.onResponse(1, "口罩检测模型加载失败");
                    }
                    Log.e("bdface", "FaceMouthMask initModel");
                }
            }
        });
    }

    public int uninitModel() {
        if (this.bdFaceInstance.getIndex() == 0) {
            return -1;
        }
        return nativeUninitModel(this.bdFaceInstance.getIndex());
    }

    public FaceMouthMask() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
