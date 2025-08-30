package com.trustdecision.android.o0O00o00OOoOo0oooOoo00;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.logging.type.LogSeverity;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0OoOo00O000;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0Oo0O0o0ooOOo0oO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0ooOoo0Oo00oOOO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0;
import com.trustdecision.android.shell.TDOption;
import com.trustdecision.android.shell.common.TDDeviceAPIStatus;
import com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.inter.FMCallback;
import com.trustdecision.android.shell.inter.TDDeviceInfoCallback;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.time.DateUtils;

public class o0Oo0OO00O0O000ooOO0 {
    public static volatile boolean O00OO0oOOooooO00000Oo = true;
    private static boolean Oo0O0Oo0OO0OOOoOO0O0 = false;
    public static boolean o0Oo0OO00O0O000ooOO0 = false;
    public static boolean oO00o0OooO0OO0o0000o;
    private static final ArrayDeque oO0oOOOOoo = new ArrayDeque();
    /* access modifiers changed from: private */
    public volatile boolean O0OoOo00O000 = false;
    private volatile boolean O0o0o0O0OOOooOo0OOoOOO = false;
    /* access modifiers changed from: private */
    public CountDownLatch O0o0o0O0ooOooOoo = null;
    public TDOption O0oOO0ooO;
    private Handler O0oOoooo0o0o0oOo;
    /* access modifiers changed from: private */
    public oOO0OooO0 OO0000O0Ooo0OO000oo;
    private volatile byte[] OO000O0O0Oo;
    private HandlerThread Oo0o000OO;
    private boolean OoOOooOoooOoo = false;
    private final Map o00ooooooO00OO0O00 = new o0O00o00OOoOo0oooOoo00(this);
    public String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("30392525253f", 11);
    /* access modifiers changed from: private */
    public volatile boolean o0Oo0O0o0ooOOo0oO0;
    /* access modifiers changed from: private */
    public CountDownLatch o0oOO0oO00OoO0 = null;
    private final o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00 o0ooO0o000Oo0Oo0O0 = new O0OoOo00O000(this);
    /* access modifiers changed from: private */
    public long o0ooOoo0Oo00oOOO = 0;
    private final Object oOOO00oO00o0oOoOo = new Object();

    public class o0O00o00OOoOo0oooOoo00 implements C0020o0Oo0OO00O0O000ooOO0 {
        private final Context o0O00o00OOoOo0oooOoo00;

        public o0O00o00OOoOo0oooOoo00(Context context) {
            this.o0O00o00OOoOo0oooOoo00 = context;
        }

        public void o0Oo0OO00O0O000ooOO0() {
            String str;
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
            if (o0Oo0OO00O0O000ooOO02.o0O00o00OOoOo0oooOoo00()) {
                O0oOO0ooO o0Oo0OO00O0O000ooOO03 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0();
                if (!O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o(this.o0O00o00OOoOo0oooOoo00) || o0Oo0OO00O0O000ooOO03 == null) {
                    str = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
                } else {
                    str = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0(), 0);
                    O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(this.o0O00o00OOoOo0oooOoo00, str, o0Oo0OO00O0O000ooOO03.o0O00o00OOoOo0oooOoo00());
                }
            } else {
                o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(1);
                str = o0Oo0OO00O0O000ooOO0.this.o00ooooooO00OO0O00(this.o0O00o00OOoOo0oooOoo00);
            }
            o0Oo0OO00O0O000ooOO0.this.o0Oo0OO00O0O000ooOO0(str);
        }
    }

    /* renamed from: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public interface C0020o0Oo0OO00O0O000ooOO0 {
        void o0Oo0OO00O0O000ooOO0();
    }

    public static class oO00o0OooO0OO0o0000o {
        static final o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0 = new o0Oo0OO00O0O000ooOO0();
    }

    static {
        try {
            System.currentTimeMillis();
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), o0Oo0OO00O0O000ooOO0("31636263627564767a6f63", 76), o0Oo0OO00O0O000ooOO0("703c38383b", 14));
            oO00o0OooO0OO0o0000o = true;
        } catch (Throwable th) {
            oO00o0OooO0OO0o0000o = false;
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.Oo0o000OO, th.getMessage());
            com.trustdecision.android.shell.common.O0oOO0ooO.o0Oo0OO00O0O000ooOO0((int) LogSeverity.WARNING_VALUE, o0Oo0OO00O0O000ooOO0("092a070c4d5a15464f0e010c000843", 32));
        }
    }

    public o0Oo0OO00O0O000ooOO0() {
        HandlerThread handlerThread = new HandlerThread(o0Oo0OO00O0O000ooOO0("3115141514031215190909151222241a1c191b1a04", 58));
        this.Oo0o000OO = handlerThread;
        handlerThread.start();
        this.O0oOoooo0o0o0oOo = new Handler(this.Oo0o000OO.getLooper());
    }

    private String O00OO0oOOooooO00000Oo(Context context) {
        try {
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
            String str = O00OO0oOOooooO00000Oo2.oO0OOO00;
            o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo o00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0;
            if (!O0OoOo00O000.o0Oo0OO00O0O000ooOO0(context, str, o00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0())) {
                com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0OOO0O0OO0oO0oOoO000, o00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0());
                return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
            }
            if (o0Oo0OO00O0O000ooOO0("36170517", 44).equals(O00OO0oOOooooO00000Oo2.o0Oo0OO00O0O000ooOO0)) {
                String str2 = O00OO0oOOooooO00000Oo2.O0oOO0ooO;
                o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00 = o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0;
                if (!O0OoOo00O000.o0Oo0OO00O0O000ooOO0(context, str2, o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0())) {
                    com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.OOoOo00oo0Ooo0o0o0o000, o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0());
                    return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
                }
            }
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 o0O00o00OOoOo0oooOoo002 = o0Oo0OO00O0O000ooOO02.o0O00o00OOoOo0oooOoo00(context, O00OO0oOOooooO00000Oo2.ooOoOooO);
            o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(o0O00o00OOoOo0oooOoo002);
            if (o0O00o00OOoOo0oooOoo002.equals(o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0)) {
                com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO03 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
                o0O00o00OOoOo0oooOoo00(context, (FMCallback) null);
                if (o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0(1, 2)) {
                    com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo, o0Oo0OO00O0O000ooOO0("15615e4a4c464a0607424a4e5b", 106));
                    o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO03.O00OO0oOOooooO00000Oo(), (C0020o0Oo0OO00O0O000ooOO0) new o0O00o00OOoOo0oooOoo00(context));
                }
                if (O00OO0oOOooooO00000Oo2.OoOOooOoooOoo) {
                    com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o00ooooooO00OO0O00, o0Oo0OO00O0O000ooOO0("045d6b66687a23347178726b6d7671", 89));
                } else if (!O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o(context)) {
                    O0oOO0ooO o0O00o00OOoOo0oooOoo003 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context);
                    if (o0O00o00OOoOo0oooOoo003 != null && O00OO0oOOooooO00000Oo.O00OO0oOOooooO00000Oo(context)) {
                        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(o0O00o00OOoOo0oooOoo003.o0Oo0OO00O0O000ooOO0(), o0O00o00OOoOo0oooOoo003.o0O00o00OOoOo0oooOoo00(), false);
                        String o0Oo0OO00O0O000ooOO04 = o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO03);
                        if (TextUtils.isEmpty(o0Oo0OO00O0O000ooOO04)) {
                            return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
                        }
                        O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO04, o0O00o00OOoOo0oooOoo003.o0O00o00OOoOo0oooOoo00());
                        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("027c4f0a1c50535c566a635349060d58485e58485e", 119));
                        return o0Oo0OO00O0O000ooOO04;
                    }
                } else {
                    String o0Oo0OO00O0O000ooOO05 = o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO03);
                    if (TextUtils.isEmpty(o0Oo0OO00O0O000ooOO05)) {
                        return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
                    }
                    O0oOO0ooO o0Oo0OO00O0O000ooOO06 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0();
                    if (o0Oo0OO00O0O000ooOO06 != null) {
                        O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO05, o0Oo0OO00O0O000ooOO06.o0O00o00OOoOo0oooOoo00());
                    }
                    com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("025a692c3a76757a704c45756f202b7e6e787e6e78", 81));
                    return o0Oo0OO00O0O000ooOO05;
                }
            } else {
                o0Oo0OO00O0O000ooOO02.o00ooooooO00OO0O00(context);
            }
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("02330045531f1c1319252c1c064942170711170711", 56));
            return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
        } catch (Throwable th) {
            return com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(th).toString();
        }
    }

    private String O0oOO0ooO(Context context) {
        O0oOO0ooO o0O00o00OOoOo0oooOoo002;
        if (!O00OO0oOOooooO00000Oo.O00OO0oOOooooO00000Oo(context) || (o0O00o00OOoOo0oooOoo002 = O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00(context)) == null) {
            return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
        }
        O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(o0O00o00OOoOo0oooOoo002.o0Oo0OO00O0O000ooOO0(), o0O00o00OOoOo0oooOoo002.o0O00o00OOoOo0oooOoo00(), false);
        return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(o0O00o00OOoOo0oooOoo002.o0Oo0OO00O0O000ooOO0(), 0);
    }

    /* access modifiers changed from: private */
    public String o00ooooooO00OO0O00(Context context) {
        if (O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o(context)) {
            O0oOO0ooO o0Oo0OO00O0O000ooOO02 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0();
            if (o0Oo0OO00O0O000ooOO02 != null && !TextUtils.isEmpty(o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0())) {
                return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(), 0);
            }
        } else if (OO000O0O0Oo.oO00o0OooO0OO0o0000o(context)) {
            return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
        }
        return O0oOO0ooO(context);
    }

    private void o0O00o00OOoOo0oooOoo00() {
        for (int i = 0; i < 2; i++) {
            CountDownLatch countDownLatch = this.o0oOO0oO00OoO0;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
        CountDownLatch countDownLatch2 = this.O0o0o0O0ooOooOoo;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x04b1, code lost:
        throw new java.lang.Exception(o0Oo0OO00O0O000ooOO0("3779786d716f73782b27743d2075776e", 71));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        if (r6 == null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ab, code lost:
        if (r7 != false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
        Oo0O0Oo0OO0OOOoOO0O0 = true;
        r0 = "231718151911";
        r2 = 57;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        r1.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0(r0, r2);
        r5.o0Oo0OO00O0O000ooOO0(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ca, code lost:
        if (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.OO0000O0Ooo0OO000oo(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()) == false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cc, code lost:
        Oo0O0Oo0OO0OOOoOO0O0 = true;
        r0 = "231e111c1018";
        r2 = 48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d3, code lost:
        Oo0O0Oo0OO0OOOoOO0O0 = false;
        r1.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("351c0317111b1b1917", 55);
        r6 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ec, code lost:
        if (android.text.TextUtils.isEmpty(r4.O0oOO0ooO) != false) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ee, code lost:
        r6.put(o0Oo0OO00O0O000ooOO0("357476637f6e72", 76), r4.O0oOO0ooO);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f9, code lost:
        r6.put(o0Oo0OO00O0O000ooOO0("332d293f24383f", 23), o0Oo0OO00O0O000ooOO0("70191d1d1e", 43));
        r6.put(o0Oo0OO00O0O000ooOO0("241a0b302517", 34), r4.ooOoOooO);
        r7 = r4.oO0OOO00;
        java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0132, code lost:
        if (o0Oo0OO00O0O000ooOO0("36081a08", 51).equals(r4.o0Oo0OO00O0O000ooOO0) == false) goto L_0x0209;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0134, code lost:
        r13 = new java.util.HashMap();
        r11 = com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0(73, (java.lang.Object) new java.lang.Object[]{r8});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0143, code lost:
        if (r11 == null) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0147, code lost:
        if ((r11 instanceof java.lang.String) == false) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0149, code lost:
        r9 = o0Oo0OO00O0O000ooOO0("315f4d", 102);
        r13.put(r9, ((java.lang.String) r11) + (java.lang.Math.abs(new java.security.SecureRandom().nextInt()) % 10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0173, code lost:
        r6 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r7, r13, r6, r8, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x017b, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x017d, code lost:
        r7 = new org.json.JSONObject(r6);
        r9 = r7.optString(o0Oo0OO00O0O000ooOO0("26585f55", 125));
        r11 = r7.optString(o0Oo0OO00O0O000ooOO0("210e191f", 38));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r0 = r7.getJSONObject(o0Oo0OO00O0O000ooOO0("377372627d7c", 77));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01a4, code lost:
        r12 = r7.optString(o0Oo0OO00O0O000ooOO0("377677677879", 72), "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b7, code lost:
        if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01b9, code lost:
        r0 = com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0(75, (java.lang.Object) new java.lang.Object[]{r12, r7.optString(o0Oo0OO00O0O000ooOO0("375d5e4e5a5c4d7767", 99), "")});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01d3, code lost:
        if (r0 == null) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d9, code lost:
        r0 = new org.json.JSONObject((java.lang.String) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01e2, code lost:
        r1.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("234e414c4048", 96);
        com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.Oo0OO00oooO0Ooo000ooOo, o0Oo0OO00O0O000ooOO0("377273667a647873202160707024216463746e6c617863642b23626d606c64", 76));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f9, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0208, code lost:
        throw new java.lang.Exception(o0Oo0OO00O0O000ooOO0("372f2e3b2739252e7d71226b76232138", 17));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x020b, code lost:
        if (r4.o0ooOoo0Oo00oOOO != false) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x020d, code lost:
        r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r7, (java.util.Map) null, r6, r8, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0212, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0214, code lost:
        r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r7, (java.util.Map) null, r6, r8, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0220, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x04a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0222, code lost:
        r0 = new org.json.JSONObject(r6);
        r9 = r0.optString(o0Oo0OO00O0O000ooOO0("263e3933", 27));
        r11 = r0.optString(o0Oo0OO00O0O000ooOO0("210c1b1d", 36));
        r0 = r0.optJSONObject(o0Oo0OO00O0O000ooOO0("377978687776", 71));
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O00OO0oOOooooO00000Oo() throws java.lang.Exception {
        /*
            r22 = this;
            r1 = r22
            r0 = 2
            r2 = 0
            r3 = 1
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r4 = r1.OO0000O0Ooo0OO000oo
            if (r4 == 0) goto L_0x04c5
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r4 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00 r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0()
            android.content.Context r6 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            int[] r6 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.O00OO0oOOooooO00000Oo(r6)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r7 = r1.OO0000O0Ooo0OO000oo
            java.lang.String r8 = "26242a3534213939"
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r3)
            r7.o0Oo0OO00O0O000ooOO0((java.lang.String) r8)
            if (r6 == 0) goto L_0x002d
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r7 = r1.OO0000O0Ooo0OO000oo
            boolean r7 = r7.o0Oo0OO00O0O000ooOO0((int[]) r6)
            goto L_0x002e
        L_0x002d:
            r7 = 0
        L_0x002e:
            android.content.Context r8 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            boolean r8 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.O00OO0oOOooooO00000Oo(r8)
            if (r8 == 0) goto L_0x0041
            android.content.Context r8 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O0oOO0ooO r8 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00((android.content.Context) r8)
            goto L_0x0042
        L_0x0041:
            r8 = 0
        L_0x0042:
            r10 = 82
            if (r8 == 0) goto L_0x006d
            android.content.Context r11 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            boolean r11 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oOOO00oO00o0oOoOo.o0Oo0OO00O0O000ooOO0((android.content.Context) r11)
            if (r11 == 0) goto L_0x006d
            android.content.Context r11 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            int r11 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r11)
            if (r11 != r3) goto L_0x005b
            goto L_0x006d
        L_0x005b:
            java.lang.String r8 = r8.o0Oo0OO00O0O000ooOO0()
            java.lang.Object[] r11 = new java.lang.Object[r3]
            r11[r2] = r8
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r10, (java.lang.Object) r11)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r8 = r1.OO0000O0Ooo0OO000oo
            byte[] r8 = r8.o0Oo0OO00O0O000ooOO0((boolean) r3)
            goto L_0x0073
        L_0x006d:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOO0OooO0 r8 = r1.OO0000O0Ooo0OO000oo
            byte[] r8 = r8.o0Oo0OO00O0O000ooOO0((boolean) r2)
        L_0x0073:
            java.lang.Object r11 = r1.oOOO00oO00o0oOoOo
            monitor-enter(r11)
            if (r8 == 0) goto L_0x04b2
            java.lang.String r13 = "35405f4b4d4747454b"
            r14 = 107(0x6b, float:1.5E-43)
            java.lang.String r13 = o0Oo0OO00O0O000ooOO0((java.lang.String) r13, (int) r14)     // Catch:{ all -> 0x008f }
            java.lang.String r14 = r1.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x008f }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x008f }
            if (r13 == 0) goto L_0x0092
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo     // Catch:{ all -> 0x008f }
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0)     // Catch:{ all -> 0x008f }
            monitor-exit(r11)     // Catch:{ all -> 0x008f }
            return
        L_0x008f:
            r0 = move-exception
            goto L_0x04c3
        L_0x0092:
            byte[] r13 = r1.OO000O0O0Oo     // Catch:{ all -> 0x008f }
            if (r13 == 0) goto L_0x00a8
            byte[] r13 = r1.OO000O0O0Oo     // Catch:{ all -> 0x008f }
            boolean r13 = java.util.Arrays.equals(r13, r8)     // Catch:{ all -> 0x008f }
            if (r13 == 0) goto L_0x00a8
            r5.o0Oo0OO00O0O000ooOO0(r2)     // Catch:{ all -> 0x008f }
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo     // Catch:{ all -> 0x008f }
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0)     // Catch:{ all -> 0x008f }
            monitor-exit(r11)     // Catch:{ all -> 0x008f }
            return
        L_0x00a8:
            monitor-exit(r11)     // Catch:{ all -> 0x008f }
            if (r6 == 0) goto L_0x00c2
            if (r7 != 0) goto L_0x00d3
            Oo0O0Oo0OO0OOOoOO0O0 = r3
            java.lang.String r0 = "231718151911"
            r2 = 57
        L_0x00b3:
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            r5.o0Oo0OO00O0O000ooOO0(r3)
        L_0x00bc:
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0)
            return
        L_0x00c2:
            android.content.Context r6 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            boolean r6 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.OO0000O0Ooo0OO000oo(r6)
            if (r6 == 0) goto L_0x00d3
            Oo0O0Oo0OO0OOOoOO0O0 = r3
            java.lang.String r0 = "231e111c1018"
            r2 = 48
            goto L_0x00b3
        L_0x00d3:
            Oo0O0Oo0OO0OOOoOO0O0 = r2
            java.lang.String r6 = "351c0317111b1b1917"
            r7 = 55
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)
            r1.o0O00o00OOoOo0oooOoo00 = r6
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r7 = r4.O0oOO0ooO
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r11 = 76
            if (r7 != 0) goto L_0x00f9
            java.lang.String r7 = "357476637f6e72"
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r11)
            java.lang.String r13 = r4.O0oOO0ooO
            r6.put(r7, r13)
        L_0x00f9:
            java.lang.String r7 = "332d293f24383f"
            r13 = 23
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r13)
            java.lang.String r13 = "70191d1d1e"
            r14 = 43
            java.lang.String r13 = o0Oo0OO00O0O000ooOO0((java.lang.String) r13, (int) r14)
            r6.put(r7, r13)
            java.lang.String r7 = "241a0b302517"
            r13 = 34
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r13)
            java.lang.String r13 = r4.ooOoOooO
            r6.put(r7, r13)
            java.lang.String r7 = r4.oO0OOO00
            java.lang.System.currentTimeMillis()
            java.lang.String r13 = "36081a08"
            r14 = 51
            java.lang.String r13 = o0Oo0OO00O0O000ooOO0((java.lang.String) r13, (int) r14)
            java.lang.String r14 = r4.o0Oo0OO00O0O000ooOO0
            boolean r13 = r13.equals(r14)
            r10 = 77
            r14 = 38
            r9 = 10
            if (r13 == 0) goto L_0x0209
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            r12 = 73
            java.lang.Object[] r11 = new java.lang.Object[r3]
            r11[r2] = r8
            java.lang.Object r11 = com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r12, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x0173
            boolean r12 = r11 instanceof java.lang.String
            if (r12 == 0) goto L_0x0173
            java.security.SecureRandom r12 = new java.security.SecureRandom
            r12.<init>()
            int r12 = r12.nextInt()
            int r12 = java.lang.Math.abs(r12)
            int r12 = r12 % r9
            java.lang.String r9 = "315f4d"
            r15 = 102(0x66, float:1.43E-43)
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r11 = (java.lang.String) r11
            r15.append(r11)
            r15.append(r12)
            java.lang.String r11 = r15.toString()
            r13.put(r9, r11)
        L_0x0173:
            java.lang.String r6 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r7, r13, r6, r8, r0)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x01fb
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>(r6)
            java.lang.String r9 = "26585f55"
            r11 = 125(0x7d, float:1.75E-43)
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r11)
            java.lang.String r9 = r7.optString(r9)
            java.lang.String r11 = "210e191f"
            java.lang.String r11 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r14)
            java.lang.String r11 = r7.optString(r11)
            java.lang.String r12 = "377372627d7c"
            java.lang.String r12 = o0Oo0OO00O0O000ooOO0((java.lang.String) r12, (int) r10)     // Catch:{ JSONException -> 0x01a4 }
            org.json.JSONObject r0 = r7.getJSONObject(r12)     // Catch:{ JSONException -> 0x01a4 }
            goto L_0x0249
        L_0x01a4:
            java.lang.String r12 = "377677677879"
            r13 = 72
            java.lang.String r12 = o0Oo0OO00O0O000ooOO0((java.lang.String) r12, (int) r13)
            java.lang.String r13 = ""
            java.lang.String r12 = r7.optString(r12, r13)
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 != 0) goto L_0x01f9
            java.lang.String r13 = "375d5e4e5a5c4d7767"
            r15 = 99
            java.lang.String r13 = o0Oo0OO00O0O000ooOO0((java.lang.String) r13, (int) r15)
            java.lang.String r15 = ""
            java.lang.String r7 = r7.optString(r13, r15)
            r13 = 75
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r12
            r0[r3] = r7
            java.lang.Object r0 = com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r13, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x01e2
            boolean r7 = r0 instanceof java.lang.String
            if (r7 == 0) goto L_0x01e2
            org.json.JSONObject r7 = new org.json.JSONObject
            java.lang.String r0 = (java.lang.String) r0
            r7.<init>(r0)
            r0 = r7
            goto L_0x0249
        L_0x01e2:
            java.lang.String r0 = "234e414c4048"
            r7 = 96
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r7)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.Oo0OO00oooO0Ooo000ooOo
            java.lang.String r7 = "377273667a647873202160707024216463746e6c617863642b23626d606c64"
            r12 = 76
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r12)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0, (java.lang.String) r7)
        L_0x01f9:
            r0 = 0
            goto L_0x0249
        L_0x01fb:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r2 = "372f2e3b2739252e7d71226b76232138"
            r3 = 17
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            r0.<init>(r2)
            throw r0
        L_0x0209:
            boolean r0 = r4.o0ooOoo0Oo00oOOO
            if (r0 != 0) goto L_0x0214
            r0 = 0
            java.lang.String r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r7, r0, r6, r8, r3)
        L_0x0212:
            r6 = r0
            goto L_0x021a
        L_0x0214:
            r0 = 0
            java.lang.String r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r7, r0, r6, r8, r2)
            goto L_0x0212
        L_0x021a:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r7 = 71
            if (r0 != 0) goto L_0x04a6
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r6)
            java.lang.String r9 = "263e3933"
            r11 = 27
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r11)
            java.lang.String r9 = r0.optString(r9)
            java.lang.String r11 = "210c1b1d"
            r12 = 36
            java.lang.String r11 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r12)
            java.lang.String r11 = r0.optString(r11)
            java.lang.String r12 = "377978687776"
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r12, (int) r7)
            org.json.JSONObject r0 = r0.optJSONObject(r7)
        L_0x0249:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00 r7 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO0000O0Ooo0OO000oo r12 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0()
            java.lang.String r13 = "757f7f"
            r15 = 86
            java.lang.String r13 = o0Oo0OO00O0O000ooOO0((java.lang.String) r13, (int) r15)
            boolean r13 = r13.equals(r9)
            if (r13 == 0) goto L_0x03c4
            r1.OO000O0O0Oo = r8
            java.lang.String r6 = "3620302620302633353f"
            r8 = 15
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r8)
            r1.o0O00o00OOoOo0oooOoo00 = r6
            if (r0 == 0) goto L_0x0395
            r5.O0oOO0ooO()
            java.lang.String r5 = "313c23292c000a"
            r6 = 14
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r6)
            java.lang.String r5 = r0.optString(r5)
            java.lang.String r6 = "27646f73"
            r8 = 87
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r8)
            java.lang.String r6 = r0.optString(r6)
            java.lang.String r9 = "26"
            r11 = 20
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r11)
            org.json.JSONObject r9 = r0.optJSONObject(r9)
            r13 = 1440(0x5a0, double:7.115E-321)
            r16 = r4
            r3 = 24
            if (r9 == 0) goto L_0x0357
            java.lang.String r11 = "23797c696563"
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r8)
            int r2 = r9.optInt(r8, r2)
            java.lang.String r8 = "3364"
            r11 = 82
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r11)
            long r3 = r9.optLong(r8, r3)
            java.lang.String r8 = "332d36"
            r11 = 27
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r11)
            long r13 = r9.optLong(r8, r13)
            java.lang.String r8 = "3366"
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r10)
            r10 = 259200(0x3f480, double:1.28062E-318)
            long r10 = r9.optLong(r8, r10)
            java.lang.String r8 = "352e"
            r15 = 30
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r15)
            r15 = -1
            int r8 = r9.optInt(r8, r15)
            java.lang.String r15 = "3509"
            r17 = r2
            r2 = 32
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r15, (int) r2)
            r15 = 443(0x1bb, float:6.21E-43)
            int r2 = r9.optInt(r2, r15)
            java.lang.String r15 = "2b4149"
            r18 = r3
            r3 = 101(0x65, float:1.42E-43)
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r15, (int) r3)
            java.lang.String r4 = ""
            java.lang.String r3 = r9.optString(r3, r4)
            java.lang.String r4 = "301b1d"
            r15 = 35
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r15)
            r15 = -1
            int r4 = r9.optInt(r4, r15)
            java.lang.String r15 = "23687d"
            r20 = r13
            r13 = 82
            java.lang.String r13 = o0Oo0OO00O0O000ooOO0((java.lang.String) r15, (int) r13)
            r14 = 1
            int r9 = r9.optInt(r13, r14)
            android.content.Context r13 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r13, (long) r10)
            boolean r10 = android.text.TextUtils.isEmpty(r3)
            if (r10 == 0) goto L_0x0328
            android.content.Context r10 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oOOO00oO00o0oOoOo.o0O00o00OOoOo0oooOoo00(r10)
        L_0x0328:
            android.content.Context r10 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r10, (java.lang.String) r3)
            android.content.Context r3 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o0O00o00OOoOo0oooOoo00((android.content.Context) r3, (int) r4)
            android.content.Context r3 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r3, (int) r9)
            r3 = -1
            if (r8 == r3) goto L_0x0351
            r3 = r16
            java.lang.String r3 = r3.oO0OOO00
            java.lang.String r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0OoOo00O000.o0Oo0OO00O0O000ooOO0((java.lang.String) r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0351
            r1.o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r2, (java.lang.String) r5)
        L_0x0351:
            r2 = r17
            r3 = r18
            r13 = r20
        L_0x0357:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oOOO00oO00o0oOoOo.o0Oo0OO00O0O000ooOO0()
            android.content.Context r8 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            java.lang.String r9 = "31085157020915"
            r10 = 49
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r10)
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r8, (java.lang.String) r9, (java.lang.String) r6)
            android.content.Context r6 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            r12.o0Oo0OO00O0O000ooOO0((android.content.Context) r6, (org.json.JSONObject) r0)
            long r8 = java.lang.System.currentTimeMillis()
            r0 = 1
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (long) r8, (boolean) r0)
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o0Oo0OO00O0O000ooOO0(r0, r8, r2)
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o0O00o00OOoOo0oooOoo00((android.content.Context) r0, (long) r3)
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO000O0O0Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r0, (long) r13)
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0((android.content.Context) r0, (java.lang.String) r5, (long) r8)
            goto L_0x03b0
        L_0x0395:
            java.lang.String r0 = "23707f727e76"
            r2 = 94
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            r0 = 1
            r5.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o
            java.lang.String r2 = "2638353a3b216e7e3b3c2b31333e273c3b74682d2c3c23226e752768682d2c3c23226e7320697f32273e37"
            r3 = 19
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0, (java.lang.String) r2)
        L_0x03b0:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO0oo0ooOO00OOO r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OO0oo0ooOO00OOO.o0Oo0OO00O0O000ooOO0()
            android.content.Context r2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            r0.o0O00o00OOoOo0oooOoo00(r2)
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            r7.o0O00o00OOoOo0oooOoo00(r0)
            goto L_0x00bc
        L_0x03c4:
            java.lang.String r0 = "764d49"
            r2 = 103(0x67, float:1.44E-43)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x03ec
            java.lang.String r0 = "230708050901"
            r2 = 41
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00$o0Oo0OO00O0O000ooOO0 r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00
            r7.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0) r0)
            r0 = 1
            r5.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.OOOOO0o0ooo00oOo0
        L_0x03e7:
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0, (java.lang.String) r11)
            goto L_0x00bc
        L_0x03ec:
            java.lang.String r0 = "76202b"
            r2 = 10
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x041b
            java.lang.String r0 = "23040b060a02"
            r2 = 42
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00$o0Oo0OO00O0O000ooOO0 r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.O0oOO0ooO
            r7.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0) r0)
            r0 = 1
            r5.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oo0o00oooo
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0, (java.lang.String) r11)
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            r7.o0Oo0OO00O0O000ooOO0((android.content.Context) r0)
            goto L_0x00bc
        L_0x041b:
            java.lang.String r0 = "764b41"
            r2 = 97
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x043f
            java.lang.String r0 = "230b0409050d"
            r2 = 37
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00$o0Oo0OO00O0O000ooOO0 r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00
            r7.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0) r0)
            r0 = 1
            r5.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.ooOoOooO
            goto L_0x03e7
        L_0x043f:
            java.lang.String r0 = "762f2c"
            r2 = 4
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0462
            java.lang.String r0 = "234e414c4048"
            r2 = 96
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00$o0Oo0OO00O0O000ooOO0 r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.OO0000O0Ooo0OO000oo
            r7.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0) r0)
            r0 = 1
            r5.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oOoo0oOo
            goto L_0x03e7
        L_0x0462:
            java.lang.String r0 = "750607"
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r14)
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0491
            java.lang.String r0 = "230e010c0008"
            r2 = 32
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            r1.o0O00o00OOoOo0oooOoo00 = r0
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oOOO00oO00o0oOoOo.o0O00o00OOoOo0oooOoo00(r0)
            android.content.Context r0 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.O0oOO0ooO(r0)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00()
            r0 = 1
            r5.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oOO0Oo000oOO00oo0o0
            goto L_0x03e7
        L_0x0491:
            r0 = 1
            java.lang.String r2 = "23626d606c64"
            r3 = 76
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            r1.o0O00o00OOoOo0oooOoo00 = r2
            r5.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r0 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r0, (java.lang.String) r6)
            goto L_0x00bc
        L_0x04a6:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r2 = "3779786d716f73782b27743d2075776e"
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r7)
            r0.<init>(r2)
            throw r0
        L_0x04b2:
            r5.o0Oo0OO00O0O000ooOO0(r2)     // Catch:{ all -> 0x008f }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "0013352933313c6c7c3d2d2d797e3f303d75"
            r3 = 17
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x008f }
            r0.<init>(r2)     // Catch:{ all -> 0x008f }
            throw r0     // Catch:{ all -> 0x008f }
        L_0x04c3:
            monitor-exit(r11)     // Catch:{ all -> 0x008f }
            throw r0
        L_0x04c5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "262d22212827367569282e2b292864683b726f3a38216c"
            r3 = 8
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo():void");
    }

    /* access modifiers changed from: private */
    public void O0oOO0ooO() {
        if (!o0Oo0O0o0ooOOo0oO0.o0O00o00OOoOo0oooOoo00(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0())) {
            if (!o0Oo0OO00O0O000ooOO0) {
                o0Oo0OO00O0O000ooOO0 = true;
                com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0());
                com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(this.o0ooO0o000Oo0Oo0O0);
            }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0().o0Oo0OO00O0O000ooOO0(1);
            return;
        }
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
        try {
            O00OO0oOOooooO00000Oo();
            if (o0Oo0OO00O0O000ooOO0("235758555951", 121).equals(this.o0O00o00OOoOo0oooOoo00) && !Oo0O0Oo0OO0OOOoOO0O0 && this.OO0000O0Ooo0OO000oo != null && !o0Oo0OO00O0O000ooOO02.o0O00o00OOoOo0oooOoo00()) {
                o0Oo0OO00O0O000ooOO0(3000);
            }
        } catch (Throwable unused) {
            this.o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("23646b666a62", 74);
            if (this.OO0000O0Ooo0OO000oo != null && !o0Oo0OO00O0O000ooOO02.o0O00o00OOoOo0oooOoo00()) {
                o0Oo0OO00O0O000ooOO0(3000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void o00ooooooO00OO0O00() {
        try {
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(new o0ooOoo0Oo00oOOO(this));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public void o0O00o00OOoOo0oooOoo00(Context context) {
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0O00o00OOoOo0oooOoo00) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("261d13524b171617160110171b0b0b1710515e1e1b070c171c5b5d06031a04467d26031a04", 56));
        if (o0o00o00ooooo0oooooo00 != null) {
            PackageInfo packageInfo = (PackageInfo) o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(o00ooooooO00OO0O00.O0oOO0ooO[0], new OO0000O0Ooo0OO000oo(this, context));
            o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0(context, 1, o0Oo0OO00O0O000ooOO0("7036323231", 4), packageInfo != null ? packageInfo.versionName : null);
        }
    }

    public static o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0() {
        return oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;
    }

    private void oO00o0OooO0OO0o0000o() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        this.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0(this.O0oOO0ooO, this.o0oOO0oO00OoO0, countDownLatch);
        try {
            countDownLatch.await(10000, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
        this.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00df A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void oO00o0OooO0OO0o0000o(android.content.Context r10) {
        /*
            r9 = this;
            r0 = 0
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r1 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00 r2 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0()
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r3 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oOO0ooO
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r3)
            android.content.Context r3 = r10.getApplicationContext()
            r4 = 1
            if (r3 == 0) goto L_0x0025
            boolean r5 = r9.OoOOooOoooOoo
            if (r5 != 0) goto L_0x0025
            android.app.Application r3 = (android.app.Application) r3
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0o00o0 r5 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0o00o0
            r5.<init>()
            r3.registerActivityLifecycleCallbacks(r5)
            r9.OoOOooOoooOoo = r4
        L_0x0025:
            r3 = 21
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x002f }
            r5[r0] = r10     // Catch:{ all -> 0x002f }
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x002f }
            goto L_0x0041
        L_0x002f:
            java.lang.String r5 = "3170717071667765697c70"
            r6 = 95
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r6)     // Catch:{ all -> 0x0041 }
            java.lang.System.loadLibrary(r5)     // Catch:{ all -> 0x0041 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0041 }
            r5[r0] = r10     // Catch:{ all -> 0x0041 }
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x0041 }
        L_0x0041:
            java.lang.String r3 = "111e6a5d190145420d000b4a5d08180e08180e"
            r5 = 39
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(r3)
            r3 = 0
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x0079 }
            r5.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = "24393c202b303b7c703f2520252025217d6d30277a7934212b3037764d30272b3a31232327"
            r7 = 31
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x0079 }
            r5.addAction(r6)     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = "265d53120f44464e554b514b5750111d414c5f54565343560b0b41"
            r7 = 120(0x78, float:1.68E-43)
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x0079 }
            android.content.Intent r5 = r10.registerReceiver(r3, r5, r6, r3)     // Catch:{ all -> 0x0079 }
            if (r5 == 0) goto L_0x0079
            java.lang.String r6 = "266a67666d60717767"
            r7 = 79
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x0079 }
            boolean r5 = r5.getBooleanExtra(r6, r0)     // Catch:{ all -> 0x0079 }
            com.trustdecision.android.shell.FMAgent.usbConnected = r5     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r5 = 28
            boolean r6 = r1.O0o0o0O0ooOooOoo     // Catch:{ all -> 0x00a5 }
            if (r6 == 0) goto L_0x00aa
            java.lang.String r6 = "36362b3d3c3d"
            r7 = 9
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x00a5 }
            java.lang.Object r10 = r10.getSystemService(r6)     // Catch:{ all -> 0x00a5 }
            android.hardware.SensorManager r10 = (android.hardware.SensorManager) r10     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "263f317069353435342332353929293532737c3c39252e353e796e25382e2f2e6f7a6d337b7b6d33257b337b25257b6d257b7b1d3f2e"
            r6 = 26
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r6)     // Catch:{ all -> 0x00a1 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00 r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r3)     // Catch:{ all -> 0x00a1 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo r3 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo) r3     // Catch:{ all -> 0x00a1 }
            if (r3 == 0) goto L_0x00a3
            r3.o0Oo0OO00O0O000ooOO0(r10)     // Catch:{ all -> 0x00a1 }
            goto L_0x00a3
        L_0x00a1:
            r3 = move-exception
            goto L_0x00db
        L_0x00a3:
            r3 = r10
            goto L_0x00aa
        L_0x00a5:
            r10 = move-exception
            r8 = r3
            r3 = r10
            r10 = r8
            goto L_0x00db
        L_0x00aa:
            java.lang.String r10 = "263936353c332228323c"
            java.lang.String r10 = o0Oo0OO00O0O000ooOO0((java.lang.String) r10, (int) r5)     // Catch:{ all -> 0x00a5 }
            r9.o0O00o00OOoOo0oooOoo00 = r10     // Catch:{ all -> 0x00a5 }
            r9.oO00o0OooO0OO0o0000o()     // Catch:{ all -> 0x00a5 }
            O00OO0oOOooooO00000Oo = r4     // Catch:{ all -> 0x00a5 }
            r2.o0Oo0OO00O0O000ooOO0(r4)     // Catch:{ all -> 0x00a5 }
            java.util.concurrent.CountDownLatch r10 = r9.o0oOO0oO00OoO0
            if (r10 == 0) goto L_0x00c1
            r10.countDown()
        L_0x00c1:
            boolean r10 = r1.O0o0o0O0ooOooOoo
            if (r10 == 0) goto L_0x0107
            if (r3 == 0) goto L_0x0107
            java.lang.String r10 = "26111f5e471b1a1b1a0d1c1b1707071b1c5d5212170b001b1057400b160001004154431d5555431d0b551d550b0b55430b5555331100"
            r0 = 52
            java.lang.String r10 = o0Oo0OO00O0O000ooOO0((java.lang.String) r10, (int) r0)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00 r10 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r10)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo r10 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo) r10
            if (r10 == 0) goto L_0x0107
            r10.o0O00o00OOoOo0oooOoo00(r3)
            goto L_0x0107
        L_0x00db:
            boolean r3 = r3 instanceof com.trustdecision.android.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00e4
            O00OO0oOOooooO00000Oo = r0     // Catch:{ all -> 0x00e2 }
            goto L_0x00e4
        L_0x00e2:
            r0 = move-exception
            goto L_0x0108
        L_0x00e4:
            r2.o0Oo0OO00O0O000ooOO0(r0)     // Catch:{ all -> 0x00e2 }
            java.util.concurrent.CountDownLatch r0 = r9.o0oOO0oO00OoO0
            if (r0 == 0) goto L_0x00ee
            r0.countDown()
        L_0x00ee:
            boolean r0 = r1.O0o0o0O0ooOooOoo
            if (r0 == 0) goto L_0x0107
            if (r10 == 0) goto L_0x0107
            java.lang.String r0 = "26545a1b025e5f5e5f48595e5242425e59181757524e455e5512054e5345444504110658101006584e1058104e4e10064e1010765445"
            r1 = 113(0x71, float:1.58E-43)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00 r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r0)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo r0 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo) r0
            if (r0 == 0) goto L_0x0107
            r0.o0O00o00OOoOo0oooOoo00(r10)
        L_0x0107:
            return
        L_0x0108:
            java.util.concurrent.CountDownLatch r2 = r9.o0oOO0oO00OoO0
            if (r2 == 0) goto L_0x010f
            r2.countDown()
        L_0x010f:
            boolean r1 = r1.O0o0o0O0ooOooOoo
            if (r1 == 0) goto L_0x0126
            if (r10 == 0) goto L_0x0126
            java.lang.String r1 = "263937766f333233322534333f2f2f3334757a3a3f232833387f68233e282928697c6b357d7d6b35237d357d23237d6b237d7d1b3928"
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r5)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00 r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r1)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo r1 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo) r1
            if (r1 == 0) goto L_0x0126
            r1.o0O00o00OOoOo0oooOoo00(r10)
        L_0x0126:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o(android.content.Context):void");
    }

    public String o0Oo0OO00O0O000ooOO0(Context context) {
        o0Oo0OO00O0O000ooOO0(false);
        if (!oO00o0OooO0OO0o0000o || !this.O0OoOo00O000 || context == null) {
            if (o0ooOoo0Oo00oOOO.o0Oo0OO00O0O000ooOO0(context)) {
                throw new IllegalStateException(o0Oo0OO00O0O000ooOO0("16627a1e3b746e213c727268687d7870666a743d7925697c71676330276276766227216e3a216978303c726f64776066606873743b317e79636d7d7e6f606068737435", 92));
            }
        } else if (O00OO0oOOooooO00000Oo) {
            return O00OO0oOOooooO00000Oo(context);
        } else {
            String o00ooooooO00OO0O002 = O00OO0oOOooooO00000Oo.o00ooooooO00OO0O00(context);
            if (!TextUtils.isEmpty(o00ooooooO00OO0O002)) {
                return o00ooooooO00OO0O002;
            }
        }
        return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(context);
    }

    @Nullable
    private String o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00) {
        String o0Oo0OO00O0O000ooOO02 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0() != null ? O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0().o0Oo0OO00O0O000ooOO0() : null;
        if (o0Oo0OO00O0O000ooOO02 == null) {
            return null;
        }
        return O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02, o0o00o00ooooo0oooooo00.oO00o0OooO0OO0o0000o() ? 1 : 0);
    }

    /* access modifiers changed from: private */
    public void oO00o0OooO0OO0o0000o(Context context, FMCallback fMCallback) {
        String o0Oo0OO00O0O000ooOO02;
        o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o;
        String o0Oo0OO00O0O000ooOO03;
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        String str = O00OO0oOOooooO00000Oo2.oO0OOO00;
        o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo o00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0;
        if (!O0OoOo00O000.o0Oo0OO00O0O000ooOO0(context, str, o00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0())) {
            oo00o0oooo0oo0o0000o = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0OOO0O0OO0oO0oOoO000;
            o0Oo0OO00O0O000ooOO03 = o00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0();
        } else {
            if (o0Oo0OO00O0O000ooOO0("360a180a", 49).equals(O00OO0oOOooooO00000Oo2.o0Oo0OO00O0O000ooOO0)) {
                String str2 = O00OO0oOOooooO00000Oo2.O0oOO0ooO;
                o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00 = o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0;
                if (!O0OoOo00O000.o0Oo0OO00O0O000ooOO0(context, str2, o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0())) {
                    oo00o0oooo0oo0o0000o = o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.OOoOo00oo0Ooo0o0o0o000;
                    o0Oo0OO00O0O000ooOO03 = o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0();
                }
            }
            try {
                com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO04 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0 o0O00o00OOoOo0oooOoo002 = o0Oo0OO00O0O000ooOO04.o0O00o00OOoOo0oooOoo00(context, O00OO0oOOooooO00000Oo2.ooOoOooO);
                o0Oo0OO00O0O000ooOO04.o0Oo0OO00O0O000ooOO0(o0O00o00OOoOo0oooOoo002);
                if (o0O00o00OOoOo0oooOoo002.equals(o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0)) {
                    com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO05 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
                    if (!o0O00o00OOoOo0oooOoo00(context, fMCallback)) {
                        if (!O00OO0oOOooooO00000Oo2.OoOOooOoooOoo) {
                            if (o0Oo0OO00O0O000ooOO05.o0Oo0OO00O0O000ooOO0(1, 2)) {
                                com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo, o0Oo0OO00O0O000ooOO0("15457a6e68626e2223666e6a7f", 78));
                                o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO05.O00OO0oOOooooO00000Oo(), (C0020o0Oo0OO00O0O000ooOO0) new o0O00o00OOoOo0oooOoo00(context));
                            } else if (o0Oo0OO00O0O000ooOO05.o0O00o00OOoOo0oooOoo00()) {
                                o0Oo0OO00O0O000ooOO02 = o00ooooooO00OO0O00(context);
                            }
                            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("020e3d786e22212e241811213b747f2a3a2c2a3a2c", 5));
                            return;
                        }
                        com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o00ooooooO00OO0O00, o0Oo0OO00O0O000ooOO0("040a3c313f2d7463262f253c3a2126", 14));
                        o0Oo0OO00O0O000ooOO02 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
                    } else {
                        return;
                    }
                } else {
                    o0Oo0OO00O0O000ooOO04.o00ooooooO00OO0O00(context);
                    o0Oo0OO00O0O000ooOO02 = O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00());
                }
                o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02);
                com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("020e3d786e22212e241811213b747f2a3a2c2a3a2c", 5));
                return;
            } catch (Throwable th) {
                o0Oo0OO00O0O000ooOO0(com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(th).toString());
                return;
            }
        }
        com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(oo00o0oooo0oo0o0000o, o0Oo0OO00O0O000ooOO03);
        o0Oo0OO00O0O000ooOO0(O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(this.OO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00()));
    }

    public void o0O00o00OOoOo0oooOoo00(@NonNull TDOption tDOption) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00();
        try {
            O0OoOo00O000.o0Oo0OO00O0O000ooOO0(tDOption, com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo());
        } catch (Throwable unused) {
        }
        this.O0oOO0ooO = tDOption;
        this.O0o0o0O0OOOooOo0OOoOOO = true;
    }

    /* access modifiers changed from: private */
    public void o0O00o00OOoOo0oooOoo00(String str) {
        String str2;
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0O00o00OOoOo0oooOoo00) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("264c42031a464746475041464a5a5a4641000f4f4a565d464d0a0c57524b55172c77524b55", 105));
        if (o0o00o00ooooo0oooooo00 != null) {
            if (TextUtils.isEmpty(str)) {
                o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("2d3a2622256f33266b31342d33717c3d272f25373d66662d37", 15));
                return;
            }
            Iterator it = this.o00ooooooO00OO0O00.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = "";
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (str.startsWith((String) entry.getKey())) {
                    str2 = (String) entry.getValue();
                    break;
                }
            }
            o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0(str2);
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
            byte b = (byte) (i ^ 41);
            byte b2 = (byte) (bArr[0] ^ 69);
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

    private boolean o0O00o00OOoOo0oooOoo00(Context context, FMCallback fMCallback) {
        if (((int) ((SystemClock.elapsedRealtime() - this.o0ooOoo0Oo00oOOO) / DateUtils.MILLIS_PER_DAY)) >= 1 && context != null) {
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
            o0Oo0OO00O0O000ooOO0(this.O0oOO0ooO);
            o0Oo0OO00O0O000ooOO0(fMCallback != null);
            if (this.OO0000O0Ooo0OO000oo != null) {
                o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(2);
                com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O00OO0oOOooooO00000Oo, o0Oo0OO00O0O000ooOO0("15152a3e38323e7273363e3a2f", 30));
                o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02.O00OO0oOOooooO00000Oo(), (C0020o0Oo0OO00O0O000ooOO0) new o0O00o00OOoOo0oooOoo00(context));
                if (fMCallback != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private void o0Oo0OO00O0O000ooOO0(long j) {
        HandlerThread handlerThread = new HandlerThread(o0Oo0OO00O0O000ooOO0("312d2c2d2c3b2a2d2131312d2a", 2));
        handlerThread.start();
        new Handler(handlerThread.getLooper()).postDelayed(new O0o0o0O0OOOooOo0OOoOOO(this), j);
    }

    public void o0Oo0OO00O0O000ooOO0(Context context, FMCallback fMCallback) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(new o00ooooooO00OO0O00(this, fMCallback, context));
    }

    public void o0Oo0OO00O0O000ooOO0(@NonNull TDOption tDOption) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        try {
            O0OoOo00O000.o0Oo0OO00O0O000ooOO0(tDOption, O00OO0oOOooooO00000Oo2);
        } catch (Throwable unused) {
        }
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0();
        if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o() == 0) {
            o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), tDOption.getAppKey());
            O0OoOo00O000.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), O00OO0oOOooooO00000Oo2.oO0OOO00, o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0());
            if (o0Oo0OO00O0O000ooOO0("36342634", 15).equals(O00OO0oOOooooO00000Oo2.o0Oo0OO00O0O000ooOO0) && com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o() == 0) {
                O0OoOo00O000.o0Oo0OO00O0O000ooOO0(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(), O00OO0oOOooooO00000Oo2.O0oOO0ooO, o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0());
            }
        }
        if (this.o0Oo0O0o0ooOOo0oO0) {
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("0c5a7a60607570786e6e7a7436712d6174796f6b38297b76243c7b7b757a333170686c6a", 84));
            return;
        }
        this.o0oOO0oO00OoO0 = new CountDownLatch(2);
        this.O0OoOo00O000 = true;
        if (!oO00o0OooO0OO0o0000o) {
            o0O00o00OOoOo0oooOoo00();
        } else {
            this.O0oOoooo0o0o0oOo.post(new O0oOO0ooO(this, o0Oo0OO00O0O000ooOO02, O00OO0oOOooooO00000Oo2, tDOption));
        }
    }

    public static synchronized void o0Oo0OO00O0O000ooOO0(FMCallback fMCallback) {
        synchronized (o0Oo0OO00O0O000ooOO0.class) {
            if (fMCallback != null) {
                ArrayDeque arrayDeque = oO0oOOOOoo;
                if (!arrayDeque.contains(fMCallback)) {
                    arrayDeque.offer(fMCallback);
                }
            }
        }
    }

    public void o0Oo0OO00O0O000ooOO0(TDDeviceInfoCallback tDDeviceInfoCallback) {
        if (tDDeviceInfoCallback != null) {
            if (!oO00o0OooO0OO0o0000o) {
                tDDeviceInfoCallback.onResult("", "", "", 0, new TDDeviceAPIStatus(1001, o0Oo0OO00O0O000ooOO0("166870143a687f626223710c6870132b2c2c6330337c717a3b3978777a767e35", 86)), "");
            } else if (!this.O0o0o0O0OOOooOo0OOoOOO) {
                tDDeviceInfoCallback.onResult("", "", "", 0, new TDDeviceAPIStatus(1001, o0Oo0OO00O0O000ooOO0("1640583c1240574a4a0b59236b5a1211444c5a404a515619501950504a74694a4b7068534a51564a03501f5e450419564c031550575c1914555a575e561d", 126)), "");
            } else {
                com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00();
                if (TextUtils.isEmpty(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().oO0OOO00)) {
                    tDDeviceInfoCallback.onResult("", "", "", 0, new TDDeviceAPIStatus(1000, o0Oo0OO00O0O000ooOO0("1176470f1a5b595946425b5b5d1809465051504c41130350190f42574e47130557181d4f574b43014609465051504c411307524c4d1e084d0f034d044833644c15155e01005e59070547080f474045763549", 99)), "");
                    return;
                }
                com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(new O00OO0oOOooooO00000Oo(this, tDDeviceInfoCallback));
            }
        }
    }

    public void o0Oo0OO00O0O000ooOO0(String str) {
        synchronized (o0Oo0OO00O0O000ooOO0.class) {
            try {
                Iterator it = oO0oOOOOoo.iterator();
                while (it.hasNext()) {
                    FMCallback fMCallback = (FMCallback) it.next();
                    if (fMCallback != null) {
                        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00(new oO00o0OooO0OO0o0000o(this, fMCallback, str));
                    }
                    it.remove();
                }
            } finally {
                while (true) {
                }
            }
        }
        if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0() != null && !o0Oo0O0o0ooOOo0oO0.o0O00o00OOoOo0oooOoo00(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0())) {
            com.trustdecision.android.shell.common.O0oOO0ooO.o0Oo0OO00O0O000ooOO0(302, o0Oo0OO00O0O000ooOO0("0b0d6362273d2f343135", 5));
        }
        com.trustdecision.android.shell.common.O0oOO0ooO.o0Oo0OO00O0O000ooOO0((String) null, (String) null);
    }

    private void o0Oo0OO00O0O000ooOO0(String str, int i, String str2) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO00o0OooO0OO0o0000o(new OoOOooOoooOoo(this, str, i, str2));
    }

    /* access modifiers changed from: private */
    public void o0Oo0OO00O0O000ooOO0(boolean z) {
        int i;
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        if (!this.O0OoOo00O000) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.O0o0o0O0ooOooOoo = countDownLatch;
                try {
                    countDownLatch.await(200, TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
            if (!this.O0OoOo00O000) {
                com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0, o0Oo0OO00O0O000ooOO0("017a5a1319564c031e504f4e5359121e50504a", 126));
            }
        }
        CountDownLatch countDownLatch2 = this.o0oOO0oO00OoO0;
        if (countDownLatch2 != null) {
            if (z) {
                try {
                    i = O00OO0oOOooooO00000Oo2.oO00o0OooO0OO0o0000o * 3;
                } catch (Throwable unused2) {
                    return;
                }
            } else {
                i = O00OO0oOOooooO00000Oo2.oO00o0OooO0OO0o0000o;
            }
            if (!countDownLatch2.await((long) i, TimeUnit.MILLISECONDS)) {
                o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o = z ? o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO0OOO00 : o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.ooOo0oO0O000o0O0O00oo;
                com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(oo00o0oooo0oo0o0000o, o0Oo0OO00O0O000ooOO0("0a2b10455e18574607190c0c161856450c15194e0b", 56) + i + o0Oo0OO00O0O000ooOO0("283d", 10));
            }
        }
    }

    private void o0Oo0OO00O0O000ooOO0(byte[] bArr, C0020o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(new oO0oOOOOoo(this, o0oo0oo00o0o000oooo0));
    }
}
