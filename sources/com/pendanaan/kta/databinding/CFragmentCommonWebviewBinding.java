package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.cbase.databinding.WidgetH5ActionBarBinding;
import com.ktakilat.cbase.weight.VerticalSwipeRefreshLayout;
import com.ktakilat.loan.R;

public final class CFragmentCommonWebviewBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout errorLayout;
    @NonNull
    public final ImageView holderCacheIv;
    @NonNull
    public final RelativeLayout holderLayout;
    @NonNull
    public final LinearLayout holderOtherView;
    @NonNull
    public final WidgetH5ActionBarBinding holderPageTitle;
    @NonNull
    public final LinearLayout homeErrorLayout;
    @NonNull
    public final LinearLayout oopsLayout;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    public final VerticalSwipeRefreshLayout refreshLayout;
    @NonNull
    public final RelativeLayout rootView;
    @NonNull
    private final RelativeLayout rootView_;
    @NonNull
    public final TextView tryAgainTv;
    @NonNull
    public final LinearLayout webContainer;

    private CFragmentCommonWebviewBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout3, @NonNull LinearLayout linearLayout, @NonNull WidgetH5ActionBarBinding widgetH5ActionBarBinding, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull VerticalSwipeRefreshLayout verticalSwipeRefreshLayout, @NonNull RelativeLayout relativeLayout4, @NonNull TextView textView, @NonNull LinearLayout linearLayout4) {
        this.rootView_ = relativeLayout;
        this.errorLayout = relativeLayout2;
        this.holderCacheIv = imageView;
        this.holderLayout = relativeLayout3;
        this.holderOtherView = linearLayout;
        this.holderPageTitle = widgetH5ActionBarBinding;
        this.homeErrorLayout = linearLayout2;
        this.oopsLayout = linearLayout3;
        this.pageTitle = cWidgetActionBarBinding;
        this.refreshLayout = verticalSwipeRefreshLayout;
        this.rootView = relativeLayout4;
        this.tryAgainTv = textView;
        this.webContainer = linearLayout4;
    }

    @NonNull
    public static CFragmentCommonWebviewBinding bind(@NonNull View view) {
        View view2 = view;
        int i = R.id.error_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.error_layout);
        if (relativeLayout != null) {
            i = R.id.holder_cache_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.holder_cache_iv);
            if (imageView != null) {
                i = R.id.holder_layout;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.holder_layout);
                if (relativeLayout2 != null) {
                    i = R.id.holder_other_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.holder_other_view);
                    if (linearLayout != null) {
                        i = R.id.holder_page_title;
                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.holder_page_title);
                        if (findChildViewById != null) {
                            WidgetH5ActionBarBinding bind = WidgetH5ActionBarBinding.bind(findChildViewById);
                            i = R.id.home_error_layout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.home_error_layout);
                            if (linearLayout2 != null) {
                                i = R.id.oops_layout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.oops_layout);
                                if (linearLayout3 != null) {
                                    i = R.id.page_title;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.page_title);
                                    if (findChildViewById2 != null) {
                                        CWidgetActionBarBinding bind2 = CWidgetActionBarBinding.bind(findChildViewById2);
                                        i = R.id.refresh_layout;
                                        VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) ViewBindings.findChildViewById(view2, R.id.refresh_layout);
                                        if (verticalSwipeRefreshLayout != null) {
                                            RelativeLayout relativeLayout3 = (RelativeLayout) view2;
                                            i = R.id.try_again_tv;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.try_again_tv);
                                            if (textView != null) {
                                                i = R.id.webContainer;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.webContainer);
                                                if (linearLayout4 != null) {
                                                    return new CFragmentCommonWebviewBinding(relativeLayout3, relativeLayout, imageView, relativeLayout2, linearLayout, bind, linearLayout2, linearLayout3, bind2, verticalSwipeRefreshLayout, relativeLayout3, textView, linearLayout4);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CFragmentCommonWebviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CFragmentCommonWebviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_fragment_common_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView_;
    }
}
