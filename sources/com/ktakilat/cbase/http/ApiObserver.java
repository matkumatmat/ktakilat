package com.ktakilat.cbase.http;

import com.ktakilat.cbase.checkvalue.CheckValueManager;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.LogActivity;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;

public abstract class ApiObserver<T extends BaseResponse> implements Observer<T> {
    public abstract void a(BaseResponse baseResponse);

    public abstract void b(BaseResponse baseResponse);

    public final void onComplete() {
    }

    public final void onError(Throwable th) {
        BaseResponse a2 = HttpExceptionController.a(th);
        ArrayList arrayList = LogActivity.k;
        a(a2);
    }

    public final void onNext(Object obj) {
        BaseResponse baseResponse = (BaseResponse) obj;
        if (baseResponse.isSuc()) {
            CheckValueManager.a(baseResponse);
            b(baseResponse);
            return;
        }
        a(baseResponse);
    }

    public final void onSubscribe(Disposable disposable) {
    }
}
