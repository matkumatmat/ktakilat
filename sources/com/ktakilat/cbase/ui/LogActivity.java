package com.ktakilat.cbase.ui;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.databinding.CActivityBaseLogBinding;
import com.ktakilat.cbase.utils.BarUtil;
import com.ktakilat.cbase.utils.KeybordUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class LogActivity extends BaseActivity {
    public static final ArrayList k = new ArrayList(0);
    public BaseQuickAdapter i;
    public CActivityBaseLogBinding j;

    /* renamed from: com.ktakilat.cbase.ui.LogActivity$1  reason: invalid class name */
    class AnonymousClass1 extends BaseQuickAdapter<String, BaseViewHolder> {
        public final void c(BaseViewHolder baseViewHolder, Object obj) {
            baseViewHolder.setText(R.id.text, (CharSequence) (String) obj);
        }
    }

    public static ArrayList z() {
        ArrayList arrayList;
        synchronized (LogActivity.class) {
            ArrayList arrayList2 = k;
            arrayList = new ArrayList(arrayList2.size());
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CActivityBaseLogBinding inflate = CActivityBaseLogBinding.inflate(getLayoutInflater());
        this.j = inflate;
        setContentView((View) inflate.getRoot());
        finish();
        this.j.titleLayout.title.setText("Log");
        this.j.titleLayout.backward.setOnClickListener(new t0(this, 10));
        ArrayList z = z();
        BaseQuickAdapter baseQuickAdapter = new BaseQuickAdapter(R.layout.c_item_base_log, z);
        this.i = baseQuickAdapter;
        baseQuickAdapter.g = new lb(this, 3);
        this.j.searchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                int i2 = 0;
                if (i != 3) {
                    return false;
                }
                LogActivity logActivity = LogActivity.this;
                String obj = logActivity.j.searchEt.getText().toString();
                EditText editText = logActivity.j.searchEt;
                Handler handler = KeybordUtils.f477a;
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                ArrayList z = LogActivity.z();
                if (TextUtils.isEmpty(obj)) {
                    logActivity.i.o(z);
                    if (!z.isEmpty()) {
                        i2 = z.size() - 1;
                    }
                    logActivity.j.recycler.scrollToPosition(i2);
                } else {
                    logActivity.y();
                    Observable.create(new t2(21, logActivity, obj)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a()).subscribe(new Observer<List<String>>() {
                        public final void onComplete() {
                        }

                        public final void onError(Throwable th) {
                            LogActivity logActivity = LogActivity.this;
                            logActivity.i.o(new ArrayList(0));
                            logActivity.j.recycler.scrollToPosition(0);
                            logActivity.o();
                        }

                        public final void onNext(Object obj) {
                            int i;
                            List list = (List) obj;
                            LogActivity logActivity = LogActivity.this;
                            logActivity.i.o(list);
                            if (list.isEmpty()) {
                                i = 0;
                            } else {
                                i = list.size() - 1;
                            }
                            logActivity.j.recycler.scrollToPosition(i);
                            logActivity.o();
                        }

                        public final void onSubscribe(Disposable disposable) {
                        }
                    });
                }
                return true;
            }
        });
        int i2 = 0;
        this.j.recycler.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.j.recycler.setAdapter(this.i);
        if (!z.isEmpty()) {
            i2 = z.size() - 1;
        }
        this.j.recycler.scrollToPosition(i2);
    }

    public final void v() {
        BarUtil.a(this, R.drawable.scaffold_white);
    }
}
