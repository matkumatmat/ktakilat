package com.ktakilat.loan.weiget;

import android.text.TextUtils;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.AppHttp;
import com.trello.rxlifecycle2.LifecycleTransformer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class j implements Consumer {
    /* JADX WARNING: type inference failed for: r0v2, types: [io.reactivex.Observer, java.lang.Object] */
    public final void accept(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            AppHttp.uploadAppList((LifecycleTransformer<BaseResponse<Object>>) null, str).subscribe(new Object());
        }
    }
}
