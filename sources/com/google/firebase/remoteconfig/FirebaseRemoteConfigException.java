package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseException;

public class FirebaseRemoteConfigException extends FirebaseException {
    private final Code code;

    public enum Code {
        UNKNOWN(0),
        CONFIG_UPDATE_STREAM_ERROR(1),
        CONFIG_UPDATE_MESSAGE_INVALID(2),
        CONFIG_UPDATE_NOT_FETCHED(3),
        CONFIG_UPDATE_UNAVAILABLE(4);
        
        private final int value;

        private Code(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }
    }

    public FirebaseRemoteConfigException(@NonNull String str) {
        super(str);
        this.code = Code.UNKNOWN;
    }

    @NonNull
    public Code getCode() {
        return this.code;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.code = Code.UNKNOWN;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @NonNull Code code2) {
        super(str);
        this.code = code2;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @Nullable Throwable th, @NonNull Code code2) {
        super(str, th);
        this.code = code2;
    }
}
