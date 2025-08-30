package org.apache.commons.lang3.text;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

@Deprecated
public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private boolean preserveEscapes;
    private StrMatcher suffixMatcher;
    private StrMatcher valueDelimiterMatcher;
    private StrLookup<?> variableResolver;

    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators((Iterable<?>) list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor((StrLookup<?>) StrLookup.systemPropertiesLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean isPreserveEscapes() {
        return this.preserveEscapes;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public String resolveVariable(String str, StrBuilder strBuilder, int i, int i2) {
        StrLookup<?> variableResolver2 = getVariableResolver();
        if (variableResolver2 == null) {
            return null;
        }
        return variableResolver2.lookup(str);
    }

    public void setEnableSubstitutionInVariables(boolean z) {
        this.enableSubstitutionInVariables = z;
    }

    public void setEscapeChar(char c) {
        this.escapeChar = c;
    }

    public void setPreserveEscapes(boolean z) {
        this.preserveEscapes = z;
    }

    public StrSubstitutor setValueDelimiter(char c) {
        return setValueDelimiterMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        this.valueDelimiterMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariablePrefix(char c) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.prefixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null.");
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.suffixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null.");
    }

    public boolean substitute(StrBuilder strBuilder, int i, int i2) {
        return substitute(strBuilder, i, i2, (List<String>) null) > 0;
    }

    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int substitute(org.apache.commons.lang3.text.StrBuilder r27, int r28, int r29, java.util.List<java.lang.String> r30) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r29
            org.apache.commons.lang3.text.StrMatcher r4 = r26.getVariablePrefixMatcher()
            org.apache.commons.lang3.text.StrMatcher r5 = r26.getVariableSuffixMatcher()
            char r6 = r26.getEscapeChar()
            org.apache.commons.lang3.text.StrMatcher r7 = r26.getValueDelimiterMatcher()
            boolean r8 = r26.isEnableSubstitutionInVariables()
            if (r30 != 0) goto L_0x0020
            r11 = 1
            goto L_0x0021
        L_0x0020:
            r11 = 0
        L_0x0021:
            char[] r12 = r1.buffer
            int r13 = r2 + r3
            r15 = r2
            r14 = r13
            r16 = 0
            r17 = 0
            r13 = r12
            r12 = r30
        L_0x002e:
            if (r15 >= r14) goto L_0x0157
            int r18 = r4.isMatch(r13, r15, r2, r14)
            if (r18 != 0) goto L_0x0044
            int r15 = r15 + 1
            r24 = r4
            r21 = r5
            r22 = r6
            r23 = r11
            r4 = 0
            r6 = 1
            goto L_0x014d
        L_0x0044:
            if (r15 <= r2) goto L_0x006b
            int r10 = r15 + -1
            char r9 = r13[r10]
            if (r9 != r6) goto L_0x006b
            boolean r9 = r0.preserveEscapes
            if (r9 == 0) goto L_0x0053
            int r15 = r15 + 1
            goto L_0x002e
        L_0x0053:
            r1.deleteCharAt(r10)
            char[] r9 = r1.buffer
            int r16 = r16 + -1
            int r14 = r14 + -1
            r24 = r4
            r21 = r5
            r22 = r6
            r13 = r9
            r23 = r11
            r4 = 0
            r6 = 1
            r17 = 1
            goto L_0x014d
        L_0x006b:
            int r9 = r15 + r18
            r10 = r9
            r19 = 0
        L_0x0070:
            if (r10 >= r14) goto L_0x0142
            if (r8 == 0) goto L_0x007f
            int r20 = r4.isMatch(r13, r10, r2, r14)
            if (r20 == 0) goto L_0x007f
            int r19 = r19 + 1
            int r10 = r10 + r20
            goto L_0x0070
        L_0x007f:
            int r20 = r5.isMatch(r13, r10, r2, r14)
            if (r20 != 0) goto L_0x0088
            int r10 = r10 + 1
            goto L_0x0070
        L_0x0088:
            if (r19 != 0) goto L_0x012e
            r21 = r5
            java.lang.String r5 = new java.lang.String
            int r19 = r10 - r15
            r22 = r6
            int r6 = r19 - r18
            r5.<init>(r13, r9, r6)
            if (r8 == 0) goto L_0x00aa
            org.apache.commons.lang3.text.StrBuilder r6 = new org.apache.commons.lang3.text.StrBuilder
            r6.<init>((java.lang.String) r5)
            int r5 = r6.length()
            r9 = 0
            r0.substitute(r6, r9, r5)
            java.lang.String r5 = r6.toString()
        L_0x00aa:
            int r10 = r10 + r20
            if (r7 == 0) goto L_0x00e5
            char[] r6 = r5.toCharArray()
            r23 = r11
            r9 = 0
        L_0x00b5:
            int r11 = r6.length
            if (r9 >= r11) goto L_0x00c1
            if (r8 != 0) goto L_0x00c5
            int r11 = r6.length
            int r11 = r4.isMatch(r6, r9, r9, r11)
            if (r11 == 0) goto L_0x00c5
        L_0x00c1:
            r24 = r4
        L_0x00c3:
            r4 = 0
            goto L_0x00ea
        L_0x00c5:
            int r11 = r7.isMatch(r6, r9)
            if (r11 == 0) goto L_0x00dd
            r24 = r4
            r4 = 0
            java.lang.String r6 = r5.substring(r4, r9)
            int r9 = r9 + r11
            java.lang.String r5 = r5.substring(r9)
            r25 = r6
            r6 = r5
            r5 = r25
            goto L_0x00eb
        L_0x00dd:
            r24 = r4
            r4 = 0
            int r9 = r9 + 1
            r4 = r24
            goto L_0x00b5
        L_0x00e5:
            r24 = r4
            r23 = r11
            goto L_0x00c3
        L_0x00ea:
            r6 = 0
        L_0x00eb:
            if (r12 != 0) goto L_0x00fa
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.lang.String r9 = new java.lang.String
            r9.<init>(r13, r2, r3)
            r12.add(r9)
        L_0x00fa:
            r0.checkCyclicSubstitution(r5, r12)
            r12.add(r5)
            java.lang.String r5 = r0.resolveVariable(r5, r1, r15, r10)
            if (r5 != 0) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r6 = r5
        L_0x0108:
            if (r6 == 0) goto L_0x0123
            int r5 = r6.length()
            r1.replace(r15, r10, r6)
            int r6 = r0.substitute(r1, r15, r5, r12)
            int r6 = r6 + r5
            int r5 = r10 - r15
            int r6 = r6 - r5
            int r10 = r10 + r6
            int r14 = r14 + r6
            int r16 = r16 + r6
            char[] r13 = r1.buffer
            r15 = r10
            r17 = 1
            goto L_0x0124
        L_0x0123:
            r15 = r10
        L_0x0124:
            int r5 = r12.size()
            r6 = 1
            int r5 = r5 - r6
            r12.remove(r5)
            goto L_0x014d
        L_0x012e:
            r24 = r4
            r21 = r5
            r22 = r6
            r23 = r11
            r4 = 0
            r6 = 1
            int r19 = r19 + -1
            int r10 = r10 + r20
            r6 = r22
            r4 = r24
            goto L_0x0070
        L_0x0142:
            r24 = r4
            r21 = r5
            r22 = r6
            r23 = r11
            r4 = 0
            r6 = 1
            r15 = r10
        L_0x014d:
            r5 = r21
            r6 = r22
            r11 = r23
            r4 = r24
            goto L_0x002e
        L_0x0157:
            r23 = r11
            if (r23 == 0) goto L_0x015c
            return r17
        L_0x015c:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.text.StrSubstitutor.substitute(org.apache.commons.lang3.text.StrBuilder, int, int, java.util.List):int");
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    public StrSubstitutor setValueDelimiter(String str) {
        if (!StringUtils.isEmpty(str)) {
            return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
        }
        setValueDelimiterMatcher((StrMatcher) null);
        return this;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null.");
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null.");
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c, String str3) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c, str3);
    }

    public boolean replaceIn(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return replaceIn(sb, 0, sb.length());
    }

    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public boolean replaceIn(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i2).append(sb, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, append.toString());
        return true;
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public boolean replaceIn(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i, i2);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        if (!substitute(strBuilder, 0, str.length())) {
            return str;
        }
        return strBuilder.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c, String str3) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiter(str3);
    }

    public String replace(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(str, i, i2);
        if (!substitute(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c) {
        this(strLookup, strMatcher, strMatcher2, c, DEFAULT_VALUE_DELIMITER);
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c, StrMatcher strMatcher3) {
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c);
        setValueDelimiterMatcher(strMatcher3);
    }

    public String replace(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(cArr, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(stringBuffer, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public String replace(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(charSequence, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StrBuilder strBuilder, int i, int i2) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i2).append(strBuilder, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }
}
