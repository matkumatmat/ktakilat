package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

public final class zae extends zai {
    protected final BaseImplementation.ApiMethodImpl zaa;

    public zae(int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        super(i);
        this.zaa = (BaseImplementation.ApiMethodImpl) Preconditions.checkNotNull(apiMethodImpl, "Null methods are not runnable.");
    }

    public final void zad(@NonNull Status status) {
        try {
            this.zaa.setFailedResult(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    public final void zae(@NonNull Exception exc) {
        try {
            this.zaa.setFailedResult(new Status(10, e.m(exc.getClass().getSimpleName(), ": ", exc.getLocalizedMessage())));
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    public final void zaf(zabq zabq) throws DeadObjectException {
        try {
            this.zaa.run(zabq.zaf());
        } catch (RuntimeException e) {
            zae(e);
        }
    }

    public final void zag(@NonNull zaad zaad, boolean z) {
        zaad.zac(this.zaa, z);
    }
}
