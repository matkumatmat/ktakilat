package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphResponse {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final JSONObject graphObject;
    private final JSONArray graphObjectArray;
    private final String rawResponse;
    private final GraphRequest request;

    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, (JSONArray) null, (FacebookRequestError) null);
    }

    public static List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new GraphResponse(list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) facebookException)));
        }
        return arrayList;
    }

    private static GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError checkResponseAndCreateError = FacebookRequestError.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
            if (checkResponseAndCreateError != null) {
                if (checkResponseAndCreateError.getErrorCode() == 190 && Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                    AccessToken.setCurrentAccessToken((AccessToken) null);
                }
                return new GraphResponse(graphRequest, httpURLConnection, checkResponseAndCreateError);
            }
            Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, NON_JSON_RESPONSE_PROPERTY);
            if (stringPropertyAsJSON instanceof JSONObject) {
                return new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONObject) stringPropertyAsJSON);
            }
            if (stringPropertyAsJSON instanceof JSONArray) {
                return new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONArray) stringPropertyAsJSON);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
        }
        throw new FacebookException("Got unexpected object type in response, class: ".concat(obj.getClass().getSimpleName()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.facebook.GraphResponse> createResponsesFromObject(java.net.HttpURLConnection r7, java.util.List<com.facebook.GraphRequest> r8, java.lang.Object r9) throws com.facebook.FacebookException, org.json.JSONException {
        /*
            int r0 = r8.size()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 1
            r3 = 0
            if (r0 != r2) goto L_0x0053
            java.lang.Object r2 = r8.get(r3)
            com.facebook.GraphRequest r2 = (com.facebook.GraphRequest) r2
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            r4.<init>()     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            java.lang.String r5 = "body"
            r4.put(r5, r9)     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            if (r7 == 0) goto L_0x0028
            int r5 = r7.getResponseCode()     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            goto L_0x002a
        L_0x0024:
            r4 = move-exception
            goto L_0x0038
        L_0x0026:
            r4 = move-exception
            goto L_0x0046
        L_0x0028:
            r5 = 200(0xc8, float:2.8E-43)
        L_0x002a:
            java.lang.String r6 = "code"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            r5.<init>()     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            r5.put(r4)     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
            goto L_0x0054
        L_0x0038:
            com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>((java.net.HttpURLConnection) r7, (java.lang.Exception) r4)
            r5.<init>(r2, r7, r6)
            r1.add(r5)
            goto L_0x0053
        L_0x0046:
            com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>((java.net.HttpURLConnection) r7, (java.lang.Exception) r4)
            r5.<init>(r2, r7, r6)
            r1.add(r5)
        L_0x0053:
            r5 = r9
        L_0x0054:
            boolean r2 = r5 instanceof org.json.JSONArray
            if (r2 == 0) goto L_0x009b
            org.json.JSONArray r5 = (org.json.JSONArray) r5
            int r2 = r5.length()
            if (r2 != r0) goto L_0x009b
        L_0x0060:
            int r0 = r5.length()
            if (r3 >= r0) goto L_0x009a
            java.lang.Object r0 = r8.get(r3)
            com.facebook.GraphRequest r0 = (com.facebook.GraphRequest) r0
            java.lang.Object r2 = r5.get(r3)     // Catch:{ JSONException -> 0x007a, FacebookException -> 0x0078 }
            com.facebook.GraphResponse r2 = createResponseFromObject(r0, r7, r2, r9)     // Catch:{ JSONException -> 0x007a, FacebookException -> 0x0078 }
            r1.add(r2)     // Catch:{ JSONException -> 0x007a, FacebookException -> 0x0078 }
            goto L_0x0097
        L_0x0078:
            r2 = move-exception
            goto L_0x007c
        L_0x007a:
            r2 = move-exception
            goto L_0x008a
        L_0x007c:
            com.facebook.GraphResponse r4 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>((java.net.HttpURLConnection) r7, (java.lang.Exception) r2)
            r4.<init>(r0, r7, r6)
            r1.add(r4)
            goto L_0x0097
        L_0x008a:
            com.facebook.GraphResponse r4 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
            r6.<init>((java.net.HttpURLConnection) r7, (java.lang.Exception) r2)
            r4.<init>(r0, r7, r6)
            r1.add(r4)
        L_0x0097:
            int r3 = r3 + 1
            goto L_0x0060
        L_0x009a:
            return r1
        L_0x009b:
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r8 = "Unexpected number of results"
            r7.<init>((java.lang.String) r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.createResponsesFromObject(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
    }

    public static List<GraphResponse> createResponsesFromStream(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        String readStreamToString = Utility.readStreamToString(inputStream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
        return createResponsesFromString(readStreamToString, httpURLConnection, graphRequestBatch);
    }

    public static List<GraphResponse> createResponsesFromString(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        List<GraphResponse> createResponsesFromObject = createResponsesFromObject(httpURLConnection, graphRequestBatch, new JSONTokener(str).nextValue());
        Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject);
        return createResponsesFromObject;
    }

    public static List<GraphResponse> fromHttpConnection(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        InputStream inputStream;
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            List<GraphResponse> createResponsesFromStream = createResponsesFromStream(inputStream, httpURLConnection, graphRequestBatch);
            Utility.closeQuietly(inputStream);
            return createResponsesFromStream;
        } catch (FacebookException e) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e);
            List<GraphResponse> constructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, e);
            Utility.closeQuietly((Closeable) null);
            return constructErrorResponses;
        } catch (Exception e2) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e2);
            List<GraphResponse> constructErrorResponses2 = constructErrorResponses(graphRequestBatch, httpURLConnection, new FacebookException((Throwable) e2));
            Utility.closeQuietly((Closeable) null);
            return constructErrorResponses2;
        } catch (Throwable th) {
            Utility.closeQuietly((Closeable) null);
            throw th;
        }
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    public GraphRequest getRequest() {
        return this.request;
    }

    public GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String str;
        JSONObject optJSONObject;
        JSONObject jSONObject = this.graphObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("paging")) == null) {
            str = null;
        } else if (pagingDirection == PagingDirection.NEXT) {
            str = optJSONObject.optString("next");
        } else {
            str = optJSONObject.optString("previous");
        }
        if (Utility.isNullOrEmpty(str)) {
            return null;
        }
        if (str != null && str.equals(this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            return new GraphRequest(this.request.getAccessToken(), new URL(str));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String toString() {
        String str;
        int i;
        try {
            Locale locale = Locale.US;
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection != null) {
                i = httpURLConnection.getResponseCode();
            } else {
                i = 200;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            str = sb.toString();
        } catch (IOException unused) {
            str = "unknown";
        }
        StringBuilder t = e.t("{Response:  responseCode: ", str, ", graphObject: ");
        t.append(this.graphObject);
        t.append(", error: ");
        t.append(this.error);
        t.append("}");
        return t.toString();
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, (JSONObject) null, jSONArray, (FacebookRequestError) null);
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, (String) null, (JSONObject) null, (JSONArray) null, facebookRequestError);
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.request = graphRequest;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
    }
}
