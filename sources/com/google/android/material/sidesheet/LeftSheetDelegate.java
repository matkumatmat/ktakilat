package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class LeftSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    public LeftSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    public int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    public float calculateSlideOffset(int i) {
        float hiddenOffset = (float) getHiddenOffset();
        return (((float) i) - hiddenOffset) / (((float) getExpandedOffset()) - hiddenOffset);
    }

    public int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    public int getExpandedOffset() {
        return Math.max(0, this.sheetBehavior.getInnerMargin() + this.sheetBehavior.getParentInnerEdge());
    }

    public int getHiddenOffset() {
        return (-this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin();
    }

    public int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getInnerMargin();
    }

    public int getMinViewPositionHorizontal() {
        return -this.sheetBehavior.getChildWidth();
    }

    public <V extends View> int getOuterEdge(@NonNull V v) {
        return this.sheetBehavior.getInnerMargin() + v.getRight();
    }

    public int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    public int getSheetEdge() {
        return 1;
    }

    public boolean isExpandingOutwards(float f) {
        return f > 0.0f;
    }

    public boolean isReleasedCloseToInnerEdge(@NonNull View view) {
        if (view.getRight() < (getExpandedOffset() - getHiddenOffset()) / 2) {
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
        if (Math.abs((this.sheetBehavior.getHideFriction() * f) + ((float) view.getLeft())) > this.sheetBehavior.getHideThreshold()) {
            return true;
        }
        return false;
    }

    public void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        marginLayoutParams.leftMargin = i;
    }

    public void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        if (i <= this.sheetBehavior.getParentWidth()) {
            marginLayoutParams.leftMargin = i2;
        }
    }
}
