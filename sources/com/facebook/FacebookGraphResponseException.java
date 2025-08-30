package com.facebook;

import org.apache.commons.lang3.StringUtils;

public class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse2, String str) {
        super(str);
        this.graphResponse = graphResponse2;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    public final String toString() {
        FacebookRequestError facebookRequestError;
        GraphResponse graphResponse2 = this.graphResponse;
        if (graphResponse2 != null) {
            facebookRequestError = graphResponse2.getError();
        } else {
            facebookRequestError = null;
        }
        StringBuilder sb = new StringBuilder("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(StringUtils.SPACE);
        }
        if (facebookRequestError != null) {
            sb.append("httpResponseCode: ");
            sb.append(facebookRequestError.getRequestStatusCode());
            sb.append(", facebookErrorCode: ");
            sb.append(facebookRequestError.getErrorCode());
            sb.append(", facebookErrorType: ");
            sb.append(facebookRequestError.getErrorType());
            sb.append(", message: ");
            sb.append(facebookRequestError.getErrorMessage());
            sb.append("}");
        }
        return sb.toString();
    }
}
