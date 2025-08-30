package com.ktakilat.cbase.ui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.multidex.MultiDexApplication;
import com.tencent.mmkv.MMKV;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class BaseApplication extends MultiDexApplication {
    public static BaseApplication e;
    public static volatile Boolean f = Boolean.FALSE;
    public int c = 0;
    public final ArrayList d = new ArrayList(0);

    public abstract void a(int i);

    public void onCreate() {
        super.onCreate();
        e = this;
        MMKV.b(this);
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                "activity create : ".concat(activity.getClass().getName());
                BaseApplication.this.d.add(new WeakReference(activity));
            }

            public final void onActivityDestroyed(Activity activity) {
                "activity destroy : ".concat(activity.getClass().getName());
                BaseApplication baseApplication = BaseApplication.this;
                int size = baseApplication.d.size();
                int i = 0;
                while (i < size) {
                    WeakReference weakReference = (WeakReference) baseApplication.d.get(i);
                    if (weakReference == null || weakReference.get() == null) {
                        baseApplication.d.remove(i);
                        i--;
                    } else if (weakReference.get() == activity) {
                        baseApplication.d.remove(weakReference);
                        return;
                    }
                    i++;
                }
            }

            public final void onActivityPaused(Activity activity) {
            }

            public final void onActivityResumed(Activity activity) {
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
                BaseApplication baseApplication = BaseApplication.this;
                int i = baseApplication.c + 1;
                baseApplication.c = i;
                baseApplication.a(i);
            }

            public final void onActivityStopped(Activity activity) {
                BaseApplication baseApplication = BaseApplication.this;
                int i = baseApplication.c - 1;
                baseApplication.c = i;
                if (i < 0) {
                    baseApplication.c = 0;
                }
                baseApplication.a(baseApplication.c);
            }
        });
    }
}
