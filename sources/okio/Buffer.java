package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J'\u0010h\u001a\u0004\u0018\u0001Hk\"\b\b\u0000\u0010k*\u00020%2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hk0lH\u0016¢\u0006\u0002\u0010mJ\u0006\u0010n\u001a\u00020\u001dJ\u0006\u0010o\u001a\u00020\u001dJ\u0006\u0010p\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bqJ\u0010\u0010r\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010s\u001a\u00020\u001dJ\u000e\u0010s\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020\u001fH\u0016J\u0015\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020/H\u0000¢\u0006\u0002\byJ\u0010\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u00020FH\u0016J\u0010\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020GH\u0016J \u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010z\u001a\u00020\u00122\u0006\u0010{\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010z\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u001dH\u0016J \u0010z\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020}2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010~\u001a\u00020\f2\u0006\u0010{\u001a\u00020}H\u0016J\u0010\u0010\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "T", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 Buffer.kt\nokio/internal/-Buffer\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 BufferedSource.kt\nokio/internal/-BufferedSource\n*L\n1#1,643:1\n89#2:644\n86#2:677\n86#2:679\n74#2:739\n74#2:765\n83#2:804\n77#2:815\n89#2:1008\n74#2:1023\n86#2:1127\n89#2:1620\n244#3,32:645\n279#3,10:680\n292#3,18:690\n414#3,2:708\n112#3:710\n416#3:711\n114#3,18:712\n313#3,9:730\n322#3,15:740\n340#3,10:755\n350#3,3:766\n348#3,25:769\n376#3,10:794\n386#3:805\n384#3,9:806\n393#3,7:816\n391#3,20:823\n682#3,60:843\n745#3,56:903\n803#3:959\n806#3:960\n807#3,6:962\n817#3,7:968\n827#3,6:978\n835#3,5:984\n867#3,6:989\n877#3:995\n878#3,11:997\n889#3,5:1009\n898#3,9:1014\n908#3,61:1024\n633#3:1085\n636#3:1086\n637#3,5:1088\n644#3:1093\n647#3,7:1094\n656#3,20:1101\n420#3:1121\n423#3,5:1122\n428#3,10:1128\n439#3,7:1138\n444#3,2:1145\n973#3:1147\n974#3,87:1149\n1064#3,48:1236\n603#3:1284\n610#3,21:1285\n1115#3,7:1306\n1125#3,7:1313\n1135#3,4:1320\n1142#3,8:1324\n1153#3,10:1332\n1166#3,14:1342\n449#3,91:1356\n543#3,40:1447\n586#3:1487\n588#3,13:1489\n1183#3:1502\n1234#3:1503\n1235#3,39:1505\n1276#3,2:1544\n1278#3,4:1547\n1285#3,3:1551\n1289#3,4:1555\n112#3:1559\n1293#3,22:1560\n114#3,18:1582\n1319#3,2:1600\n1321#3,3:1603\n112#3:1606\n1324#3,13:1607\n1337#3,13:1621\n114#3,18:1634\n1354#3,2:1652\n1357#3:1655\n112#3:1656\n1358#3,50:1657\n114#3,18:1707\n1417#3,14:1725\n1434#3,32:1739\n1469#3,12:1771\n1484#3,18:1783\n1506#3:1801\n1507#3:1803\n1512#3,34:1804\n1#4:678\n1#4:961\n1#4:996\n1#4:1087\n1#4:1148\n1#4:1488\n1#4:1504\n1#4:1546\n1#4:1554\n1#4:1602\n1#4:1654\n1#4:1802\n26#5,3:975\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer\n*L\n167#1:644\n197#1:677\n235#1:679\n261#1:739\n264#1:765\n267#1:804\n267#1:815\n337#1:1008\n340#1:1023\n376#1:1127\n485#1:1620\n181#1:645,32\n252#1:680,10\n255#1:690,18\n258#1:708,2\n258#1:710\n258#1:711\n258#1:712,18\n261#1:730,9\n261#1:740,15\n264#1:755,10\n264#1:766,3\n264#1:769,25\n267#1:794,10\n267#1:805\n267#1:806,9\n267#1:816,7\n267#1:823,20\n279#1:843,60\n282#1:903,56\n284#1:959\n287#1:960\n287#1:962,6\n289#1:968,7\n294#1:978,6\n297#1:984,5\n331#1:989,6\n337#1:995\n337#1:997,11\n337#1:1009,5\n340#1:1014,9\n340#1:1024,61\n342#1:1085\n345#1:1086\n345#1:1088,5\n347#1:1093\n350#1:1094,7\n353#1:1101,20\n373#1:1121\n376#1:1122,5\n376#1:1128,10\n378#1:1138,7\n381#1:1145,2\n386#1:1147\n386#1:1149,87\n389#1:1236,48\n412#1:1284\n418#1:1285,21\n439#1:1306,7\n443#1:1313,7\n445#1:1320,4\n447#1:1324,8\n451#1:1332,10\n455#1:1342,14\n459#1:1356,91\n462#1:1447,40\n465#1:1487\n465#1:1489,13\n467#1:1502\n467#1:1503\n467#1:1505,39\n469#1:1544,2\n469#1:1547,4\n479#1:1551,3\n479#1:1555,4\n479#1:1559\n479#1:1560,22\n479#1:1582,18\n485#1:1600,2\n485#1:1603,3\n485#1:1606\n485#1:1607,13\n485#1:1621,13\n485#1:1634,18\n490#1:1652,2\n490#1:1655\n490#1:1656\n490#1:1657,50\n490#1:1707,18\n500#1:1725,14\n570#1:1739,32\n572#1:1771,12\n580#1:1783,18\n588#1:1801\n588#1:1803\n590#1:1804,34\n287#1:961\n337#1:996\n345#1:1087\n386#1:1148\n465#1:1488\n467#1:1504\n469#1:1546\n479#1:1554\n485#1:1602\n490#1:1654\n588#1:1802\n291#1:975,3\n*E\n"})
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    @Nullable
    @JvmField
    public Segment head;
    private long size;

    @SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n+ 2 Buffer.kt\nokio/internal/-Buffer\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,643:1\n1567#2:644\n1568#2:646\n1572#2:647\n1573#2,68:649\n1644#2:717\n1645#2,32:719\n1677#2,18:752\n1698#2:770\n1699#2,18:772\n1721#2:790\n1723#2,7:792\n1#3:645\n1#3:648\n1#3:718\n1#3:771\n1#3:791\n86#4:751\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n*L\n630#1:644\n630#1:646\n632#1:647\n632#1:649,68\n634#1:717\n634#1:719,32\n634#1:752,18\n636#1:770\n636#1:772,18\n639#1:790\n639#1:792,7\n630#1:645\n632#1:648\n634#1:718\n636#1:771\n639#1:791\n634#1:751\n*E\n"})
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnsafeCursor implements Closeable {
        @Nullable
        @JvmField
        public Buffer buffer;
        @Nullable
        @JvmField
        public byte[] data;
        @JvmField
        public int end = -1;
        @JvmField
        public long offset = -1;
        @JvmField
        public boolean readWrite;
        @Nullable
        private Segment segment;
        @JvmField
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                setSegment$okio((Segment) null);
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException(ba.k(i, "minByteCount <= 0: ").toString());
            } else if (i <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long size = buffer2.size();
                    Segment writableSegment$okio = buffer2.writableSegment$okio(i);
                    int i2 = 8192 - writableSegment$okio.limit;
                    writableSegment$okio.limit = 8192;
                    long j = (long) i2;
                    buffer2.setSize$okio(size + j);
                    setSegment$okio(writableSegment$okio);
                    this.offset = size;
                    this.data = writableSegment$okio.data;
                    this.start = 8192 - i2;
                    this.end = 8192;
                    return j;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException(ba.k(i, "minByteCount > Segment.SIZE: ").toString());
            }
        }

        @Nullable
        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long j;
            long j2 = this.offset;
            Buffer buffer2 = this.buffer;
            Intrinsics.c(buffer2);
            if (j2 != buffer2.size()) {
                long j3 = this.offset;
                if (j3 == -1) {
                    j = 0;
                } else {
                    j = j3 + ((long) (this.end - this.start));
                }
                return seek(j);
            }
            throw new IllegalStateException("no more bytes");
        }

        public final long resizeBuffer(long j) {
            long j2 = j;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long size = buffer2.size();
                int i = (j2 > size ? 1 : (j2 == size ? 0 : -1));
                if (i <= 0) {
                    if (j2 >= 0) {
                        long j3 = size - j2;
                        while (true) {
                            if (j3 <= 0) {
                                break;
                            }
                            Segment segment2 = buffer2.head;
                            Intrinsics.c(segment2);
                            Segment segment3 = segment2.prev;
                            Intrinsics.c(segment3);
                            int i2 = segment3.limit;
                            long j4 = (long) (i2 - segment3.pos);
                            if (j4 > j3) {
                                segment3.limit = i2 - ((int) j3);
                                break;
                            }
                            buffer2.head = segment3.pop();
                            SegmentPool.recycle(segment3);
                            j3 -= j4;
                        }
                        setSegment$okio((Segment) null);
                        this.offset = j2;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException(e.j(j2, "newSize < 0: ").toString());
                    }
                } else if (i > 0) {
                    long j5 = j2 - size;
                    boolean z = true;
                    for (long j6 = 0; j5 > j6; j6 = 0) {
                        Segment writableSegment$okio = buffer2.writableSegment$okio(1);
                        int min = (int) Math.min(j5, (long) (8192 - writableSegment$okio.limit));
                        writableSegment$okio.limit += min;
                        j5 -= (long) min;
                        if (z) {
                            setSegment$okio(writableSegment$okio);
                            this.offset = size;
                            this.data = writableSegment$okio.data;
                            int i3 = writableSegment$okio.limit;
                            this.start = i3 - min;
                            this.end = i3;
                            z = false;
                        }
                    }
                }
                buffer2.setSize$okio(j2);
                return size;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final int seek(long j) {
            Segment segment2;
            Buffer buffer2 = this.buffer;
            if (buffer2 != null) {
                int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
                if (i < 0 || j > buffer2.size()) {
                    throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer2.size());
                } else if (i == 0 || j == buffer2.size()) {
                    setSegment$okio((Segment) null);
                    this.offset = j;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                } else {
                    long size = buffer2.size();
                    Segment segment3 = buffer2.head;
                    long j2 = 0;
                    if (getSegment$okio() != null) {
                        long j3 = this.offset;
                        int i2 = this.start;
                        Segment segment$okio = getSegment$okio();
                        Intrinsics.c(segment$okio);
                        long j4 = j3 - ((long) (i2 - segment$okio.pos));
                        if (j4 > j) {
                            segment2 = segment3;
                            segment3 = getSegment$okio();
                            size = j4;
                        } else {
                            segment2 = getSegment$okio();
                            j2 = j4;
                        }
                    } else {
                        segment2 = segment3;
                    }
                    if (size - j > j - j2) {
                        while (true) {
                            Intrinsics.c(segment2);
                            int i3 = segment2.limit;
                            int i4 = segment2.pos;
                            if (j < ((long) (i3 - i4)) + j2) {
                                break;
                            }
                            j2 += (long) (i3 - i4);
                            segment2 = segment2.next;
                        }
                    } else {
                        while (size > j) {
                            Intrinsics.c(segment3);
                            segment3 = segment3.prev;
                            Intrinsics.c(segment3);
                            size -= (long) (segment3.limit - segment3.pos);
                        }
                        j2 = size;
                        segment2 = segment3;
                    }
                    if (this.readWrite) {
                        Intrinsics.c(segment2);
                        if (segment2.shared) {
                            Segment unsharedCopy = segment2.unsharedCopy();
                            if (buffer2.head == segment2) {
                                buffer2.head = unsharedCopy;
                            }
                            segment2 = segment2.push(unsharedCopy);
                            Segment segment4 = segment2.prev;
                            Intrinsics.c(segment4);
                            segment4.pop();
                        }
                    }
                    setSegment$okio(segment2);
                    this.offset = j;
                    Intrinsics.c(segment2);
                    this.data = segment2.data;
                    int i5 = segment2.pos + ((int) (j - j2));
                    this.start = i5;
                    int i6 = segment2.limit;
                    this.end = i6;
                    return i6 - i5;
                }
            } else {
                throw new IllegalStateException("not attached to a buffer");
            }
        }

        public final void setSegment$okio(@Nullable Segment segment2) {
            this.segment = segment2;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = buffer.size - j3;
        }
        return buffer.copyTo(outputStream, j3, j2);
    }

    private final ByteString digest(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i = segment.pos;
            instance.update(bArr, i, segment.limit - i);
            Segment segment2 = segment.next;
            Intrinsics.c(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i2 = segment2.pos;
                instance.update(bArr2, i2, segment2.limit - i2);
                segment2 = segment2.next;
                Intrinsics.c(segment2);
            }
        }
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i = segment.pos;
                instance.update(bArr, i, segment.limit - i);
                Segment segment2 = segment.next;
                Intrinsics.c(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i2 = segment2.pos;
                    instance.update(bArr2, i2, segment2.limit - i2);
                    segment2 = segment2.next;
                    Intrinsics.c(segment2);
                }
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m160deprecated_getByte(long j) {
        return getByte(j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m161deprecated_size() {
        return this.size;
    }

    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size2 = size();
        if (size2 == 0) {
            return 0;
        }
        Segment segment = this.head;
        Intrinsics.c(segment);
        Segment segment2 = segment.prev;
        Intrinsics.c(segment2);
        int i = segment2.limit;
        if (i < 8192 && segment2.owner) {
            size2 -= (long) (i - segment2.pos);
        }
        return size2;
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.c(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                Intrinsics.c(segment3);
                Intrinsics.c(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    @NotNull
    @JvmOverloads
    public final Buffer copyTo(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, 0, 0, 6, (Object) null);
    }

    @NotNull
    public Buffer emit() {
        return this;
    }

    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0009
            goto L_0x0081
        L_0x0009:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0011
        L_0x000e:
            r2 = 0
            goto L_0x0081
        L_0x0011:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0020
            goto L_0x000e
        L_0x0020:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002b
            goto L_0x0081
        L_0x002b:
            okio.Segment r3 = r0.head
            kotlin.jvm.internal.Intrinsics.c(r3)
            okio.Segment r1 = r1.head
            kotlin.jvm.internal.Intrinsics.c(r1)
            int r5 = r3.pos
            int r6 = r1.pos
            r9 = r7
        L_0x003a:
            long r11 = r18.size()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0081
            int r11 = r3.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x004e:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0069
            byte[] r15 = r3.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0061
            goto L_0x000e
        L_0x0061:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x004e
        L_0x0069:
            int r13 = r3.limit
            if (r5 != r13) goto L_0x0074
            okio.Segment r3 = r3.next
            kotlin.jvm.internal.Intrinsics.c(r3)
            int r5 = r3.pos
        L_0x0074:
            int r13 = r1.limit
            if (r6 != r13) goto L_0x007f
            okio.Segment r1 = r1.next
            kotlin.jvm.internal.Intrinsics.c(r1)
            int r6 = r1.pos
        L_0x007f:
            long r9 = r9 + r11
            goto L_0x003a
        L_0x0081:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    public boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void flush() {
    }

    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @JvmName(name = "getByte")
    public final byte getByte(long j) {
        SegmentedByteString.checkOffsetAndCount(size(), j, 1);
        Segment segment = this.head;
        if (segment == null) {
            Intrinsics.c((Object) null);
            throw null;
        } else if (size() - j < j) {
            long size2 = size();
            while (size2 > j) {
                segment = segment.prev;
                Intrinsics.c(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j) - size2)];
        } else {
            long j2 = 0;
            while (true) {
                int i = segment.limit;
                int i2 = segment.pos;
                long j3 = ((long) (i - i2)) + j2;
                if (j3 > j) {
                    return segment.data[(int) ((((long) i2) + j) - j2)];
                }
                segment = segment.next;
                Intrinsics.c(segment);
                j2 = j3;
            }
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.c(segment);
        } while (segment != this.head);
        return i;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA1", byteString);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA256", byteString);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        return indexOfElement(byteString, 0);
    }

    @NotNull
    public InputStream inputStream() {
        return new Buffer$inputStream$1(this);
    }

    public boolean isOpen() {
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @NotNull
    public OutputStream outputStream() {
        return new Buffer$outputStream$1(this);
    }

    @NotNull
    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public int read(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i = segment.pos + min;
        segment.pos = i;
        this.size -= (long) min;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public long readAll(@NotNull Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size2 = size();
        if (size2 > 0) {
            sink.write(this, size2);
        }
        return size2;
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.c(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            setSize$okio(size() - 1);
            if (i3 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a2, code lost:
        if (r2 == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a4, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a6, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        if (r1 >= r14) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        if (size() == 0) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b3, code lost:
        if (r2 == false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b5, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b8, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ba, code lost:
        r1 = defpackage.e.s(r1, " but was 0x");
        r1.append(okio.SegmentedByteString.toHexString(getByte(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d4, code lost:
        throw new java.lang.NumberFormatException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00da, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00db, code lost:
        if (r2 == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r19 = this;
            r0 = r19
            long r1 = r19.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00e0
            r1 = 0
            r5 = -7
            r8 = r3
            r6 = r5
            r2 = 0
            r5 = 0
        L_0x0013:
            okio.Segment r10 = r0.head
            kotlin.jvm.internal.Intrinsics.c(r10)
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L_0x001e:
            if (r12 >= r13) goto L_0x0080
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006e
            r14 = 57
            if (r15 > r14) goto L_0x006e
            int r14 = 48 - r15
            r16 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r18 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r18 < 0) goto L_0x0044
            if (r18 != 0) goto L_0x003d
            long r3 = (long) r14
            int r16 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x003d
            goto L_0x0044
        L_0x003d:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0078
        L_0x0044:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong((long) r8)
            okio.Buffer r1 = r1.writeByte((int) r15)
            if (r2 != 0) goto L_0x0056
            r1.readByte()
        L_0x0056:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006e:
            r3 = 45
            if (r15 != r3) goto L_0x007f
            if (r1 != 0) goto L_0x007f
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x0078:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = 0
            goto L_0x001e
        L_0x007f:
            r5 = 1
        L_0x0080:
            if (r12 != r13) goto L_0x008c
            okio.Segment r3 = r10.pop()
            r0.head = r3
            okio.SegmentPool.recycle(r10)
            goto L_0x008e
        L_0x008c:
            r10.pos = r12
        L_0x008e:
            if (r5 != 0) goto L_0x0099
            okio.Segment r3 = r0.head
            if (r3 != 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            r3 = 0
            goto L_0x0013
        L_0x0099:
            long r3 = r19.size()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.setSize$okio(r3)
            if (r2 == 0) goto L_0x00a6
            r14 = 2
            goto L_0x00a7
        L_0x00a6:
            r14 = 1
        L_0x00a7:
            if (r1 >= r14) goto L_0x00db
            long r3 = r19.size()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00d5
            if (r2 == 0) goto L_0x00b8
            java.lang.String r1 = "Expected a digit"
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00ba:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r3 = " but was 0x"
            java.lang.StringBuilder r1 = defpackage.e.s(r1, r3)
            byte r3 = r0.getByte(r5)
            java.lang.String r3 = okio.SegmentedByteString.toHexString((byte) r3)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x00d5:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x00db:
            if (r2 == 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            long r8 = -r8
        L_0x00df:
            return r8
        L_0x00e0:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        readFrom(inputStream, LocationRequestCompat.PASSIVE_INTERVAL, true);
        return this;
    }

    public void readFully(@NotNull Buffer buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (size() >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        if (r8 != r9) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        r15.head = r6.pop();
        okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0099, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        if (r1 != false) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0075 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ab
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000d:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.Intrinsics.c(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0018:
            if (r8 >= r9) goto L_0x008d
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0027
            r11 = 57
            if (r10 > r11) goto L_0x0027
            int r11 = r10 + -48
            goto L_0x003c
        L_0x0027:
            r11 = 97
            if (r10 < r11) goto L_0x0032
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0032
            int r11 = r10 + -87
            goto L_0x003c
        L_0x0032:
            r11 = 65
            if (r10 < r11) goto L_0x0071
            r11 = 70
            if (r10 > r11) goto L_0x0071
            int r11 = r10 + -55
        L_0x003c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x004c:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0071:
            if (r0 == 0) goto L_0x0075
            r1 = 1
            goto L_0x008d
        L_0x0075:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = okio.SegmentedByteString.toHexString((byte) r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008d:
            if (r8 != r9) goto L_0x0099
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x009b
        L_0x0099:
            r6.pos = r8
        L_0x009b:
            if (r1 != 0) goto L_0x00a1
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L_0x000d
        L_0x00a1:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        L_0x00ab:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            Intrinsics.c(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 4) {
                return ((readByte() & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((readByte() & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE);
            }
            byte[] bArr = segment.data;
            byte b = ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN);
            int i3 = i + 3;
            int i4 = i + 4;
            byte b2 = (bArr[i3] & UnsignedBytes.MAX_VALUE) | b | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
            setSize$okio(size() - 4);
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    public int readIntLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readInt());
    }

    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            Intrinsics.c(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            long j = ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40);
            int i3 = i + 7;
            int i4 = i + 8;
            long j2 = j | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8) | (((long) bArr[i3]) & 255);
            setSize$okio(size() - 8);
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return j2;
        }
        throw new EOFException();
    }

    public long readLongLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readLong());
    }

    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            Intrinsics.c(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) (((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i + 2;
            byte b = (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << 8);
            setSize$okio(size() - 2);
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) b;
        }
        throw new EOFException();
    }

    public short readShortLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readShort());
    }

    @NotNull
    public String readString(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    @NotNull
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b;
        int i;
        byte b2;
        if (size() != 0) {
            byte b3 = getByte(0);
            int i2 = 1;
            if ((b3 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                b2 = b3 & Ascii.DEL;
                i = 1;
                b = 0;
            } else if ((b3 & 224) == 192) {
                b2 = b3 & Ascii.US;
                i = 2;
                b = UnsignedBytes.MAX_POWER_OF_TWO;
            } else if ((b3 & 240) == 224) {
                b2 = b3 & Ascii.SI;
                i = 3;
                b = Ascii.NUL;
            } else if ((b3 & 248) == 240) {
                b2 = b3 & 7;
                i = 4;
                b = Ascii.NUL;
            } else {
                skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j = (long) i;
            if (size() >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte b4 = getByte(j2);
                    if ((b4 & 192) == 128) {
                        b2 = (b2 << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
                        i2++;
                    } else {
                        skip(j2);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                skip(j);
                if (b2 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 > b2 || b2 >= 57344) && b2 >= b) {
                    return b2;
                }
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            StringBuilder t = ba.t(i, "size < ", ": ");
            t.append(size());
            t.append(" (to read code point prefixed 0x");
            t.append(SegmentedByteString.toHexString(b3));
            t.append(')');
            throw new EOFException(t.toString());
        }
        throw new EOFException();
    }

    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public boolean request(long j) {
        if (this.size >= j) {
            return true;
        }
        return false;
    }

    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    public int select(@NotNull Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = okio.internal.Buffer.selectPrefix$default(this, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    @JvmName(name = "size")
    public final long size() {
        return this.size;
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                setSize$okio(size() - j2);
                j -= j2;
                int i = segment.pos + min;
                segment.pos = i;
                if (i == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Intrinsics.c(segment);
        Segment segment2 = segment.prev;
        Intrinsics.c(segment2);
        if (segment2.limit + i > 8192 || !segment2.owner) {
            return segment2.push(SegmentPool.take());
        }
        return segment2;
    }

    public long writeAll(@NotNull Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @NotNull
    @JvmOverloads
    public final Buffer writeTo(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return writeTo$default(this, outputStream, 0, 2, (Object) null);
    }

    @NotNull
    public Buffer clone() {
        return copy();
    }

    @NotNull
    @JvmOverloads
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, j, 0, 4, (Object) null);
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long indexOfElement(@NotNull ByteString byteString, long j) {
        long j2;
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j3 = 0;
        if (j >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            if (size() - j < j) {
                j2 = size();
                while (j2 > j) {
                    segment = segment.prev;
                    Intrinsics.c(segment);
                    j2 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b = byteString.getByte(0);
                    byte b2 = byteString.getByte(1);
                    while (j2 < size()) {
                        byte[] bArr = segment.data;
                        i2 = (int) ((((long) segment.pos) + j) - j2);
                        int i4 = segment.limit;
                        while (i2 < i4) {
                            byte b3 = bArr[i2];
                            if (!(b3 == b || b3 == b2)) {
                                i2++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.c(segment);
                        j = j2;
                    }
                    return -1;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                while (j2 < size()) {
                    byte[] bArr2 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j2);
                    int i5 = segment.limit;
                    while (i < i5) {
                        byte b4 = bArr2[i];
                        for (byte b5 : internalArray$okio) {
                            if (b4 == b5) {
                                i3 = segment.pos;
                                return ((long) (i2 - i3)) + j2;
                            }
                        }
                        i++;
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.c(segment);
                    j = j2;
                }
                return -1;
            }
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j3;
                if (j4 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.c(segment);
                j3 = j4;
            }
            if (byteString.size() == 2) {
                byte b6 = byteString.getByte(0);
                byte b7 = byteString.getByte(1);
                while (j2 < size()) {
                    byte[] bArr3 = segment.data;
                    int i6 = (int) ((((long) segment.pos) + j) - j2);
                    int i7 = segment.limit;
                    while (i2 < i7) {
                        byte b8 = bArr3[i2];
                        if (!(b8 == b6 || b8 == b7)) {
                            i6 = i2 + 1;
                        }
                    }
                    j3 = j2 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    Intrinsics.c(segment);
                    j = j3;
                }
                return -1;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            while (j2 < size()) {
                byte[] bArr4 = segment.data;
                int i8 = (int) ((((long) segment.pos) + j) - j2);
                int i9 = segment.limit;
                while (i < i9) {
                    byte b9 = bArr4[i];
                    for (byte b10 : internalArray$okio2) {
                        if (b9 == b10) {
                            i3 = segment.pos;
                            return ((long) (i2 - i3)) + j2;
                        }
                    }
                    i8 = i + 1;
                }
                j3 = j2 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                Intrinsics.c(segment);
                j = j3;
            }
            return -1;
            i3 = segment.pos;
            return ((long) (i2 - i3)) + j2;
        }
        throw new IllegalArgumentException(e.j(j, "fromIndex < 0: ").toString());
    }

    public boolean rangeEquals(long j, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || size() - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @NotNull
    public byte[] readByteArray(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(e.j(j, "byteCount: ").toString());
        } else if (size() >= j) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @NotNull
    public ByteString readByteString(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(e.j(j, "byteCount: ").toString());
        } else if (size() < j) {
            throw new EOFException();
        } else if (j < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new ByteString(readByteArray(j));
        } else {
            ByteString snapshot = snapshot((int) j);
            skip(j);
            return snapshot;
        }
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException(e.j(j, "byteCount < 0: ").toString());
    }

    @NotNull
    public String readString(long j, @NotNull Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(e.j(j, "byteCount: ").toString());
        } else if (this.size < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            Segment segment = this.head;
            Intrinsics.c(segment);
            int i2 = segment.pos;
            if (((long) i2) + j > ((long) segment.limit)) {
                return new String(readByteArray(j), charset);
            }
            int i3 = (int) j;
            String str = new String(segment.data, i2, i3, charset);
            int i4 = segment.pos + i3;
            segment.pos = i4;
            this.size -= j;
            if (i4 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    @NotNull
    @JvmOverloads
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadUnsafe(this, unsafeCursor);
    }

    @NotNull
    public String readUtf8(long j) throws EOFException {
        return readString(j, Charsets.UTF_8);
    }

    @NotNull
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return okio.internal.Buffer.readUtf8Line(this, indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return okio.internal.Buffer.readUtf8Line(this, j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException(e.j(j, "limit < 0: ").toString());
    }

    @NotNull
    public Buffer writeByte(int i) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        setSize$okio(size() + 1);
        return this;
    }

    @NotNull
    public Buffer writeDecimalLong(long j) {
        boolean z;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j != 0) {
            long j2 = (long) 10;
            i3--;
            bArr[i3] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        writableSegment$okio.limit += i2;
        setSize$okio(size() + ((long) i2));
        return this;
    }

    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        setSize$okio(size() + ((long) i));
        return this;
    }

    @NotNull
    public Buffer writeInt(int i) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    @NotNull
    public Buffer writeIntLe(int i) {
        return writeInt(SegmentedByteString.reverseBytes(i));
    }

    @NotNull
    public Buffer writeLong(long j) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        bArr[i + 1] = (byte) ((int) ((j >>> 48) & 255));
        bArr[i + 2] = (byte) ((int) ((j >>> 40) & 255));
        bArr[i + 3] = (byte) ((int) ((j >>> 32) & 255));
        bArr[i + 4] = (byte) ((int) ((j >>> 24) & 255));
        bArr[i + 5] = (byte) ((int) ((j >>> 16) & 255));
        bArr[i + 6] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i + 7] = (byte) ((int) (j & 255));
        writableSegment$okio.limit = i + 8;
        setSize$okio(size() + 8);
        return this;
    }

    @NotNull
    public Buffer writeLongLe(long j) {
        return writeLong(SegmentedByteString.reverseBytes(j));
    }

    @NotNull
    public Buffer writeShort(int i) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        writableSegment$okio.limit = i2 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    @NotNull
    public Buffer writeShortLe(int i) {
        return writeShort((int) SegmentedByteString.reverseBytes((short) i));
    }

    @NotNull
    @JvmOverloads
    public final Buffer writeTo(@NotNull OutputStream outputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        SegmentedByteString.checkOffsetAndCount(this.size, 0, j);
        Segment segment = this.head;
        while (j > 0) {
            Intrinsics.c(segment);
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, min);
            int i = segment.pos + min;
            segment.pos = i;
            long j2 = (long) min;
            this.size -= j2;
            j -= j2;
            if (i == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @NotNull
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i2 = writableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit = i2 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i && i < 57344) {
            writeByte(63);
        } else if (i < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i3 = writableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit = i3 + 3;
            setSize$okio(size() + 3);
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i4 = writableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit = i4 + 4;
            setSize$okio(size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i));
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    @NotNull
    @JvmOverloads
    public final Buffer copyTo(@NotNull OutputStream outputStream, long j, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        SegmentedByteString.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            Intrinsics.c(segment);
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        while (j2 > 0) {
            Intrinsics.c(segment);
            int i3 = (int) (((long) segment.pos) + j);
            int min = (int) Math.min((long) (segment.limit - i3), j2);
            outputStream.write(segment.data, i3, min);
            j2 -= (long) min;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public long indexOf(@NotNull ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return indexOf(byteString, 0);
    }

    @NotNull
    public Buffer writeString(@NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    @NotNull
    public Buffer writeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        return writeUtf8(str, 0, str.length());
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3;
        int i;
        long j4 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > size()) {
            j2 = size();
        }
        if (j == j2 || (segment = this.head) == null) {
            return -1;
        }
        if (size() - j < j) {
            j3 = size();
            while (j3 > j) {
                segment = segment.prev;
                Intrinsics.c(segment);
                j3 -= (long) (segment.limit - segment.pos);
            }
            while (j3 < j2) {
                byte[] bArr = segment.data;
                int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                i = (int) ((((long) segment.pos) + j) - j3);
                while (i < min) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                j3 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.c(segment);
                j = j3;
            }
            return -1;
        }
        while (true) {
            long j5 = ((long) (segment.limit - segment.pos)) + j4;
            if (j5 > j) {
                break;
            }
            segment = segment.next;
            Intrinsics.c(segment);
            j4 = j5;
        }
        while (j3 < j2) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
            int i2 = (int) ((((long) segment.pos) + j) - j3);
            while (i < min2) {
                if (bArr2[i] != b) {
                    i2 = i + 1;
                }
            }
            j4 = j3 + ((long) (segment.limit - segment.pos));
            segment = segment.next;
            Intrinsics.c(segment);
            j = j4;
        }
        return -1;
        return ((long) (i - segment.pos)) + j3;
    }

    @Nullable
    public <T> T select(@NotNull TypedOptions<T> typedOptions) {
        Intrinsics.checkNotNullParameter(typedOptions, "options");
        int select = select(typedOptions.getOptions$okio());
        if (select == -1) {
            return null;
        }
        return typedOptions.get(select);
    }

    @NotNull
    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(size(), 0, (long) i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.c(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.c(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new C0026SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public Buffer writeUtf8(@NotNull String str, int i, int i2) {
        char charAt;
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (i < 0) {
            throw new IllegalArgumentException(ba.k(i, "beginIndex < 0: ").toString());
        } else if (i2 < i) {
            throw new IllegalArgumentException(e.h(i2, "endIndex < beginIndex: ", " < ", i).toString());
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    Segment writableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = writableSegment$okio.data;
                    int i3 = writableSegment$okio.limit - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i5 = writableSegment$okio.limit;
                            int i6 = (i3 + i) - i5;
                            writableSegment$okio.limit = i5 + i6;
                            setSize$okio(size() + ((long) i6));
                        } else {
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                    }
                    int i52 = writableSegment$okio.limit;
                    int i62 = (i3 + i) - i52;
                    writableSegment$okio.limit = i52 + i62;
                    setSize$okio(size() + ((long) i62));
                } else {
                    if (charAt2 < 2048) {
                        Segment writableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = writableSegment$okio2.data;
                        int i7 = writableSegment$okio2.limit;
                        bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                        bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio2.limit = i7 + 2;
                        setSize$okio(size() + 2);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        Segment writableSegment$okio3 = writableSegment$okio(3);
                        byte[] bArr3 = writableSegment$okio3.data;
                        int i8 = writableSegment$okio3.limit;
                        bArr3[i8] = (byte) ((charAt2 >> 12) | 224);
                        bArr3[i8 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        bArr3[i8 + 2] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio3.limit = i8 + 3;
                        setSize$okio(size() + 3);
                    } else {
                        int i9 = i + 1;
                        char charAt3 = i9 < i2 ? str.charAt(i9) : 0;
                        if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                            writeByte(63);
                            i = i9;
                        } else {
                            int i10 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + Ascii.MIN;
                            Segment writableSegment$okio4 = writableSegment$okio(4);
                            byte[] bArr4 = writableSegment$okio4.data;
                            int i11 = writableSegment$okio4.limit;
                            bArr4[i11] = (byte) ((i10 >> 18) | 240);
                            bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                            writableSegment$okio4.limit = i11 + 4;
                            setSize$okio(size() + 4);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            StringBuilder t = ba.t(i2, "endIndex > string.length: ", " > ");
            t.append(str.length());
            throw new IllegalArgumentException(t.toString().toString());
        }
    }

    public void readFully(@NotNull byte[] bArr) throws EOFException {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public Buffer writeString(@NotNull String str, int i, int i2, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (i < 0) {
            throw new IllegalArgumentException(ba.k(i, "beginIndex < 0: ").toString());
        } else if (i2 < i) {
            throw new IllegalArgumentException(e.h(i2, "endIndex < beginIndex: ", " < ", i).toString());
        } else if (i2 > str.length()) {
            StringBuilder t = ba.t(i2, "endIndex > string.length: ", " > ");
            t.append(str.length());
            throw new IllegalArgumentException(t.toString().toString());
        } else if (Intrinsics.a(charset, Charsets.UTF_8)) {
            return writeUtf8(str, i, i2);
        } else {
            String substring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            byte[] bytes = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return write(bytes, 0, bytes.length);
        }
    }

    public int write(@NotNull ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i -= min;
            writableSegment$okio.limit += min;
        }
        this.size += (long) remaining;
        return remaining;
    }

    public int read(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    private final void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        while (true) {
            if (j > 0 || z) {
                Segment writableSegment$okio = writableSegment$okio(1);
                int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, (long) (8192 - writableSegment$okio.limit)));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        this.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (!z) {
                        throw new EOFException();
                    }
                    return;
                }
                writableSegment$okio.limit += read;
                long j2 = (long) read;
                this.size += j2;
                j -= j2;
            } else {
                return;
            }
        }
    }

    public int read(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        ArraysKt.i(bArr2, i, bArr, i3, i3 + min);
        segment.pos += min;
        setSize$okio(size() - ((long) min));
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        return copyTo(buffer, j, this.size - j);
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer, long j, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        SegmentedByteString.checkOffsetAndCount(size(), j, j2);
        if (j2 != 0) {
            buffer.setSize$okio(buffer.size() + j2);
            Segment segment = this.head;
            while (true) {
                Intrinsics.c(segment);
                int i = segment.limit;
                int i2 = segment.pos;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                segment = segment.next;
            }
            while (j2 > 0) {
                Intrinsics.c(segment);
                Segment sharedCopy = segment.sharedCopy();
                int i3 = sharedCopy.pos + ((int) j);
                sharedCopy.pos = i3;
                sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    Intrinsics.c(segment2);
                    Segment segment3 = segment2.prev;
                    Intrinsics.c(segment3);
                    segment3.push(sharedCopy);
                }
                j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j = 0;
            }
        }
        return this;
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, i, i2);
        return this;
    }

    @NotNull
    public Buffer write(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @NotNull
    public Buffer write(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        long j = (long) i2;
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt.i(bArr, writableSegment$okio.limit, writableSegment$okio.data, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        setSize$okio(size() + j);
        return this;
    }

    public long read(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(e.j(j, "byteCount < 0: ").toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j > size()) {
                j = size();
            }
            buffer.write(this, j);
            return j;
        }
    }

    @NotNull
    public Buffer write(@NotNull Source source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public long indexOf(@NotNull ByteString byteString, long j) throws IOException {
        long j2;
        int i;
        long j3 = j;
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (byteString.size() > 0) {
            long j4 = 0;
            if (j3 >= 0) {
                Segment segment = this.head;
                if (segment != null) {
                    if (size() - j3 < j3) {
                        j2 = size();
                        while (j2 > j3) {
                            segment = segment.prev;
                            Intrinsics.c(segment);
                            j2 -= (long) (segment.limit - segment.pos);
                        }
                        byte[] internalArray$okio = byteString.internalArray$okio();
                        byte b = internalArray$okio[0];
                        int size2 = byteString.size();
                        long size3 = (size() - ((long) size2)) + 1;
                        while (j2 < size3) {
                            byte[] bArr = segment.data;
                            long j5 = size3;
                            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size3) - j2);
                            i = (int) ((((long) segment.pos) + j3) - j2);
                            while (i < min) {
                                if (bArr[i] != b || !okio.internal.Buffer.rangeEquals(segment, i + 1, internalArray$okio, 1, size2)) {
                                    i++;
                                }
                            }
                            j2 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            Intrinsics.c(segment);
                            j3 = j2;
                            size3 = j5;
                        }
                    } else {
                        while (true) {
                            long j6 = ((long) (segment.limit - segment.pos)) + j4;
                            if (j6 > j3) {
                                break;
                            }
                            segment = segment.next;
                            Intrinsics.c(segment);
                            j4 = j6;
                        }
                        byte[] internalArray$okio2 = byteString.internalArray$okio();
                        byte b2 = internalArray$okio2[0];
                        int size4 = byteString.size();
                        long size5 = (size() - ((long) size4)) + 1;
                        while (j2 < size5) {
                            byte[] bArr2 = segment.data;
                            long j7 = size5;
                            int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size5) - j2);
                            int i2 = (int) ((((long) segment.pos) + j3) - j2);
                            while (i < min2) {
                                if (bArr2[i] == b2) {
                                    if (okio.internal.Buffer.rangeEquals(segment, i + 1, internalArray$okio2, 1, size4)) {
                                    }
                                }
                                i2 = i + 1;
                            }
                            j4 = j2 + ((long) (segment.limit - segment.pos));
                            segment = segment.next;
                            Intrinsics.c(segment);
                            j3 = j4;
                            size5 = j7;
                        }
                    }
                    return ((long) (i - segment.pos)) + j2;
                }
                return -1;
            }
            throw new IllegalArgumentException(e.j(j3, "fromIndex < 0: ").toString());
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public void write(@NotNull Buffer buffer, long j) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (buffer != this) {
            SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j);
            while (j > 0) {
                Segment segment2 = buffer.head;
                Intrinsics.c(segment2);
                int i = segment2.limit;
                Segment segment3 = buffer.head;
                Intrinsics.c(segment3);
                if (j < ((long) (i - segment3.pos))) {
                    Segment segment4 = this.head;
                    if (segment4 != null) {
                        Intrinsics.c(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            Segment segment5 = buffer.head;
                            Intrinsics.c(segment5);
                            segment5.writeTo(segment, (int) j);
                            buffer.setSize$okio(buffer.size() - j);
                            setSize$okio(size() + j);
                            return;
                        }
                    }
                    Segment segment6 = buffer.head;
                    Intrinsics.c(segment6);
                    buffer.head = segment6.split((int) j);
                }
                Segment segment7 = buffer.head;
                Intrinsics.c(segment7);
                long j2 = (long) (segment7.limit - segment7.pos);
                buffer.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    Intrinsics.c(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.c(segment9);
                    segment9.push(segment7).compact();
                }
                buffer.setSize$okio(buffer.size() - j2);
                setSize$okio(size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
