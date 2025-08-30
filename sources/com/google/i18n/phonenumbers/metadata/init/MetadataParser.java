package com.google.i18n.phonenumbers.metadata.init;

import java.util.logging.Logger;

public final class MetadataParser {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f324a = Logger.getLogger(MetadataParser.class.getName());

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A[SYNTHETIC, Splitter:B:30:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060 A[SYNTHETIC, Splitter:B:34:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List a(java.io.InputStream r8) {
        /*
            r7 = this;
            java.util.logging.Logger r0 = f324a
            java.lang.String r1 = "Error closing input stream (ignored)"
            if (r8 != 0) goto L_0x000d
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r8 = (java.util.List) r8
            return r8
        L_0x000d:
            r2 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0047, all -> 0x0042 }
            r3.<init>(r8)     // Catch:{ IOException -> 0x0047, all -> 0x0042 }
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection r2 = new com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection     // Catch:{ IOException -> 0x0038 }
            r2.<init>()     // Catch:{ IOException -> 0x0038 }
            r2.readExternal(r3)     // Catch:{ IOException -> 0x0038 }
            java.util.List r4 = r2.getMetadataList()     // Catch:{ IOException -> 0x0038 }
            boolean r4 = r4.isEmpty()     // Catch:{ IOException -> 0x0038 }
            if (r4 != 0) goto L_0x003a
            java.util.List r8 = r2.getMetadataList()     // Catch:{ IOException -> 0x0038 }
            r3.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0033
        L_0x002d:
            r2 = move-exception
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            r0.log(r3, r1, r2)
        L_0x0033:
            java.util.List r8 = (java.util.List) r8
            return r8
        L_0x0036:
            r2 = move-exception
            goto L_0x0053
        L_0x0038:
            r2 = move-exception
            goto L_0x004b
        L_0x003a:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0038 }
            java.lang.String r4 = "Empty metadata"
            r2.<init>(r4)     // Catch:{ IOException -> 0x0038 }
            throw r2     // Catch:{ IOException -> 0x0038 }
        L_0x0042:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0053
        L_0x0047:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x004b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0036 }
            java.lang.String r5 = "Unable to parse metadata file"
            r4.<init>(r5, r2)     // Catch:{ all -> 0x0036 }
            throw r4     // Catch:{ all -> 0x0036 }
        L_0x0053:
            if (r3 == 0) goto L_0x0060
            r3.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x006a
        L_0x0059:
            r8 = move-exception
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            r0.log(r3, r1, r8)
            goto L_0x006a
        L_0x0060:
            r8.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x006a
        L_0x0064:
            r8 = move-exception
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            r0.log(r3, r1, r8)
        L_0x006a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.metadata.init.MetadataParser.a(java.io.InputStream):java.util.List");
    }
}
