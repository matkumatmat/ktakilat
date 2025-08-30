package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

public final class ContextUtil {

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        public static Context createAttributionContext(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        @Nullable
        public static String getAttributionTag(@NonNull Context context) {
            return context.getAttributionTag();
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @NonNull
        public static Context createDeviceContext(@NonNull Context context, int i) {
            return context.createDeviceContext(i);
        }

        public static int getDeviceId(@NonNull Context context) {
            return context.getDeviceId();
        }
    }

    private ContextUtil() {
    }

    @NonNull
    public static Context getApplicationContext(@NonNull Context context) {
        int deviceId;
        Context applicationContext = context.getApplicationContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 34 && (deviceId = Api34Impl.getDeviceId(context)) != Api34Impl.getDeviceId(applicationContext)) {
            applicationContext = Api34Impl.createDeviceContext(applicationContext, deviceId);
        }
        if (i < 30) {
            return applicationContext;
        }
        String attributionTag = Api30Impl.getAttributionTag(context);
        if (!Objects.equals(attributionTag, Api30Impl.getAttributionTag(applicationContext))) {
            return Api30Impl.createAttributionContext(applicationContext, attributionTag);
        }
        return applicationContext;
    }

    @Nullable
    public static Application getApplicationFromContext(@NonNull Context context) {
        for (Context applicationContext = getApplicationContext(context); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }
}
