package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = "com.facebook.appevents.AppEventStore";

    public static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            if (readClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
            }
            return readClassDescriptor;
        }
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            try {
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents readAndClearStore = readAndClearStore();
                if (readAndClearStore.containsKey(accessTokenAppIdPair)) {
                    readAndClearStore.get(accessTokenAppIdPair).addAll(sessionEventsState.getEventsToPersist());
                } else {
                    readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                }
                saveEventsToDisk(readAndClearStore);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0090 A[Catch:{ Exception -> 0x0031 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x002e }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x002e }
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043, all -> 0x003f }
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043, all -> 0x003f }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043, all -> 0x003f }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043, all -> 0x003f }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0046, Exception -> 0x0043, all -> 0x003f }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x007b, Exception -> 0x003d }
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x007b, Exception -> 0x003d }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x0031 }
            r1.delete()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0039
        L_0x002e:
            r1 = move-exception
            goto L_0x0097
        L_0x0031:
            r1 = move-exception
            java.lang.String r2 = TAG     // Catch:{ all -> 0x002e }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r2, r4, r1)     // Catch:{ all -> 0x002e }
        L_0x0039:
            r2 = r3
            goto L_0x008e
        L_0x003b:
            r2 = move-exception
            goto L_0x0065
        L_0x003d:
            r3 = move-exception
            goto L_0x0048
        L_0x003f:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto L_0x0065
        L_0x0043:
            r3 = move-exception
            r4 = r2
            goto L_0x0048
        L_0x0046:
            r4 = r2
            goto L_0x007b
        L_0x0048:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x003b }
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x003b }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x002e }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x005c }
            r1.delete()     // Catch:{ Exception -> 0x005c }
            goto L_0x008e
        L_0x005c:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x002e }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L_0x0061:
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x002e }
            goto L_0x008e
        L_0x0065:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x002e }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0072 }
            r1.delete()     // Catch:{ Exception -> 0x0072 }
            goto L_0x007a
        L_0x0072:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x002e }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x002e }
        L_0x007a:
            throw r2     // Catch:{ all -> 0x002e }
        L_0x007b:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x002e }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0088 }
            r1.delete()     // Catch:{ Exception -> 0x0088 }
            goto L_0x008e
        L_0x0088:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x002e }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L_0x0061
        L_0x008e:
            if (r2 != 0) goto L_0x0095
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x002e }
            r2.<init>()     // Catch:{ all -> 0x002e }
        L_0x0095:
            monitor-exit(r0)
            return r2
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    private static void saveEventsToDisk(PersistedEvents persistedEvents) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream2.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream2);
            } catch (Exception e) {
                e = e;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", e);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception unused) {
                    }
                    Utility.closeQuietly(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    Utility.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
                Utility.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Log.w(TAG, "Got unexpected exception while persisting events: ", e);
            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            Utility.closeQuietly(objectOutputStream);
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            try {
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents readAndClearStore = readAndClearStore();
                for (AccessTokenAppIdPair next : appEventCollection.keySet()) {
                    readAndClearStore.addEvents(next, appEventCollection.get(next).getEventsToPersist());
                }
                saveEventsToDisk(readAndClearStore);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
