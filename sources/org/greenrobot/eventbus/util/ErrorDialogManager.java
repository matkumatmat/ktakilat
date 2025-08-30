package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;

public class ErrorDialogManager {

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {
        public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
            if (throwableFailureEvent == null) {
                throw null;
            }
            throw null;
        }

        public void onPause() {
            throw null;
        }

        public void onResume() {
            super.onResume();
            throw null;
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            throw null;
        }

        public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
            if (throwableFailureEvent == null) {
                throw null;
            }
            throw null;
        }

        public final void onPause() {
            throw null;
        }

        public final void onResume() {
            super.onResume();
            throw null;
        }
    }
}
