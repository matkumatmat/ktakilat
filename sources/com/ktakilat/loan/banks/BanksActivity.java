package com.ktakilat.loan.banks;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.R;
import com.ktakilat.loan.banks.BanksContact;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.bank_card.BankResp;
import com.pendanaan.kta.databinding.ActivityBankListBinding;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class BanksActivity extends BaseActivity implements BanksContact.View {
    public static final /* synthetic */ int l = 0;
    public BanksPresenter i;
    public BaseQuickAdapter j;
    public ActivityBankListBinding k;

    /* renamed from: com.ktakilat.loan.banks.BanksActivity$1  reason: invalid class name */
    class AnonymousClass1 extends BaseQuickAdapter<BankResp, BaseViewHolder> {
        public final void c(BaseViewHolder baseViewHolder, Object obj) {
            baseViewHolder.setText((int) R.id.bank_name, (CharSequence) ((BankResp) obj).getName());
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityBankListBinding inflate = ActivityBankListBinding.inflate(getLayoutInflater());
        this.k = inflate;
        setContentView((View) inflate.getRoot());
        this.k.pageTitle.backward.setOnClickListener(new t0(this, 0));
        BaseQuickAdapter baseQuickAdapter = new BaseQuickAdapter(R.layout.c_item_custom_banks, new ArrayList(0));
        this.j = baseQuickAdapter;
        baseQuickAdapter.f = new k0(this, 1);
        this.i = new BanksPresenter(this);
        this.k.pageTitle.title.setText(R.string.b_l_b);
        this.k.bankList.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.k.bankList.setAdapter(this.j);
        BanksPresenter banksPresenter = this.i;
        BanksActivity banksActivity = banksPresenter.f486a;
        banksActivity.n();
        new ArrayList(0);
        AppHttp.bankList(RxLifecycle.a(banksActivity.c, ActivityEvent.DESTROY)).subscribe(new ApiObserver<BaseResponse<List<BankResp>>>() {
            public final void a(BaseResponse baseResponse) {
                BanksPresenter.this.f486a.u();
                ResponseCodeDeal.a(baseResponse);
            }

            public final void b(BaseResponse baseResponse) {
                List list = (List) baseResponse.getData();
                if (list == null || list.size() <= 0) {
                    BanksPresenter banksPresenter = BanksPresenter.this;
                    banksPresenter.f486a.u();
                    banksPresenter.f486a.z(list);
                    return;
                }
                Observable.create(new k0(list, 2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a()).subscribe(new Observer<List<BankResp>>() {
                    public final void onComplete() {
                    }

                    public final void onError(Throwable th) {
                        AnonymousClass1 r2 = AnonymousClass1.this;
                        BanksPresenter.this.f486a.u();
                        BanksActivity banksActivity = BanksPresenter.this.f486a;
                    }

                    public final void onNext(Object obj) {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        BanksPresenter.this.f486a.u();
                        BanksPresenter.this.f486a.z((List) obj);
                    }

                    public final void onSubscribe(Disposable disposable) {
                    }
                });
            }
        });
    }

    public final void onDestroy() {
        BanksPresenter banksPresenter = this.i;
        if (banksPresenter != null) {
            banksPresenter.getClass();
        }
        super.onDestroy();
    }

    public final void z(List list) {
        if (list != null) {
            this.j.o(list);
        }
    }
}
