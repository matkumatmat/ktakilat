package defpackage;

import androidx.camera.core.impl.EncoderProfilesProxy;

/* renamed from: q6  reason: default package */
public abstract /* synthetic */ class q6 {
    public static String a(int i) {
        switch (i) {
            case 1:
                return "audio/3gpp";
            case 2:
                return "audio/amr-wb";
            case 3:
            case 4:
            case 5:
                return "audio/mp4a-latm";
            case 6:
                return "audio/vorbis";
            case 7:
                return "audio/opus";
            default:
                return EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE;
        }
    }

    public static int b(int i) {
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 5;
        }
        if (i != 5) {
            return -1;
        }
        return 39;
    }

    public static String c(int i) {
        switch (i) {
            case 1:
                return "video/3gpp";
            case 2:
                return "video/avc";
            case 3:
                return "video/mp4v-es";
            case 4:
                return "video/x-vnd.on2.vp8";
            case 5:
                return "video/hevc";
            case 6:
                return "video/x-vnd.on2.vp9";
            case 7:
                return "video/dolby-vision";
            case 8:
                return "video/av01";
            default:
                return EncoderProfilesProxy.VideoProfileProxy.MEDIA_TYPE_NONE;
        }
    }
}
