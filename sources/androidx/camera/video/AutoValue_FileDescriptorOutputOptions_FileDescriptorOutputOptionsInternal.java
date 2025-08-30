package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.FileDescriptorOutputOptions;

final class AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal {
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;
    private final ParcelFileDescriptor parcelFileDescriptor;

    public static final class Builder extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;
        private ParcelFileDescriptor parcelFileDescriptor;

        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor2) {
            if (parcelFileDescriptor2 != null) {
                this.parcelFileDescriptor = parcelFileDescriptor2;
                return this;
            }
            throw new NullPointerException("Null parcelFileDescriptor");
        }

        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal build() {
            String str;
            if (this.fileSizeLimit == null) {
                str = " fileSizeLimit";
            } else {
                str = "";
            }
            if (this.durationLimitMillis == null) {
                str = e.l(str, " durationLimitMillis");
            }
            if (this.parcelFileDescriptor == null) {
                str = e.l(str, " parcelFileDescriptor");
            }
            if (str.isEmpty()) {
                return new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.parcelFileDescriptor);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setDurationLimitMillis(long j) {
            this.durationLimitMillis = Long.valueOf(j);
            return this;
        }

        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setFileSizeLimit(long j) {
            this.fileSizeLimit = Long.valueOf(j);
            return this;
        }

        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setLocation(@Nullable Location location2) {
            this.location = location2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        Location location2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal)) {
            return false;
        }
        FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal fileDescriptorOutputOptionsInternal = (FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) obj;
        if (this.fileSizeLimit != fileDescriptorOutputOptionsInternal.getFileSizeLimit() || this.durationLimitMillis != fileDescriptorOutputOptionsInternal.getDurationLimitMillis() || ((location2 = this.location) != null ? !location2.equals(fileDescriptorOutputOptionsInternal.getLocation()) : fileDescriptorOutputOptionsInternal.getLocation() != null) || !this.parcelFileDescriptor.equals(fileDescriptorOutputOptionsInternal.getParcelFileDescriptor())) {
            return false;
        }
        return true;
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

    @NonNull
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
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
        return this.parcelFileDescriptor.hashCode() ^ ((i2 ^ i) * 1000003);
    }

    public String toString() {
        return "FileDescriptorOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", parcelFileDescriptor=" + this.parcelFileDescriptor + "}";
    }

    private AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(long j, long j2, @Nullable Location location2, ParcelFileDescriptor parcelFileDescriptor2) {
        this.fileSizeLimit = j;
        this.durationLimitMillis = j2;
        this.location = location2;
        this.parcelFileDescriptor = parcelFileDescriptor2;
    }
}
