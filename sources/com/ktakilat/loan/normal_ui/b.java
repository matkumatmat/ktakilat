package com.ktakilat.loan.normal_ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import com.ktakilat.cbase.utils.Base64Decoder;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.http.face.google.AutoCompleteAddress;
import com.ktakilat.loan.http.face.google.GoolgePlaceDetailResp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public final /* synthetic */ class b implements AdapterView.OnItemClickListener {
    public final /* synthetic */ SearchAddressActivity c;

    public /* synthetic */ b(SearchAddressActivity searchAddressActivity) {
        this.c = searchAddressActivity;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str;
        SearchAddressActivity searchAddressActivity = this.c;
        if (searchAddressActivity.l) {
            ArrayList arrayList = searchAddressActivity.i;
            if (i <= arrayList.size() - 1) {
                Intent intent = new Intent();
                if (searchAddressActivity.k) {
                    str = ((AutoCompleteAddress) arrayList.get(i)).description;
                } else {
                    str = ((AutoCompleteAddress) arrayList.get(i)).structured_formatting.main_text;
                }
                intent.putExtra("address", str);
                if (TextUtils.isEmpty(((AutoCompleteAddress) arrayList.get(i)).place_id) || !searchAddressActivity.k) {
                    searchAddressActivity.setResult(-1, intent);
                    searchAddressActivity.finish();
                    return;
                }
                Call call = searchAddressActivity.o;
                if (call != null) {
                    call.cancel();
                }
                StringBuilder t = e.t("?placeid=", ((AutoCompleteAddress) arrayList.get(i)).place_id, "&key=");
                t.append(Base64Decoder.c());
                String sb = t.toString();
                Request.Builder builder = new Request.Builder();
                Call newCall = searchAddressActivity.s.newCall(builder.url("https://maps.googleapis.com/maps/api/place/details/json" + sb).addHeader(HttpHeaders.CONTENT_TYPE, "application/json;").get().build());
                searchAddressActivity.o = newCall;
                FirebasePerfOkHttpClient.enqueue(newCall, new Callback(intent) {
                    public final /* synthetic */ Intent c;

                    {
                        this.c = r2;
                    }

                    public final void onFailure(Call call, IOException iOException) {
                        DataCollectManager.c(new SearchCompanyDetailFailException(iOException.getMessage()));
                        SearchAddressActivity.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AnonymousClass3 r0 = AnonymousClass3.this;
                                if (!SearchAddressActivity.this.isFinishing() && !SearchAddressActivity.this.isDestroyed()) {
                                    SearchAddressActivity.this.setResult(-1, r0.c);
                                    SearchAddressActivity.this.finish();
                                }
                            }
                        });
                    }

                    public final void onResponse(Call call, Response response) {
                        final String string = response.body().string();
                        final GoolgePlaceDetailResp goolgePlaceDetailResp = (GoolgePlaceDetailResp) JsonUtil.c(string, GoolgePlaceDetailResp.class);
                        SearchAddressActivity.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AnonymousClass3 r0 = AnonymousClass3.this;
                                if (!SearchAddressActivity.this.isFinishing() && !SearchAddressActivity.this.isDestroyed()) {
                                    GoolgePlaceDetailResp goolgePlaceDetailResp = goolgePlaceDetailResp;
                                    if (goolgePlaceDetailResp == null || !goolgePlaceDetailResp.status.toLowerCase(Locale.ROOT).equals("ok")) {
                                        r0.c.putExtra("lat", 0.0d);
                                        r0.c.putExtra("lng", 0.0d);
                                        DataCollectManager.c(new SearchCompanyDetailFailException(string));
                                    } else {
                                        r0.c.putExtra("lat", goolgePlaceDetailResp.result.geometry.location.lat);
                                        r0.c.putExtra("lng", goolgePlaceDetailResp.result.geometry.location.lng);
                                    }
                                    SearchAddressActivity.this.setResult(-1, r0.c);
                                    SearchAddressActivity.this.finish();
                                }
                            }
                        });
                    }
                });
            }
        }
    }
}
