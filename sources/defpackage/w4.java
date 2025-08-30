package defpackage;

import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.adservices.measurement.DeletionRequest;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.Topic;

/* renamed from: w4  reason: default package */
public abstract /* synthetic */ class w4 {
    public static /* synthetic */ CustomAudience.Builder c() {
        return new CustomAudience.Builder();
    }

    public static /* synthetic */ JoinCustomAudienceRequest.Builder e() {
        return new JoinCustomAudienceRequest.Builder();
    }

    public static /* synthetic */ LeaveCustomAudienceRequest.Builder h() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    public static /* synthetic */ TrustedBiddingData.Builder k() {
        return new TrustedBiddingData.Builder();
    }

    public static /* synthetic */ DeletionRequest.Builder o() {
        return new DeletionRequest.Builder();
    }

    public static /* synthetic */ GetTopicsRequest.Builder t() {
        return new GetTopicsRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ Topic x(Object obj) {
        return (Topic) obj;
    }
}
