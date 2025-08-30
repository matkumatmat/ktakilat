package defpackage;

import android.os.Bundle;
import android.os.StatFs;
import androidx.lifecycle.MutableLiveData;
import coil3.decode.Decoder;
import coil3.disk.DiskCache;
import coil3.disk.RealDiskCache;
import coil3.disk.UtilsKt;
import coil3.fetch.Fetcher;
import coil3.network.CacheStrategy;
import coil3.network.okhttp.internal.CallFactoryNetworkClient;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.DecoderServiceLoaderTarget;
import coil3.util.FetcherServiceLoaderTarget;
import coil3.util.ServiceLoaderComponentRegistry;
import com.ktakilat.cbase.datacollect.KtaEvent;
import com.ktakilat.loan.http.division.DivisionEnum;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharDirectionality;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.OkHttpClient;
import okio.FileSystem;
import okio.Path;

/* renamed from: q0  reason: default package */
public final /* synthetic */ class q0 implements Function0 {
    public final /* synthetic */ int c;

    public /* synthetic */ q0(int i) {
        this.c = i;
    }

    /* JADX WARNING: type inference failed for: r0v22, types: [com.katkilat.baidu_face.manager.QualityConfigManager, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v14, types: [com.katkilat.baidu_face.model.QualityConfig, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.Object, java.util.Comparator] */
    /* JADX WARNING: type inference failed for: r2v8, types: [java.lang.Object, java.util.Comparator] */
    /* JADX WARNING: type inference failed for: r0v43, types: [coil3.disk.DiskCache$Builder, java.lang.Object] */
    public final Object invoke() {
        Pair pair;
        KClass type;
        long j;
        int i = 0;
        switch (this.c) {
            case 0:
                return new Object();
            case 1:
                EnumEntries<CharDirectionality> entries = CharDirectionality.getEntries();
                int c2 = MapsKt.c(CollectionsKt.h(entries));
                if (c2 < 16) {
                    c2 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(c2);
                for (CharDirectionality next : entries) {
                    linkedHashMap.put(Integer.valueOf(next.c), next);
                }
                return linkedHashMap;
            case 2:
                return new MutableLiveData(DivisionEnum.PROVINCE);
            case 3:
                return new MutableLiveData();
            case 4:
                return new MutableLiveData();
            case 5:
                return new MutableLiveData();
            case 6:
                KtaEvent.Companion.b("n_gg_permission_pop_slide_content_expose", (Bundle) null);
                return null;
            case 7:
                return (DiskCache) UtilsKt.f85a.getValue();
            case 8:
                return new MutableLiveData();
            case 9:
                return new MutableLiveData();
            case 10:
                return new MutableLiveData();
            case 11:
                return new MutableLiveData();
            case 12:
                return CacheStrategy.f121a;
            case 13:
                return new MutableLiveData();
            case 14:
                return new MutableLiveData(Boolean.FALSE);
            case 15:
                return new MutableLiveData(Boolean.FALSE);
            case 16:
                return new MutableLiveData(Boolean.FALSE);
            case 17:
                return new MutableLiveData(Boolean.FALSE);
            case 18:
                return new CallFactoryNetworkClient(new OkHttpClient());
            case 19:
                ? obj = new Object();
                obj.f461a = new Object();
                return obj;
            case 20:
                List z = CollectionsKt.z((List) ServiceLoaderComponentRegistry.f160a.getValue(), new Object());
                ArrayList arrayList = new ArrayList();
                int size = z.size();
                while (i < size) {
                    FetcherServiceLoaderTarget fetcherServiceLoaderTarget = (FetcherServiceLoaderTarget) z.get(i);
                    Intrinsics.d(fetcherServiceLoaderTarget, "null cannot be cast to non-null type coil3.util.FetcherServiceLoaderTarget<kotlin.Any>");
                    Fetcher.Factory factory = fetcherServiceLoaderTarget.factory();
                    if (factory == null || (type = fetcherServiceLoaderTarget.type()) == null) {
                        pair = null;
                    } else {
                        pair = new Pair(factory, type);
                    }
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                    i++;
                }
                return arrayList;
            case 21:
                List z2 = CollectionsKt.z((List) ServiceLoaderComponentRegistry.b.getValue(), new Object());
                ArrayList arrayList2 = new ArrayList();
                int size2 = z2.size();
                while (i < size2) {
                    Decoder.Factory factory2 = ((DecoderServiceLoaderTarget) z2.get(i)).factory();
                    if (factory2 != null) {
                        arrayList2.add(factory2);
                    }
                    i++;
                }
                return arrayList2;
            case 22:
                Lazy lazy = ServiceLoaderComponentRegistry.f160a;
                Class<FetcherServiceLoaderTarget> cls = FetcherServiceLoaderTarget.class;
                return Collections_jvmCommonKt.a(SequencesKt.l(SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator())));
            case 23:
                Lazy lazy2 = ServiceLoaderComponentRegistry.f160a;
                Class<DecoderServiceLoaderTarget> cls2 = DecoderServiceLoaderTarget.class;
                return Collections_jvmCommonKt.a(SequencesKt.l(SequencesKt.c(ServiceLoader.load(cls2, cls2.getClassLoader()).iterator())));
            default:
                Lazy lazy3 = UtilsKt.f85a;
                ? obj2 = new Object();
                obj2.f80a = FileSystem.SYSTEM;
                obj2.b = 10485760;
                DefaultScheduler defaultScheduler = Dispatchers.f767a;
                obj2.c = DefaultIoScheduler.c;
                Path resolve = FileSystem.SYSTEM_TEMPORARY_DIRECTORY.resolve("coil3_disk_cache");
                if (resolve != null) {
                    try {
                        File file = resolve.toFile();
                        file.mkdir();
                        StatFs statFs = new StatFs(file.getAbsolutePath());
                        j = RangesKt.a((long) (0.02d * ((double) (statFs.getBlockSizeLong() * statFs.getBlockCountLong()))), 10485760, 262144000);
                    } catch (Exception unused) {
                        j = obj2.b;
                    }
                    return new RealDiskCache(j, obj2.c, obj2.f80a, resolve);
                }
                throw new IllegalStateException("directory == null");
        }
    }
}
