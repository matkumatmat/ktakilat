package com.katkilat.baidu_face.model;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/model/QualityConfig;", "", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QualityConfig {

    /* renamed from: a  reason: collision with root package name */
    public float f462a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f462a = (float) jSONObject.optDouble("minIllum");
            this.b = (float) jSONObject.optDouble("maxIllum");
            this.c = (float) jSONObject.optDouble("blur");
            this.d = (float) jSONObject.optDouble("leftEyeOcclusion");
            this.e = (float) jSONObject.optDouble("rightEyeOcclusion");
            this.f = (float) jSONObject.optDouble("noseOcclusion");
            this.g = (float) jSONObject.optDouble("mouseOcclusion");
            this.h = (float) jSONObject.optDouble("leftContourOcclusion");
            this.i = (float) jSONObject.optDouble("rightContourOcclusion");
            this.j = (float) jSONObject.optDouble("chinOcclusion");
            this.k = jSONObject.optInt("pitch");
            this.l = jSONObject.optInt("yaw");
            this.m = jSONObject.optInt("roll");
        }
    }
}
