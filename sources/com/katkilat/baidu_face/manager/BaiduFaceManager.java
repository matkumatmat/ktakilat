package com.katkilat.baidu_face.manager;

import android.app.Activity;
import android.util.Log;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.utils.FileUtils;
import com.facebook.places.model.PlaceFields;
import com.katkilat.baidu_face.model.QualityConfig;
import com.ktakilat.cbase.datacollect.KtaCollect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/katkilat/baidu_face/manager/BaiduFaceManager;", "", "Companion", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaiduFaceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaiduFaceManager.kt\ncom/katkilat/baidu_face/manager/BaiduFaceManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,239:1\n1557#2:240\n1628#2,3:241\n*S KotlinDebug\n*F\n+ 1 BaiduFaceManager.kt\ncom/katkilat/baidu_face/manager/BaiduFaceManager\n*L\n49#1:240\n49#1:241,3\n*E\n"})
public final class BaiduFaceManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f457a = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new q0(0));

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/manager/BaiduFaceManager$Companion;", "", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
    public static void a(Activity activity, ArrayList arrayList, Function0 function0, Function0 function02) {
        Intrinsics.checkNotNullParameter(activity, "mContext");
        Intrinsics.checkNotNullParameter(arrayList, "livenessList");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function02, "onFail");
        ArrayList arrayList2 = new ArrayList(CollectionsKt.h(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((LivenessTypeEnum) it.next()).ordinal()));
        }
        KtaCollect.n_face_type(CollectionsKt.p(arrayList2, ",", (String) null, (String) null, (Function1) null, 62));
        FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
        QualityConfigManager qualityConfigManager = (QualityConfigManager) QualityConfigManager.b.getValue();
        qualityConfigManager.getClass();
        Class<QualityConfigManager> cls = QualityConfigManager.class;
        Intrinsics.checkNotNullParameter(activity, PlaceFields.CONTEXT);
        try {
            JSONObject optJSONObject = new JSONObject(FileUtils.readAssetFileUtf8String(activity.getAssets(), "quality_config.json")).optJSONObject("normal");
            QualityConfig qualityConfig = qualityConfigManager.f461a;
            if (qualityConfig != null) {
                qualityConfig.a(optJSONObject);
            }
        } catch (IOException e) {
            Log.e(cls.getName(), "初始配置读取失败", e);
            qualityConfigManager.f461a = null;
        } catch (JSONException e2) {
            Log.e(cls.getName(), "初始配置读取失败, JSON格式不正确", e2);
            qualityConfigManager.f461a = null;
        } catch (Exception e3) {
            Log.e(cls.getName(), "初始配置读取失败, JSON格式不正确", e3);
            qualityConfigManager.f461a = null;
        }
        QualityConfig qualityConfig2 = qualityConfigManager.f461a;
        if (qualityConfig2 == null) {
            Log.e("baidu_face", "初始化失败 = json配置文件解析出错");
            function02.invoke();
            return;
        }
        faceConfig.setBlurnessValue(qualityConfig2.c);
        faceConfig.setBrightnessValue(qualityConfig2.f462a);
        faceConfig.setBrightnessMaxValue(qualityConfig2.b);
        faceConfig.setOcclusionLeftEyeValue(qualityConfig2.d);
        faceConfig.setOcclusionRightEyeValue(qualityConfig2.e);
        faceConfig.setOcclusionNoseValue(qualityConfig2.f);
        faceConfig.setOcclusionMouthValue(qualityConfig2.g);
        faceConfig.setOcclusionLeftContourValue(qualityConfig2.h);
        faceConfig.setOcclusionRightContourValue(qualityConfig2.i);
        faceConfig.setOcclusionChinValue(qualityConfig2.j);
        faceConfig.setHeadPitchValue(qualityConfig2.k);
        faceConfig.setHeadYawValue(qualityConfig2.l);
        faceConfig.setHeadRollValue(qualityConfig2.m);
        faceConfig.setMinFaceSize(200);
        faceConfig.setNotFaceValue(0.6f);
        faceConfig.setEyeClosedValue(0.7f);
        faceConfig.setCacheImageNum(3);
        faceConfig.setLivenessTypeList(arrayList);
        faceConfig.setLivenessRandom(true);
        faceConfig.setSound(true);
        faceConfig.setScale(1.0f);
        faceConfig.setCropHeight(FaceEnvironment.VALUE_CROP_HEIGHT);
        faceConfig.setCropWidth(FaceEnvironment.VALUE_CROP_WIDTH);
        faceConfig.setEnlargeRatio(1.5f);
        faceConfig.setTimeDetectModule(FaceEnvironment.TIME_DETECT_MODULE);
        faceConfig.setFaceFarRatio(0.4f);
        faceConfig.setFaceClosedRatio(1.0f);
        faceConfig.setOpenMask(true);
        FaceSDKManager.getInstance().setFaceConfig(faceConfig);
        FaceSDKManager.getInstance().initialize(activity, "ktakilat-face-android", "idl-license.face-android", new BaiduFaceManager$initialize$1(activity, function0, function02));
    }
}
