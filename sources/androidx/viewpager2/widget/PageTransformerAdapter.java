package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Locale;

final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.mPageTransformer != null) {
            float f2 = -f;
            int i3 = 0;
            while (i3 < this.mLayoutManager.getChildCount()) {
                View childAt = this.mLayoutManager.getChildAt(i3);
                if (childAt != null) {
                    this.mPageTransformer.transformPage(childAt, ((float) (this.mLayoutManager.getPosition(childAt) - i)) + f2);
                    i3++;
                } else {
                    Locale locale = Locale.US;
                    int childCount = this.mLayoutManager.getChildCount();
                    throw new IllegalStateException("LayoutManager returned a null child at pos " + i3 + RemoteSettings.FORWARD_SLASH_STRING + childCount + " while transforming pages");
                }
            }
        }
    }

    public void onPageSelected(int i) {
    }

    public void setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }
}
