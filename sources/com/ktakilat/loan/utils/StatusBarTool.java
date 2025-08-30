package com.ktakilat.loan.utils;

import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.WindowCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ktakilat/loan/utils/StatusBarTool;", "", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StatusBarTool {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/utils/StatusBarTool$Companion;", "", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static void a(Window window, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(viewGroup, "view");
            try {
                WindowCompat.getInsetsController(window, viewGroup).setAppearanceLightStatusBars(true);
            } catch (Exception unused) {
            }
        }
    }
}
