package defpackage;

import android.content.ClipboardManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.ktakilat.cbase.ui.CrashActivity;
import com.ktakilat.cbase.utils.ToastUtil;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.CharEncoding;

/* renamed from: n4  reason: default package */
public final /* synthetic */ class n4 implements OnItemLongClickListener, ObservableOnSubscribe {
    public final /* synthetic */ CrashActivity c;

    public /* synthetic */ n4(CrashActivity crashActivity) {
        this.c = crashActivity;
    }

    public void c(BaseQuickAdapter baseQuickAdapter, int i) {
        int i2 = CrashActivity.j;
        CrashActivity crashActivity = this.c;
        ((ClipboardManager) crashActivity.getApplicationContext().getSystemService("clipboard")).setText((CharSequence) baseQuickAdapter.f179a.get(i));
        ToastUtil.d(crashActivity, "copy success");
    }

    public void d(ObservableEmitter observableEmitter) {
        String str;
        CrashActivity crashActivity = this.c;
        int i = CrashActivity.j;
        crashActivity.getClass();
        ArrayList arrayList = new ArrayList(0);
        String[] fileList = crashActivity.fileList();
        if (fileList != null && fileList.length > 0) {
            ArrayList arrayList2 = new ArrayList(fileList.length);
            arrayList2.addAll(Arrays.asList(fileList));
            ArrayList arrayList3 = new ArrayList(10);
            for (int i2 = 0; i2 < 10; i2++) {
                String str2 = null;
                int i3 = -1;
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    String str3 = (String) arrayList2.get(i4);
                    try {
                        if (str3.contains("crash-")) {
                            long parseLong = Long.parseLong(str3.substring(str3.lastIndexOf("-") + 1, str3.lastIndexOf(".")));
                            if (str2 != null) {
                                if (parseLong <= Long.parseLong(str2.substring(str2.lastIndexOf("-") + 1, str2.lastIndexOf(".")))) {
                                }
                            }
                            i3 = i4;
                            str2 = str3;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (i3 > -1) {
                    arrayList2.remove(i3);
                    arrayList3.add(str2);
                }
            }
            synchronized (CrashActivity.class) {
                try {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        String str4 = "";
                        try {
                            FileInputStream openFileInput = crashActivity.openFileInput((String) it.next());
                            byte[] bArr = new byte[openFileInput.available()];
                            openFileInput.read(bArr);
                            str = new String(bArr, CharEncoding.UTF_8);
                            try {
                                openFileInput.close();
                            } catch (IOException e) {
                                e = e;
                                str4 = str;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            str = str4;
                            arrayList.add(str);
                        }
                        arrayList.add(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }
}
