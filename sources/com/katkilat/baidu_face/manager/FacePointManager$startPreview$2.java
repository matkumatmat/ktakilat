package com.katkilat.baidu_face.manager;

import android.graphics.Rect;
import android.hardware.Camera;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/katkilat/baidu_face/manager/FacePointManager$startPreview$2", "Landroid/hardware/Camera$PreviewCallback;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacePointManager$startPreview$2 implements Camera.PreviewCallback {
    public final /* synthetic */ FacePointManager c;

    public FacePointManager$startPreview$2(FacePointManager facePointManager) {
        this.c = facePointManager;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        FacePointManager facePointManager = this.c;
        if (!facePointManager.p) {
            if (facePointManager.l == null) {
                FaceSDKManager instance = FaceSDKManager.getInstance();
                FacePointManager$initParams$3 facePointManager$initParams$3 = this.c.j;
                if (facePointManager$initParams$3 != null) {
                    facePointManager.l = instance.getLivenessStrategyModule(facePointManager$initParams$3);
                    FacePointManager facePointManager2 = this.c;
                    ILivenessStrategy iLivenessStrategy = facePointManager2.l;
                    if (iLivenessStrategy != null) {
                        iLivenessStrategy.setPreviewDegree(facePointManager2.v);
                    }
                    FacePointManager facePointManager3 = this.c;
                    ILivenessStrategy iLivenessStrategy2 = facePointManager3.l;
                    if (iLivenessStrategy2 != null) {
                        iLivenessStrategy2.setLivenessStrategySoundEnable(facePointManager3.o);
                    }
                    int i = FaceDetectRoundView.t;
                    FacePointManager facePointManager4 = this.c;
                    Rect a2 = FaceDetectRoundView.Companion.a(facePointManager4.n, facePointManager4.u, facePointManager4.t);
                    FacePointManager facePointManager5 = this.c;
                    ILivenessStrategy iLivenessStrategy3 = facePointManager5.l;
                    if (iLivenessStrategy3 != null) {
                        FaceConfig faceConfig = facePointManager5.k;
                        if (faceConfig != null) {
                            List<LivenessTypeEnum> livenessTypeList = faceConfig.getLivenessTypeList();
                            FacePointManager facePointManager6 = this.c;
                            Rect rect = facePointManager6.m;
                            FacePointManager$initParams$2 facePointManager$initParams$2 = facePointManager6.i;
                            if (facePointManager$initParams$2 != null) {
                                iLivenessStrategy3.setLivenessStrategyConfig(livenessTypeList, rect, a2, facePointManager$initParams$2);
                            } else {
                                Intrinsics.k("mLivenessStrategyCallback");
                                throw null;
                            }
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    }
                } else {
                    Intrinsics.k("mLivenessViewCallback");
                    throw null;
                }
            }
            ILivenessStrategy iLivenessStrategy4 = this.c.l;
            if (iLivenessStrategy4 != null) {
                iLivenessStrategy4.livenessStrategy(bArr);
            }
        }
    }
}
