package com.google.android.material.carousel;

import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f = ((KeylineState) e.f(list, 1)).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f;
        float f2 = keylineState.getLastKeyline().loc - ((KeylineState) e.f(list2, 1)).getLastKeyline().loc;
        this.endShiftRange = f2;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f2, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        if (stateStepsRange[0] > 0.5f) {
            return list.get((int) stateStepsRange[2]);
        }
        return list.get((int) stateStepsRange[1]);
    }

    private static int findFirstInBoundsKeylineIndex(KeylineState keylineState) {
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            if (keylineState.getKeylines().get(i).locOffset >= 0.0f) {
                return i;
            }
        }
        return -1;
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findLastInBoundsKeylineIndex(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (keylineState.getKeylines().get(size).locOffset <= ((float) containerHeight)) {
                return size;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState) {
        return new KeylineStateList(keylineState, getStateStepsStart(keylineState), getStateStepsEnd(carousel, keylineState));
    }

    private static float[] getStateStepInterpolationPoints(float f, List<KeylineState> list, boolean z) {
        float f2;
        float f3;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i = 1; i < size; i++) {
            int i2 = i - 1;
            KeylineState keylineState = list.get(i2);
            KeylineState keylineState2 = list.get(i);
            if (z) {
                f2 = keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
            } else {
                f2 = keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc;
            }
            float f4 = f2 / f;
            if (i == size - 1) {
                f3 = 1.0f;
            } else {
                f3 = fArr[i2] + f4;
            }
            fArr[i] = f3;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState) {
        int i;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findLastInBoundsKeylineIndex = findLastInBoundsKeylineIndex(carousel, keylineState);
        if (!isLastFocalItemAtRightOfContainer(carousel, keylineState) && findLastInBoundsKeylineIndex != -1) {
            int lastFocalKeylineIndex = findLastInBoundsKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            for (int i2 = 0; i2 < lastFocalKeylineIndex; i2++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i3 = (findLastInBoundsKeylineIndex - i2) + 1;
                if (i3 < keylineState.getKeylines().size()) {
                    i = findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i3).mask) + 1;
                } else {
                    i = 0;
                }
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, findLastInBoundsKeylineIndex, i, f, keylineState.getFirstFocalKeylineIndex() + i2 + 1, keylineState.getLastFocalKeylineIndex() + i2 + 1));
            }
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f, float[] fArr) {
        int size = list.size();
        float f2 = fArr[0];
        int i = 1;
        while (i < size) {
            float f3 = fArr[i];
            if (f <= f3) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f2, f3, f), (float) (i - 1), (float) i};
            }
            i++;
            f2 = f3;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(KeylineState keylineState) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findFirstInBoundsKeylineIndex = findFirstInBoundsKeylineIndex(keylineState);
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && findFirstInBoundsKeylineIndex != -1) {
            int firstFocalKeylineIndex = (keylineState.getFirstFocalKeylineIndex() - 1) - findFirstInBoundsKeylineIndex;
            float f = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            for (int i = 0; i <= firstFocalKeylineIndex; i++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int size = keylineState.getKeylines().size() - 1;
                int i2 = (findFirstInBoundsKeylineIndex + i) - 1;
                if (i2 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i2).mask) - 1;
                }
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, findFirstInBoundsKeylineIndex, size, f, (keylineState.getFirstFocalKeylineIndex() - i) - 1, (keylineState.getLastFocalKeylineIndex() - i) - 1));
            }
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        if (keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) <= 0.0f || keylineState.getFirstFocalKeyline() == keylineState.getFirstKeyline()) {
            return true;
        }
        return false;
    }

    private static boolean isLastFocalItemAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        if ((keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset >= ((float) containerHeight) || keylineState.getLastFocalKeyline() == keylineState.getLastKeyline()) {
            return true;
        }
        return false;
    }

    private static KeylineState lerp(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i, int i2, float f, int i3, int i4) {
        boolean z;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i2, (KeylineState.Keyline) arrayList.remove(i));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize());
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i5);
            float f2 = keyline.maskedItemSize;
            float f3 = (f2 / 2.0f) + f;
            if (i5 < i3 || i5 > i4) {
                z = false;
            } else {
                z = true;
            }
            builder.addKeyline(f3, keyline.mask, f2, z);
            f += keyline.maskedItemSize;
        }
        return builder.build();
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return (KeylineState) e.f(this.endStateSteps, 1);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6;
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = -1;
            if (i7 >= i) {
                break;
            }
            if (z) {
                i6 = (i - i7) - 1;
            } else {
                i6 = i7;
            }
            float f = ((float) i6) * itemSize;
            if (!z) {
                i9 = 1;
            }
            if (f * ((float) i9) > ((float) i3) - this.endShiftRange || i7 >= i - this.endStateSteps.size()) {
                Integer valueOf = Integer.valueOf(i6);
                List<KeylineState> list = this.endStateSteps;
                hashMap.put(valueOf, list.get(MathUtils.clamp(i8, 0, list.size() - 1)));
                i8++;
            }
            i7++;
        }
        int i10 = 0;
        for (int i11 = i - 1; i11 >= 0; i11--) {
            if (z) {
                i4 = (i - i11) - 1;
            } else {
                i4 = i11;
            }
            float f2 = ((float) i4) * itemSize;
            if (z) {
                i5 = -1;
            } else {
                i5 = 1;
            }
            if (f2 * ((float) i5) < ((float) i2) + this.startShiftRange || i11 < this.startStateSteps.size()) {
                Integer valueOf2 = Integer.valueOf(i4);
                List<KeylineState> list2 = this.startStateSteps;
                hashMap.put(valueOf2, list2.get(MathUtils.clamp(i10, 0, list2.size() - 1)));
                i10++;
            }
        }
        return hashMap;
    }

    public KeylineState getShiftedState(float f, float f2, float f3) {
        return getShiftedState(f, f2, f3, false);
    }

    public KeylineState getStartState() {
        return (KeylineState) e.f(this.startStateSteps, 1);
    }

    public KeylineState getShiftedState(float f, float f2, float f3, boolean z) {
        float[] fArr;
        List<KeylineState> list;
        float f4;
        float f5 = this.startShiftRange + f2;
        float f6 = f3 - this.endShiftRange;
        if (f < f5) {
            f4 = AnimationUtils.lerp(1.0f, 0.0f, f2, f5, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else if (f <= f6) {
            return this.defaultState;
        } else {
            f4 = AnimationUtils.lerp(0.0f, 1.0f, f6, f3, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        if (z) {
            return closestStateStepFromInterpolation(list, f4, fArr);
        }
        return lerp(list, f4, fArr);
    }
}
