package defpackage;

import android.graphics.drawable.Icon;
import android.media.browse.MediaBrowser;
import android.os.Parcelable;

/* renamed from: c0  reason: default package */
public abstract /* synthetic */ class c0 {
    public static /* bridge */ /* synthetic */ boolean D(Parcelable parcelable) {
        return parcelable instanceof Icon;
    }

    public static /* bridge */ /* synthetic */ Icon h(Parcelable parcelable) {
        return (Icon) parcelable;
    }

    public static /* bridge */ /* synthetic */ MediaBrowser.ItemCallback j(Object obj) {
        return (MediaBrowser.ItemCallback) obj;
    }
}
