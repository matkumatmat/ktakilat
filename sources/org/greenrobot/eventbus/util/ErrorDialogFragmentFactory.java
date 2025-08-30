package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;

public abstract class ErrorDialogFragmentFactory<T> {

    @TargetApi(11)
    public static class Honeycomb extends ErrorDialogFragmentFactory<Fragment> {
    }

    public static class Support extends ErrorDialogFragmentFactory<androidx.fragment.app.Fragment> {
    }
}
