package androidx.camera.extensions.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AutoValue
public abstract class Version implements Comparable<Version> {
    public static final Version VERSION_1_0 = create(1, 0, 0, "");
    public static final Version VERSION_1_1 = create(1, 1, 0, "");
    public static final Version VERSION_1_2 = create(1, 2, 0, "");
    public static final Version VERSION_1_3 = create(1, 3, 0, "");
    public static final Version VERSION_1_4 = create(1, 4, 0, "");
    private static final Pattern VERSION_STRING_PATTERN = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:\\-(.+))?");

    @NonNull
    public static Version create(int i, int i2, int i3, @NonNull String str) {
        return new AutoValue_Version(i, i2, i3, str);
    }

    private static BigInteger createBigInteger(Version version) {
        return BigInteger.valueOf((long) version.getMajor()).shiftLeft(32).or(BigInteger.valueOf((long) version.getMinor())).shiftLeft(32).or(BigInteger.valueOf((long) version.getPatch()));
    }

    @Nullable
    public static Version parse(@NonNull String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = VERSION_STRING_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        int parseInt2 = Integer.parseInt(matcher.group(2));
        int parseInt3 = Integer.parseInt(matcher.group(3));
        if (matcher.group(4) != null) {
            str2 = matcher.group(4);
        } else {
            str2 = "";
        }
        return create(parseInt, parseInt2, parseInt3, str2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (!Integer.valueOf(getMajor()).equals(Integer.valueOf(version.getMajor())) || !Integer.valueOf(getMinor()).equals(Integer.valueOf(version.getMinor())) || !Integer.valueOf(getPatch()).equals(Integer.valueOf(version.getPatch()))) {
            return false;
        }
        return true;
    }

    public abstract String getDescription();

    public abstract int getMajor();

    public abstract int getMinor();

    public abstract int getPatch();

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getMajor()), Integer.valueOf(getMinor()), Integer.valueOf(getPatch())});
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder(getMajor() + "." + getMinor() + "." + getPatch());
        if (!TextUtils.isEmpty(getDescription())) {
            sb.append("-" + getDescription());
        }
        return sb.toString();
    }

    public int compareTo(@NonNull Version version) {
        return createBigInteger(this).compareTo(createBigInteger(version));
    }

    public int compareTo(int i) {
        return compareTo(i, 0);
    }

    public int compareTo(int i, int i2) {
        if (getMajor() == i) {
            return Integer.compare(getMinor(), i2);
        }
        return Integer.compare(getMajor(), i);
    }
}
