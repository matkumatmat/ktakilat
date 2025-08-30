package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import java.util.Collection;

class MonthAdapter extends BaseAdapter {
    private static final int MAXIMUM_GRID_CELLS = ((UtcDates.getUtcCalendar().getMaximum(7) + UtcDates.getUtcCalendar().getMaximum(5)) - 1);
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    @Nullable
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    public MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2, @Nullable DayViewDecorator dayViewDecorator2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
        this.dayViewDecorator = dayViewDecorator2;
        this.previouslySelectedDates = dateSelector2.getSelectedDays();
    }

    private String getDayContentDescription(Context context, long j) {
        return DateStrings.getDayContentDescription(context, j, isToday(j), isStartOfRange(j), isEndOfRange(j));
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    private boolean isSelected(long j) {
        for (Long longValue : this.dateSelector.getSelectedDays()) {
            if (UtcDates.canonicalYearMonthDay(j) == UtcDates.canonicalYearMonthDay(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isToday(long j) {
        if (UtcDates.getTodayCalendar().getTimeInMillis() == j) {
            return true;
        }
        return false;
    }

    private void updateSelectedState(@Nullable TextView textView, long j, int i) {
        boolean z;
        CalendarItemStyle calendarItemStyle;
        CalendarItemStyle calendarItemStyle2;
        TextView textView2 = textView;
        long j2 = j;
        if (textView2 != null) {
            Context context = textView.getContext();
            String dayContentDescription = getDayContentDescription(context, j2);
            textView2.setContentDescription(dayContentDescription);
            boolean isValid = this.calendarConstraints.getDateValidator().isValid(j2);
            if (isValid) {
                textView2.setEnabled(true);
                boolean isSelected = isSelected(j2);
                textView2.setSelected(isSelected);
                if (isSelected) {
                    calendarItemStyle2 = this.calendarStyle.selectedDay;
                } else if (isToday(j2)) {
                    calendarItemStyle2 = this.calendarStyle.todayDay;
                } else {
                    calendarItemStyle2 = this.calendarStyle.day;
                }
                calendarItemStyle = calendarItemStyle2;
                z = isSelected;
            } else {
                textView2.setEnabled(false);
                calendarItemStyle = this.calendarStyle.invalidDay;
                z = false;
            }
            DayViewDecorator dayViewDecorator2 = this.dayViewDecorator;
            if (dayViewDecorator2 == null || i == -1) {
                calendarItemStyle.styleItem(textView2);
                return;
            }
            Month month2 = this.month;
            int i2 = month2.year;
            int i3 = month2.month;
            Context context2 = context;
            int i4 = i2;
            int i5 = i;
            boolean z2 = isValid;
            int i6 = i3;
            int i7 = i6;
            ColorStateList backgroundColor = dayViewDecorator2.getBackgroundColor(context2, i4, i3, i5, z2, z);
            boolean z3 = z;
            calendarItemStyle.styleItem(textView2, backgroundColor, this.dayViewDecorator.getTextColor(context2, i4, i7, i5, z2, z3));
            Drawable compoundDrawableLeft = this.dayViewDecorator.getCompoundDrawableLeft(context2, i4, i7, i5, z2, z3);
            Drawable compoundDrawableTop = this.dayViewDecorator.getCompoundDrawableTop(context2, i4, i7, i5, z2, z3);
            String str = dayContentDescription;
            Drawable compoundDrawableRight = this.dayViewDecorator.getCompoundDrawableRight(context2, i4, i7, i5, z2, z3);
            boolean z4 = z;
            textView2.setCompoundDrawables(compoundDrawableLeft, compoundDrawableTop, compoundDrawableRight, this.dayViewDecorator.getCompoundDrawableBottom(context2, i4, i7, i5, z2, z4));
            textView2.setContentDescription(this.dayViewDecorator.getContentDescription(context2, i4, i7, i5, z2, z4, str));
        }
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.create(j).equals(this.month)) {
            int dayOfMonth = this.month.getDayOfMonth(j);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(dayOfMonth) - materialCalendarGridView.getFirstVisiblePosition()), j, dayOfMonth);
        }
    }

    public int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    public int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    public long getItemId(int i) {
        return (long) (i / this.month.daysInWeek);
    }

    public boolean hasStableIds() {
        return true;
    }

    @VisibleForTesting
    public boolean isEndOfRange(long j) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            S s = pair.second;
            if (s != null && ((Long) s).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    public boolean isFirstInRow(int i) {
        if (i % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    public boolean isLastInRow(int i) {
        if ((i + 1) % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public boolean isStartOfRange(long j) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            F f = pair.first;
            if (f != null && ((Long) f).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    public int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int i) {
        return (i - firstPositionInMonth()) + 1;
    }

    public void updateSelectedStates(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.previouslySelectedDates) {
            updateSelectedStateForDate(materialCalendarGridView, longValue.longValue());
        }
        DateSelector<?> dateSelector2 = this.dateSelector;
        if (dateSelector2 != null) {
            for (Long longValue2 : dateSelector2.getSelectedDays()) {
                updateSelectedStateForDate(materialCalendarGridView, longValue2.longValue());
            }
            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    public boolean withinMonth(int i) {
        if (i < firstPositionInMonth() || i > lastPositionInMonth()) {
            return false;
        }
        return true;
    }

    @Nullable
    public Long getItem(int i) {
        if (i < firstPositionInMonth() || i > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i)));
    }

    /* JADX WARNING: type inference failed for: r7v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            android.content.Context r1 = r8.getContext()
            r5.initializeStyles(r1)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            if (r7 != 0) goto L_0x001f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r1 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r1, r8, r2)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x001f:
            int r7 = r5.firstPositionInMonth()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0054
            com.google.android.material.datepicker.Month r8 = r5.month
            int r3 = r8.daysInMonth
            if (r7 < r3) goto L_0x002e
            goto L_0x0054
        L_0x002e:
            int r7 = r7 + r0
            r1.setTag(r8)
            android.content.res.Resources r8 = r1.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r1.setText(r8)
            r1.setVisibility(r2)
            r1.setEnabled(r0)
            goto L_0x005d
        L_0x0054:
            r7 = 8
            r1.setVisibility(r7)
            r1.setEnabled(r2)
            r7 = -1
        L_0x005d:
            java.lang.Long r6 = r5.getItem((int) r6)
            if (r6 != 0) goto L_0x0064
            return r1
        L_0x0064:
            long r2 = r6.longValue()
            r5.updateSelectedState(r1, r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }
}
