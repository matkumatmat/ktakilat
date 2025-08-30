package defpackage;

import android.app.Person;
import android.media.session.MediaSessionManager;
import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* renamed from: mc  reason: default package */
public abstract /* synthetic */ class mc {
    public static /* bridge */ /* synthetic */ Person f(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ Person g(Object obj) {
        return (Person) obj;
    }

    public static /* synthetic */ MediaSessionManager.RemoteUserInfo i(int i, int i2, String str) {
        return new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public static /* synthetic */ PrecomputedText.Params.Builder l(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ PrecomputedText o(Object obj) {
        return (PrecomputedText) obj;
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj) {
        return obj instanceof PrecomputedText;
    }
}
