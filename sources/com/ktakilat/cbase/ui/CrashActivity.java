package com.ktakilat.cbase.ui;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.databinding.CActivityBaseLogBinding;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class CrashActivity extends BaseActivity {
    public static final /* synthetic */ int j = 0;
    public BaseQuickAdapter i;

    /* renamed from: com.ktakilat.cbase.ui.CrashActivity$1  reason: invalid class name */
    class AnonymousClass1 extends BaseQuickAdapter<String, BaseViewHolder> {
        public final void c(BaseViewHolder baseViewHolder, Object obj) {
            baseViewHolder.setText(R.id.text, (CharSequence) (String) obj);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CActivityBaseLogBinding inflate = CActivityBaseLogBinding.inflate(getLayoutInflater());
        setContentView((View) inflate.getRoot());
        finish();
        inflate.titleLayout.backward.setOnClickListener(new t0(this, 3));
        inflate.titleLayout.title.setText("崩溃日志");
        BaseQuickAdapter baseQuickAdapter = new BaseQuickAdapter(R.layout.c_item_base_log, new ArrayList(0));
        this.i = baseQuickAdapter;
        baseQuickAdapter.g = new n4(this);
        inflate.recycler.setLayoutManager(new LinearLayoutManager(this, 1, false));
        inflate.recycler.setAdapter(this.i);
        Observable.create(new n4(this)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a()).subscribe(new Observer<List<String>>() {
            public final void onComplete() {
                CrashActivity.this.u();
            }

            public final void onError(Throwable th) {
                CrashActivity.this.u();
            }

            public final void onNext(Object obj) {
                List list = (List) obj;
                CrashActivity crashActivity = CrashActivity.this;
                if (crashActivity.i != null && !crashActivity.isFinishing() && !crashActivity.isDestroyed()) {
                    crashActivity.i.o(list);
                }
            }

            public final void onSubscribe(Disposable disposable) {
                CrashActivity.this.n();
            }
        });
    }
}
