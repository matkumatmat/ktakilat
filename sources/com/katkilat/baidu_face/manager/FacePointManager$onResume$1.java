package com.katkilat.baidu_face.manager;

import android.media.AudioManager;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.katkilat.baidu_face.manager.FacePointManager;
import com.katkilat.baidu_face.utils.VolumeUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/katkilat/baidu_face/manager/FacePointManager$onResume$1", "Lcom/katkilat/baidu_face/utils/VolumeUtils$VolumeCallback;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacePointManager$onResume$1 implements VolumeUtils.VolumeCallback {
    public final /* synthetic */ FacePointManager c;

    public FacePointManager$onResume$1(FacePointManager facePointManager) {
        this.c = facePointManager;
    }

    public final void c() {
        boolean z;
        try {
            AudioManager audioManager = (AudioManager) this.c.f459a.getSystemService("audio");
            if (audioManager != null) {
                int streamVolume = audioManager.getStreamVolume(3);
                FacePointManager facePointManager = this.c;
                if (streamVolume > 0) {
                    z = true;
                } else {
                    z = false;
                }
                facePointManager.o = z;
                FacePointManager.Companion.InitCall initCall = this.c.A;
                FacePointManager facePointManager2 = this.c;
                ILivenessStrategy iLivenessStrategy = facePointManager2.l;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.setLivenessStrategySoundEnable(facePointManager2.o);
                }
            }
        } catch (Exception unused) {
        }
    }
}
