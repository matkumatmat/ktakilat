package kotlin.enums;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/enums/EnumEntriesList;", "", "T", "Lkotlin/enums/EnumEntries;", "Lkotlin/collections/AbstractList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.8")
final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, Serializable {
    public final Enum[] c;

    public EnumEntriesList(Enum[] enumArr) {
        Intrinsics.checkNotNullParameter(enumArr, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        this.c = enumArr;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.c);
    }

    public final boolean contains(Object obj) {
        Enum enumR;
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum enumR2 = (Enum) obj;
        Intrinsics.checkNotNullParameter(enumR2, "element");
        int ordinal = enumR2.ordinal();
        Enum[] enumArr = this.c;
        Intrinsics.checkNotNullParameter(enumArr, "<this>");
        if (ordinal < 0 || ordinal >= enumArr.length) {
            enumR = null;
        } else {
            enumR = enumArr[ordinal];
        }
        if (enumR == enumR2) {
            return true;
        }
        return false;
    }

    public final Object get(int i) {
        AbstractList.Companion companion = AbstractList.Companion;
        Enum[] enumArr = this.c;
        int length = enumArr.length;
        companion.getClass();
        AbstractList.Companion.b(i, length);
        return enumArr[i];
    }

    public final int getSize() {
        return this.c.length;
    }

    public final int indexOf(Object obj) {
        Enum enumR;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum enumR2 = (Enum) obj;
        Intrinsics.checkNotNullParameter(enumR2, "element");
        int ordinal = enumR2.ordinal();
        Enum[] enumArr = this.c;
        Intrinsics.checkNotNullParameter(enumArr, "<this>");
        if (ordinal < 0 || ordinal >= enumArr.length) {
            enumR = null;
        } else {
            enumR = enumArr[ordinal];
        }
        if (enumR == enumR2) {
            return ordinal;
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum enumR = (Enum) obj;
        Intrinsics.checkNotNullParameter(enumR, "element");
        return indexOf(enumR);
    }
}
