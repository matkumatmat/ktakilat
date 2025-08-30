package com.ktakilat.cbase.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;

public class ImageUtil {

    /* renamed from: com.ktakilat.cbase.utils.ImageUtil$1  reason: invalid class name */
    class AnonymousClass1 extends AsyncTask<Void, Void, Drawable> {
        public final Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            StateListDrawable stateListDrawable = new StateListDrawable();
            BitmapDrawable bitmapDrawable = new BitmapDrawable((Bitmap) null);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable((Bitmap) null);
            stateListDrawable.addState(new int[]{16842919}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{16842912}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{16842913}, bitmapDrawable2);
            stateListDrawable.addState(new int[]{-16842919}, bitmapDrawable);
            stateListDrawable.addState(new int[]{-16842912}, bitmapDrawable);
            stateListDrawable.addState(new int[]{-16842913}, bitmapDrawable);
            return stateListDrawable;
        }

        public final void onPostExecute(Object obj) {
            super.onPostExecute((Drawable) obj);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054 A[SYNTHETIC, Splitter:B:33:0x0054] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.graphics.Bitmap r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0060
            boolean r1 = r4.isRecycled()
            if (r1 == 0) goto L_0x000a
            goto L_0x0060
        L_0x000a:
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x001c }
            r2.<init>(r5)     // Catch:{ Exception -> 0x001c }
            boolean r5 = r2.exists()     // Catch:{ Exception -> 0x001c }
            if (r5 == 0) goto L_0x001e
            r2.delete()     // Catch:{ Exception -> 0x001c }
            goto L_0x001e
        L_0x001a:
            r4 = move-exception
            goto L_0x0052
        L_0x001c:
            r4 = move-exception
            goto L_0x0041
        L_0x001e:
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x001c }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001c }
            r3.<init>(r2)     // Catch:{ Exception -> 0x001c }
            r5.<init>(r3)     // Catch:{ Exception -> 0x001c }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r2 = 100
            r4.compress(r1, r2, r5)     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r5.flush()     // Catch:{ IOException -> 0x0036 }
            r5.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003a:
            r4 = 1
            return r4
        L_0x003c:
            r4 = move-exception
            r1 = r5
            goto L_0x0052
        L_0x003f:
            r4 = move-exception
            r1 = r5
        L_0x0041:
            r4.printStackTrace()     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0051
            r1.flush()     // Catch:{ IOException -> 0x004d }
            r1.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0051:
            return r0
        L_0x0052:
            if (r1 == 0) goto L_0x005f
            r1.flush()     // Catch:{ IOException -> 0x005b }
            r1.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005f:
            throw r4
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.utils.ImageUtil.a(android.graphics.Bitmap, java.lang.String):boolean");
    }
}
