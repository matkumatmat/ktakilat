package defpackage;

import android.content.res.Configuration;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentManager;

/* renamed from: j9  reason: default package */
public final /* synthetic */ class j9 implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ FragmentManager d;

    public /* synthetic */ j9(FragmentManager fragmentManager, int i) {
        this.c = i;
        this.d = fragmentManager;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                this.d.lambda$new$0((Configuration) obj);
                return;
            case 1:
                this.d.lambda$new$1((Integer) obj);
                return;
            case 2:
                this.d.lambda$new$2((MultiWindowModeChangedInfo) obj);
                return;
            default:
                this.d.lambda$new$3((PictureInPictureModeChangedInfo) obj);
                return;
        }
    }
}
