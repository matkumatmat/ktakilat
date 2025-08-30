package com.ktakilat.loan.normal_ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.BarUtil;
import com.ktakilat.cbase.utils.Base64Decoder;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.face.google.AutoCompleteAddress;
import com.ktakilat.loan.http.face.google.AutoCompleteResp;
import com.ktakilat.loan.utils.StatusBarTool;
import com.pendanaan.kta.databinding.CActivitySearchAddressLayoutBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchAddressActivity extends BaseActivity {
    public static final /* synthetic */ int t = 0;
    public final ArrayList i = new ArrayList(0);
    public GoolgeSearchAddressAdapter j;
    public boolean k = false;
    public boolean l = false;
    public final Handler m = new Handler(Looper.getMainLooper());
    public Call n = null;
    public Call o = null;
    public CActivitySearchAddressLayoutBinding p;
    public boolean q = true;
    public String r = "";
    public OkHttpClient s;

    /* renamed from: com.ktakilat.loan.normal_ui.SearchAddressActivity$1  reason: invalid class name */
    class AnonymousClass1 implements View.OnFocusChangeListener {
        public final void onFocusChange(View view, boolean z) {
            if (z) {
                KtaCollect.n_company_search_clc_type();
            }
        }
    }

    public static class GoolgeSearchAddressAdapter extends BaseAdapter {
        public final ArrayList c;
        public final LayoutInflater d;
        public final boolean e;

        public GoolgeSearchAddressAdapter(SearchAddressActivity searchAddressActivity, ArrayList arrayList, boolean z) {
            this.c = arrayList;
            this.d = LayoutInflater.from(searchAddressActivity);
            this.e = z;
        }

        public final int getCount() {
            return this.c.size();
        }

        public final Object getItem(int i) {
            return (AutoCompleteAddress) this.c.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            String str;
            View inflate = this.d.inflate(R.layout.c_address_list_item, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.text1);
            if (this.e) {
                str = ((AutoCompleteAddress) this.c.get(i)).description;
            } else {
                str = ((AutoCompleteAddress) this.c.get(i)).structured_formatting.main_text;
            }
            textView.setText(str);
            return inflate;
        }
    }

    public static class SearchCompanyDetailFailException extends Throwable {
        public SearchCompanyDetailFailException(String str) {
            super(str);
        }
    }

    public static class SearchCompanyFailException extends Throwable {
        public SearchCompanyFailException(String str) {
            super(str);
        }
    }

    public final void A(boolean z) {
        int i2;
        TextView textView = this.p.tvOk;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.view.View$OnFocusChangeListener, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v2, types: [okhttp3.Interceptor, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object, javax.net.ssl.HostnameVerifier] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CActivitySearchAddressLayoutBinding inflate = CActivitySearchAddressLayoutBinding.inflate(getLayoutInflater());
        this.p = inflate;
        setContentView((View) inflate.getRoot());
        KtaCollect.n_company_search_exposure();
        this.p.et.requestFocus();
        this.p.et.setOnFocusChangeListener(new Object());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.s = builder.connectTimeout(40, timeUnit).readTimeout(40, timeUnit).writeTimeout(40, timeUnit).addInterceptor(new Object()).hostnameVerifier(new Object()).build();
        this.k = getIntent().getBooleanExtra("isDetailAddress", false);
        int intExtra = getIntent().getIntExtra("addressTag", 0);
        String stringExtra = getIntent().getStringExtra("input");
        if (intExtra == 1) {
            this.p.title.setText("Alamat rumah");
        } else if (intExtra == 2) {
            this.p.title.setText("Alamat kantor");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.p.et.setText(stringExtra);
            A(true);
        }
        this.p.et.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                SearchAddressActivity searchAddressActivity = SearchAddressActivity.this;
                searchAddressActivity.l = false;
                if (TextUtils.isEmpty(searchAddressActivity.p.et.getText().toString())) {
                    searchAddressActivity.i.clear();
                    searchAddressActivity.j.notifyDataSetChanged();
                    searchAddressActivity.A(false);
                    return;
                }
                searchAddressActivity.A(true);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.p.et.setOnFocusChangeListener(new e1(this, 2));
        this.p.et.setOnEditorActionListener(new ie(this));
        GoolgeSearchAddressAdapter goolgeSearchAddressAdapter = new GoolgeSearchAddressAdapter(this, this.i, this.k);
        this.j = goolgeSearchAddressAdapter;
        this.p.lv.setAdapter(goolgeSearchAddressAdapter);
        this.p.lv.setOnItemClickListener(new b(this));
        this.p.tvOk.setOnClickListener(new je(this, 0));
        this.p.ivRight.setOnClickListener(new a(this, 2));
        this.p.backward.setOnClickListener(new je(this, 1));
        this.p.et.setOnClickListener(new y9(9));
        StatusBarTool.Companion.a(getWindow(), this.p.getRoot());
    }

    public final void v() {
        BarUtil.a(this, R.drawable.scaffold_white);
    }

    public final void z(final String str) {
        System.currentTimeMillis();
        Call call = this.n;
        if (call != null) {
            call.cancel();
        }
        StringBuilder t2 = e.t("?input=", str, "&key=");
        t2.append(Base64Decoder.c());
        String sb = t2.toString();
        Request.Builder builder = new Request.Builder();
        this.n = this.s.newCall(builder.url("https://maps.googleapis.com/maps/api/place/queryautocomplete/json" + sb).addHeader(HttpHeaders.CONTENT_TYPE, "application/json;").get().build());
        this.q = false;
        n();
        FirebasePerfOkHttpClient.enqueue(this.n, new Callback() {
            public final void onFailure(Call call, IOException iOException) {
                DataCollectManager.c(new SearchCompanyFailException(iOException.getMessage()));
                SearchAddressActivity.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AnonymousClass5 r0 = AnonymousClass5.this;
                        SearchAddressActivity.this.u();
                        SearchAddressActivity searchAddressActivity = SearchAddressActivity.this;
                        searchAddressActivity.q = true;
                        if (!searchAddressActivity.isFinishing() && !searchAddressActivity.isDestroyed()) {
                            String str = searchAddressActivity.r;
                            String str2 = str;
                            if (str2.equals(str)) {
                                searchAddressActivity.i.clear();
                                searchAddressActivity.i.add(new AutoCompleteAddress(str2));
                                searchAddressActivity.j.notifyDataSetChanged();
                                searchAddressActivity.l = true;
                            }
                        }
                    }
                });
            }

            public final void onResponse(Call call, Response response) {
                final String string = response.body().string();
                final AutoCompleteResp autoCompleteResp = (AutoCompleteResp) JsonUtil.c(string, AutoCompleteResp.class);
                SearchAddressActivity.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AnonymousClass5 r0 = AnonymousClass5.this;
                        SearchAddressActivity.this.u();
                        SearchAddressActivity searchAddressActivity = SearchAddressActivity.this;
                        searchAddressActivity.q = true;
                        if (!searchAddressActivity.isFinishing() && !searchAddressActivity.isDestroyed()) {
                            AutoCompleteResp autoCompleteResp = autoCompleteResp;
                            if (autoCompleteResp == null || !autoCompleteResp.status.toLowerCase(Locale.ROOT).equals("ok")) {
                                DataCollectManager.c(new SearchCompanyFailException(string));
                            }
                            String str = searchAddressActivity.r;
                            String str2 = str;
                            if (!str2.equals(str)) {
                                return;
                            }
                            if (autoCompleteResp == null || !autoCompleteResp.status.toLowerCase(Locale.ROOT).equals("ok")) {
                                searchAddressActivity.r = "";
                                searchAddressActivity.i.clear();
                                searchAddressActivity.i.add(new AutoCompleteAddress(str2));
                                searchAddressActivity.j.notifyDataSetChanged();
                                searchAddressActivity.l = true;
                                return;
                            }
                            searchAddressActivity.i.clear();
                            searchAddressActivity.i.addAll(autoCompleteResp.predictions);
                            searchAddressActivity.i.add(new AutoCompleteAddress(str2));
                            searchAddressActivity.j.notifyDataSetChanged();
                            searchAddressActivity.l = true;
                        }
                    }
                });
            }
        });
    }
}
