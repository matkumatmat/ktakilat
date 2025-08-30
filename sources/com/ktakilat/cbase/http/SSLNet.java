package com.ktakilat.cbase.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class SSLNet {

    public static class TrustAllHostnameVerifier implements HostnameVerifier {
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static class TrustAllManager implements X509TrustManager {
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
