package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    public RightSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    public int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    public float calculateSlideOffset(int i) {
        float hiddenOffset = (float) getHiddenOffset();
        return (hiddenOffset - ((float) i)) / (hiddenOffset - ((float) getExpandedOffset()));
    }

    public int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    public int getExpandedOffset() {
        return Math.max(0, (getHiddenOffset() - this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin());
    }

    public int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    public int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getParentWidth();
    }

    public int getMinViewPositionHorizontal() {
        return getExpandedOffset();
    }

    public <V extends View> int getOuterEdge(@NonNull V v) {
        return v.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    public int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    public int getSheetEdge() {
        return 0;
    }

    public boolean isExpandingOutwards(float f) {
        return f < 0.0f;
    }

    public boolean isReleasedCloseToInnerEdge(@NonNull View view) {
        if (view.getLeft() > (getHiddenOffset() + getExpandedOffset()) / 2) {
            return true;
        }
        return false;
    }

    public boolean isSwipeSignificant(float f, float f2) {
        if (!SheetUtils.isSwipeMostlyHorizontal(f, f2) || Math.abs(f) <= ((float) this.sheetBehavior.getSignificantVelocityThreshold())) {
            return false;
        }
        return true;
    }

    public boolean shouldHide(@NonNull View view, float f) {
        if (Math.abs((this.sheetBehavior.getHideFriction() * f) + ((float) view.getRight())) > this.sheetBehavior.getHideThreshold()) {
            return true;
        }
        return false;
    }

    public void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.rightMargin = i;
    }

    public void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        int parentWidth = this.sheetBehavior.getParentWidth();
        if (i <= parentWidth) {
            marginLayoutParams.rightMargin = parentWidth - i;
        }
    }
}
