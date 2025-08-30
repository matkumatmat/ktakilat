package kotlin.io;

import com.facebook.internal.NativeProtocol;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,157:1\n57#1:158\n1#2:159\n1#2:162\n1317#3,2:160\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n35#1:158\n35#1:159\n35#1:160,2\n*E\n"})
@JvmName(name = "TextStreamsKt")
public final class TextStreamsKt {
    public static final ArrayList a(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        ArrayList arrayList = new ArrayList();
        a aVar = new a(arrayList, 9);
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        try {
            Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
            Iterator it = SequencesKt.d(new LinesSequence(bufferedReader)).iterator();
            while (it.hasNext()) {
                aVar.invoke(it.next());
            }
            Unit unit = Unit.f696a;
            CloseableKt.a(bufferedReader, (Throwable) null);
            return arrayList;
        } catch (Throwable th) {
            CloseableKt.a(bufferedReader, th);
            throw th;
        }
    }
}
