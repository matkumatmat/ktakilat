package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i2 > 0 || json.length() + i >= CLElement.MAX_LINE) {
            sb.append("[\n");
            Iterator<CLElement> it = this.mElements.iterator();
            boolean z = true;
            while (it.hasNext()) {
                CLElement next = it.next();
                if (!z) {
                    sb.append(",\n");
                } else {
                    z = false;
                }
                addIndent(sb, CLElement.BASE_INDENT + i);
                sb.append(next.toFormattedJSON(CLElement.BASE_INDENT + i, i2 - 1));
            }
            sb.append(StringUtils.LF);
            addIndent(sb, i);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z = true;
        for (int i = 0; i < this.mElements.size(); i++) {
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(this.mElements.get(i).toJSON());
        }
        return sb + "]";
    }
}
