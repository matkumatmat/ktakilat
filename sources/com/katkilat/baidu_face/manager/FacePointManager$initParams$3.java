package com.katkilat.baidu_face.manager;

import com.baidu.idl.face.platform.ILivenessViewCallback;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/katkilat/baidu_face/manager/FacePointManager$initParams$3", "Lcom/baidu/idl/face/platform/ILivenessViewCallback;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacePointManager$initParams$3 implements ILivenessViewCallback {
    public final /* synthetic */ FacePointManager c;

    public FacePointManager$initParams$3(FacePointManager facePointManager) {
        this.c = facePointManager;
    }

    public final void animStop() {
        this.c.h();
    }

    public final void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
        this.c.z = livenessTypeEnum;
    }

    public final void setFaceInfo(FaceExtInfo faceExtInfo) {
    }

    public final void viewReset() {
        FaceDetectRoundView faceDetectRoundView = this.c.c;
        if (faceDetectRoundView != null) {
            faceDetectRoundView.setProcessCount(0, 1);
        } else {
            Intrinsics.k("mFaceRoundView");
            throw null;
        }
    }
}
