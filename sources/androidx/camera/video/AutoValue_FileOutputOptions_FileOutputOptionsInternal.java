package androidx.camera.video;

import android.location.Location;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.FileOutputOptions;
import java.io.File;

final class AutoValue_FileOutputOptions_FileOutputOptionsInternal extends FileOutputOptions.FileOutputOptionsInternal {
    private final long durationLimitMillis;
    private final File file;
    private final long fileSizeLimit;
    private final Location location;

    public static final class Builder extends FileOutputOptions.FileOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private File file;
        private Long fileSizeLimit;
        private Location location;

        public FileOutputOptions.FileOutputOptionsInternal.Builder setFile(File file2) {
            if (file2 != null) {
                this.file = file2;
                return this;
            }
            throw new NullPointerException("Null file");
        }

        public FileOutputOptions.FileOutputOptionsInternal build() {
            String str;
            if (this.fileSizeLimit == null) {
                str = " fileSizeLimit";
            } else {
                str = "";
            }
            if (this.durationLimitMillis == null) {
                str = e.l(str, " durationLimitMillis");
            }
            if (this.file == null) {
                str = e.l(str, " file");
            }
            if (str.isEmpty()) {
                return new AutoValue_FileOutputOptions_FileOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.file);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public FileOutputOptions.FileOutputOptionsInternal.Builder setDurationLimitMillis(long j) {
            this.durationLimitMillis = Long.valueOf(j);
            return this;
        }

        public FileOutputOptions.FileOutputOptionsInternal.Builder setFileSizeLimit(long j) {
            this.fileSizeLimit = Long.valueOf(j);
            return this;
        }

        public FileOutputOptions.FileOutputOptionsInternal.Builder setLocation(@Nullable Location location2) {
            this.location = location2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        Location location2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileOutputOptions.FileOutputOptionsInternal)) {
            return false;
        }
        FileOutputOptions.FileOutputOptionsInternal fileOutputOptionsInternal = (FileOutputOptions.FileOutputOptionsInternal) obj;
        if (this.fileSizeLimit != fileOutputOptionsInternal.getFileSizeLimit() || this.durationLimitMillis != fileOutputOptionsInternal.getDurationLimitMillis() || ((location2 = this.location) != null ? !location2.equals(fileOutputOptionsInternal.getLocation()) : fileOutputOptionsInternal.getLocation() != null) || !this.file.equals(fileOutputOptionsInternal.getFile())) {
            return false;
        }
        return true;
    }

    @IntRange(from = 0)
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @NonNull
    public File getFile() {
        return this.file;
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
        return this.file.hashCode() ^ ((i2 ^ i) * 1000003);
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", file=" + this.file + "}";
    }

    private AutoValue_FileOutputOptions_FileOutputOptionsInternal(long j, long j2, @Nullable Location location2, File file2) {
        this.fileSizeLimit = j;
        this.durationLimitMillis = j2;
        this.location = location2;
        this.file = file2;
    }
}
