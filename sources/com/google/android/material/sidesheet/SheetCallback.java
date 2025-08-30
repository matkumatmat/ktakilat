package com.google.android.material.sidesheet;

import android.view.View;
import androidx.annotation.NonNull;

interface SheetCallback {
    void onSlide(@NonNull View view, float f);

    void onStateChanged(@NonNull View view, int i);
}
