package androidx.camera.core.impl;

import androidx.camera.core.impl.UseCaseAttachState;

public final /* synthetic */ class c implements UseCaseAttachState.AttachStateFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f26a;

    public /* synthetic */ c(int i) {
        this.f26a = i;
    }

    public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
        switch (this.f26a) {
            case 0:
                return useCaseAttachInfo.getAttached();
            case 1:
                return useCaseAttachInfo.getAttached();
            case 2:
                return useCaseAttachInfo.getAttached();
            default:
                return UseCaseAttachState.lambda$getActiveAndAttachedSessionConfigs$3(useCaseAttachInfo);
        }
    }
}
