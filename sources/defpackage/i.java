package defpackage;

import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.InspectionCompanion;
import java.util.Map;

/* renamed from: i  reason: default package */
public abstract /* synthetic */ class i {
    public static /* bridge */ /* synthetic */ ColorStateListDrawable e(Drawable drawable) {
        return (ColorStateListDrawable) drawable;
    }

    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo h(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    public static /* synthetic */ InspectionCompanion.UninitializedPropertyMapException j() {
        return new InspectionCompanion.UninitializedPropertyMapException();
    }

    public static /* bridge */ /* synthetic */ boolean r(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }
}
