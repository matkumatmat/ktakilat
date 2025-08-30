package androidx.activity;

import android.view.View;
import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class c implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f2a;

    public /* synthetic */ c(ProducerScope producerScope) {
        this.f2a = producerScope;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(this.f2a, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
