package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public final /* synthetic */ class a implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f312a;

    public /* synthetic */ a(int i) {
        this.f312a = i;
    }

    public final Object parse(JsonReader jsonReader) {
        switch (this.f312a) {
            case 0:
                return CrashlyticsReportJsonTransform.parseEventFrame(jsonReader);
            case 1:
                return CrashlyticsReportJsonTransform.parseBuildIdMappingForArch(jsonReader);
            case 2:
                return CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
            case 3:
                return CrashlyticsReportJsonTransform.parseProcessDetails(jsonReader);
            case 4:
                return CrashlyticsReportJsonTransform.parseEvent(jsonReader);
            case 5:
                return CrashlyticsReportJsonTransform.parseEventThread(jsonReader);
            case 6:
                return CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader);
            case 7:
                return CrashlyticsReportJsonTransform.parseFile(jsonReader);
            default:
                return CrashlyticsReportJsonTransform.parseEventRolloutsAssignment(jsonReader);
        }
    }
}
