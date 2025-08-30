package com.ktakilat.loan.http;

import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.BaseUrl;
import com.ktakilat.loan.http.bank_card.BankResp;
import com.ktakilat.loan.http.change_phone.CheckPwdReq;
import com.ktakilat.loan.http.collect.CollectReq;
import com.ktakilat.loan.http.collect.FirebaseBindReq;
import com.ktakilat.loan.http.division.DivisionItem;
import com.ktakilat.loan.http.division.DivisionReq;
import com.ktakilat.loan.http.forget_pwd.CheckEktpReq;
import com.ktakilat.loan.http.forget_pwd.CheckOtpForgetPwdReq;
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
import com.ktakilat.loan.http.pop.FetchItem;
import com.ktakilat.loan.http.pop.FetchReq;
import com.ktakilat.loan.http.pop.RenderReq;
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
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AppHttpService {
    @BaseUrl(isThirdDomain = false, moduleName = "com.ktakilat.loan")
    public static final String host = "https://api.pendanaan.com/";

    @POST("/kta/api/v1/bankcard/bank/list")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<List<BankResp>>> bankList();

    @POST("/kta/api/v1/appsflyer/device/binding")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<Object>> bindAppsflyerId(@Body BindAppsflyerIdReq bindAppsflyerIdReq);

    @POST("/kta/api/v1/msgFcm/bindPushToken")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<Object>> bindPushToken(@Body BindPushTokenReq bindPushTokenReq);

    @POST("/kta/api/v1/user/checkEktp")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<IsValidResp>> checkEktp(@Body CheckEktpReq checkEktpReq);

    @POST("/kta/api/v1/user/checkSmsCodeForPwd")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<CheckOtpForgetPwdResp>> checkOtpForgetPwd(@Body CheckOtpForgetPwdReq checkOtpForgetPwdReq);

    @POST("/kta/api/v1/user/checkPwdForChangeMobile")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<CheckOtpForgetPwdResp>> checkPwdChangePhone(@Body CheckPwdReq checkPwdReq);

    @POST("/kta/api/v1/user/face/login/setting/disable")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<Boolean>> closeFace();

    @POST("/kta/api/v1/firebase/device/binding")
    Observable<BaseResponse<Object>> commonFirebaseBind(@Body FirebaseBindReq firebaseBindReq);

    @POST("/kta/api/v1/user/self/verification/face")
    @Multipart
    Observable<BaseResponse<VerifyOtpResp>> commonFirstVerifyByFace(@Part("mobileNo") RequestBody requestBody, @Part("scene") RequestBody requestBody2, @Part("loginLat") RequestBody requestBody3, @Part("loginLng") RequestBody requestBody4, @Part MultipartBody.Part part);

    @POST("/kta/api/v1/user/self/verification/otp")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<VerifyOtpResp>> commonFirstVerifyByOtp(@Body VerifyOtpReq verifyOtpReq);

    @POST("/kta/api/v1/user/self/verification/twoFactorVerification/ektp")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<VerifyEktpResp>> commonSecondVerifyByEktp(@Body FaceEktpReq faceEktpReq);

    @POST("/kta/api/v1/attachment/upload")
    @Multipart
    Observable<BaseResponse<UploadFileResp>> commonUploadFile(@Part("type") RequestBody requestBody, @Part MultipartBody.Part part);

    @POST("/kta/api/v1/user/self/verification/settings")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<VerifyMethodResp>> commonVerifyByLoadMethod(@Body VerifyMethodReq verifyMethodReq);

    @POST("/kta/api/v1/user/face/login/setting/enable/trustdecision")
    Observable<BaseResponse<FaceOpenResp>> enableTrustDecisionFace(@Body Map<String, Object> map);

    @POST("/kta/api/v1/user/face/login")
    @Multipart
    Observable<BaseResponse<FaceLoginResp>> faceLogin(@Part("mobileNo") RequestBody requestBody, @Part("loginLat") RequestBody requestBody2, @Part("loginLng") RequestBody requestBody3, @Part MultipartBody.Part part);

    @POST("/kta/api/v1/user/face/login/ektp")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<UserLoginResp>> faceLoginEktp(@Body FaceEktpReq faceEktpReq);

    @POST("/kta/api/v1/user/face/login/trustdecision")
    Observable<BaseResponse<FaceLoginResp>> faceLoginTrustDecision(@Body Map<String, Object> map);

    @POST("/kta/api/v1/division/getDivision")
    Observable<BaseResponse<List<DivisionItem>>> getDivision(@Body DivisionReq divisionReq);

    @GET("/kta/api/v1/user/face/login/setting/guideScene")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<String>> getFaceConfig();

    @GET("/kta/api/v1/user/face/login/setting")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<FaceEnableResp>> getFaceEnable();

    @POST("/kta/api/v1/trustdecisio/face/license")
    Observable<BaseResponse<LoginFaceLicenseResp>> getFaceLicense(@Body Map<String, Object> map);

    @GET("/kta/api/v1/user/gesture/guideScene")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<String>> getGestureConfig();

    @GET("/kta/api/v1/user/gesture/status")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<GestureSwitchResp>> getGestureSwitch();

    @POST("/kta/api/v1/appHome/getUserConfig")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<String>> getNewPwdTip();

    @POST("/kta/api/v1/opSplash/getOpSplashList")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<SplashItem>> getOpSplashList();

    @POST("/kta/api/v1/user/sendSmsCodeMethods")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<OtpTypeResp>> getOtpSendType();

    @GET("/kta/api/v1/appVersion/getAppVersion")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<VersionResp>> getVersion();

    @POST("/kta/api/v1/operation/listValidOpHorseRaceLampByNoUser")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<List<OpHorseRaceLampConfigResp>>> listValidOpHorseRaceLampByNoUser(@Body OpHorseRaceLampReq opHorseRaceLampReq);

    @POST("/kta/api/v1/user/gesture/login")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<UserLoginResp>> loginGesture(@Body LoginGestureReq loginGestureReq);

    @POST("/kta/api/v1/appHome/getConfig")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<List<LoginMoreResp>>> loginMore(@Body LoginMoreReq loginMoreReq);

    @GET("/kta/api/v1/user/logout")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<Object>> logout();

    @POST("/kta/api/v1/user/mobileVerifyAndLoginType")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<MobileCheckResp>> mobileCheck(@Body MobileVerifyReq mobileVerifyReq);

    @POST("/kta/api/v1/statement/check")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<OjkStatementResp>> ojkStatementCheck(@Body OjkStatementReq ojkStatementReq);

    @POST("/kta/api/v1/statement/save")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<Object>> ojkStatementSave(@Body OjkStatementReq ojkStatementReq);

    @POST("/kta/api/v1/user/face/login/setting/enable")
    @Multipart
    Observable<BaseResponse<FaceOpenResp>> openFace(@Part MultipartBody.Part part);

    @POST("/kta/api/v1/user/face/login/setting/enable/ektp")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<Boolean>> openFaceEktp(@Body FaceEktpReq faceEktpReq);

    @POST("/kta/api/v1/pop/fetch")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<List<FetchItem>>> popFetch(@Body FetchReq fetchReq);

    @POST("/kta/api/v1/opPop/renderTemp")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<String>> renderHtml(@Body RenderReq renderReq);

    @POST("/kta/api/v1/user/commonSendWaSmsCode")
    Observable<BaseResponse<String>> sendWhatsAppOtp(@Body PhoneCodeReq phoneCodeReq);

    @POST("/kta/api/v1/user/gesture/setting")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<IsSuccessResp>> setGesture(@Body SetGestureReq setGestureReq);

    @POST("/kta/api/v1/user/setLoginPhoneVerify")
    Observable<BaseResponse<AcountVerifyResp>> setLoginPhoneVerify(@Body VerifyPhoneCodeNoLoginReq verifyPhoneCodeNoLoginReq);

    @POST("/kta/api/v1/user/self/verification/face/trustdecision")
    Observable<BaseResponse<VerifyOtpResp>> trustDecisionVerification(@Body Map<String, Object> map);

    @POST("/kta/api/v1/appsflyer/updateGaid")
    @Headers({"Content-Type: application/json;"})
    Observable<BaseResponse<Object>> updateGaid();

    @POST("/kta/api/v1/clientInfo/app_list")
    Observable<BaseResponse<Object>> uploadAppList(@Body CollectReq collectReq);

    @POST("/kta/api/v1/clientInfo/google-install/referrer")
    Observable<BaseResponse<Object>> uploadAppsflyerReferrer(@Body CollectReq collectReq);

    @POST("/kta/api/v1/clientInfo/devices")
    Observable<BaseResponse<Object>> uploadDevices(@Body CollectReq collectReq);

    @POST("/kta/api/v1/clientInfo/devices_info")
    Observable<BaseResponse<Object>> uploadDevicesInfo(@Body CollectReq collectReq);

    @POST("/kta/api/v1/trustdecisio/face/liveness/result/log")
    Observable<BaseResponse<Object>> uploadFaceLog(@Body LivenessResultReq livenessResultReq);

    @POST("/kta/api/v1/clientInfo/locations")
    Observable<BaseResponse<Object>> uploadLocation(@Body CollectReq collectReq);

    @POST("/kta/api/v1/clientInfo/locations/list")
    Observable<BaseResponse<Object>> uploadLocationList(@Body CollectReq collectReq);

    @POST("/kta/api/v1/identity/uploadOcrSourceFile")
    Observable<BaseResponse<Object>> uploadOcrSourceFile(@Body UploadOcrSourceReq uploadOcrSourceReq);

    @POST("/kta/api/v1/clientInfo/appCallLog")
    Observable<BaseResponse<Object>> uploadThirdException(@Body CollectReq collectReq);

    @POST("/kta/api/v1/clientInfo/devices_tongdun")
    Observable<BaseResponse<Object>> uploadTondun(@Body CollectReq collectReq);

    @POST("/kta/api/v1/user/confirm/move")
    Observable<BaseResponse<AcountVerifyResp>> userAccountAttention(@Body AcountVerifyReq acountVerifyReq);

    @POST("/kta/api/v1/user/accountVerify")
    Observable<BaseResponse<AcountVerifyResp>> userAccountVerify(@Body AcountVerifyReq acountVerifyReq);

    @POST("/kta/api/v1/user/commonPhoneSendCode")
    Observable<BaseResponse<String>> userCommonPhoneSendCode(@Body PhoneCodeReq phoneCodeReq);

    @POST("/kta/api/v1/user/login")
    Observable<BaseResponse<UserLoginResp>> userLogin(@Body UserLoginReq userLoginReq);

    @POST("/kta/api/v1/user/mobileVerify")
    Observable<BaseResponse<String>> userMobileVerify(@Body MobileVerifyReq mobileVerifyReq);

    @POST("/kta/api/v1/user/setPassword")
    Observable<BaseResponse<Boolean>> userSetPasswordNeedLogin(@Header("Authorization") String str, @Body SetPwdReq setPwdReq);
}
