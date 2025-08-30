package com.katkilat.baidu_face.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/katkilat/baidu_face/utils/VolumeUtils;", "", "VolumeCallback", "Companion", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VolumeUtils {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/katkilat/baidu_face/utils/VolumeUtils$Companion;", "", "VolumeReceiver", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/utils/VolumeUtils$Companion$VolumeReceiver;", "Landroid/content/BroadcastReceiver;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class VolumeReceiver extends BroadcastReceiver {

            /* renamed from: a  reason: collision with root package name */
            public final VolumeCallback f463a;

            public VolumeReceiver(VolumeCallback volumeCallback) {
                this.f463a = volumeCallback;
            }

            public final void onReceive(Context context, Intent intent) {
                VolumeCallback volumeCallback;
                Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.a(intent.getAction(), "android.media.VOLUME_CHANGED_ACTION") && (volumeCallback = this.f463a) != null) {
                    Log.e("VolumeUtils", "android.media.VOLUME_CHANGED_ACTION");
                    volumeCallback.c();
                }
            }
        }

        public static VolumeReceiver a(Context context, VolumeCallback volumeCallback) {
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            VolumeReceiver volumeReceiver = null;
            try {
                VolumeReceiver volumeReceiver2 = new VolumeReceiver(volumeCallback);
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                    if (Build.VERSION.SDK_INT >= 33) {
                        context.registerReceiver(volumeReceiver2, intentFilter, 1);
                        return volumeReceiver2;
                    }
                    context.registerReceiver(volumeReceiver2, intentFilter);
                    return volumeReceiver2;
                } catch (IllegalArgumentException e) {
                    e = e;
                    volumeReceiver = volumeReceiver2;
                    e.printStackTrace();
                    return volumeReceiver;
                } catch (Exception e2) {
                    e = e2;
                    volumeReceiver = volumeReceiver2;
                    e.printStackTrace();
                    return volumeReceiver;
                }
            } catch (IllegalArgumentException e3) {
                e = e3;
                e.printStackTrace();
                return volumeReceiver;
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                return volumeReceiver;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/utils/VolumeUtils$VolumeCallback;", "", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface VolumeCallback {
        void c();
    }
}
