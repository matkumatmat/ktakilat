package com.ktakilat.loan.widgets;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ktakilat.loan.http.division.DivisionEnum;
import com.ktakilat.loan.http.division.DivisionItem;
import com.pendanaan.kta.databinding.RegionItemTileBinding;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/widgets/RegionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ktakilat/loan/widgets/RegionAdapter$ViewHolder;", "Lcom/simplecityapps/recyclerview_fastscroll/views/FastScrollRecyclerView$SectionedAdapter;", "ViewHolder", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RegionAdapter extends RecyclerView.Adapter<ViewHolder> implements FastScrollRecyclerView.SectionedAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final CityPickerFragViewModel f618a;
    public final DivisionEnum b;
    public final String c;
    public final ArrayList d = new ArrayList();

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/widgets/RegionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final RegionItemTileBinding c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(RegionItemTileBinding regionItemTileBinding) {
            super(regionItemTileBinding.getRoot());
            Intrinsics.checkNotNullParameter(regionItemTileBinding, "binding");
            this.c = regionItemTileBinding;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f619a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.ktakilat.loan.http.division.DivisionEnum[] r0 = com.ktakilat.loan.http.division.DivisionEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.ktakilat.loan.http.division.DivisionEnum r1 = com.ktakilat.loan.http.division.DivisionEnum.PROVINCE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.ktakilat.loan.http.division.DivisionEnum r1 = com.ktakilat.loan.http.division.DivisionEnum.CITY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.ktakilat.loan.http.division.DivisionEnum r1 = com.ktakilat.loan.http.division.DivisionEnum.DISTRUCT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f619a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.widgets.RegionAdapter.WhenMappings.<clinit>():void");
        }
    }

    public RegionAdapter(CityPickerFragViewModel cityPickerFragViewModel, DivisionEnum divisionEnum, String str) {
        Intrinsics.checkNotNullParameter(cityPickerFragViewModel, "vm");
        Intrinsics.checkNotNullParameter(divisionEnum, "cityEnum");
        Intrinsics.checkNotNullParameter(str, "cityType");
        this.f618a = cityPickerFragViewModel;
        this.b = divisionEnum;
        this.c = str;
    }

    public final String a(int i) {
        String name = ((DivisionItem) this.d.get(i)).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.N(1, name);
    }

    public final int getItemCount() {
        return this.d.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(viewHolder2, "holder");
        viewHolder2.c.name.setText(((DivisionItem) this.d.get(i)).getName());
        viewHolder2.c.getRoot().setOnClickListener(new rd(this, i));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        RegionItemTileBinding inflate = RegionItemTileBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }
}
