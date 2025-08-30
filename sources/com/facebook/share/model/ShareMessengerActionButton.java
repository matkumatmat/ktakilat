package com.facebook.share.model;

import android.os.Parcel;
import androidx.annotation.Nullable;

public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder> implements ShareModelBuilder<M, B> {
        /* access modifiers changed from: private */
        public String title;

        public B setTitle(@Nullable String str) {
            this.title = str;
            return this;
        }

        public B readFrom(M m) {
            return m == null ? this : setTitle(m.getTitle());
        }
    }

    public ShareMessengerActionButton(Builder builder) {
        this.title = builder.title;
    }

    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
    }

    public ShareMessengerActionButton(Parcel parcel) {
        this.title = parcel.readString();
    }
}
