package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import org.apache.commons.lang3.CharEncoding;

public final class oO0oOOOOoo {
    private EGLContext o0O00o00OOoOo0oooOoo00 = EGL14.EGL_NO_CONTEXT;
    private EGLConfig o0Oo0OO00O0O000ooOO0 = null;
    private EGLDisplay oO00o0OooO0OO0o0000o;

    public oO0oOOOOoo(EGLContext eGLContext, int i) {
        EGLConfig o0Oo0OO00O0O000ooOO02;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.oO00o0OooO0OO0o0000o = eGLDisplay;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.oO00o0OooO0OO0o0000o = eglGetDisplay;
            if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException(o0Oo0OO00O0O000ooOO0("70485c505d5a1607481c145142073651582e5647175e49504f5e4b", 42));
            } else if (EGL14.eglInitialize(eglGetDisplay, new int[2], 0, new int[2], 1)) {
                if (!((i & 2) == 0 || (o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0(i, 3)) == null)) {
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.oO00o0OooO0OO0o0000o, o0Oo0OO00O0O000ooOO02, eGLContext, new int[]{12440, 3, 12344}, 0);
                    if (EGL14.eglGetError() == 12288) {
                        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO02;
                        this.o0O00o00OOoOo0oooOoo00 = eglCreateContext;
                    }
                }
                if (this.o0O00o00OOoOo0oooOoo00 == EGL14.EGL_NO_CONTEXT) {
                    EGLConfig o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO0(i, 2);
                    if (o0Oo0OO00O0O000ooOO03 != null) {
                        EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.oO00o0OooO0OO0o0000o, o0Oo0OO00O0O000ooOO03, eGLContext, new int[]{12440, 2, 12344}, 0);
                        o0O00o00OOoOo0oooOoo00();
                        this.o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO03;
                        this.o0O00o00OOoOo0oooOoo00 = eglCreateContext2;
                    } else {
                        throw new RuntimeException(o0Oo0OO00O0O000ooOO0("5053676b66612d3c73272e676f622c29293b6e74757d6b66612d0d6a63674469606766", 17));
                    }
                }
                EGL14.eglQueryContext(this.oO00o0OooO0OO0o0000o, this.o0O00o00OOoOo0oooOoo00, 12440, new int[1], 0);
            } else {
                this.oO00o0OooO0OO0o0000o = null;
                throw new RuntimeException(o0Oo0OO00O0O000ooOO0("707c6864696e22337c282e60607a7a6f6a6274782202656c1a62", 30));
            }
        } else {
            throw new RuntimeException(o0Oo0OO00O0O000ooOO0("404841260b47545d4e4f5713195c5b1e1f4f", 51));
        }
    }

    private void o0O00o00OOoOo0oooOoo00() {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(o0Oo0OO00O0O000ooOO0("60070e2a34120110142329041f1418094b1f60070e6940120518184d1f154d", 124) + Integer.toHexString(eglGetError));
        }
    }

    private EGLConfig o0Oo0OO00O0O000ooOO0(int i, int i2) {
        int[] iArr = new int[13];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        int i3 = 4;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12352;
        if (i2 >= 3) {
            i3 = 68;
        }
        iArr[9] = i3;
        iArr[10] = 12344;
        iArr[11] = 0;
        iArr[12] = 12344;
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.oO00o0OooO0OO0o0000o, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        return null;
    }

    public void finalize() throws Throwable {
        try {
            EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        } finally {
            super.finalize();
        }
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 121);
            byte b2 = (byte) (bArr[0] ^ 5);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void o0Oo0OO00O0O000ooOO0() {
        EGLDisplay eGLDisplay = this.oO00o0OooO0OO0o0000o;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLContext eGLContext = this.o0O00o00OOoOo0oooOoo00;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.oO00o0OooO0OO0o0000o, eGLContext);
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.oO00o0OooO0OO0o0000o);
        }
        this.oO00o0OooO0OO0o0000o = EGL14.EGL_NO_DISPLAY;
        this.o0O00o00OOoOo0oooOoo00 = EGL14.EGL_NO_CONTEXT;
        this.o0Oo0OO00O0O000ooOO0 = null;
    }

    public void o0Oo0OO00O0O000ooOO0(EGLSurface eGLSurface) {
        if (!EGL14.eglMakeCurrent(this.oO00o0OooO0OO0o0000o, eGLSurface, eGLSurface, this.o0O00o00OOoOo0oooOoo00)) {
            throw new RuntimeException(o0Oo0OO00O0O000ooOO0("606a63494462664e5e6f687f63723c2e6f606d6169", 17));
        }
    }
}
