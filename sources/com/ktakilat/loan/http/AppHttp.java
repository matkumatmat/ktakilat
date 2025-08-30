package com.ktakilat.loan.http;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.ktakilat.cbase.http.ApiManager;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.bank_card.BankResp;
import com.ktakilat.loan.http.change_phone.CheckPwdReq;
import com.ktakilat.loan.http.collect.CollectReq;
import com.ktakilat.loan.http.collect.FirebaseBindReq;
import com.ktakilat.loan.http.division.DivisionEnum;
import com.ktakilat.loan.http.division.DivisionItem;
import com.ktakilat.loan.http.division.DivisionReq;
import com.ktakilat.loan.http.forget_pwd.CheckEktpReq;
import com.ktakilat.loan.http.forget_pwd.CheckOtpForgetPwdResp;
import com.ktakilat.loan.http.forget_pwd.IsValidResp;
import com.ktakilat.loan.http.gesture.GestureSwitchResp;
import com.ktakilat.loan.http.gesture.IsSuccessResp;
import com.ktakilat.loan.http.gesture.LoginGestureReq;
import com.ktakilat.loan.http.gesture.SetGestureReq;
import com.ktakilat.loan.http.kta_face.FaceEktpReq;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.http.kta_face.FaceLoginResp;
import com.ktakilat.loan.http.kta_face.FaceOpenResp;
import com.ktakilat.loan.http.login.LoginFaceLicenseResp;
import com.ktakilat.loan.http.login.LoginMoreReq;
import com.ktakilat.loan.http.login.LoginMoreResp;
import com.ktakilat.loan.http.login.MobileCheckResp;
import com.ktakilat.loan.http.ojk.OjkStatementReq;
import com.ktakilat.loan.http.ojk.OjkStatementResp;
import com.ktakilat.loan.http.op_horse.OpHorseRaceLampConfigResp;
import com.ktakilat.loan.http.op_horse.OpHorseRaceLampReq;
import com.ktakilat.loan.http.operation.SplashItem;
import com.ktakilat.loan.http.phone_code.PhoneCodeReq;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.pop.FetchItem;
import com.ktakilat.loan.http.pop.FetchReq;
import com.ktakilat.loan.http.pop.RenderReq;
import com.ktakilat.loan.http.upload.FileUploadEnum;
import com.ktakilat.loan.http.upload.LivenessResultReq;
import com.ktakilat.loan.http.upload.UploadFileResp;
import com.ktakilat.loan.http.upload.UploadOcrSourceReq;
import com.ktakilat.loan.http.user.AcountVerifyReq;
import com.ktakilat.loan.http.user.AcountVerifyResp;
import com.ktakilat.loan.http.user.BindAppsflyerIdReq;
import com.ktakilat.loan.http.user.BindPushTokenReq;
import com.ktakilat.loan.http.user.MobileVerifyReq;
import com.ktakilat.loan.http.user.OtpTypeResp;
import com.ktakilat.loan.http.user.SetPwdReq;
import com.ktakilat.loan.http.user.UserLoginReq;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.http.user.VerifyPhoneCodeNoLoginReq;
import com.ktakilat.loan.http.verify.VerifyEktpResp;
import com.ktakilat.loan.http.verify.VerifyMethodReq;
import com.ktakilat.loan.http.verify.VerifyMethodResp;
import com.ktakilat.loan.http.verify.VerifyOtpReq;
import com.ktakilat.loan.http.verify.VerifyOtpResp;
import com.ktakilat.loan.http.version.VersionResp;
import com.ktakilat.loan.utils.LivenessResult;
import com.ktakilat.loan.weiget.CommonPopUtil;
import com.trello.rxlifecycle2.LifecycleTransformer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AppHttp {
    public static Observable<BaseResponse<List<BankResp>>> bankList(LifecycleTransformer<BaseResponse<List<BankResp>>> lifecycleTransformer) {
        Observable<BaseResponse<List<BankResp>>> observeOn = ((AppHttpService) ApiManager.b().d()).bankList().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> bindAppsflyerId(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).bindAppsflyerId(new BindAppsflyerIdReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> bindPushToken(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).bindPushToken(new BindPushTokenReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<IsValidResp>> checkEktp(LifecycleTransformer<BaseResponse<IsValidResp>> lifecycleTransformer, String str) {
        Observable<BaseResponse<IsValidResp>> observeOn = ((AppHttpService) ApiManager.b().d()).checkEktp(new CheckEktpReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<CheckOtpForgetPwdResp>> checkPwdChangePhone(LifecycleTransformer<BaseResponse<CheckOtpForgetPwdResp>> lifecycleTransformer, String str, String str2) {
        Observable<BaseResponse<CheckOtpForgetPwdResp>> observeOn = ((AppHttpService) ApiManager.b().d()).checkPwdChangePhone(new CheckPwdReq(str, str2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Boolean>> closeFace(LifecycleTransformer<BaseResponse<Boolean>> lifecycleTransformer) {
        Observable<BaseResponse<Boolean>> observeOn = ((AppHttpService) ApiManager.b().d()).closeFace().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> commonFirebaseBind(String str) {
        return ((AppHttpService) ApiManager.b().d()).commonFirebaseBind(new FirebaseBindReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
    }

    public static Observable<BaseResponse<VerifyOtpResp>> commonFirstVerifyByFace(LifecycleTransformer<BaseResponse<VerifyOtpResp>> lifecycleTransformer, String str, int i, File file, String str2, double d, double d2) {
        String str3;
        LifecycleTransformer<BaseResponse<VerifyOtpResp>> lifecycleTransformer2 = lifecycleTransformer;
        if (TextUtils.isEmpty(str2)) {
            str3 = String.valueOf(System.currentTimeMillis()) + ".jpg";
        } else {
            str3 = str2;
        }
        String str4 = str;
        File file2 = file;
        Observable<BaseResponse<VerifyOtpResp>> observeOn = ((AppHttpService) ApiManager.b().d()).commonFirstVerifyByFace(RequestBody.create(MediaType.parse("text/plain"), str), RequestBody.create(MediaType.parse("text/plain"), String.valueOf(i)), RequestBody.create(MediaType.parse("text/plain"), String.valueOf(d)), RequestBody.create(MediaType.parse("text/plain"), String.valueOf(d2)), MultipartBody.Part.createFormData("faceImg", str3, RequestBody.create(MediaType.parse("multipart/form-data; boundary=c7812f06-aaa4-4111-b517-73d26816861a"), file))).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer2 != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<VerifyOtpResp>> commonFirstVerifyByOtp(LifecycleTransformer<BaseResponse<VerifyOtpResp>> lifecycleTransformer, String str, String str2, int i, double d, double d2) {
        LifecycleTransformer<BaseResponse<VerifyOtpResp>> lifecycleTransformer2 = lifecycleTransformer;
        Observable<BaseResponse<VerifyOtpResp>> observeOn = ((AppHttpService) ApiManager.b().d()).commonFirstVerifyByOtp(new VerifyOtpReq(i, str, str2, d, d2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer2 != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<VerifyEktpResp>> commonSecondVerifyByEktp(LifecycleTransformer<BaseResponse<VerifyEktpResp>> lifecycleTransformer, String str, String str2) {
        Observable<BaseResponse<VerifyEktpResp>> observeOn = ((AppHttpService) ApiManager.b().d()).commonSecondVerifyByEktp(new FaceEktpReq(str, str2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<UploadFileResp>> commonUploadFile(LifecycleTransformer<BaseResponse<UploadFileResp>> lifecycleTransformer, FileUploadEnum fileUploadEnum, File file, String str) {
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(System.currentTimeMillis()) + ".jpg";
        }
        Observable<BaseResponse<UploadFileResp>> observeOn = ((AppHttpService) ApiManager.b().d()).commonUploadFile(RequestBody.create(MediaType.parse("text/plain"), fileUploadEnum.getValue()), MultipartBody.Part.createFormData(MessengerShareContentUtility.ATTACHMENT, str, RequestBody.create(MediaType.parse("multipart/form-data; boundary=c7812f06-aaa4-4111-b517-73d26816861a"), file))).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<VerifyMethodResp>> commonVerifyByLoadMethod(LifecycleTransformer<BaseResponse<VerifyMethodResp>> lifecycleTransformer, String str, int i) {
        Observable<BaseResponse<VerifyMethodResp>> observeOn = ((AppHttpService) ApiManager.b().d()).commonVerifyByLoadMethod(new VerifyMethodReq(str, i)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<FaceOpenResp>> enableTrustDecisionFace(LifecycleTransformer<BaseResponse<FaceOpenResp>> lifecycleTransformer, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("faceImg", str);
        hashMap.put("livenessId", str2);
        Observable<BaseResponse<FaceOpenResp>> subscribeOn = ((AppHttpService) ApiManager.b().d()).enableTrustDecisionFace(hashMap).subscribeOn(Schedulers.c).subscribeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return subscribeOn.compose(lifecycleTransformer);
        }
        return subscribeOn;
    }

    public static Observable<BaseResponse<FaceLoginResp>> faceLogin(LifecycleTransformer<BaseResponse<FaceLoginResp>> lifecycleTransformer, String str, double d, double d2, File file, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = String.valueOf(System.currentTimeMillis()) + ".jpg";
        }
        Observable<BaseResponse<FaceLoginResp>> observeOn = ((AppHttpService) ApiManager.b().d()).faceLogin(RequestBody.create(MediaType.parse("text/plain"), str), RequestBody.create(MediaType.parse("text/plain"), String.valueOf(d)), RequestBody.create(MediaType.parse("text/plain"), String.valueOf(d2)), MultipartBody.Part.createFormData("faceImg", str2, RequestBody.create(MediaType.parse("multipart/form-data; boundary=c7812f06-aaa4-4111-b517-73d26816861a"), file))).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<UserLoginResp>> faceLoginEktp(LifecycleTransformer<BaseResponse<UserLoginResp>> lifecycleTransformer, String str, String str2) {
        Observable<BaseResponse<UserLoginResp>> observeOn = ((AppHttpService) ApiManager.b().d()).faceLoginEktp(new FaceEktpReq(str, str2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<FaceLoginResp>> faceLoginTrustDecision(LifecycleTransformer<BaseResponse<FaceLoginResp>> lifecycleTransformer, String str, String str2, double d, double d2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobileNo", str2);
        hashMap.put("faceImg", str3);
        hashMap.put("loginLat", Double.valueOf(d));
        hashMap.put("loginLng", Double.valueOf(d2));
        hashMap.put("livenessId", str4);
        Observable<BaseResponse<FaceLoginResp>> subscribeOn = ((AppHttpService) ApiManager.b().d()).faceLoginTrustDecision(hashMap).subscribeOn(Schedulers.c).subscribeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return subscribeOn.compose(lifecycleTransformer);
        }
        return subscribeOn;
    }

    public static Observable<BaseResponse<List<DivisionItem>>> getDivision(LifecycleTransformer<BaseResponse<List<DivisionItem>>> lifecycleTransformer, DivisionEnum divisionEnum, Integer num) {
        Observable<BaseResponse<List<DivisionItem>>> observeOn = ((AppHttpService) ApiManager.b().d()).getDivision(new DivisionReq(Integer.valueOf(divisionEnum.getValue()), Boolean.valueOf(divisionEnum.equals(DivisionEnum.PROVINCE)), num)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<String>> getFaceConfig(LifecycleTransformer<BaseResponse<String>> lifecycleTransformer) {
        Observable<BaseResponse<String>> observeOn = ((AppHttpService) ApiManager.b().d()).getFaceConfig().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<FaceEnableResp>> getFaceEnable(LifecycleTransformer<BaseResponse<FaceEnableResp>> lifecycleTransformer) {
        Observable<BaseResponse<FaceEnableResp>> observeOn = ((AppHttpService) ApiManager.b().d()).getFaceEnable().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<LoginFaceLicenseResp>> getFaceLicense(LifecycleTransformer<BaseResponse<LoginFaceLicenseResp>> lifecycleTransformer) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceNo", AppKv.g().f465a.getString("androidIDv2", ""));
        Observable<BaseResponse<LoginFaceLicenseResp>> subscribeOn = ((AppHttpService) ApiManager.b().d()).getFaceLicense(hashMap).subscribeOn(Schedulers.c);
        if (lifecycleTransformer != null) {
            return subscribeOn.compose(lifecycleTransformer);
        }
        return subscribeOn;
    }

    public static Observable<BaseResponse<String>> getGestureConfig(LifecycleTransformer<BaseResponse<String>> lifecycleTransformer) {
        Observable<BaseResponse<String>> observeOn = ((AppHttpService) ApiManager.b().d()).getGestureConfig().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<GestureSwitchResp>> getGestureSwitch(LifecycleTransformer<BaseResponse<GestureSwitchResp>> lifecycleTransformer) {
        Observable<BaseResponse<GestureSwitchResp>> observeOn = ((AppHttpService) ApiManager.b().d()).getGestureSwitch().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<String>> getNewPwdTip(LifecycleTransformer<BaseResponse<String>> lifecycleTransformer) {
        Observable<BaseResponse<String>> observeOn = ((AppHttpService) ApiManager.b().d()).getNewPwdTip().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<SplashItem>> getOpSplashList(LifecycleTransformer<BaseResponse<SplashItem>> lifecycleTransformer) {
        Observable<BaseResponse<SplashItem>> observeOn = ((AppHttpService) ApiManager.b().d()).getOpSplashList().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<OtpTypeResp>> getOtpSendType() {
        return ((AppHttpService) ApiManager.b().d()).getOtpSendType().subscribeOn(Schedulers.c).subscribeOn(AndroidSchedulers.a());
    }

    public static Observable<BaseResponse<VersionResp>> getVersion(LifecycleTransformer<BaseResponse<VersionResp>> lifecycleTransformer) {
        Observable<BaseResponse<VersionResp>> observeOn = ((AppHttpService) ApiManager.b().d()).getVersion().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<List<OpHorseRaceLampConfigResp>>> listValidOpHorseRaceLampByNoUser(LifecycleTransformer<BaseResponse<List<OpHorseRaceLampConfigResp>>> lifecycleTransformer, String... strArr) {
        OpHorseRaceLampReq opHorseRaceLampReq = new OpHorseRaceLampReq();
        opHorseRaceLampReq.addPosition(strArr);
        Observable<BaseResponse<List<OpHorseRaceLampConfigResp>>> observeOn = ((AppHttpService) ApiManager.b().d()).listValidOpHorseRaceLampByNoUser(opHorseRaceLampReq).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<UserLoginResp>> loginGesture(LifecycleTransformer<BaseResponse<UserLoginResp>> lifecycleTransformer, String str, List<Integer> list, double d, double d2) {
        StringBuilder sb = new StringBuilder();
        for (Integer append : list) {
            sb.append(append);
        }
        Observable<BaseResponse<UserLoginResp>> observeOn = ((AppHttpService) ApiManager.b().d()).loginGesture(new LoginGestureReq(str, sb.toString(), d, d2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<List<LoginMoreResp>>> loginMore(LifecycleTransformer<BaseResponse<List<LoginMoreResp>>> lifecycleTransformer, String str) {
        Observable<BaseResponse<List<LoginMoreResp>>> observeOn = ((AppHttpService) ApiManager.b().d()).loginMore(new LoginMoreReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> logout(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).logout().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<MobileCheckResp>> mobileCheck(LifecycleTransformer<BaseResponse<MobileCheckResp>> lifecycleTransformer, String str) {
        Observable<BaseResponse<MobileCheckResp>> observeOn = ((AppHttpService) ApiManager.b().d()).mobileCheck(new MobileVerifyReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<OjkStatementResp>> ojkStatementCheck(LifecycleTransformer<BaseResponse<OjkStatementResp>> lifecycleTransformer) {
        Observable<BaseResponse<OjkStatementResp>> observeOn = ((AppHttpService) ApiManager.b().d()).ojkStatementCheck(new OjkStatementReq("OJK", 1)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> ojkStatementSave(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).ojkStatementSave(new OjkStatementReq("OJK", 1)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<FaceOpenResp>> openFace(LifecycleTransformer<BaseResponse<FaceOpenResp>> lifecycleTransformer, File file, String str) {
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(System.currentTimeMillis()) + ".jpg";
        }
        Observable<BaseResponse<FaceOpenResp>> observeOn = ((AppHttpService) ApiManager.b().d()).openFace(MultipartBody.Part.createFormData("faceImg", str, RequestBody.create(MediaType.parse("multipart/form-data; boundary=c7812f06-aaa4-4111-b517-73d26816861a"), file))).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Boolean>> openFaceEktp(LifecycleTransformer<BaseResponse<Boolean>> lifecycleTransformer, String str, String str2) {
        Observable<BaseResponse<Boolean>> observeOn = ((AppHttpService) ApiManager.b().d()).openFaceEktp(new FaceEktpReq(str, str2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<List<FetchItem>>> popFetch(LifecycleTransformer<BaseResponse<List<FetchItem>>> lifecycleTransformer, CommonPopUtil.PageType pageType) {
        Observable<BaseResponse<List<FetchItem>>> observeOn = ((AppHttpService) ApiManager.b().d()).popFetch(new FetchReq(pageType.getValue())).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<String>> renderHtml(LifecycleTransformer<BaseResponse<String>> lifecycleTransformer, String str) {
        Observable<BaseResponse<String>> observeOn = ((AppHttpService) ApiManager.b().d()).renderHtml(new RenderReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<String>> sendPhoneCode(LifecycleTransformer<BaseResponse<String>> lifecycleTransformer, String str, PhoneCodeType phoneCodeType) {
        Observable<BaseResponse<String>> observeOn = ((AppHttpService) ApiManager.b().d()).userCommonPhoneSendCode(new PhoneCodeReq(str, phoneCodeType)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<String>> sendWhatsAppOtp(LifecycleTransformer<BaseResponse<String>> lifecycleTransformer, String str, PhoneCodeType phoneCodeType) {
        Observable<BaseResponse<String>> subscribeOn = ((AppHttpService) ApiManager.b().d()).sendWhatsAppOtp(new PhoneCodeReq(str, phoneCodeType)).subscribeOn(Schedulers.c).subscribeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return subscribeOn.compose(lifecycleTransformer);
        }
        return subscribeOn;
    }

    public static Observable<BaseResponse<IsSuccessResp>> setGesture(LifecycleTransformer<BaseResponse<IsSuccessResp>> lifecycleTransformer, List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer append : list) {
            sb.append(append);
        }
        Observable<BaseResponse<IsSuccessResp>> observeOn = ((AppHttpService) ApiManager.b().d()).setGesture(new SetGestureReq(sb.toString())).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<AcountVerifyResp>> setLoginPhoneVerify(LifecycleTransformer<BaseResponse<AcountVerifyResp>> lifecycleTransformer, String str, String str2, double d, double d2) {
        Observable<BaseResponse<AcountVerifyResp>> observeOn = ((AppHttpService) ApiManager.b().d()).setLoginPhoneVerify(new VerifyPhoneCodeNoLoginReq(str, str2, d, d2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<VerifyOtpResp>> trustDecisionVerification(LifecycleTransformer<BaseResponse<VerifyOtpResp>> lifecycleTransformer, String str, int i, double d, double d2, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobileNo", str);
        hashMap.put("scene", Integer.valueOf(i));
        hashMap.put("loginLat", Double.valueOf(d));
        hashMap.put("loginLng", Double.valueOf(d2));
        hashMap.put("faceImg", str2);
        hashMap.put("livenessId", str3);
        Observable<BaseResponse<VerifyOtpResp>> subscribeOn = ((AppHttpService) ApiManager.b().d()).trustDecisionVerification(hashMap).subscribeOn(Schedulers.c).subscribeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return subscribeOn.compose(lifecycleTransformer);
        }
        return subscribeOn;
    }

    public static Observable<BaseResponse<Object>> updateGaid(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).updateGaid().subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadAppList(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadAppList(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadAppsflyerReferrer(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadAppsflyerReferrer(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadDevices(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadDevices(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadDevicesInfo(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadDevicesInfo(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadFaceLog(LivenessResult livenessResult) {
        LivenessResultReq livenessResultReq = new LivenessResultReq();
        livenessResultReq.setLivenessId(livenessResult.getLiveness_id());
        livenessResultReq.setCode(Integer.valueOf(livenessResult.getCode()));
        livenessResultReq.setMessage(livenessResult.getMessage());
        livenessResultReq.setSequenceId(livenessResult.getSequence_id());
        livenessResultReq.setImage(livenessResult.getImage());
        return ((AppHttpService) ApiManager.b().d()).uploadFaceLog(livenessResultReq).subscribeOn(Schedulers.c).subscribeOn(AndroidSchedulers.a());
    }

    public static Observable<BaseResponse<Object>> uploadLocation(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadLocation(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadLocationList(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadLocationList(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadOcrSourceFile(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str, String str2) {
        Observable<BaseResponse<Object>> subscribeOn = ((AppHttpService) ApiManager.b().d()).uploadOcrSourceFile(new UploadOcrSourceReq(str, str2)).subscribeOn(Schedulers.c).subscribeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return subscribeOn.compose(lifecycleTransformer);
        }
        return subscribeOn;
    }

    public static Observable<BaseResponse<Object>> uploadThirdException(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadThirdException(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Object>> uploadTondun(LifecycleTransformer<BaseResponse<Object>> lifecycleTransformer, String str) {
        Observable<BaseResponse<Object>> observeOn = ((AppHttpService) ApiManager.b().d()).uploadTondun(new CollectReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<AcountVerifyResp>> userAccountAttention(LifecycleTransformer<BaseResponse<AcountVerifyResp>> lifecycleTransformer, String str, String str2, double d, double d2, String str3, String str4, String str5) {
        LifecycleTransformer<BaseResponse<AcountVerifyResp>> lifecycleTransformer2 = lifecycleTransformer;
        Observable<BaseResponse<AcountVerifyResp>> observeOn = ((AppHttpService) ApiManager.b().d()).userAccountAttention(new AcountVerifyReq(str2, str, (String) null, (String) null, d, d2, str3, str4, str5)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer2 != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<UserLoginResp>> userLogin(LifecycleTransformer<BaseResponse<UserLoginResp>> lifecycleTransformer, String str, String str2, double d, double d2) {
        Observable<BaseResponse<UserLoginResp>> observeOn = ((AppHttpService) ApiManager.b().d()).userLogin(new UserLoginReq(str, str2, d, d2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<String>> userMobileVerify(LifecycleTransformer<BaseResponse<String>> lifecycleTransformer, String str) {
        Observable<BaseResponse<String>> observeOn = ((AppHttpService) ApiManager.b().d()).userMobileVerify(new MobileVerifyReq(str)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<AcountVerifyResp>> userRegist(LifecycleTransformer<BaseResponse<AcountVerifyResp>> lifecycleTransformer, String str, String str2, String str3, double d, double d2, String str4, String str5, String str6) {
        LifecycleTransformer<BaseResponse<AcountVerifyResp>> lifecycleTransformer2 = lifecycleTransformer;
        Observable<BaseResponse<AcountVerifyResp>> observeOn = ((AppHttpService) ApiManager.b().d()).userAccountVerify(new AcountVerifyReq((String) null, str, str2, str3, d, d2, str4, str5, str6)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer2 != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }

    public static Observable<BaseResponse<Boolean>> userSetPasswordNeedLogin(LifecycleTransformer<BaseResponse<Boolean>> lifecycleTransformer, String str, String str2, String str3) {
        Observable<BaseResponse<Boolean>> observeOn = ((AppHttpService) ApiManager.b().d()).userSetPasswordNeedLogin(str, new SetPwdReq(str2)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a());
        if (lifecycleTransformer != null) {
            return observeOn.compose(lifecycleTransformer);
        }
        return observeOn;
    }
}
