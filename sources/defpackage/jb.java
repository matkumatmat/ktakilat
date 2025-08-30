package defpackage;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.proto.ProtobufEncoder;

/* renamed from: jb  reason: default package */
public final /* synthetic */ class jb implements ObjectEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f348a;

    public /* synthetic */ jb(int i) {
        this.f348a = i;
    }

    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        switch (this.f348a) {
            case 0:
                JsonDataEncoderBuilder.lambda$static$0(obj, objectEncoderContext);
                return;
            default:
                ProtobufEncoder.Builder.lambda$static$0(obj, objectEncoderContext);
                return;
        }
    }
}
