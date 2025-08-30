package com.trustdecision.android.shell.inter;

import com.trustdecision.android.shell.common.TDDeviceAPIStatus;

public interface TDDeviceInfoCallback {
    void onResult(String str, String str2, String str3, int i, TDDeviceAPIStatus tDDeviceAPIStatus, String str4);
}
