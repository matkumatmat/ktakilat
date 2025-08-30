package com.ktakilat.cbase.datacollect;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ktakilat/cbase/datacollect/KtaEvent;", "", "Companion", "CBase_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KtaEvent {

    @SourceDebugExtension({"SMAP\nKtaEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KtaEvent.kt\ncom/ktakilat/cbase/datacollect/KtaEvent$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/cbase/datacollect/KtaEvent$Companion;", "", "CBase_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static void a(String str, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putInt("result", z ? 1 : 0);
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
            b("n_set_password_success", bundle);
        }

        public static void b(String str, Bundle bundle) {
            try {
                DataCollectManager.b(str, bundle);
            } catch (Exception unused) {
            }
        }
    }
}
