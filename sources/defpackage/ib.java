package defpackage;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.location.Location;
import android.view.View;
import android.webkit.WebView;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.imagecapture.RequestWithCallback;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Consumer;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.loan.login_face.LoginFaceActivity;
import com.ktakilat.loan.login_face.a;
import com.ktakilat.loan.normal_ui.SearchAddressActivity;
import com.ktakilat.loan.utils.LivenessResult;
import com.ktakilat.loan.weiget.GpsUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: ib  reason: default package */
public final /* synthetic */ class ib implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ ib(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        String str;
        Object obj = this.e;
        Object obj2 = this.d;
        switch (this.c) {
            case 0:
                WebView webView = (WebView) obj2;
                String str2 = (String) obj;
                try {
                    webView.loadUrl("javascript:" + str2);
                    return;
                } catch (Exception e2) {
                    e2.toString();
                    ArrayList arrayList = LogActivity.k;
                    return;
                }
            case 1:
                ((LiveDataObservable) obj2).lambda$fetchData$0((CallbackToFutureAdapter.Completer) obj);
                return;
            case 2:
                ((Consumer) obj2).accept((Location) obj);
                return;
            case 3:
                int i = LoginFaceActivity.r;
                LoginFaceActivity loginFaceActivity = (LoginFaceActivity) obj2;
                loginFaceActivity.getClass();
                GpsUtil.b(loginFaceActivity, new a(loginFaceActivity, (LivenessResult) obj));
                return;
            case 4:
                ((MetadataImageReader) obj2).lambda$enqueueImageProxy$1((ImageReaderProxy.OnImageAvailableListener) obj);
                return;
            case 5:
                BaseResponse baseResponse = (BaseResponse) obj;
                if (baseResponse != null) {
                    str = baseResponse.getMsg();
                } else {
                    str = null;
                }
                ((a) obj2).invoke(str);
                return;
            case 6:
                ((Preview.SurfaceProvider) obj2).onSurfaceRequested((SurfaceRequest) obj);
                return;
            case 7:
                ((Preview) obj2).lambda$createPipeline$0((CameraInternal) obj);
                return;
            case 8:
                ((Executor) obj2).execute((Runnable) obj);
                return;
            case 9:
                ((Recorder) obj2).lambda$onSourceStateChanged$1((VideoOutput.SourceState) obj);
                return;
            case 10:
                ((RemovalListener) obj2).onRemoval((RemovalNotification) obj);
                return;
            case 11:
                ((ResourcesCompat.FontCallback) obj2).lambda$callbackSuccessAsync$0((Typeface) obj);
                return;
            case 12:
                int i2 = SearchAddressActivity.t;
                ((SearchAddressActivity) obj2).z((String) obj);
                return;
            case 13:
                ((SurfaceProcessorWithExecutor) obj2).lambda$onInputSurface$0((SurfaceRequest) obj);
                return;
            case 14:
                ((SurfaceProcessorWithExecutor) obj2).lambda$onOutputSurface$1((SurfaceOutput) obj);
                return;
            case 15:
                ((TakePictureManager) obj2).lambda$trackCurrentRequests$1((RequestWithCallback) obj);
                return;
            case 16:
                ((TakePictureRequest) obj2).lambda$onResult$2((ImageProxy) obj);
                return;
            case 17:
                ((TakePictureRequest) obj2).lambda$onPostviewBitmapAvailable$4((Bitmap) obj);
                return;
            case 18:
                ((TakePictureRequest) obj2).lambda$onResult$1((ImageCapture.OutputFileResults) obj);
                return;
            case 19:
                ((TakePictureRequest) obj2).lambda$onError$0((ImageCaptureException) obj);
                return;
            case 20:
                Threads.lambda$runOnMainSync$0((Runnable) obj2, (CountDownLatch) obj);
                return;
            case 21:
                ((UserMetadata) obj2).lambda$updateRolloutsState$1((List) obj);
                return;
            case 22:
                ((VideoCapture) obj2).lambda$createPipeline$2((DeferrableSurface) obj);
                return;
            default:
                ((ViewTransition) obj2).lambda$applyTransition$0((View[]) obj);
                return;
        }
    }
}
