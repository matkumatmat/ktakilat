package com.trustdecision.liveness.cw.api.il111liilil;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class il11iii11l11i1 {
    public static String illill1ll1(String str, String str2, int i) {
        try {
            return illill1ll1(new URL(str), str2.getBytes(illill1ll1("4959473252", 57)), i);
        } catch (Throwable th) {
            th.printStackTrace();
            return illill1ll1("IRU=");
        }
    }

    private static String illill1ll1(URL url, byte[] bArr, int i) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        Reader reader;
        Reader reader2;
        Reader reader3;
        Reader reader4;
        Reader reader5;
        Reader reader6;
        Reader reader7;
        Reader inputStreamReader;
        JSONObject jSONObject = new JSONObject();
        StringBuilder sb = new StringBuilder();
        OutputStream outputStream = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(illill1ll1("OQcWFwYMG3ccARMG"), illill1ll1("OxgIDwoBDi4BFw1MCBw1Bg=="));
            httpURLConnection.setRequestMethod(illill1ll1("CicrNw=="));
            OutputStream outputStream2 = httpURLConnection.getOutputStream();
            try {
                outputStream2.write(bArr);
                outputStream2.flush();
                int responseCode = httpURLConnection.getResponseCode();
                jSONObject.put(illill1ll1("OQccBg=="), responseCode);
                if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }
            } catch (IOException e) {
                e = e;
                inputStream = null;
                reader5 = null;
                bufferedReader = reader5;
                reader4 = reader5;
                outputStream = outputStream2;
                reader2 = reader4;
                try {
                    jSONObject.put(illill1ll1("7f2d682c", 64), 500);
                    jSONObject.put(illill1ll1("KA0LFg8W"), e.getMessage());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    th = th;
                    reader = reader2;
                    illill1ll1((Closeable) outputStream);
                    illill1ll1(inputStream);
                    illill1ll1((Closeable) bufferedReader);
                    illill1ll1((Closeable) reader);
                    throw th;
                }
                e.printStackTrace();
                illill1ll1((Closeable) outputStream);
                reader3 = reader2;
                illill1ll1(inputStream);
                illill1ll1((Closeable) bufferedReader);
                illill1ll1((Closeable) reader3);
                return jSONObject.toString();
            } catch (JSONException e3) {
                e = e3;
                inputStream = null;
                reader5 = null;
                bufferedReader = reader5;
                reader4 = reader5;
                outputStream = outputStream2;
                reader2 = reader4;
                jSONObject.put(illill1ll1("7f2d682c", 64), 500);
                jSONObject.put(illill1ll1("KA0LFg8W"), e.getMessage());
                e.printStackTrace();
                illill1ll1((Closeable) outputStream);
                reader3 = reader2;
                illill1ll1(inputStream);
                illill1ll1((Closeable) bufferedReader);
                illill1ll1((Closeable) reader3);
                return jSONObject.toString();
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                reader7 = null;
                bufferedReader = reader7;
                reader6 = reader7;
                outputStream = outputStream2;
                reader = reader6;
                illill1ll1((Closeable) outputStream);
                illill1ll1(inputStream);
                illill1ll1((Closeable) bufferedReader);
                illill1ll1((Closeable) reader);
                throw th;
            }
            try {
                inputStreamReader = new InputStreamReader(inputStream, illill1ll1("694e670572", 46));
            } catch (IOException | JSONException e4) {
                e = e4;
                reader5 = null;
                bufferedReader = reader5;
                reader4 = reader5;
                outputStream = outputStream2;
                reader2 = reader4;
                jSONObject.put(illill1ll1("7f2d682c", 64), 500);
                jSONObject.put(illill1ll1("KA0LFg8W"), e.getMessage());
                e.printStackTrace();
                illill1ll1((Closeable) outputStream);
                reader3 = reader2;
                illill1ll1(inputStream);
                illill1ll1((Closeable) bufferedReader);
                illill1ll1((Closeable) reader3);
                return jSONObject.toString();
            } catch (Throwable th3) {
                th = th3;
                reader7 = null;
                bufferedReader = reader7;
                reader6 = reader7;
                outputStream = outputStream2;
                reader = reader6;
                illill1ll1((Closeable) outputStream);
                illill1ll1(inputStream);
                illill1ll1((Closeable) bufferedReader);
                illill1ll1((Closeable) reader);
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (IOException e5) {
                        e = e5;
                        reader4 = inputStreamReader;
                        outputStream = outputStream2;
                        reader2 = reader4;
                        jSONObject.put(illill1ll1("7f2d682c", 64), 500);
                        jSONObject.put(illill1ll1("KA0LFg8W"), e.getMessage());
                        e.printStackTrace();
                        illill1ll1((Closeable) outputStream);
                        reader3 = reader2;
                        illill1ll1(inputStream);
                        illill1ll1((Closeable) bufferedReader);
                        illill1ll1((Closeable) reader3);
                        return jSONObject.toString();
                    } catch (JSONException e6) {
                        e = e6;
                        reader4 = inputStreamReader;
                        outputStream = outputStream2;
                        reader2 = reader4;
                        jSONObject.put(illill1ll1("7f2d682c", 64), 500);
                        jSONObject.put(illill1ll1("KA0LFg8W"), e.getMessage());
                        e.printStackTrace();
                        illill1ll1((Closeable) outputStream);
                        reader3 = reader2;
                        illill1ll1(inputStream);
                        illill1ll1((Closeable) bufferedReader);
                        illill1ll1((Closeable) reader3);
                        return jSONObject.toString();
                    } catch (Throwable th4) {
                        th = th4;
                        reader6 = inputStreamReader;
                        outputStream = outputStream2;
                        reader = reader6;
                        illill1ll1((Closeable) outputStream);
                        illill1ll1(inputStream);
                        illill1ll1((Closeable) bufferedReader);
                        illill1ll1((Closeable) reader);
                        throw th;
                    }
                }
                jSONObject.put(illill1ll1("6e4a644c7d54", 60), sb.toString());
                httpURLConnection.disconnect();
                illill1ll1((Closeable) outputStream2);
                reader3 = inputStreamReader;
            } catch (IOException | JSONException e7) {
                e = e7;
                bufferedReader = null;
                reader4 = inputStreamReader;
                outputStream = outputStream2;
                reader2 = reader4;
                jSONObject.put(illill1ll1("7f2d682c", 64), 500);
                jSONObject.put(illill1ll1("KA0LFg8W"), e.getMessage());
                e.printStackTrace();
                illill1ll1((Closeable) outputStream);
                reader3 = reader2;
                illill1ll1(inputStream);
                illill1ll1((Closeable) bufferedReader);
                illill1ll1((Closeable) reader3);
                return jSONObject.toString();
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                reader6 = inputStreamReader;
                outputStream = outputStream2;
                reader = reader6;
                illill1ll1((Closeable) outputStream);
                illill1ll1(inputStream);
                illill1ll1((Closeable) bufferedReader);
                illill1ll1((Closeable) reader);
                throw th;
            }
        } catch (IOException | JSONException e8) {
            e = e8;
            inputStream = null;
            reader2 = null;
            bufferedReader = null;
            jSONObject.put(illill1ll1("7f2d682c", 64), 500);
            jSONObject.put(illill1ll1("KA0LFg8W"), e.getMessage());
            e.printStackTrace();
            illill1ll1((Closeable) outputStream);
            reader3 = reader2;
            illill1ll1(inputStream);
            illill1ll1((Closeable) bufferedReader);
            illill1ll1((Closeable) reader3);
            return jSONObject.toString();
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            reader = null;
            bufferedReader = null;
            illill1ll1((Closeable) outputStream);
            illill1ll1(inputStream);
            illill1ll1((Closeable) bufferedReader);
            illill1ll1((Closeable) reader);
            throw th;
        }
        illill1ll1(inputStream);
        illill1ll1((Closeable) bufferedReader);
        illill1ll1((Closeable) reader3);
        return jSONObject.toString();
    }

    public static void illill1ll1(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void illill1ll1(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static String illill1ll1(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 97);
            byte b2 = (byte) (bArr[0] ^ Ascii.FS);
            bArr[0] = b2;
            int i4 = 1;
            while (i4 < length) {
                byte b3 = bArr[i4];
                bArr[i4] = (byte) ((b2 ^ b3) ^ b);
                i4++;
                b2 = b3;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String illill1ll1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "Zhxccbo".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }
}
