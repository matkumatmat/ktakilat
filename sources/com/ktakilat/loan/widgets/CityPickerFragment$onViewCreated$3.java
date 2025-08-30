package com.ktakilat.loan.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.division.DivisionItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ktakilat/loan/widgets/CityPickerFragment$onViewCreated$3", "Landroid/text/TextWatcher;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCityPickerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CityPickerFragment.kt\ncom/ktakilat/loan/widgets/CityPickerFragment$onViewCreated$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,197:1\n774#2:198\n865#2,2:199\n*S KotlinDebug\n*F\n+ 1 CityPickerFragment.kt\ncom/ktakilat/loan/widgets/CityPickerFragment$onViewCreated$3\n*L\n117#1:198\n117#1:199,2\n*E\n"})
public final class CityPickerFragment$onViewCreated$3 implements TextWatcher {
    public final /* synthetic */ CityPickerFragment c;

    public CityPickerFragment$onViewCreated$3(CityPickerFragment cityPickerFragment) {
        this.c = cityPickerFragment;
    }

    public final void afterTextChanged(Editable editable) {
        int i;
        if (editable != null) {
            String obj = editable.toString();
            CityPickerFragment cityPickerFragment = this.c;
            String str = cityPickerFragment.c;
            Integer num = cityPickerFragment.e;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            List i2 = AppKv.i(i, str);
            if (obj.length() == 0) {
                Intrinsics.c(i2);
                cityPickerFragment.d(i2);
            } else if (!i2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object next : i2) {
                    String name = ((DivisionItem) next).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    Locale locale = Locale.ROOT;
                    String lowerCase = name.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = obj.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (StringsKt.n(lowerCase, lowerCase2)) {
                        arrayList.add(next);
                    }
                }
                cityPickerFragment.d(arrayList);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
