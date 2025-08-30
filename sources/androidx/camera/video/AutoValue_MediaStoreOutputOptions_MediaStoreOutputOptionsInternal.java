package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.MediaStoreOutputOptions;

final class AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal {
    private final Uri collectionUri;
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;

    public static final class Builder extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder {
        private Uri collectionUri;
        private ContentResolver contentResolver;
        private ContentValues contentValues;
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;

        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setCollectionUri(Uri uri) {
            if (uri != null) {
                this.collectionUri = uri;
                return this;
            }
            throw new NullPointerException("Null collectionUri");
        }

        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentResolver(ContentResolver contentResolver2) {
            if (contentResolver2 != null) {
                this.contentResolver = contentResolver2;
                return this;
            }
            throw new NullPointerException("Null contentResolver");
        }

        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentValues(ContentValues contentValues2) {
            if (contentValues2 != null) {
                this.contentValues = contentValues2;
                return this;
            }
            throw new NullPointerException("Null contentValues");
        }

        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal build() {
            String str;
            if (this.fileSizeLimit == null) {
                str = " fileSizeLimit";
            } else {
                str = "";
            }
            if (this.durationLimitMillis == null) {
                str = e.l(str, " durationLimitMillis");
            }
            if (this.contentResolver == null) {
                str = e.l(str, " contentResolver");
            }
            if (this.collectionUri == null) {
                str = e.l(str, " collectionUri");
            }
            if (this.contentValues == null) {
                str = e.l(str, " contentValues");
            }
            if (str.isEmpty()) {
                return new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.contentResolver, this.collectionUri, this.contentValues);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setDurationLimitMillis(long j) {
            this.durationLimitMillis = Long.valueOf(j);
            return this;
        }

        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setFileSizeLimit(long j) {
            this.fileSizeLimit = Long.valueOf(j);
            return this;
        }

        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setLocation(@Nullable Location location2) {
            this.location = location2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        Location location2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaStoreOutputOptions.MediaStoreOutputOptionsInternal)) {
            return false;
        }
        MediaStoreOutputOptions.MediaStoreOutputOptionsInternal mediaStoreOutputOptionsInternal = (MediaStoreOutputOptions.MediaStoreOutputOptionsInternal) obj;
        if (this.fileSizeLimit != mediaStoreOutputOptionsInternal.getFileSizeLimit() || this.durationLimitMillis != mediaStoreOutputOptionsInternal.getDurationLimitMillis() || ((location2 = this.location) != null ? !location2.equals(mediaStoreOutputOptionsInternal.getLocation()) : mediaStoreOutputOptionsInternal.getLocation() != null) || !this.contentResolver.equals(mediaStoreOutputOptionsInternal.getContentResolver()) || !this.collectionUri.equals(mediaStoreOutputOptionsInternal.getCollectionUri()) || !this.contentValues.equals(mediaStoreOutputOptionsInternal.getContentValues())) {
            return false;
        }
        return true;
    }

    @NonNull
    public Uri getCollectionUri() {
        return this.collectionUri;
    }

    @NonNull
    public ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    @NonNull
    public ContentValues getContentValues() {
        return this.contentValues;
    }

    @IntRange(from = 0)
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @IntRange(from = 0)
    public long getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    @Nullable
    public Location getLocation() {
        return this.location;
    }

    public int hashCode() {
        int i;
        long j = this.fileSizeLimit;
        long j2 = this.durationLimitMillis;
        int i2 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        Location location2 = this.location;
        if (location2 == null) {
            i = 0;
        } else {
            i = location2.hashCode();
        }
        return this.contentValues.hashCode() ^ ((((((i2 ^ i) * 1000003) ^ this.contentResolver.hashCode()) * 1000003) ^ this.collectionUri.hashCode()) * 1000003);
    }

    public String toString() {
        return "MediaStoreOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", contentResolver=" + this.contentResolver + ", collectionUri=" + this.collectionUri + ", contentValues=" + this.contentValues + "}";
    }

    private AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(long j, long j2, @Nullable Location location2, ContentResolver contentResolver2, Uri uri, ContentValues contentValues2) {
        this.fileSizeLimit = j;
        this.durationLimitMillis = j2;
        this.location = location2;
        this.contentResolver = contentResolver2;
        this.collectionUri = uri;
        this.contentValues = contentValues2;
    }
}
