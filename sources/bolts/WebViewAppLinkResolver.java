package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import bolts.AppLink;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewAppLinkResolver implements AppLinkResolver {
    private static final String KEY_AL_VALUE = "value";
    private static final String KEY_ANDROID = "android";
    private static final String KEY_APP_NAME = "app_name";
    private static final String KEY_CLASS = "class";
    private static final String KEY_PACKAGE = "package";
    private static final String KEY_SHOULD_FALLBACK = "should_fallback";
    private static final String KEY_URL = "url";
    private static final String KEY_WEB = "web";
    private static final String KEY_WEB_URL = "url";
    private static final String META_TAG_PREFIX = "al";
    private static final String PREFER_HEADER = "Prefer-Html-Meta-Tags";
    private static final String TAG_EXTRACTION_JAVASCRIPT = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";
    /* access modifiers changed from: private */
    public final Context context;

    public WebViewAppLinkResolver(Context context2) {
        this.context = context2;
    }

    private static List<Map<String, Object>> getAlList(Map<String, Object> map, String str) {
        List<Map<String, Object>> list = (List) map.get(str);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    /* access modifiers changed from: private */
    public static AppLink makeAppLinkFromAlData(Map<String, Object> map, Uri uri) {
        Uri uri2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Map<String, Object> map2 = map;
        ArrayList arrayList = new ArrayList();
        List list = (List) map2.get("android");
        if (list == null) {
            list = Collections.emptyList();
        }
        Iterator it = list.iterator();
        while (true) {
            uri2 = null;
            if (!it.hasNext()) {
                break;
            }
            Map map3 = (Map) it.next();
            List<Map<String, Object>> alList = getAlList(map3, "url");
            List<Map<String, Object>> alList2 = getAlList(map3, KEY_PACKAGE);
            List<Map<String, Object>> alList3 = getAlList(map3, KEY_CLASS);
            List<Map<String, Object>> alList4 = getAlList(map3, "app_name");
            int max = Math.max(alList.size(), Math.max(alList2.size(), Math.max(alList3.size(), alList4.size())));
            for (int i = 0; i < max; i++) {
                if (alList.size() > i) {
                    obj = alList.get(i).get("value");
                } else {
                    obj = null;
                }
                Uri tryCreateUrl = tryCreateUrl((String) obj);
                if (alList2.size() > i) {
                    obj2 = alList2.get(i).get("value");
                } else {
                    obj2 = null;
                }
                String str = (String) obj2;
                if (alList3.size() > i) {
                    obj3 = alList3.get(i).get("value");
                } else {
                    obj3 = null;
                }
                String str2 = (String) obj3;
                if (alList4.size() > i) {
                    obj4 = alList4.get(i).get("value");
                } else {
                    obj4 = null;
                }
                arrayList.add(new AppLink.Target(str, str2, tryCreateUrl, (String) obj4));
            }
        }
        List list2 = (List) map2.get("web");
        if (list2 == null || list2.size() <= 0) {
            uri2 = uri;
        } else {
            Map map4 = (Map) list2.get(0);
            List list3 = (List) map4.get("url");
            List list4 = (List) map4.get(KEY_SHOULD_FALLBACK);
            if (list4 == null || list4.size() <= 0 || !Arrays.asList(new String[]{BooleanUtils.NO, BooleanUtils.FALSE, AppEventsConstants.EVENT_PARAM_VALUE_NO}).contains(((String) ((Map) list4.get(0)).get("value")).toLowerCase())) {
                uri2 = uri;
            }
            if (!(uri2 == null || list3 == null || list3.size() <= 0)) {
                uri2 = tryCreateUrl((String) ((Map) list3.get(0)).get("value"));
            }
        }
        return new AppLink(uri, arrayList, uri2);
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> parseAlData(JSONArray jSONArray) throws JSONException {
        Map hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String[] split = jSONObject.getString("property").split(":");
            if (split[0].equals(META_TAG_PREFIX)) {
                Map map = hashMap;
                int i2 = 1;
                while (true) {
                    Map map2 = null;
                    if (i2 >= split.length) {
                        break;
                    }
                    List list = (List) map.get(split[i2]);
                    if (list == null) {
                        list = new ArrayList();
                        map.put(split[i2], list);
                    }
                    if (list.size() > 0) {
                        map2 = (Map) e.f(list, 1);
                    }
                    if (map2 == null || i2 == split.length - 1) {
                        map = new HashMap();
                        list.add(map);
                    } else {
                        map = map2;
                    }
                    i2++;
                }
                if (jSONObject.has(FirebaseAnalytics.Param.CONTENT)) {
                    if (jSONObject.isNull(FirebaseAnalytics.Param.CONTENT)) {
                        map.put("value", (Object) null);
                    } else {
                        map.put("value", jSONObject.getString(FirebaseAnalytics.Param.CONTENT));
                    }
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static String readFromConnection(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        int i;
        if (uRLConnection instanceof HttpURLConnection) {
            try {
                inputStream = uRLConnection.getInputStream();
            } catch (Exception unused) {
                inputStream = ((HttpURLConnection) uRLConnection).getErrorStream();
            }
        } else {
            inputStream = uRLConnection.getInputStream();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                i = 0;
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String contentEncoding = uRLConnection.getContentEncoding();
            if (contentEncoding == null) {
                String[] split = uRLConnection.getContentType().split(";");
                int length = split.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String trim = split[i].trim();
                    if (trim.startsWith("charset=")) {
                        contentEncoding = trim.substring(8);
                        break;
                    }
                    i++;
                }
                if (contentEncoding == null) {
                    contentEncoding = CharEncoding.UTF_8;
                }
            }
            String str = new String(byteArrayOutputStream.toByteArray(), contentEncoding);
            inputStream.close();
            return str;
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private static Uri tryCreateUrl(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public Task<AppLink> getAppLinkFromUrlInBackground(final Uri uri) {
        final Capture capture = new Capture();
        final Capture capture2 = new Capture();
        return Task.callInBackground(new Callable<Void>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.net.URLConnection} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Void call() throws java.lang.Exception {
                /*
                    r5 = this;
                    java.net.URL r0 = new java.net.URL
                    android.net.Uri r1 = r5
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    r1 = 0
                    r2 = r1
                L_0x000d:
                    if (r0 == 0) goto L_0x0058
                    java.net.URLConnection r0 = r0.openConnection()
                    java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)
                    r2 = r0
                    java.net.URLConnection r2 = (java.net.URLConnection) r2
                    boolean r0 = r2 instanceof java.net.HttpURLConnection
                    if (r0 == 0) goto L_0x0025
                    r0 = r2
                    java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
                    r3 = 1
                    r0.setInstanceFollowRedirects(r3)
                L_0x0025:
                    java.lang.String r0 = "Prefer-Html-Meta-Tags"
                    java.lang.String r3 = "al"
                    r2.setRequestProperty(r0, r3)
                    r2.connect()
                    boolean r0 = r2 instanceof java.net.HttpURLConnection
                    if (r0 == 0) goto L_0x0056
                    r0 = r2
                    java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
                    int r3 = r0.getResponseCode()
                    r4 = 300(0x12c, float:4.2E-43)
                    if (r3 < r4) goto L_0x0056
                    int r3 = r0.getResponseCode()
                    r4 = 400(0x190, float:5.6E-43)
                    if (r3 >= r4) goto L_0x0056
                    java.net.URL r3 = new java.net.URL
                    java.lang.String r4 = "Location"
                    java.lang.String r4 = r0.getHeaderField(r4)
                    r3.<init>(r4)
                    r0.disconnect()
                    r0 = r3
                    goto L_0x000d
                L_0x0056:
                    r0 = r1
                    goto L_0x000d
                L_0x0058:
                    bolts.Capture r0 = r0     // Catch:{ all -> 0x0074 }
                    java.lang.String r3 = bolts.WebViewAppLinkResolver.readFromConnection(r2)     // Catch:{ all -> 0x0074 }
                    r0.set(r3)     // Catch:{ all -> 0x0074 }
                    bolts.Capture r0 = r1     // Catch:{ all -> 0x0074 }
                    java.lang.String r3 = r2.getContentType()     // Catch:{ all -> 0x0074 }
                    r0.set(r3)     // Catch:{ all -> 0x0074 }
                    boolean r0 = r2 instanceof java.net.HttpURLConnection
                    if (r0 == 0) goto L_0x0073
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
                    r2.disconnect()
                L_0x0073:
                    return r1
                L_0x0074:
                    r0 = move-exception
                    boolean r1 = r2 instanceof java.net.HttpURLConnection
                    if (r1 == 0) goto L_0x007e
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
                    r2.disconnect()
                L_0x007e:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: bolts.WebViewAppLinkResolver.AnonymousClass3.call():java.lang.Void");
            }
        }).onSuccessTask(new Continuation<Void, Task<JSONArray>>() {
            public Task<JSONArray> then(Task<Void> task) throws Exception {
                final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                WebView webView = new WebView(WebViewAppLinkResolver.this.context);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setNetworkAvailable(false);
                webView.setWebViewClient(new WebViewClient() {
                    private boolean loaded = false;

                    private void runJavaScript(WebView webView) {
                        if (!this.loaded) {
                            this.loaded = true;
                            webView.loadUrl(WebViewAppLinkResolver.TAG_EXTRACTION_JAVASCRIPT);
                        }
                    }

                    public void onLoadResource(WebView webView, String str) {
                        super.onLoadResource(webView, str);
                        runJavaScript(webView);
                    }

                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        runJavaScript(webView);
                    }
                });
                webView.addJavascriptInterface(new Object() {
                    @JavascriptInterface
                    public void setValue(String str) {
                        try {
                            taskCompletionSource.trySetResult(new JSONArray(str));
                        } catch (JSONException e) {
                            taskCompletionSource.trySetError(e);
                        }
                    }
                }, "boltsWebViewAppLinkResolverResult");
                webView.loadDataWithBaseURL(uri.toString(), (String) capture.get(), capture2.get() != null ? ((String) capture2.get()).split(";")[0] : null, (String) null, (String) null);
                return taskCompletionSource.getTask();
            }
        }, Task.UI_THREAD_EXECUTOR).onSuccess(new Continuation<JSONArray, AppLink>() {
            public AppLink then(Task<JSONArray> task) throws Exception {
                return WebViewAppLinkResolver.makeAppLinkFromAlData(WebViewAppLinkResolver.parseAlData(task.getResult()), uri);
            }
        });
    }
}
