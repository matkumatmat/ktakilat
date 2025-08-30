package com.trustdecision.android.o0Oo0OO00O0O000ooOO0;

import com.google.common.base.Ascii;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 {
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("48686f55376f6f", 112);
    protected static final HostnameVerifier o0Oo0OO00O0O000ooOO0 = new o0O00o00OOoOo0oooOoo00();
    /* access modifiers changed from: private */
    public static final String[] oO00o0OooO0OO0o0000o = {o0Oo0OO00O0O000ooOO0("480e0933510909", 22)};

    public static class o0O00o00OOoOo0oooOoo00 extends SSLSocketFactory {
        private SSLContext o0Oo0OO00O0O000ooOO0;

        public o0O00o00OOoOo0oooOoo00(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
            try {
                SSLContext instance = SSLContext.getInstance(o0Oo0OO00O0O000ooOO0("5d2522", 37));
                this.o0Oo0OO00O0O000ooOO0 = instance;
                instance.init(keyManagerArr, trustManagerArr, secureRandom);
            } catch (Exception unused) {
            }
        }

        private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
            try {
                int length = str.length() / 2;
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                }
                byte b = (byte) (i ^ 24);
                byte b2 = (byte) (bArr[0] ^ 9);
                bArr[0] = b2;
                for (int i4 = 1; i4 < length; i4++) {
                    b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                    bArr[i4] = b2;
                }
                return new String(bArr, CharEncoding.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
            SSLSocket sSLSocket = (SSLSocket) this.o0Oo0OO00O0O000ooOO0.getSocketFactory().createSocket(str, i);
            if (O00OO0oOOooooO00000Oo.O0oo0o00oooo) {
                sSLSocket.setEnabledProtocols(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o);
            }
            return sSLSocket;
        }

        public String[] getDefaultCipherSuites() {
            return this.o0Oo0OO00O0O000ooOO0.getSocketFactory().getDefaultCipherSuites();
        }

        public String[] getSupportedCipherSuites() {
            return this.o0Oo0OO00O0O000ooOO0.getSocketFactory().getSupportedCipherSuites();
        }

        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
            SSLSocket sSLSocket = (SSLSocket) this.o0Oo0OO00O0O000ooOO0.getSocketFactory().createSocket(str, i);
            if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().O0oo0o00oooo) {
                sSLSocket.setEnabledProtocols(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o);
            }
            return sSLSocket;
        }

        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            SSLSocket sSLSocket = (SSLSocket) this.o0Oo0OO00O0O000ooOO0.getSocketFactory().createSocket(inetAddress, i);
            if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().O0oo0o00oooo) {
                sSLSocket.setEnabledProtocols(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o);
            }
            return sSLSocket;
        }

        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            SSLSocket sSLSocket = (SSLSocket) this.o0Oo0OO00O0O000ooOO0.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
            if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().O0oo0o00oooo) {
                sSLSocket.setEnabledProtocols(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o);
            }
            return sSLSocket;
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
            SSLSocket sSLSocket = (SSLSocket) this.o0Oo0OO00O0O000ooOO0.getSocketFactory().createSocket(socket, str, i, z);
            if (O00OO0oOOooooO00000Oo.O0oo0o00oooo) {
                sSLSocket.setEnabledProtocols(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o);
            }
            return sSLSocket;
        }
    }

    /* renamed from: com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public interface C0021o0Oo0OO00O0O000ooOO0 {
        void o0Oo0OO00O0O000ooOO0(Map map);
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) i;
            byte b2 = (byte) (bArr[0] ^ Ascii.FS);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(String str, Map map, Map map2, byte[] bArr, int i, C0021o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map2.entrySet()) {
            if (entry.getValue() != null) {
                sb.append((String) entry.getKey());
                sb.append(o0Oo0OO00O0O000ooOO0("21", 76));
                sb.append(URLEncoder.encode((String) entry.getValue(), o0Oo0OO00O0O000ooOO0("6977643d63", 118)));
                sb.append(o0Oo0OO00O0O000ooOO0("3a", 53));
            }
        }
        if (!map2.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        StringBuilder v = ba.v(str);
        v.append(o0Oo0OO00O0O000ooOO0("23", 121));
        v.append(sb.toString());
        return o0Oo0OO00O0O000ooOO0(new URL(v.toString()), map, bArr, o0Oo0OO00O0O000ooOO0("7d3829352c232b3c342f286869253e383870772e2f3e2d25", 41), i, o0oo0oo00o0o000oooo0);
    }

    public static String o0Oo0OO00O0O000ooOO0(String str, Map map, byte[] bArr, int i, C0021o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) throws Exception {
        return o0Oo0OO00O0O000ooOO0(str, (Map) null, map, bArr, i, o0oo0oo00o0o000oooo0);
    }

    private static String o0Oo0OO00O0O000ooOO0(URL url, Map map, byte[] bArr, String str, int i, C0021o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) throws Exception {
        HttpsURLConnection httpsURLConnection;
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        if (o0Oo0OO00O0O000ooOO0("746d717572", 113).equals(url.getProtocol())) {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(O00OO0oOOooooO00000Oo.oO0o0oOoOO0OO ? url.openConnection() : url.openConnection(Proxy.NO_PROXY)));
            o0Oo0OO00O0O000ooOO0(httpsURLConnection2, i);
            httpsURLConnection = httpsURLConnection2;
        } else {
            httpsURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(O00OO0oOOooooO00000Oo.oO0o0oOoOO0OO ? url.openConnection() : url.openConnection(Proxy.NO_PROXY)));
        }
        o0Oo0OO00O0O000ooOO0(httpsURLConnection, map);
        o0Oo0OO00O0O000ooOO0(httpsURLConnection, str);
        httpsURLConnection.setRequestMethod(o0Oo0OO00O0O000ooOO0("4c77746f", 104));
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode != 200) {
            String str2 = o0Oo0OO00O0O000ooOO0("5f1e33323934256674353a373b337a3e602524312d332f2477713e393377", 50) + responseCode;
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(str2);
            return str2;
        }
        if (o0oo0oo00o0o000oooo0 != null) {
            try {
                o0oo0oo00o0o000oooo0.o0Oo0OO00O0O000ooOO0(httpsURLConnection.getHeaderFields());
            } catch (Exception unused) {
            }
        }
        InputStream inputStream = httpsURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, o0Oo0OO00O0O000ooOO0("6977643d63", 118)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                inputStream.close();
                outputStream.close();
                return sb.toString();
            }
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(HttpURLConnection httpURLConnection, String str) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        httpURLConnection.setRequestProperty(o0Oo0OO00O0O000ooOO0("5f371a010a1001426236120e", 27), str);
        httpURLConnection.setConnectTimeout(O00OO0oOOooooO00000Oo.o0ooO0o000Oo0Oo0O0);
        httpURLConnection.setReadTimeout(O00OO0oOOooooO00000Oo.o0ooO0o000Oo0Oo0O0);
        httpURLConnection.setDoOutput(true);
    }

    public static void o0Oo0OO00O0O000ooOO0(HttpURLConnection httpURLConnection, Map map) {
        if (httpURLConnection != null && map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(HttpsURLConnection httpsURLConnection, int i) {
        com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 O00OO0oOOooooO00000Oo = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo();
        if (i == 2) {
            httpsURLConnection.setHostnameVerifier(o0Oo0OO00O0O000ooOO0);
        }
        if (O00OO0oOOooooO00000Oo.O0oo0o00oooo) {
            httpsURLConnection.setSSLSocketFactory(new o0O00o00OOoOo0oooOoo00((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null));
        }
    }
}
