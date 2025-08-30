package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.LayoutInflaterFactory;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ktakilat.cbase.ui.BaseActivity;

/* renamed from: u0  reason: default package */
public final /* synthetic */ class u0 implements LayoutInflaterFactory, OnApplyWindowInsetsListener {
    public final /* synthetic */ BaseActivity c;

    public /* synthetic */ u0(BaseActivity baseActivity) {
        this.c = baseActivity;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Typeface typeface = BaseActivity.g;
        Insets insets = windowInsetsCompat.getInsets(this.c.r());
        try {
            view.setPadding(0, insets.top, 0, insets.bottom);
        } catch (Exception unused) {
        }
        return WindowInsetsCompat.CONSUMED;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Typeface typeface = BaseActivity.g;
        View createView = this.c.getDelegate().createView(view, str, context, attributeSet);
        if (createView instanceof TextView) {
            ((TextView) createView).setTypeface(BaseActivity.g);
        }
        if (createView instanceof EditText) {
            ((EditText) createView).setTypeface(BaseActivity.g);
        }
        return createView;
    }
}
