package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/EncryptedTopic;", "", "encryptedTopic", "", "keyIdentifier", "", "encapsulatedKey", "([BLjava/lang/String;[B)V", "getEncapsulatedKey", "()[B", "getEncryptedTopic", "getKeyIdentifier", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalFeatures.Ext11OptIn
public final class EncryptedTopic {
    @NotNull
    private final byte[] encapsulatedKey;
    @NotNull
    private final byte[] encryptedTopic;
    @NotNull
    private final String keyIdentifier;

    public EncryptedTopic(@NotNull byte[] bArr, @NotNull String str, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "encryptedTopic");
        Intrinsics.checkNotNullParameter(str, "keyIdentifier");
        Intrinsics.checkNotNullParameter(bArr2, "encapsulatedKey");
        this.encryptedTopic = bArr;
        this.keyIdentifier = str;
        this.encapsulatedKey = bArr2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic2 = (EncryptedTopic) obj;
        if (!Arrays.equals(this.encryptedTopic, encryptedTopic2.encryptedTopic) || !this.keyIdentifier.contentEquals(encryptedTopic2.keyIdentifier) || !Arrays.equals(this.encapsulatedKey, encryptedTopic2.encapsulatedKey)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    @NotNull
    public final byte[] getEncryptedTopic() {
        return this.encryptedTopic;
    }

    @NotNull
    public final String getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(Arrays.hashCode(this.encryptedTopic)), this.keyIdentifier, Integer.valueOf(Arrays.hashCode(this.encapsulatedKey))});
    }

    @NotNull
    public String toString() {
        return e.B("EncryptedTopic { ", "EncryptedTopic=" + StringsKt.o(this.encryptedTopic) + ", KeyIdentifier=" + this.keyIdentifier + ", EncapsulatedKey=" + StringsKt.o(this.encapsulatedKey) + " }");
    }
}
