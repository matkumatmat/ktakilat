package defpackage;

import android.view.View;
import androidx.core.view.DragStartHelper;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;

/* renamed from: o5  reason: default package */
public final /* synthetic */ class o5 implements View.OnLongClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ o5(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final boolean onLongClick(View view) {
        Object obj = this.d;
        switch (this.c) {
            case 0:
                return ((DragStartHelper) obj).onLongClick(view);
            default:
                int i = MobileCheckV2Activity.g;
                ((MobileCheckV2Activity) obj).p();
                return true;
        }
    }
}
