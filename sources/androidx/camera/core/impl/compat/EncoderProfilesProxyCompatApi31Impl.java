package androidx.camera.core.impl.compat;

import android.media.EncoderProfiles;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(31)
class EncoderProfilesProxyCompatApi31Impl {
    private EncoderProfilesProxyCompatApi31Impl() {
    }

    @NonNull
    public static EncoderProfilesProxy from(@NonNull EncoderProfiles encoderProfiles) {
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfiles.getDefaultDurationSeconds(), encoderProfiles.getRecommendedFileFormat(), fromAudioProfiles(encoderProfiles.getAudioProfiles()), fromVideoProfiles(encoderProfiles.getVideoProfiles()));
    }

    @NonNull
    private static List<EncoderProfilesProxy.AudioProfileProxy> fromAudioProfiles(@NonNull List<EncoderProfiles.AudioProfile> list) {
        ArrayList arrayList = new ArrayList();
        for (EncoderProfiles.AudioProfile next : list) {
            arrayList.add(EncoderProfilesProxy.AudioProfileProxy.create(next.getCodec(), next.getMediaType(), next.getBitrate(), next.getSampleRate(), next.getChannels(), next.getProfile()));
        }
        return arrayList;
    }

    @NonNull
    private static List<EncoderProfilesProxy.VideoProfileProxy> fromVideoProfiles(@NonNull List<EncoderProfiles.VideoProfile> list) {
        ArrayList arrayList = new ArrayList();
        for (EncoderProfiles.VideoProfile next : list) {
            arrayList.add(EncoderProfilesProxy.VideoProfileProxy.create(next.getCodec(), next.getMediaType(), next.getBitrate(), next.getFrameRate(), next.getWidth(), next.getHeight(), next.getProfile(), 8, 0, 0));
        }
        return arrayList;
    }
}
