package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.annotation.RequiresApi;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.FilteringSequence$iterator$1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(21)
@SourceDebugExtension({"SMAP\nNetworkDataCollectorApi21.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkDataCollectorApi21.kt\ncom/appsflyer/internal/network/NetworkDataCollectorApi21\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n179#2,2:47\n1#3:49\n1#3:60\n11653#4,9:50\n13579#4:59\n13580#4:61\n11662#4:62\n1747#5,3:63\n*S KotlinDebug\n*F\n+ 1 NetworkDataCollectorApi21.kt\ncom/appsflyer/internal/network/NetworkDataCollectorApi21\n*L\n17#1:47,2\n31#1:60\n31#1:50,9\n31#1:59\n31#1:61\n31#1:62\n33#1:63,3\n*E\n"})
public final class AFi1qSDK extends AFi1pSDK {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFi1qSDK(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
    }

    private static boolean w_(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null || !networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(15)) {
            return false;
        }
        return true;
    }

    public final boolean getMonetizationNetwork() {
        Network[] allNetworks;
        try {
            ConnectivityManager connectivityManager = this.getMonetizationNetwork;
            if (connectivityManager == null || (allNetworks = connectivityManager.getAllNetworks()) == null) {
                return false;
            }
            ArrayList<NetworkCapabilities> arrayList = new ArrayList<>();
            for (Network networkCapabilities : allNetworks) {
                ConnectivityManager connectivityManager2 = this.getMonetizationNetwork;
                Intrinsics.c(connectivityManager2);
                NetworkCapabilities networkCapabilities2 = connectivityManager2.getNetworkCapabilities(networkCapabilities);
                if (networkCapabilities2 != null) {
                    arrayList.add(networkCapabilities2);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            for (NetworkCapabilities w_ : arrayList) {
                if (w_(w_)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            AFLogger.afErrorLog("Failed collecting ivc data", e);
            return false;
        }
    }

    @NotNull
    public final String getRevenue() {
        Network[] allNetworks;
        Sequence sequence;
        Object obj;
        ConnectivityManager connectivityManager = this.getMonetizationNetwork;
        if (!(connectivityManager == null || (allNetworks = connectivityManager.getAllNetworks()) == null)) {
            Intrinsics.checkNotNullParameter(allNetworks, "<this>");
            if (allNetworks.length == 0) {
                sequence = SequencesKt.e();
            } else {
                sequence = new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1(allNetworks);
            }
            if (sequence != null) {
                FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1(SequencesKt.k(sequence, new Function1<Network, NetworkInfo>(this) {
                    private /* synthetic */ AFi1qSDK getCurrencyIso4217Code;

                    {
                        this.getCurrencyIso4217Code = r1;
                    }

                    @Nullable
                    /* renamed from: x_ */
                    public final NetworkInfo invoke(Network network) {
                        ConnectivityManager connectivityManager = this.getCurrencyIso4217Code.getMonetizationNetwork;
                        Intrinsics.c(connectivityManager);
                        return connectivityManager.getNetworkInfo(network);
                    }
                }));
                while (true) {
                    if (!filteringSequence$iterator$1.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = filteringSequence$iterator$1.next();
                    if (AFi1pSDK.v_((NetworkInfo) obj)) {
                        break;
                    }
                }
                NetworkInfo networkInfo = (NetworkInfo) obj;
                if (networkInfo != null) {
                    int type = networkInfo.getType();
                    if (type == 0) {
                        return "MOBILE";
                    }
                    if (type != 1) {
                        return "unknown";
                    }
                    return "WIFI";
                }
            }
        }
        return "unknown";
    }
}
