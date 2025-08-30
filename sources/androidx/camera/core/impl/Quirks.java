package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quirks {
    @NonNull
    private final List<Quirk> mQuirks;

    public Quirks(@NonNull List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }

    @NonNull
    public static String toString(@NonNull Quirks quirks) {
        ArrayList arrayList = new ArrayList();
        for (Quirk quirk : quirks.mQuirks) {
            arrayList.add(quirk.getClass().getSimpleName());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    @VisibleForTesting
    public void addQuirkForTesting(@NonNull Quirk quirk) {
        this.mQuirks.add(quirk);
    }

    public boolean contains(@NonNull Class<? extends Quirk> cls) {
        for (Quirk quirk : this.mQuirks) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public <T extends Quirk> T get(@NonNull Class<T> cls) {
        Iterator<Quirk> it = this.mQuirks.iterator();
        while (it.hasNext()) {
            T t = (Quirk) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    @NonNull
    public <T extends Quirk> List<T> getAll(@NonNull Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Quirk next : this.mQuirks) {
            if (cls.isAssignableFrom(next.getClass())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
