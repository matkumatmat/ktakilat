package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import java.util.Collection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DefaultSpecialEffectsController$TransitionEffect$onStart$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Object $mergedTransition;
    final /* synthetic */ Ref.ObjectRef<Function0<Unit>> $seekCancelLambda;
    final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController$TransitionEffect$onStart$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj, Ref.ObjectRef<Function0<Unit>> objectRef) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
        this.$seekCancelLambda = objectRef;
    }

    public final void invoke() {
        DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
        transitionEffect.setController(transitionEffect.getTransitionImpl().controlDelayedTransition(this.$container, this.$mergedTransition));
        boolean z = this.this$0.getController() != null;
        final Object obj = this.$mergedTransition;
        final ViewGroup viewGroup = this.$container;
        if (z) {
            Ref.ObjectRef<Function0<Unit>> objectRef = this.$seekCancelLambda;
            final DefaultSpecialEffectsController.TransitionEffect transitionEffect2 = this.this$0;
            objectRef.element = new Function0<Unit>() {
                /* access modifiers changed from: private */
                public static final void invoke$lambda$2(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
                    Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
                    Intrinsics.checkNotNullParameter(viewGroup, "$container");
                    for (DefaultSpecialEffectsController.TransitionInfo operation : transitionEffect.getTransitionInfos()) {
                        SpecialEffectsController.Operation operation2 = operation.getOperation();
                        View view = operation2.getFragment().getView();
                        if (view != null) {
                            operation2.getFinalState().applyState(view, viewGroup);
                        }
                    }
                }

                /* access modifiers changed from: private */
                public static final void invoke$lambda$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
                    Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
                    FragmentManager.isLoggingEnabled(2);
                    for (DefaultSpecialEffectsController.TransitionInfo operation : transitionEffect.getTransitionInfos()) {
                        operation.getOperation().completeEffect(transitionEffect);
                    }
                }

                public final void invoke() {
                    Iterable<DefaultSpecialEffectsController.TransitionInfo> transitionInfos = transitionEffect2.getTransitionInfos();
                    if (!(transitionInfos instanceof Collection) || !((Collection) transitionInfos).isEmpty()) {
                        for (DefaultSpecialEffectsController.TransitionInfo operation : transitionInfos) {
                            if (!operation.getOperation().isSeeking()) {
                                FragmentManager.isLoggingEnabled(2);
                                CancellationSignal cancellationSignal = new CancellationSignal();
                                transitionEffect2.getTransitionImpl().setListenerForTransitionEnd(transitionEffect2.getTransitionInfos().get(0).getOperation().getFragment(), obj, cancellationSignal, new b(transitionEffect2, 2));
                                cancellationSignal.cancel();
                                return;
                            }
                        }
                    }
                    FragmentManager.isLoggingEnabled(2);
                    FragmentTransitionImpl transitionImpl = transitionEffect2.getTransitionImpl();
                    Object controller = transitionEffect2.getController();
                    Intrinsics.c(controller);
                    transitionImpl.animateToStart(controller, new c(transitionEffect2, viewGroup));
                }
            };
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(this.this$0.getFirstOut());
                Objects.toString(this.this$0.getLastIn());
                return;
            }
            return;
        }
        throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
    }
}
