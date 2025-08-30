package com.ktakilat.cbase.http;

import android.os.Build;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.JsonParseException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import retrofit2.HttpException;

public class HttpExceptionController {

    public interface HTTP_ERROR {
    }

    public interface JSON_ERROR {
    }

    public interface NET_DNS_ERROR {
    }

    public interface NORMAL_ERROR {
    }

    public interface TIME_OUT_ERROR {
    }

    public interface UNKNOWN_HOST_ERROR {
    }

    public static BaseResponse a(Throwable th) {
        FirebaseCrashlytics.getInstance().recordException(th);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(false);
        baseResponse.setCode("Y100000");
        baseResponse.setMsg("Internet tidak stabil, harap perbarui halaman dan coba lagi[Y100000]");
        if (th instanceof HttpException) {
            baseResponse.setCode("Y100001");
            baseResponse.setMsg("Internet tidak stabil, harap perbarui halaman dan coba lagi[Y100001]");
        } else if (th instanceof UnknownHostException) {
            baseResponse.setCode("Y100005");
            baseResponse.setMsg("Internet tidak stabil, harap perbarui halaman dan coba lagi[Y100005]");
        } else if ((th instanceof JsonParseException) || (th instanceof JSONException) || (th instanceof ParseException)) {
            baseResponse.setCode("Y100003");
            baseResponse.setMsg("Internet tidak stabil, harap perbarui halaman dan coba lagi[Y100003]");
        } else if ((th instanceof ConnectException) || (th instanceof SocketTimeoutException) || (th instanceof ConnectTimeoutException)) {
            baseResponse.setCode("Y100004");
            baseResponse.setMsg("Internet tidak stabil, harap perbarui halaman dan coba lagi[Y100004]");
        }
        if (Build.VERSION.SDK_INT >= 29 && z.t(th)) {
            baseResponse.setCode("Y100002");
            baseResponse.setMsg("Internet tidak stabil, harap perbarui halaman dan coba lagi");
        }
        return baseResponse;
    }
}
