package com.tbruyelle.rxpermissions2;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;

public class RxPermissionsFragment extends Fragment {
    public final HashMap c = new HashMap();

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
            }
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str = strArr[i3];
                HashMap hashMap = this.c;
                PublishSubject publishSubject = (PublishSubject) hashMap.get(str);
                if (publishSubject == null) {
                    Log.e("RxPermissions", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                    return;
                }
                hashMap.remove(strArr[i3]);
                if (iArr[i3] == 0) {
                    z = true;
                } else {
                    z = false;
                }
                publishSubject.onNext(new Permission(strArr[i3], z, zArr[i3]));
                publishSubject.onComplete();
            }
        }
    }
}
