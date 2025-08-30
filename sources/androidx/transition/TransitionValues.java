package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        if (this.view != transitionValues.view || !this.values.equals(transitionValues.values)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder s = e.s("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        s.append(this.view);
        s.append(StringUtils.LF);
        String l = e.l(s.toString(), "    values:");
        for (String next : this.values.keySet()) {
            l = l + "    " + next + ": " + this.values.get(next) + StringUtils.LF;
        }
        return l;
    }

    public TransitionValues(@NonNull View view2) {
        this.view = view2;
    }
}
