package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal;
import androidx.camera.video.OutputOptions;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;

public final class MediaStoreOutputOptions extends OutputOptions {
    @NonNull
    public static final ContentValues EMPTY_CONTENT_VALUES = new ContentValues();
    private final MediaStoreOutputOptionsInternal mMediaStoreOutputOptionsInternal;

    public static final class Builder extends OutputOptions.Builder<MediaStoreOutputOptions, Builder> {
        private final MediaStoreOutputOptionsInternal.Builder mInternalBuilder;

        public Builder(@NonNull ContentResolver contentResolver, @NonNull Uri uri) {
            super(new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(contentResolver, "Content resolver can't be null.");
            Preconditions.checkNotNull(uri, "Collection Uri can't be null.");
            MediaStoreOutputOptionsInternal.Builder builder = (MediaStoreOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = builder;
            builder.setContentResolver(contentResolver).setCollectionUri(uri).setContentValues(MediaStoreOutputOptions.EMPTY_CONTENT_VALUES);
        }

        @NonNull
        public Builder setContentValues(@NonNull ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "Content values can't be null.");
            this.mInternalBuilder.setContentValues(contentValues);
            return this;
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object setDurationLimitMillis(@IntRange(from = 0) long j) {
            return super.setDurationLimitMillis(j);
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object setFileSizeLimit(@IntRange(from = 0) long j) {
            return super.setFileSizeLimit(j);
        }

        @NonNull
        public /* bridge */ /* synthetic */ Object setLocation(@Nullable Location location) {
            return super.setLocation(location);
        }

        @NonNull
        public MediaStoreOutputOptions build() {
            return new MediaStoreOutputOptions(this.mInternalBuilder.build());
        }
    }

    @AutoValue
    public static abstract class MediaStoreOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {

        @AutoValue.Builder
        public static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            @NonNull
            public abstract MediaStoreOutputOptionsInternal build();

            @NonNull
            public abstract Builder setCollectionUri(@NonNull Uri uri);

            @NonNull
            public abstract Builder setContentResolver(@NonNull ContentResolver contentResolver);

            @NonNull
            public abstract Builder setContentValues(@NonNull ContentValues contentValues);
        }

        @NonNull
        public abstract Uri getCollectionUri();

        @NonNull
        public abstract ContentResolver getContentResolver();

        @NonNull
        public abstract ContentValues getContentValues();
    }

    public MediaStoreOutputOptions(@NonNull MediaStoreOutputOptionsInternal mediaStoreOutputOptionsInternal) {
        super(mediaStoreOutputOptionsInternal);
        this.mMediaStoreOutputOptionsInternal = mediaStoreOutputOptionsInternal;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStoreOutputOptions)) {
            return false;
        }
        return this.mMediaStoreOutputOptionsInternal.equals(((MediaStoreOutputOptions) obj).mMediaStoreOutputOptionsInternal);
    }

    @NonNull
    public Uri getCollectionUri() {
        return this.mMediaStoreOutputOptionsInternal.getCollectionUri();
    }

    @NonNull
    public ContentResolver getContentResolver() {
        return this.mMediaStoreOutputOptionsInternal.getContentResolver();
    }

    @NonNull
    public ContentValues getContentValues() {
        return this.mMediaStoreOutputOptionsInternal.getContentValues();
    }

    public int hashCode() {
        return this.mMediaStoreOutputOptionsInternal.hashCode();
    }

    @NonNull
    public String toString() {
        return this.mMediaStoreOutputOptionsInternal.toString().replaceFirst("MediaStoreOutputOptionsInternal", "MediaStoreOutputOptions");
    }
}
