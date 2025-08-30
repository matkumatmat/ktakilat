package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import com.appsflyer.internal.AFj1iSDK;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

public class AFKeystoreWrapper {
    public int AFAdRevenueData;
    public KeyStore getCurrencyIso4217Code;
    private Context getMediationNetwork;
    public final Object getMonetizationNetwork = new Object();
    public String getRevenue;

    public AFKeystoreWrapper(Context context) {
        this.getMediationNetwork = context;
        this.getRevenue = "";
        this.AFAdRevenueData = 0;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.getCurrencyIso4217Code = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e);
        }
    }

    private static boolean AFAdRevenueData(String str) {
        return str.startsWith("com.appsflyer");
    }

    public final String getMediationNetwork() {
        StringBuilder sb = new StringBuilder("com.appsflyer,KSAppsFlyerId=");
        synchronized (this.getMonetizationNetwork) {
            sb.append(this.getRevenue);
            sb.append(",KSAppsFlyerRICounter=");
            sb.append(this.AFAdRevenueData);
        }
        return sb.toString();
    }

    public final String getMonetizationNetwork() {
        String str;
        synchronized (this.getMonetizationNetwork) {
            str = this.getRevenue;
        }
        return str;
    }

    public final boolean getRevenue() {
        boolean z;
        synchronized (this.getMonetizationNetwork) {
            try {
                KeyStore keyStore = this.getCurrencyIso4217Code;
                z = false;
                if (keyStore != null) {
                    Enumeration<String> aliases = keyStore.aliases();
                    while (true) {
                        if (!aliases.hasMoreElements()) {
                            break;
                        }
                        String nextElement = aliases.nextElement();
                        if (nextElement != null && AFAdRevenueData(nextElement)) {
                            String[] split = nextElement.split(",");
                            if (split.length == 3) {
                                AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(nextElement));
                                z = true;
                                String[] split2 = split[1].trim().split("=");
                                String[] split3 = split[2].trim().split("=");
                                if (split2.length == 2 && split3.length == 2) {
                                    this.getRevenue = split2[1].trim();
                                    this.AFAdRevenueData = Integer.parseInt(split3[1].trim());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final int AFAdRevenueData() {
        int i;
        synchronized (this.getMonetizationNetwork) {
            i = this.AFAdRevenueData;
        }
        return i;
    }

    public final void getRevenue(String str) {
        AlgorithmParameterSpec algorithmParameterSpec;
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            synchronized (this.getMonetizationNetwork) {
                if (!this.getCurrencyIso4217Code.containsAlias(str)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        gh.u();
                        algorithmParameterSpec = gh.h(str).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else {
                        algorithmParameterSpec = !AFj1iSDK.getMediationNetwork() ? new KeyPairGeneratorSpec.Builder(this.getMediationNetwork).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build() : null;
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }
}
