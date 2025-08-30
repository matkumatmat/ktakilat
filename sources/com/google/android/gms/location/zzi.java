package com.google.android.gms.location;

import java.util.Comparator;

final class zzi implements Comparator<ActivityTransition> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        int activityType = activityTransition.getActivityType();
        int activityType2 = activityTransition2.getActivityType();
        if (activityType == activityType2) {
            int transitionType = activityTransition.getTransitionType();
            int transitionType2 = activityTransition2.getTransitionType();
            if (transitionType == transitionType2) {
                return 0;
            }
            if (transitionType < transitionType2) {
                return -1;
            }
            return 1;
        } else if (activityType < activityType2) {
            return -1;
        } else {
            return 1;
        }
    }
}
