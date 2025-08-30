package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;

abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private String getError(Bundle bundle) {
        String string = bundle.getString("error");
        if (string == null) {
            return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
        }
        return string;
    }

    private String getErrorMessage(Bundle bundle) {
        String string = bundle.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
        if (string == null) {
            return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        }
        return string;
    }

    private LoginClient.Result handleResultCancel(LoginClient.Request request, Intent intent) {
        String str;
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        if (extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null) {
            str = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString();
        } else {
            str = null;
        }
        if (ServerProtocol.errorConnectionFailure.equals(str)) {
            return LoginClient.Result.createErrorResult(request, error, getErrorMessage(extras), str);
        }
        return LoginClient.Result.createCancelResult(request, error);
    }

    private LoginClient.Result handleResultOk(LoginClient.Request request, Intent intent) {
        String str;
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        if (extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null) {
            str = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString();
        } else {
            str = null;
        }
        String errorMessage = getErrorMessage(extras);
        String string = extras.getString("e2e");
        if (!Utility.isNullOrEmpty(string)) {
            logWebLoginCompleted(string);
        }
        if (error == null && str == null && errorMessage == null) {
            try {
                return LoginClient.Result.createTokenResult(request, LoginMethodHandler.createAccessTokenFromWebBundle(request.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.getApplicationId()));
            } catch (FacebookException e) {
                return LoginClient.Result.createErrorResult(request, (String) null, e.getMessage());
            }
        } else if (ServerProtocol.errorsProxyAuthDisabled.contains(error)) {
            return null;
        } else {
            if (ServerProtocol.errorsUserCanceled.contains(error)) {
                return LoginClient.Result.createCancelResult(request, (String) null);
            }
            return LoginClient.Result.createErrorResult(request, error, errorMessage, str);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        LoginClient.Result result;
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (intent == null) {
            result = LoginClient.Result.createCancelResult(pendingRequest, "Operation canceled");
        } else if (i2 == 0) {
            result = handleResultCancel(pendingRequest, intent);
        } else if (i2 != -1) {
            result = LoginClient.Result.createErrorResult(pendingRequest, "Unexpected resultCode from authorization.", (String) null);
        } else {
            result = handleResultOk(pendingRequest, intent);
        }
        if (result != null) {
            this.loginClient.completeAndValidate(result);
            return true;
        }
        this.loginClient.tryNextHandler();
        return true;
    }

    public abstract boolean tryAuthorize(LoginClient.Request request);

    public boolean tryIntent(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.loginClient.getFragment().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
