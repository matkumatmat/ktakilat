package com.katkilat.baidu_face.utils;

import android.hardware.Camera;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/utils/CameraUtils;", "", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraUtils {
    public static void a(Camera camera) {
        if (camera != null) {
            try {
                camera.release();
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
