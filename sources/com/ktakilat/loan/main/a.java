package com.ktakilat.loan.main;

import android.text.TextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.ktakilat.loan.http.AppHttp;

public final /* synthetic */ class a implements OnCompleteListener {
    public final /* synthetic */ HomeActivity c;

    public /* synthetic */ a(HomeActivity homeActivity) {
        this.c = homeActivity;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [io.reactivex.Observer, java.lang.Object] */
    public final void onComplete(Task task) {
        int i = HomeActivity.p;
        this.c.getClass();
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            if (!TextUtils.isEmpty(str) && !"".equals(str)) {
                AppHttp.commonFirebaseBind(str).subscribe(new Object());
            }
        }
    }
}
