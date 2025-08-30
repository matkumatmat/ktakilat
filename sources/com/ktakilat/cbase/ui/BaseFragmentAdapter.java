package com.ktakilat.cbase.ui;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class BaseFragmentAdapter extends FragmentStatePagerAdapter {
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        throw null;
    }

    public final int getCount() {
        return 0;
    }

    public final Fragment getItem(int i) {
        throw null;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        throw null;
    }
}
