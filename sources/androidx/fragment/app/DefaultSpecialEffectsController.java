package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.BackEventCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\b\u001f !\"#$%&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003J\u001e\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J2\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0016\u0010\u001a\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J&\u0010\u001b\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0002¨\u0006'"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "collectAnimEffects", "", "animationInfos", "", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "collectEffects", "operations", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "isPop", "", "createTransitionEffect", "transitionInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "firstOut", "lastIn", "findNamedViews", "namedViews", "", "", "Landroid/view/View;", "view", "syncAnimations", "retainMatchingViews", "Landroidx/collection/ArrayMap;", "names", "", "AnimationEffect", "AnimationInfo", "AnimatorEffect", "Api24Impl", "Api26Impl", "SpecialEffectsInfo", "TransitionEffect", "TransitionInfo", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1151:1\n288#2,2:1152\n533#2,6:1154\n1360#2:1160\n1446#2,5:1161\n819#2:1166\n847#2,2:1167\n766#2:1169\n857#2,2:1170\n1789#2,3:1172\n1726#2,3:1175\n1855#2,2:1178\n*S KotlinDebug\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController\n*L\n52#1:1152,2\n58#1:1154,6\n117#1:1160\n117#1:1161,5\n190#1:1166\n190#1:1167,2\n193#1:1169\n193#1:1170,2\n197#1:1172,3\n355#1:1175,3\n366#1:1178,2\n*E\n"})
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "animationInfo", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "(Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;)V", "getAnimationInfo", "()Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "onCancel", "", "container", "Landroid/view/ViewGroup;", "onCommit", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimationEffect extends SpecialEffectsController.Effect {
        @NotNull
        private final AnimationInfo animationInfo;

        public AnimationEffect(@NotNull AnimationInfo animationInfo2) {
            Intrinsics.checkNotNullParameter(animationInfo2, "animationInfo");
            this.animationInfo = animationInfo2;
        }

        @NotNull
        public final AnimationInfo getAnimationInfo() {
            return this.animationInfo;
        }

        public void onCancel(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            view.clearAnimation();
            viewGroup.endViewTransition(view);
            this.animationInfo.getOperation().completeEffect(this);
            if (FragmentManager.isLoggingEnabled(2)) {
                operation.toString();
            }
        }

        public void onCommit(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (this.animationInfo.isVisibilityUnchanged()) {
                this.animationInfo.getOperation().completeEffect(this);
                return;
            }
            Context context = viewGroup.getContext();
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            AnimationInfo animationInfo2 = this.animationInfo;
            Intrinsics.checkNotNullExpressionValue(context, PlaceFields.CONTEXT);
            FragmentAnim.AnimationOrAnimator animation = animationInfo2.getAnimation(context);
            if (animation != null) {
                Animation animation2 = animation.animation;
                if (animation2 == null) {
                    throw new IllegalStateException("Required value was null.");
                } else if (operation.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view.startAnimation(animation2);
                    this.animationInfo.getOperation().completeEffect(this);
                } else {
                    viewGroup.startViewTransition(view);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, viewGroup, view);
                    endViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$AnimationEffect$onCommit$1(operation, viewGroup, view, this));
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        operation.toString();
                    }
                }
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "isPop", "", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Z)V", "animation", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "isAnimLoaded", "getAnimation", "context", "Landroid/content/Context;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimationInfo(@NotNull SpecialEffectsController.Operation operation, boolean z) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.isPop = z;
        }

        @Nullable
        public final FragmentAnim.AnimationOrAnimator getAnimation(@NotNull Context context) {
            boolean z;
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            if (this.isAnimLoaded) {
                return this.animation;
            }
            Fragment fragment = getOperation().getFragment();
            if (getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                z = true;
            } else {
                z = false;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, fragment, z, this.isPop);
            this.animation = loadAnimation;
            this.isAnimLoaded = true;
            return loadAnimation;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimatorEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "animatorInfo", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "(Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;)V", "animator", "Landroid/animation/AnimatorSet;", "getAnimator", "()Landroid/animation/AnimatorSet;", "setAnimator", "(Landroid/animation/AnimatorSet;)V", "getAnimatorInfo", "()Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "isSeekingSupported", "", "()Z", "onCancel", "", "container", "Landroid/view/ViewGroup;", "onCommit", "onProgress", "backEvent", "Landroidx/activity/BackEventCompat;", "onStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimatorEffect extends SpecialEffectsController.Effect {
        @Nullable
        private AnimatorSet animator;
        @NotNull
        private final AnimationInfo animatorInfo;

        public AnimatorEffect(@NotNull AnimationInfo animationInfo) {
            Intrinsics.checkNotNullParameter(animationInfo, "animatorInfo");
            this.animatorInfo = animationInfo;
        }

        @Nullable
        public final AnimatorSet getAnimator() {
            return this.animator;
        }

        @NotNull
        public final AnimationInfo getAnimatorInfo() {
            return this.animatorInfo;
        }

        public boolean isSeekingSupported() {
            return true;
        }

        public void onCancel(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            if (!operation.isSeeking()) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                Api26Impl.INSTANCE.reverse(animatorSet);
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                operation.toString();
                operation.isSeeking();
            }
        }

        public void onCommit(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(operation);
            }
        }

        public void onProgress(@NotNull BackEventCompat backEventCompat, @NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
            } else if (Build.VERSION.SDK_INT >= 34 && operation.getFragment().mTransitioning) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    operation.toString();
                }
                long j = Api24Impl.INSTANCE.totalDuration(animatorSet);
                long progress = (long) (backEventCompat.getProgress() * ((float) j));
                if (progress == 0) {
                    progress = 1;
                }
                if (progress == j) {
                    progress = j - 1;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    animatorSet.toString();
                    operation.toString();
                }
                Api26Impl.INSTANCE.setCurrentPlayTime(animatorSet, progress);
            }
        }

        public void onStart(@NotNull ViewGroup viewGroup) {
            AnimatorSet animatorSet;
            boolean z;
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!this.animatorInfo.isVisibilityUnchanged()) {
                Context context = viewGroup.getContext();
                AnimationInfo animationInfo = this.animatorInfo;
                Intrinsics.checkNotNullExpressionValue(context, PlaceFields.CONTEXT);
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation != null) {
                    animatorSet = animation.animator;
                } else {
                    animatorSet = null;
                }
                this.animator = animatorSet;
                SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
                Fragment fragment = operation.getFragment();
                if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                    z = true;
                } else {
                    z = false;
                }
                View view = fragment.mView;
                viewGroup.startViewTransition(view);
                AnimatorSet animatorSet2 = this.animator;
                if (animatorSet2 != null) {
                    animatorSet2.addListener(new DefaultSpecialEffectsController$AnimatorEffect$onStart$1(viewGroup, view, z, operation, this));
                }
                AnimatorSet animatorSet3 = this.animator;
                if (animatorSet3 != null) {
                    animatorSet3.setTarget(view);
                }
            }
        }

        public final void setAnimator(@Nullable AnimatorSet animatorSet) {
            this.animator = animatorSet;
        }
    }

    @RequiresApi(24)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api24Impl;", "", "()V", "totalDuration", "", "animatorSet", "Landroid/animation/AnimatorSet;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api24Impl {
        @NotNull
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public final long totalDuration(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    @RequiresApi(26)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api26Impl;", "", "()V", "reverse", "", "animatorSet", "Landroid/animation/AnimatorSet;", "setCurrentPlayTime", "time", "", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api26Impl {
        @NotNull
        public static final Api26Impl INSTANCE = new Api26Impl();

        private Api26Impl() {
        }

        @DoNotInline
        public final void reverse(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        @DoNotInline
        public final void setCurrentPlayTime(@NotNull AnimatorSet animatorSet, long j) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "isVisibilityUnchanged", "", "()Z", "getOperation", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SpecialEffectsInfo {
        @NotNull
        private final SpecialEffectsController.Operation operation;

        public SpecialEffectsInfo(@NotNull SpecialEffectsController.Operation operation2) {
            Intrinsics.checkNotNullParameter(operation2, "operation");
            this.operation = operation2;
        }

        @NotNull
        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State state2;
            View view = this.operation.getFragment().mView;
            if (view != null) {
                state = SpecialEffectsController.Operation.State.Companion.asOperationState(view);
            } else {
                state = null;
            }
            SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
            if (state == finalState || (state != (state2 = SpecialEffectsController.Operation.State.VISIBLE) && finalState != state2)) {
                return true;
            }
            return false;
        }
    }

    @SourceDebugExtension({"SMAP\nDefaultSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1151:1\n1726#2,3:1152\n1726#2,3:1155\n1855#2,2:1158\n1549#2:1160\n1620#2,3:1161\n1855#2,2:1164\n1855#2,2:1167\n1549#2:1169\n1620#2,3:1170\n1855#2,2:1173\n1#3:1166\n*S KotlinDebug\n*F\n+ 1 DefaultSpecialEffectsController.kt\nandroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect\n*L\n722#1:1152,3\n731#1:1155,3\n739#1:1158,2\n768#1:1160\n768#1:1161,3\n768#1:1164,2\n846#1:1167,2\n867#1:1169\n867#1:1170,3\n867#1:1173,2\n*E\n"})
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BÝ\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ(\u0010;\u001a\u00020<2\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010>\u001a\u00020\u000eH\u0002J@\u0010?\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0004\u0012\u00020\u000b0@2\u0006\u0010A\u001a\u00020B2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010C\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010D\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016J\u0018\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020G2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010H\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016J6\u0010I\u001a\u00020<2\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010A\u001a\u00020B2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020<0LH\u0002R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R!\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010'R\u0014\u0010(\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u00103\u001a\u000204¢\u0006\u000e\n\u0000\u0012\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b:\u0010'¨\u0006M"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "transitionInfos", "", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "firstOut", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "lastIn", "transitionImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "sharedElementTransition", "", "sharedElementFirstOutViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "sharedElementLastInViews", "sharedElementNameMapping", "Landroidx/collection/ArrayMap;", "", "enteringNames", "exitingNames", "firstOutViews", "lastInViews", "isPop", "", "(Ljava/util/List;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/FragmentTransitionImpl;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/ArrayMap;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;Z)V", "controller", "getController", "()Ljava/lang/Object;", "setController", "(Ljava/lang/Object;)V", "getEnteringNames", "()Ljava/util/ArrayList;", "getExitingNames", "getFirstOut", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "getFirstOutViews", "()Landroidx/collection/ArrayMap;", "()Z", "isSeekingSupported", "getLastIn", "getLastInViews", "getSharedElementFirstOutViews", "getSharedElementLastInViews", "getSharedElementNameMapping", "getSharedElementTransition", "getTransitionImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "getTransitionInfos", "()Ljava/util/List;", "transitionSignal", "Landroidx/core/os/CancellationSignal;", "getTransitionSignal$annotations", "()V", "getTransitionSignal", "()Landroidx/core/os/CancellationSignal;", "transitioning", "getTransitioning", "captureTransitioningViews", "", "transitioningViews", "view", "createMergedTransition", "Lkotlin/Pair;", "container", "Landroid/view/ViewGroup;", "onCancel", "onCommit", "onProgress", "backEvent", "Landroidx/activity/BackEventCompat;", "onStart", "runTransition", "enteringViews", "executeTransition", "Lkotlin/Function0;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransitionEffect extends SpecialEffectsController.Effect {
        @Nullable
        private Object controller;
        @NotNull
        private final ArrayList<String> enteringNames;
        @NotNull
        private final ArrayList<String> exitingNames;
        @Nullable
        private final SpecialEffectsController.Operation firstOut;
        @NotNull
        private final ArrayMap<String, View> firstOutViews;
        private final boolean isPop;
        @Nullable
        private final SpecialEffectsController.Operation lastIn;
        @NotNull
        private final ArrayMap<String, View> lastInViews;
        @NotNull
        private final ArrayList<View> sharedElementFirstOutViews;
        @NotNull
        private final ArrayList<View> sharedElementLastInViews;
        @NotNull
        private final ArrayMap<String, String> sharedElementNameMapping;
        @Nullable
        private final Object sharedElementTransition;
        @NotNull
        private final FragmentTransitionImpl transitionImpl;
        @NotNull
        private final List<TransitionInfo> transitionInfos;
        @NotNull
        private final CancellationSignal transitionSignal = new CancellationSignal();

        public TransitionEffect(@NotNull List<TransitionInfo> list, @Nullable SpecialEffectsController.Operation operation, @Nullable SpecialEffectsController.Operation operation2, @NotNull FragmentTransitionImpl fragmentTransitionImpl, @Nullable Object obj, @NotNull ArrayList<View> arrayList, @NotNull ArrayList<View> arrayList2, @NotNull ArrayMap<String, String> arrayMap, @NotNull ArrayList<String> arrayList3, @NotNull ArrayList<String> arrayList4, @NotNull ArrayMap<String, View> arrayMap2, @NotNull ArrayMap<String, View> arrayMap3, boolean z) {
            Intrinsics.checkNotNullParameter(list, "transitionInfos");
            Intrinsics.checkNotNullParameter(fragmentTransitionImpl, "transitionImpl");
            Intrinsics.checkNotNullParameter(arrayList, "sharedElementFirstOutViews");
            Intrinsics.checkNotNullParameter(arrayList2, "sharedElementLastInViews");
            Intrinsics.checkNotNullParameter(arrayMap, "sharedElementNameMapping");
            Intrinsics.checkNotNullParameter(arrayList3, "enteringNames");
            Intrinsics.checkNotNullParameter(arrayList4, "exitingNames");
            Intrinsics.checkNotNullParameter(arrayMap2, "firstOutViews");
            Intrinsics.checkNotNullParameter(arrayMap3, "lastInViews");
            this.transitionInfos = list;
            this.firstOut = operation;
            this.lastIn = operation2;
            this.transitionImpl = fragmentTransitionImpl;
            this.sharedElementTransition = obj;
            this.sharedElementFirstOutViews = arrayList;
            this.sharedElementLastInViews = arrayList2;
            this.sharedElementNameMapping = arrayMap;
            this.enteringNames = arrayList3;
            this.exitingNames = arrayList4;
            this.firstOutViews = arrayMap2;
            this.lastInViews = arrayMap3;
            this.isPop = z;
        }

        private final void captureTransitioningViews(ArrayList<View> arrayList, View view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!ViewGroupCompat.isTransitionGroup(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getVisibility() == 0) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            captureTransitioningViews(arrayList, childAt);
                        }
                    }
                } else if (!arrayList.contains(view)) {
                    arrayList.add(view);
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        }

        private final Pair<ArrayList<View>, Object> createMergedTransition(ViewGroup viewGroup, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
            Iterator<TransitionInfo> it;
            ViewGroup viewGroup2 = viewGroup;
            SpecialEffectsController.Operation operation3 = operation;
            SpecialEffectsController.Operation operation4 = operation2;
            View view = new View(viewGroup.getContext());
            Rect rect = new Rect();
            View view2 = null;
            boolean z = false;
            for (TransitionInfo hasSharedElementTransition : this.transitionInfos) {
                if (!(!hasSharedElementTransition.hasSharedElementTransition() || operation4 == null || operation3 == null || this.sharedElementNameMapping.isEmpty() || this.sharedElementTransition == null)) {
                    FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), this.isPop, this.firstOutViews, true);
                    OneShotPreDrawListener.add(viewGroup2, new a(operation3, 1, operation4, this));
                    this.sharedElementFirstOutViews.addAll(this.firstOutViews.values());
                    if (!this.exitingNames.isEmpty()) {
                        String str = this.exitingNames.get(0);
                        Intrinsics.checkNotNullExpressionValue(str, "exitingNames[0]");
                        view2 = this.firstOutViews.get(str);
                        this.transitionImpl.setEpicenter(this.sharedElementTransition, view2);
                    }
                    this.sharedElementLastInViews.addAll(this.lastInViews.values());
                    if (!this.enteringNames.isEmpty()) {
                        String str2 = this.enteringNames.get(0);
                        Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[0]");
                        View view3 = this.lastInViews.get(str2);
                        if (view3 != null) {
                            OneShotPreDrawListener.add(viewGroup2, new a(this.transitionImpl, 2, view3, rect));
                            z = true;
                        }
                    }
                    this.transitionImpl.setSharedElementTargets(this.sharedElementTransition, view, this.sharedElementFirstOutViews);
                    FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
                    Object obj = this.sharedElementTransition;
                    fragmentTransitionImpl.scheduleRemoveTargets(obj, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj, this.sharedElementLastInViews);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<TransitionInfo> it2 = this.transitionInfos.iterator();
            Object obj2 = null;
            Object obj3 = null;
            while (it2.hasNext()) {
                TransitionInfo next = it2.next();
                SpecialEffectsController.Operation operation5 = next.getOperation();
                Object cloneTransition = this.transitionImpl.cloneTransition(next.getTransition());
                if (cloneTransition != null) {
                    ArrayList arrayList2 = new ArrayList();
                    it = it2;
                    View view4 = operation5.getFragment().mView;
                    Object obj4 = obj3;
                    Intrinsics.checkNotNullExpressionValue(view4, "operation.fragment.mView");
                    captureTransitioningViews(arrayList2, view4);
                    if (this.sharedElementTransition != null && (operation5 == operation4 || operation5 == operation3)) {
                        if (operation5 == operation4) {
                            arrayList2.removeAll(CollectionsKt.G(this.sharedElementFirstOutViews));
                        } else {
                            arrayList2.removeAll(CollectionsKt.G(this.sharedElementLastInViews));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        this.transitionImpl.addTarget(cloneTransition, view);
                    } else {
                        this.transitionImpl.addTargets(cloneTransition, arrayList2);
                        this.transitionImpl.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList2, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (operation5.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation5.setAwaitingContainerChanges(false);
                            ArrayList arrayList3 = new ArrayList(arrayList2);
                            arrayList3.remove(operation5.getFragment().mView);
                            this.transitionImpl.scheduleHideFragmentView(cloneTransition, operation5.getFragment().mView, arrayList3);
                            OneShotPreDrawListener.add(viewGroup2, new b(arrayList2, 0));
                        }
                    }
                    if (operation5.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z) {
                            this.transitionImpl.setEpicenter(cloneTransition, rect);
                        }
                        if (FragmentManager.isLoggingEnabled(2)) {
                            cloneTransition.toString();
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                Object next2 = it3.next();
                                Intrinsics.checkNotNullExpressionValue(next2, "transitioningViews");
                                Objects.toString((View) next2);
                            }
                        }
                    } else {
                        this.transitionImpl.setEpicenter(cloneTransition, view2);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            cloneTransition.toString();
                            Iterator it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                Object next3 = it4.next();
                                Intrinsics.checkNotNullExpressionValue(next3, "transitioningViews");
                                Objects.toString((View) next3);
                            }
                        }
                    }
                    if (next.isOverlapAllowed()) {
                        obj2 = this.transitionImpl.mergeTransitionsTogether(obj2, cloneTransition, (Object) null);
                        operation3 = operation;
                        it2 = it;
                        obj3 = obj4;
                    } else {
                        obj3 = this.transitionImpl.mergeTransitionsTogether(obj4, cloneTransition, (Object) null);
                        operation3 = operation;
                        it2 = it;
                    }
                } else {
                    it = it2;
                    Object obj5 = obj3;
                    operation3 = operation;
                    it2 = it;
                }
            }
            Object mergeTransitionsInSequence = this.transitionImpl.mergeTransitionsInSequence(obj2, obj3, this.sharedElementTransition);
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(mergeTransitionsInSequence);
            }
            return new Pair<>(arrayList, mergeTransitionsInSequence);
        }

        /* access modifiers changed from: private */
        public static final void createMergedTransition$lambda$12(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), transitionEffect.isPop, transitionEffect.lastInViews, false);
        }

        /* access modifiers changed from: private */
        public static final void createMergedTransition$lambda$13(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            Intrinsics.checkNotNullParameter(fragmentTransitionImpl, "$impl");
            Intrinsics.checkNotNullParameter(rect, "$lastInEpicenterRect");
            fragmentTransitionImpl.getBoundsOnScreen(view, rect);
        }

        /* access modifiers changed from: private */
        public static final void createMergedTransition$lambda$14(ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "$transitioningViews");
            FragmentTransition.setViewVisibility(arrayList, 4);
        }

        public static /* synthetic */ void getTransitionSignal$annotations() {
        }

        /* access modifiers changed from: private */
        public static final void onCommit$lambda$11$lambda$10(SpecialEffectsController.Operation operation, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(operation, "$operation");
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(operation);
            }
            operation.completeEffect(transitionEffect);
        }

        /* access modifiers changed from: private */
        public static final void onStart$lambda$6$lambda$4(Ref.ObjectRef objectRef) {
            Intrinsics.checkNotNullParameter(objectRef, "$seekCancelLambda");
            Function0 function0 = (Function0) objectRef.element;
            if (function0 != null) {
                function0.invoke();
            }
        }

        /* access modifiers changed from: private */
        public static final void onStart$lambda$6$lambda$5(SpecialEffectsController.Operation operation, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(operation, "$operation");
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(operation);
            }
            operation.completeEffect(transitionEffect);
        }

        private final void runTransition(ArrayList<View> arrayList, ViewGroup viewGroup, Function0<Unit> function0) {
            FragmentTransition.setViewVisibility(arrayList, 4);
            ArrayList<String> prepareSetNameOverridesReordered = this.transitionImpl.prepareSetNameOverridesReordered(this.sharedElementLastInViews);
            if (FragmentManager.isLoggingEnabled(2)) {
                Iterator<View> it = this.sharedElementFirstOutViews.iterator();
                while (it.hasNext()) {
                    View next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "sharedElementFirstOutViews");
                    View view = next;
                    Objects.toString(view);
                    ViewCompat.getTransitionName(view);
                }
                Iterator<View> it2 = this.sharedElementLastInViews.iterator();
                while (it2.hasNext()) {
                    View next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "sharedElementLastInViews");
                    View view2 = next2;
                    Objects.toString(view2);
                    ViewCompat.getTransitionName(view2);
                }
            }
            function0.invoke();
            this.transitionImpl.setNameOverridesReordered(viewGroup, this.sharedElementFirstOutViews, this.sharedElementLastInViews, prepareSetNameOverridesReordered, this.sharedElementNameMapping);
            FragmentTransition.setViewVisibility(arrayList, 0);
            this.transitionImpl.swapSharedElementTargets(this.sharedElementTransition, this.sharedElementFirstOutViews, this.sharedElementLastInViews);
        }

        @Nullable
        public final Object getController() {
            return this.controller;
        }

        @NotNull
        public final ArrayList<String> getEnteringNames() {
            return this.enteringNames;
        }

        @NotNull
        public final ArrayList<String> getExitingNames() {
            return this.exitingNames;
        }

        @Nullable
        public final SpecialEffectsController.Operation getFirstOut() {
            return this.firstOut;
        }

        @NotNull
        public final ArrayMap<String, View> getFirstOutViews() {
            return this.firstOutViews;
        }

        @Nullable
        public final SpecialEffectsController.Operation getLastIn() {
            return this.lastIn;
        }

        @NotNull
        public final ArrayMap<String, View> getLastInViews() {
            return this.lastInViews;
        }

        @NotNull
        public final ArrayList<View> getSharedElementFirstOutViews() {
            return this.sharedElementFirstOutViews;
        }

        @NotNull
        public final ArrayList<View> getSharedElementLastInViews() {
            return this.sharedElementLastInViews;
        }

        @NotNull
        public final ArrayMap<String, String> getSharedElementNameMapping() {
            return this.sharedElementNameMapping;
        }

        @Nullable
        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        @NotNull
        public final FragmentTransitionImpl getTransitionImpl() {
            return this.transitionImpl;
        }

        @NotNull
        public final List<TransitionInfo> getTransitionInfos() {
            return this.transitionInfos;
        }

        @NotNull
        public final CancellationSignal getTransitionSignal() {
            return this.transitionSignal;
        }

        public final boolean getTransitioning() {
            Iterable<TransitionInfo> iterable = this.transitionInfos;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return true;
            }
            for (TransitionInfo operation : iterable) {
                if (!operation.getOperation().getFragment().mTransitioning) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isPop() {
            return this.isPop;
        }

        public boolean isSeekingSupported() {
            if (this.transitionImpl.isSeekingSupported()) {
                Iterable iterable = this.transitionInfos;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TransitionInfo transitionInfo = (TransitionInfo) it.next();
                        if (Build.VERSION.SDK_INT >= 34) {
                            if (transitionInfo.getTransition() != null) {
                                if (!this.transitionImpl.isSeekingSupported(transitionInfo.getTransition())) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                Object obj = this.sharedElementTransition;
                if (obj == null || this.transitionImpl.isSeekingSupported(obj)) {
                    return true;
                }
            }
            return false;
        }

        public void onCancel(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            this.transitionSignal.cancel();
        }

        public void onCommit(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (TransitionInfo transitionInfo : this.transitionInfos) {
                    SpecialEffectsController.Operation operation = transitionInfo.getOperation();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        viewGroup.toString();
                        Objects.toString(operation);
                    }
                    transitionInfo.getOperation().completeEffect(this);
                }
                return;
            }
            Object obj = this.controller;
            if (obj != null) {
                this.transitionImpl.animateToEnd(obj);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(this.firstOut);
                    Objects.toString(this.lastIn);
                    return;
                }
                return;
            }
            Pair<ArrayList<View>, Object> createMergedTransition = createMergedTransition(viewGroup, this.lastIn, this.firstOut);
            ArrayList component1 = createMergedTransition.component1();
            Object component2 = createMergedTransition.component2();
            Iterable<TransitionInfo> iterable = this.transitionInfos;
            ArrayList arrayList = new ArrayList(CollectionsKt.h(iterable));
            for (TransitionInfo operation2 : iterable) {
                arrayList.add(operation2.getOperation());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) it.next();
                this.transitionImpl.setListenerForTransitionEnd(operation3.getFragment(), component2, this.transitionSignal, new c(operation3, this, 1));
            }
            runTransition(component1, viewGroup, new DefaultSpecialEffectsController$TransitionEffect$onCommit$4(this, viewGroup, component2));
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(this.firstOut);
                Objects.toString(this.lastIn);
            }
        }

        public void onProgress(@NotNull BackEventCompat backEventCompat, @NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Object obj = this.controller;
            if (obj != null) {
                this.transitionImpl.setCurrentPlayTime(obj, backEventCompat.getProgress());
            }
        }

        public void onStart(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (TransitionInfo operation : this.transitionInfos) {
                    SpecialEffectsController.Operation operation2 = operation.getOperation();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        viewGroup.toString();
                        Objects.toString(operation2);
                    }
                }
                return;
            }
            if (getTransitioning() && this.sharedElementTransition != null && !isSeekingSupported()) {
                Objects.toString(this.sharedElementTransition);
                Objects.toString(this.firstOut);
                Objects.toString(this.lastIn);
            }
            if (isSeekingSupported() && getTransitioning()) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Pair<ArrayList<View>, Object> createMergedTransition = createMergedTransition(viewGroup, this.lastIn, this.firstOut);
                ArrayList component1 = createMergedTransition.component1();
                Object component2 = createMergedTransition.component2();
                Iterable<TransitionInfo> iterable = this.transitionInfos;
                ArrayList arrayList = new ArrayList(CollectionsKt.h(iterable));
                for (TransitionInfo operation3 : iterable) {
                    arrayList.add(operation3.getOperation());
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it.next();
                    b bVar = new b(objectRef, 1);
                    this.transitionImpl.setListenerForTransitionEnd(operation4.getFragment(), component2, this.transitionSignal, bVar, new c(operation4, this, 0));
                }
                runTransition(component1, viewGroup, new DefaultSpecialEffectsController$TransitionEffect$onStart$4(this, viewGroup, component2, objectRef));
            }
        }

        public final void setController(@Nullable Object obj) {
            this.controller = obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(@NotNull ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
    }

    @SuppressLint({"NewApi", "PrereleaseSdkCoreDependency"})
    private final void collectAnimEffects(List<AnimationInfo> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AnimationInfo operation : list) {
            CollectionsKt.f(arrayList2, operation.getOperation().getEffects$fragment_release());
        }
        boolean isEmpty = arrayList2.isEmpty();
        boolean z = false;
        for (AnimationInfo next : list) {
            Context context = getContainer().getContext();
            SpecialEffectsController.Operation operation2 = next.getOperation();
            Intrinsics.checkNotNullExpressionValue(context, PlaceFields.CONTEXT);
            FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
            if (animation != null) {
                if (animation.animator == null) {
                    arrayList.add(next);
                } else {
                    Fragment fragment = operation2.getFragment();
                    if (operation2.getEffects$fragment_release().isEmpty()) {
                        if (operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation2.setAwaitingContainerChanges(false);
                        }
                        operation2.addEffect(new AnimatorEffect(next));
                        z = true;
                    } else if (FragmentManager.isLoggingEnabled(2)) {
                        Objects.toString(fragment);
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AnimationInfo animationInfo = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation3 = animationInfo.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (!isEmpty) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment2);
                }
            } else if (!z) {
                operation3.addEffect(new AnimationEffect(animationInfo));
            } else if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(fragment2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void collectEffects$lambda$2(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(defaultSpecialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        defaultSpecialEffectsController.applyContainerChangesToOperation$fragment_release(operation);
    }

    private final void createTransitionEffect(List<TransitionInfo> list, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        FragmentTransitionImpl fragmentTransitionImpl;
        Iterator it;
        Object obj;
        Pair pair;
        FragmentTransitionImpl fragmentTransitionImpl2;
        ArrayList<String> arrayList;
        String findKeyForValue;
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            if (!((TransitionInfo) next).isVisibilityUnchanged()) {
                arrayList2.add(next);
            }
        }
        ArrayList<TransitionInfo> arrayList3 = new ArrayList<>();
        for (Object next2 : arrayList2) {
            if (((TransitionInfo) next2).getHandlingImpl() != null) {
                arrayList3.add(next2);
            }
        }
        FragmentTransitionImpl fragmentTransitionImpl3 = null;
        for (TransitionInfo transitionInfo : arrayList3) {
            FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
            if (fragmentTransitionImpl3 == null || handlingImpl == fragmentTransitionImpl3) {
                fragmentTransitionImpl3 = handlingImpl;
            } else {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition type than other Fragments.").toString());
            }
        }
        if (fragmentTransitionImpl3 != null) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayMap arrayMap = new ArrayMap();
            ArrayList<String> arrayList6 = new ArrayList<>();
            ArrayList<String> arrayList7 = new ArrayList<>();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayMap arrayMap3 = new ArrayMap();
            Iterator it2 = arrayList3.iterator();
            loop3:
            while (true) {
                obj = null;
                while (it.hasNext()) {
                    TransitionInfo transitionInfo2 = (TransitionInfo) it.next();
                    if (!transitionInfo2.hasSharedElementTransition() || operation == null || operation2 == null) {
                        it = it;
                        fragmentTransitionImpl = fragmentTransitionImpl;
                    } else {
                        obj = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(transitionInfo2.getSharedElementTransition()));
                        ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                        Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                        ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                        Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                        ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                        Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                        int size = sharedElementTargetNames.size();
                        int i = 0;
                        while (i < size) {
                            Iterator it3 = it;
                            int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                            if (indexOf != -1) {
                                sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                            }
                            i++;
                            it = it3;
                        }
                        Iterator it4 = it;
                        arrayList6 = operation2.getFragment().getSharedElementTargetNames();
                        Intrinsics.checkNotNullExpressionValue(arrayList6, "lastIn.fragment.sharedElementTargetNames");
                        if (!z) {
                            pair = new Pair(operation.getFragment().getExitTransitionCallback(), operation2.getFragment().getEnterTransitionCallback());
                        } else {
                            pair = new Pair(operation.getFragment().getEnterTransitionCallback(), operation2.getFragment().getExitTransitionCallback());
                        }
                        SharedElementCallback sharedElementCallback = (SharedElementCallback) pair.component1();
                        SharedElementCallback sharedElementCallback2 = (SharedElementCallback) pair.component2();
                        int size2 = sharedElementSourceNames.size();
                        int i2 = 0;
                        while (true) {
                            fragmentTransitionImpl2 = fragmentTransitionImpl;
                            if (i2 >= size2) {
                                break;
                            }
                            int i3 = size2;
                            String str = sharedElementSourceNames.get(i2);
                            Intrinsics.checkNotNullExpressionValue(str, "exitingNames[i]");
                            String str2 = arrayList6.get(i2);
                            Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[i]");
                            arrayMap.put(str, str2);
                            i2++;
                            fragmentTransitionImpl = fragmentTransitionImpl2;
                            size2 = i3;
                        }
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Iterator<String> it5 = arrayList6.iterator();
                            while (it5.hasNext()) {
                                String next3 = it5.next();
                            }
                            Iterator<String> it6 = sharedElementSourceNames.iterator();
                            while (it6.hasNext()) {
                                String next4 = it6.next();
                            }
                        }
                        View view = operation.getFragment().mView;
                        Intrinsics.checkNotNullExpressionValue(view, "firstOut.fragment.mView");
                        findNamedViews(arrayMap2, view);
                        arrayMap2.retainAll(sharedElementSourceNames);
                        if (sharedElementCallback != null) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                operation.toString();
                            }
                            sharedElementCallback.onMapSharedElements(sharedElementSourceNames, arrayMap2);
                            int size3 = sharedElementSourceNames.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i4 = size3 - 1;
                                    String str3 = sharedElementSourceNames.get(size3);
                                    Intrinsics.checkNotNullExpressionValue(str3, "exitingNames[i]");
                                    String str4 = str3;
                                    View view2 = (View) arrayMap2.get(str4);
                                    if (view2 == null) {
                                        arrayMap.remove(str4);
                                        arrayList = sharedElementSourceNames;
                                    } else {
                                        arrayList = sharedElementSourceNames;
                                        if (!Intrinsics.a(str4, ViewCompat.getTransitionName(view2))) {
                                            arrayMap.put(ViewCompat.getTransitionName(view2), (String) arrayMap.remove(str4));
                                        }
                                    }
                                    if (i4 < 0) {
                                        break;
                                    }
                                    size3 = i4;
                                    sharedElementSourceNames = arrayList;
                                }
                            } else {
                                arrayList = sharedElementSourceNames;
                            }
                        } else {
                            arrayList = sharedElementSourceNames;
                            arrayMap.retainAll(arrayMap2.keySet());
                        }
                        View view3 = operation2.getFragment().mView;
                        Intrinsics.checkNotNullExpressionValue(view3, "lastIn.fragment.mView");
                        findNamedViews(arrayMap3, view3);
                        arrayMap3.retainAll(arrayList6);
                        arrayMap3.retainAll(arrayMap.values());
                        if (sharedElementCallback2 != null) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                operation2.toString();
                            }
                            sharedElementCallback2.onMapSharedElements(arrayList6, arrayMap3);
                            int size4 = arrayList6.size() - 1;
                            if (size4 >= 0) {
                                while (true) {
                                    int i5 = size4 - 1;
                                    String str5 = arrayList6.get(size4);
                                    Intrinsics.checkNotNullExpressionValue(str5, "enteringNames[i]");
                                    String str6 = str5;
                                    View view4 = (View) arrayMap3.get(str6);
                                    if (view4 == null) {
                                        String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap, str6);
                                        if (findKeyForValue2 != null) {
                                            arrayMap.remove(findKeyForValue2);
                                        }
                                    } else if (!Intrinsics.a(str6, ViewCompat.getTransitionName(view4)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap, str6)) != null) {
                                        arrayMap.put(findKeyForValue, ViewCompat.getTransitionName(view4));
                                    }
                                    if (i5 < 0) {
                                        break;
                                    }
                                    size4 = i5;
                                }
                            }
                        } else {
                            FragmentTransition.retainValues(arrayMap, arrayMap3);
                        }
                        Set keySet = arrayMap.keySet();
                        Intrinsics.checkNotNullExpressionValue(keySet, "sharedElementNameMapping.keys");
                        retainMatchingViews(arrayMap2, keySet);
                        Collection values = arrayMap.values();
                        Intrinsics.checkNotNullExpressionValue(values, "sharedElementNameMapping.values");
                        retainMatchingViews(arrayMap3, values);
                        if (arrayMap.isEmpty()) {
                            Objects.toString(obj);
                            operation.toString();
                            operation2.toString();
                            arrayList4.clear();
                            arrayList5.clear();
                            it2 = it4;
                            fragmentTransitionImpl3 = fragmentTransitionImpl2;
                            arrayList7 = arrayList;
                        } else {
                            it = it4;
                            fragmentTransitionImpl = fragmentTransitionImpl2;
                            arrayList7 = arrayList;
                        }
                    }
                }
                break loop3;
            }
            FragmentTransitionImpl fragmentTransitionImpl4 = fragmentTransitionImpl;
            if (obj != null) {
                TransitionEffect transitionEffect = new TransitionEffect(arrayList3, operation, operation2, fragmentTransitionImpl4, obj, arrayList4, arrayList5, arrayMap, arrayList6, arrayList7, arrayMap2, arrayMap3, z);
            } else if (!arrayList3.isEmpty()) {
                for (TransitionInfo transition : arrayList3) {
                    if (transition.getTransition() != null) {
                    }
                }
                return;
            } else {
                return;
            }
            TransitionEffect transitionEffect2 = new TransitionEffect(arrayList3, operation, operation2, fragmentTransitionImpl4, obj, arrayList4, arrayList5, arrayMap, arrayList6, arrayList7, arrayMap2, arrayMap3, z);
            for (TransitionInfo operation3 : arrayList3) {
                operation3.getOperation().addEffect(transitionEffect2);
            }
        }
    }

    private final void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "child");
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    private final void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Set<Map.Entry<String, View>> entrySet = arrayMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        CollectionsKt.x(entrySet, new DefaultSpecialEffectsController$retainMatchingViews$1(collection));
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> list) {
        Fragment fragment = ((SpecialEffectsController.Operation) CollectionsKt.q(list)).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    public void collectEffects(@NotNull List<? extends SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation;
        Object obj;
        Intrinsics.checkNotNullParameter(list, "operations");
        Iterator it = list.iterator();
        while (true) {
            operation = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) obj;
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.Companion;
            View view = operation2.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State asOperationState = companion.asOperationState(view);
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (asOperationState == state && operation2.getFinalState() != state) {
                break;
            }
        }
        SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) obj;
        ListIterator<? extends SpecialEffectsController.Operation> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) previous;
            SpecialEffectsController.Operation.State.Companion companion2 = SpecialEffectsController.Operation.State.Companion;
            View view2 = operation4.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view2, "operation.fragment.mView");
            SpecialEffectsController.Operation.State asOperationState2 = companion2.asOperationState(view2);
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.VISIBLE;
            if (asOperationState2 != state2 && operation4.getFinalState() == state2) {
                operation = previous;
                break;
            }
        }
        SpecialEffectsController.Operation operation5 = operation;
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(operation3);
            Objects.toString(operation5);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        syncAnimations(list);
        for (SpecialEffectsController.Operation operation6 : list) {
            arrayList.add(new AnimationInfo(operation6, z));
            boolean z2 = false;
            if (z) {
                if (operation6 != operation3) {
                    arrayList2.add(new TransitionInfo(operation6, z, z2));
                    operation6.addCompletionListener(new e0(16, this, operation6));
                }
            } else if (operation6 != operation5) {
                arrayList2.add(new TransitionInfo(operation6, z, z2));
                operation6.addCompletionListener(new e0(16, this, operation6));
            }
            z2 = true;
            arrayList2.add(new TransitionInfo(operation6, z, z2));
            operation6.addCompletionListener(new e0(16, this, operation6));
        }
        createTransitionEffect(arrayList2, z, operation3, operation5);
        collectAnimEffects(arrayList);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0006\u0010\u0014\u001a\u00020\u0005R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "isPop", "", "providesSharedElementTransition", "(Landroidx/fragment/app/SpecialEffectsController$Operation;ZZ)V", "handlingImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "getHandlingImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "isOverlapAllowed", "()Z", "sharedElementTransition", "", "getSharedElementTransition", "()Ljava/lang/Object;", "transition", "getTransition", "hasSharedElementTransition", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        @Nullable
        private final Object sharedElementTransition;
        @Nullable
        private final Object transition;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransitionInfo(@NotNull SpecialEffectsController.Operation operation, boolean z, boolean z2) {
            super(operation);
            Object obj;
            boolean z3;
            Object obj2;
            Intrinsics.checkNotNullParameter(operation, "operation");
            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (finalState == state) {
                Fragment fragment = operation.getFragment();
                if (z) {
                    obj = fragment.getReenterTransition();
                } else {
                    obj = fragment.getEnterTransition();
                }
            } else {
                Fragment fragment2 = operation.getFragment();
                if (z) {
                    obj = fragment2.getReturnTransition();
                } else {
                    obj = fragment2.getExitTransition();
                }
            }
            this.transition = obj;
            if (operation.getFinalState() != state) {
                z3 = true;
            } else if (z) {
                z3 = operation.getFragment().getAllowReturnTransitionOverlap();
            } else {
                z3 = operation.getFragment().getAllowEnterTransitionOverlap();
            }
            this.isOverlapAllowed = z3;
            if (!z2) {
                obj2 = null;
            } else if (z) {
                obj2 = operation.getFragment().getSharedElementReturnTransition();
            } else {
                obj2 = operation.getFragment().getSharedElementEnterTransition();
            }
            this.sharedElementTransition = obj2;
        }

        @Nullable
        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.transition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.sharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        }

        @Nullable
        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        @Nullable
        public final Object getTransition() {
            return this.transition;
        }

        public final boolean hasSharedElementTransition() {
            if (this.sharedElementTransition != null) {
                return true;
            }
            return false;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        private final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
