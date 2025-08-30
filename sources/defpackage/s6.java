package defpackage;

import coil3.decode.ExifOrientationStrategy;

/* renamed from: s6  reason: default package */
public final /* synthetic */ class s6 implements ExifOrientationStrategy {
    public final /* synthetic */ int c;

    public /* synthetic */ s6(int i) {
        this.c = i;
    }

    public final boolean a(String str) {
        switch (this.c) {
            case 0:
                if (str == null || (!str.equals("image/jpeg") && !str.equals("image/webp") && !str.equals("image/heic") && !str.equals("image/heif"))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }
}
