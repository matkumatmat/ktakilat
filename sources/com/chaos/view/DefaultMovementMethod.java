package com.chaos.view;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

class DefaultMovementMethod implements MovementMethod {

    /* renamed from: a  reason: collision with root package name */
    public static DefaultMovementMethod f187a;

    public final boolean canSelectArbitrarily() {
        return false;
    }

    public final void initialize(TextView textView, Spannable spannable) {
        Selection.setSelection(spannable, 0);
    }

    public final boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public final boolean onKeyDown(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        return false;
    }

    public final boolean onKeyUp(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return false;
    }

    public final void onTakeFocus(TextView textView, Spannable spannable, int i) {
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public final boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }
}
