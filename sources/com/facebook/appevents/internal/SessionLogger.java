package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

class SessionLogger {
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, 900000, 1800000, DateUtils.MILLIS_PER_HOUR, 21600000, 43200000, DateUtils.MILLIS_PER_DAY, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final String TAG = "com.facebook.appevents.internal.SessionLogger";

    private static int getQuantaIndex(long j) {
        int i = 0;
        while (true) {
            long[] jArr = INACTIVE_SECONDS_QUANTA;
            if (i >= jArr.length || jArr[i] >= j) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void logActivateApp(Context context, String str, SourceApplicationInfo sourceApplicationInfo, String str2) {
        String str3;
        if (sourceApplicationInfo != null) {
            str3 = sourceApplicationInfo.toString();
        } else {
            str3 = "Unclassified";
        }
        Bundle c = e.c(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str3);
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, (AccessToken) null);
        internalAppEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, c);
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.flush();
        }
    }

    private static void logClockSkewEvent() {
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }

    public static void logDeactivateApp(Context context, String str, SessionInfo sessionInfo, String str2) {
        String str3;
        long diskRestoreTime = sessionInfo.getDiskRestoreTime() - sessionInfo.getSessionLastEventTime().longValue();
        Long valueOf = Long.valueOf(diskRestoreTime);
        Long l = 0L;
        if (diskRestoreTime < 0) {
            logClockSkewEvent();
            valueOf = l;
        }
        long sessionLength = sessionInfo.getSessionLength();
        Long valueOf2 = Long.valueOf(sessionLength);
        if (sessionLength < 0) {
            logClockSkewEvent();
        } else {
            l = valueOf2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
        Locale locale = Locale.ROOT;
        int quantaIndex = getQuantaIndex(valueOf.longValue());
        bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, "session_quanta_" + quantaIndex);
        SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
        if (sourceApplicationInfo != null) {
            str3 = sourceApplicationInfo.toString();
        } else {
            str3 = "Unclassified";
        }
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str3);
        bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, sessionInfo.getSessionLastEventTime().longValue() / 1000);
        new InternalAppEventsLogger(str, str2, (AccessToken) null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, (double) (l.longValue() / 1000), bundle);
    }
}
