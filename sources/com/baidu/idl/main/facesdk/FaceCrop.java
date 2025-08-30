package com.baidu.idl.main.facesdk;

import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.model.BDFaceCropParam;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceInstance;
import com.baidu.idl.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.concurrent.atomic.AtomicInteger;

public class FaceCrop {
    private static final String TAG = "FaceCrop";
    /* access modifiers changed from: private */
    public BDFaceInstance bdFaceInstance;

    public FaceCrop(BDFaceInstance bDFaceInstance) {
        if (bDFaceInstance != null) {
            this.bdFaceInstance = bDFaceInstance;
        }
    }

    private native BDFaceImageInstance nativeCropFaceByBox(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByBoxIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByBoxParam(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmark(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f, boolean z, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByLandmarkIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmarkParam(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    /* access modifiers changed from: private */
    public native int nativeCropImageInit(long j);

    private native BDFaceImageInstance nativeResizeImage(BDFaceImageInstance bDFaceImageInstance, int i, BDFaceSDKCommon.BDFaceImageType bDFaceImageType);

    private native int nativeUnInitCropImage(long j);

    public BDFaceImageInstance cropFaceByBox(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance == null || faceInfo == null || atomicInteger == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        int[] iArr = new int[1];
        BDFaceImageInstance nativeCropFaceByBox = nativeCropFaceByBox(index, bDFaceImageInstance, faceInfo, f, iArr);
        atomicInteger.set(iArr[0]);
        return nativeCropFaceByBox;
    }

    public BDFaceIsOutBoundary cropFaceByBoxIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByBoxIsOutofBoundary(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByBoxParam(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByBoxParam(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByLandmark(BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f, boolean z, AtomicInteger atomicInteger) {
        if (bDFaceImageInstance == null || atomicInteger == null || fArr.length < 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        int[] iArr = new int[1];
        BDFaceImageInstance nativeCropFaceByLandmark = nativeCropFaceByLandmark(index, bDFaceImageInstance, fArr, f, z, iArr);
        atomicInteger.set(iArr[0]);
        return nativeCropFaceByLandmark;
    }

    public BDFaceIsOutBoundary cropFaceByLandmarkIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByLandmarkIsOutofBoundary(index, bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public BDFaceImageInstance cropFaceByLandmarkParam(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
            return null;
        }
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return null;
        }
        return nativeCropFaceByLandmarkParam(index, bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public void initFaceCrop(final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                long index = FaceCrop.this.bdFaceInstance.getIndex();
                if (index == 0) {
                    callback.onResponse(-1, "抠图能力加载失败 instanceIndex=0");
                    return;
                }
                int access$100 = FaceCrop.this.nativeCropImageInit(index);
                if (access$100 == 0) {
                    callback.onResponse(access$100, "抠图能力加载成功");
                    return;
                }
                Callback callback = callback;
                callback.onResponse(access$100, "抠图能力加载失败: " + access$100);
            }
        });
    }

    public BDFaceImageInstance resizeImage(BDFaceImageInstance bDFaceImageInstance, int i) {
        if (bDFaceImageInstance == null) {
            return null;
        }
        return nativeResizeImage(bDFaceImageInstance, i, bDFaceImageInstance.imageType);
    }

    public int uninitFaceCrop() {
        long index = this.bdFaceInstance.getIndex();
        if (index == 0) {
            return -1;
        }
        return nativeUnInitCropImage(index);
    }

    public FaceCrop() {
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
