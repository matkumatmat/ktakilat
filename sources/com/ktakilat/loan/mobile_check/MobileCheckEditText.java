package com.ktakilat.loan.mobile_check;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.facebook.places.model.PlaceFields;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ktakilat/loan/mobile_check/MobileCheckEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMobileCheckEditText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MobileCheckEditText.kt\ncom/ktakilat/loan/mobile_check/MobileCheckEditText\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,36:1\n31#2:37\n*S KotlinDebug\n*F\n+ 1 MobileCheckEditText.kt\ncom/ktakilat/loan/mobile_check/MobileCheckEditText\n*L\n16#1:37\n*E\n"})
public final class MobileCheckEditText extends AppCompatEditText {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileCheckEditText(@NotNull Context context) {
        this(context, (AttributeSet) null, 6, 0);
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
    }

    public final boolean onTextContextMenuItem(int i) {
        ClipData primaryClip;
        if (i != 16908322) {
            return super.onTextContextMenuItem(i);
        }
        try {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context, ClipboardManager.class);
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0) {
                return false;
            }
            String obj = primaryClip.getItemAt(0).getText().toString();
            if (!StringsKt.I(obj, "+", false)) {
                return false;
            }
            setText(String.valueOf(PhoneNumberUtil.c().j(obj, "ID").getNationalNumber()));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileCheckEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobileCheckEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, (i & 2) != 0 ? null : attributeSet, 16842862);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MobileCheckEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
    }
}
