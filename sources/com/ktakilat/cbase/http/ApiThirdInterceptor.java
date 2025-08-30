package com.ktakilat.cbase.http;

import android.text.TextUtils;
import com.ktakilat.cbase.ui.LogActivity;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.apache.commons.lang3.CharEncoding;

public class ApiThirdInterceptor implements Interceptor {
    public static String a(RequestBody requestBody) {
        Buffer buffer = new Buffer();
        if (requestBody == null) {
            return "";
        }
        try {
            requestBody.writeTo(buffer);
            Charset forName = Charset.forName(CharEncoding.UTF_8);
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                forName = contentType.charset(Charset.forName(CharEncoding.UTF_8));
            }
            return buffer.readString(forName);
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = LogActivity.k;
            return "";
        }
    }

    public final Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        System.currentTimeMillis();
        try {
            Response proceed = chain.proceed(request);
            System.currentTimeMillis();
            String string = proceed.body().string();
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            String a2 = a(request.body());
            request.method();
            Objects.toString(request.url());
            RequestBody body = request.body();
            if (!(body == null || body.contentType() == null)) {
                body.contentType().toString();
            }
            a2.length();
            request.headers().toString();
            ArrayList arrayList = LogActivity.k;
            return proceed.newBuilder().body(ResponseBody.create(proceed.body().contentType(), string)).build();
        } catch (Exception e) {
            System.currentTimeMillis();
            String a3 = a(request.body());
            request.method();
            Objects.toString(request.url());
            RequestBody body2 = request.body();
            if (!(body2 == null || body2.contentType() == null)) {
                body2.contentType().toString();
            }
            a3.length();
            request.headers().toString();
            e.toString();
            ArrayList arrayList2 = LogActivity.k;
            throw e;
        }
    }
}
