package com.ktakilat.loan.webtool;

import com.google.gson.JsonObject;
import com.ktakilat.loan.webtool.CommonWebViewSetting;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CommonWebViewSetting.JsCallAndroidInterface d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Object f;

    public /* synthetic */ d(CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface, String str, JsonObject jsonObject, String str2) {
        this.c = 3;
        this.d = jsCallAndroidInterface;
        this.e = str;
        this.f = jsonObject;
    }

    /* JADX WARNING: type inference failed for: r1v71, types: [java.lang.Object, io.reactivex.functions.Consumer] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x053e  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x059f A[Catch:{ Exception -> 0x052c }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0647 A[Catch:{ Exception -> 0x0637 }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x069f A[Catch:{ Exception -> 0x0637 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = "type"
            java.lang.String r4 = "title"
            java.lang.Object r9 = r1.f
            com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface r11 = r1.d
            java.lang.String r12 = r1.e
            int r14 = r1.c
            switch(r14) {
                case 0: goto L_0x05f7;
                case 1: goto L_0x05d5;
                case 2: goto L_0x04ef;
                default: goto L_0x0011;
            }
        L_0x0011:
            r11.getClass()
            java.lang.String r14 = "witchPage"
            java.lang.String r15 = "code"
            java.lang.String r8 = "responseBody"
            java.lang.String r10 = "requestBody"
            java.lang.String r13 = "apiUrl"
            java.lang.String r6 = "requestMethod"
            java.lang.String r5 = "url"
            java.lang.String r7 = "showFailDialog"
            java.lang.String r0 = "emailTo"
            java.lang.String r3 = "emailTitle"
            java.lang.String r1 = "phone"
            r16 = r4
            java.lang.String r4 = "open"
            r17 = r14
            java.lang.String r14 = "mailto:"
            r18 = r15
            java.lang.String r15 = "tel:"
            int r19 = r12.hashCode()     // Catch:{ Exception -> 0x004f }
            switch(r19) {
                case -1879411563: goto L_0x0178;
                case -1819731633: goto L_0x016c;
                case -1218736622: goto L_0x015f;
                case -1060266576: goto L_0x0152;
                case -817905008: goto L_0x0146;
                case -800915673: goto L_0x0139;
                case -712731262: goto L_0x012d;
                case -555405913: goto L_0x0120;
                case -552636906: goto L_0x0113;
                case -525551202: goto L_0x0105;
                case -194451501: goto L_0x00f8;
                case -145604414: goto L_0x00ea;
                case -74856466: goto L_0x00dc;
                case 107332: goto L_0x00ce;
                case 2490612: goto L_0x00c0;
                case 110514339: goto L_0x00b3;
                case 296983838: goto L_0x00a5;
                case 666257082: goto L_0x0097;
                case 734550137: goto L_0x0089;
                case 852370472: goto L_0x007c;
                case 1115275854: goto L_0x006e;
                case 1367638230: goto L_0x0060;
                case 1496797948: goto L_0x0052;
                case 1565199084: goto L_0x0041;
                default: goto L_0x003d;
            }     // Catch:{ Exception -> 0x004f }
        L_0x003d:
            r19 = r8
            goto L_0x0184
        L_0x0041:
            r19 = r8
            java.lang.String r8 = "tokenExpired"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 8
            goto L_0x0185
        L_0x004f:
            r0 = move-exception
            goto L_0x04e9
        L_0x0052:
            r19 = r8
            java.lang.String r8 = "copyValue"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 21
            goto L_0x0185
        L_0x0060:
            r19 = r8
            java.lang.String r8 = "uploadLocation"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 14
            goto L_0x0185
        L_0x006e:
            r19 = r8
            java.lang.String r8 = "toCallLocation"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 10
            goto L_0x0185
        L_0x007c:
            r19 = r8
            java.lang.String r8 = "toGoogleMap"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 4
            goto L_0x0185
        L_0x0089:
            r19 = r8
            java.lang.String r8 = "recordHttp"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 11
            goto L_0x0185
        L_0x0097:
            r19 = r8
            java.lang.String r8 = "openBrowserByUrl"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 13
            goto L_0x0185
        L_0x00a5:
            r19 = r8
            java.lang.String r8 = "uploadAppList"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 17
            goto L_0x0185
        L_0x00b3:
            r19 = r8
            java.lang.String r8 = "toOcr"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 0
            goto L_0x0185
        L_0x00c0:
            r19 = r8
            java.lang.String r8 = "sendEmail"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 19
            goto L_0x0185
        L_0x00ce:
            r19 = r8
            java.lang.String r8 = "log"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 18
            goto L_0x0185
        L_0x00dc:
            r19 = r8
            java.lang.String r8 = "uploadSpecialDevice"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 15
            goto L_0x0185
        L_0x00ea:
            r19 = r8
            java.lang.String r8 = "uploadCommonDevice"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 16
            goto L_0x0185
        L_0x00f8:
            r19 = r8
            java.lang.String r8 = "tdLiveness"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 2
            goto L_0x0185
        L_0x0105:
            r19 = r8
            java.lang.String r8 = "loadAppListPkgName"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 12
            goto L_0x0185
        L_0x0113:
            r19 = r8
            java.lang.String r8 = "toPeopleIdentify"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 1
            goto L_0x0185
        L_0x0120:
            r19 = r8
            java.lang.String r8 = "toSelectPicture"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 23
            goto L_0x0185
        L_0x012d:
            r19 = r8
            java.lang.String r8 = "toCompany"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 6
            goto L_0x0185
        L_0x0139:
            r19 = r8
            java.lang.String r8 = "apiCode"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 9
            goto L_0x0185
        L_0x0146:
            r19 = r8
            java.lang.String r8 = "toContactUser"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 5
            goto L_0x0185
        L_0x0152:
            r19 = r8
            java.lang.String r8 = "callPhone"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 20
            goto L_0x0185
        L_0x015f:
            r19 = r8
            java.lang.String r8 = "listenSms"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 22
            goto L_0x0185
        L_0x016c:
            r19 = r8
            java.lang.String r8 = "toRegion"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 3
            goto L_0x0185
        L_0x0178:
            r19 = r8
            java.lang.String r8 = "toBankList"
            boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x004f }
            if (r8 == 0) goto L_0x0184
            r8 = 7
            goto L_0x0185
        L_0x0184:
            r8 = -1
        L_0x0185:
            com.ktakilat.cbase.ui.BaseActivity r12 = r11.b
            com.google.gson.JsonObject r9 = (com.google.gson.JsonObject) r9
            r20 = r10
            java.lang.String r10 = "android.intent.action.PICK"
            r21 = r13
            com.ktakilat.loan.webtool.CommonWebViewSetting r13 = com.ktakilat.loan.webtool.CommonWebViewSetting.this
            r22 = r6
            java.lang.String r6 = "content"
            r23 = r5
            java.lang.String r5 = ""
            switch(r8) {
                case 0: goto L_0x04da;
                case 1: goto L_0x04cd;
                case 2: goto L_0x04b5;
                case 3: goto L_0x0484;
                case 4: goto L_0x0465;
                case 5: goto L_0x0454;
                case 6: goto L_0x043c;
                case 7: goto L_0x042b;
                case 8: goto L_0x0424;
                case 9: goto L_0x03fc;
                case 10: goto L_0x03ed;
                case 11: goto L_0x03a5;
                case 12: goto L_0x0383;
                case 13: goto L_0x0347;
                case 14: goto L_0x031f;
                case 15: goto L_0x02ff;
                case 16: goto L_0x02fa;
                case 17: goto L_0x02d7;
                case 18: goto L_0x02d3;
                case 19: goto L_0x0272;
                case 20: goto L_0x023b;
                case 21: goto L_0x01fc;
                case 22: goto L_0x01af;
                case 23: goto L_0x019e;
                default: goto L_0x019c;
            }
        L_0x019c:
            goto L_0x04ee
        L_0x019e:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            r0.<init>(r10)     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = "image/*"
            r0.setType(r1)     // Catch:{ Exception -> 0x004f }
            r1 = 3004(0xbbc, float:4.21E-42)
            r12.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x01af:
            com.google.gson.JsonElement r0 = r9.get(r4)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x01c1
            com.google.gson.JsonElement r0 = r9.get(r4)     // Catch:{ Exception -> 0x004f }
            boolean r0 = r0.getAsBoolean()     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x01c1
            r10 = 1
            goto L_0x01c2
        L_0x01c1:
            r10 = 0
        L_0x01c2:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)     // Catch:{ Exception -> 0x004f }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x004f }
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x01e5
            com.ktakilat.cbase.ui.BaseActivity r0 = r13.d     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x04ee
            boolean r1 = r0.isDestroyed()     // Catch:{ Exception -> 0x004f }
            if (r1 != 0) goto L_0x04ee
            boolean r1 = r0.isFinishing()     // Catch:{ Exception -> 0x004f }
            if (r1 != 0) goto L_0x04ee
            boolean r1 = com.ktakilat.loan.service.sms.SmsVerificationService.e     // Catch:{ Exception -> 0x04ee }
            com.ktakilat.loan.service.sms.SmsVerificationService.Companion.a(r0)     // Catch:{ Exception -> 0x04ee }
            goto L_0x04ee
        L_0x01e5:
            com.ktakilat.cbase.ui.BaseActivity r0 = r13.d     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x04ee
            boolean r1 = r0.isDestroyed()     // Catch:{ Exception -> 0x004f }
            if (r1 != 0) goto L_0x04ee
            boolean r1 = r0.isFinishing()     // Catch:{ Exception -> 0x004f }
            if (r1 != 0) goto L_0x04ee
            boolean r1 = com.ktakilat.loan.service.sms.SmsVerificationService.e     // Catch:{ Exception -> 0x04ee }
            com.ktakilat.loan.service.sms.SmsVerificationService.Companion.b(r0)     // Catch:{ Exception -> 0x04ee }
            goto L_0x04ee
        L_0x01fc:
            com.google.gson.JsonElement r0 = r9.get(r6)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x020a
            com.google.gson.JsonElement r0 = r9.get(r6)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x020a:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x04ee
            if (r5 == 0) goto L_0x04ee
            android.os.Handler r0 = com.ktakilat.cbase.utils.KeybordUtils.f477a     // Catch:{ Exception -> 0x004f }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0235 }
            if (r0 != 0) goto L_0x04ee
            java.lang.String r0 = "clipboard"
            java.lang.Object r0 = r12.getSystemService(r0)     // Catch:{ Exception -> 0x0235 }
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0     // Catch:{ Exception -> 0x0235 }
            r1 = 0
            android.content.ClipData r1 = android.content.ClipData.newPlainText(r1, r5)     // Catch:{ Exception -> 0x0235 }
            r0.setPrimaryClip(r1)     // Catch:{ Exception -> 0x0235 }
            int r0 = com.ktakilat.cbase.R.string.copy_success     // Catch:{ Exception -> 0x0235 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x0235 }
            com.ktakilat.cbase.utils.ToastUtil.d(r12, r0)     // Catch:{ Exception -> 0x0235 }
            goto L_0x04ee
        L_0x0235:
            r0 = move-exception
            com.ktakilat.cbase.utils.LogUtil.a(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x023b:
            com.google.gson.JsonElement r0 = r9.get(r1)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x0249
            com.google.gson.JsonElement r0 = r9.get(r1)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x0249:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x04ee
            if (r12 != 0) goto L_0x0253
            goto L_0x04ee
        L_0x0253:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = "android.intent.action.DIAL"
            r0.<init>(r1)     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r1.<init>(r15)     // Catch:{ Exception -> 0x004f }
            r1.append(r5)     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004f }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x004f }
            r0.setData(r1)     // Catch:{ Exception -> 0x004f }
            r12.startActivity(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0272:
            com.google.gson.JsonElement r1 = r9.get(r6)     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x0281
            com.google.gson.JsonElement r1 = r9.get(r6)     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x004f }
            goto L_0x0282
        L_0x0281:
            r1 = r5
        L_0x0282:
            com.google.gson.JsonElement r2 = r9.get(r3)     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x0291
            com.google.gson.JsonElement r2 = r9.get(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = r2.getAsString()     // Catch:{ Exception -> 0x004f }
            goto L_0x0292
        L_0x0291:
            r2 = r5
        L_0x0292:
            com.google.gson.JsonElement r3 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            if (r3 == 0) goto L_0x02a0
            com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x02a0:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x04ee
            if (r12 != 0) goto L_0x02aa
            goto L_0x04ee
        L_0x02aa:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = "android.intent.action.SENDTO"
            r0.<init>(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r3.<init>(r14)     // Catch:{ Exception -> 0x004f }
            r3.append(r5)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004f }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x004f }
            r0.setData(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = "android.intent.extra.SUBJECT"
            r0.putExtra(r3, r2)     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = "android.intent.extra.TEXT"
            r0.putExtra(r2, r1)     // Catch:{ Exception -> 0x004f }
            r12.startActivity(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x02d3:
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x02d7:
            lb r0 = new lb     // Catch:{ Exception -> 0x004f }
            r1 = 11
            r0.<init>(r12, r1)     // Catch:{ Exception -> 0x004f }
            io.reactivex.Observable r0 = io.reactivex.Observable.create(r0)     // Catch:{ Exception -> 0x004f }
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.c     // Catch:{ Exception -> 0x004f }
            io.reactivex.Observable r0 = r0.subscribeOn(r1)     // Catch:{ Exception -> 0x004f }
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.a()     // Catch:{ Exception -> 0x004f }
            io.reactivex.Observable r0 = r0.observeOn(r1)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.weiget.j r1 = new com.ktakilat.loan.weiget.j     // Catch:{ Exception -> 0x004f }
            r1.<init>()     // Catch:{ Exception -> 0x004f }
            r0.subscribe(r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x02fa:
            com.ktakilat.loan.weiget.PhoneUploadUtil.e()     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x02ff:
            r1 = 0
            com.ktakilat.loan.weiget.PhoneUploadUtil.g(r12)     // Catch:{ Exception -> 0x004f }
            com.google.gson.JsonElement r0 = r9.get(r2)     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x0310
            com.ktakilat.loan.weiget.TongDunEnum r0 = com.ktakilat.loan.weiget.TongDunEnum.APPLY_LOAN     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.weiget.PhoneUploadUtil.a(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0310:
            java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = com.trustdecision.mobrisk.TDRisk.getBlackBox()     // Catch:{ all -> 0x0319 }
            goto L_0x031a
        L_0x0319:
            r3 = r1
        L_0x031a:
            com.ktakilat.loan.weiget.PhoneUploadUtil.i(r3, r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x031f:
            java.lang.String r0 = com.ktakilat.loan.device.DeviceUtil.d(r12)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.cbase.cache.KvSave r1 = com.ktakilat.loan.global.AppKv.g()     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = "mac_address"
            r1.b(r2, r0)     // Catch:{ Exception -> 0x004f }
            com.google.gson.JsonElement r0 = r9.get(r7)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x033b
            com.google.gson.JsonElement r0 = r9.get(r7)     // Catch:{ Exception -> 0x004f }
            boolean r10 = r0.getAsBoolean()     // Catch:{ Exception -> 0x004f }
            goto L_0x033c
        L_0x033b:
            r10 = 0
        L_0x033c:
            com.ktakilat.loan.webtool.e r0 = new com.ktakilat.loan.webtool.e     // Catch:{ Exception -> 0x004f }
            r1 = 4
            r0.<init>(r11, r1)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.weiget.GpsUtil.a(r12, r0, r10)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0347:
            r0 = r23
            com.google.gson.JsonElement r1 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x0357
            com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x0357:
            if (r12 == 0) goto L_0x04ee
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x04ee
            java.lang.String r0 = "http"
            boolean r0 = r5.startsWith(r0)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x04ee
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x037d }
            r0.<init>()     // Catch:{ Exception -> 0x037d }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.setAction(r1)     // Catch:{ Exception -> 0x037d }
            android.net.Uri r1 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x037d }
            r0.setData(r1)     // Catch:{ Exception -> 0x037d }
            r12.startActivity(r0)     // Catch:{ Exception -> 0x037d }
            goto L_0x04ee
        L_0x037d:
            r0 = move-exception
            com.ktakilat.cbase.utils.LogUtil.a(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0383:
            com.ktakilat.loan.webtool.e r0 = new com.ktakilat.loan.webtool.e     // Catch:{ Exception -> 0x004f }
            r1 = 3
            r0.<init>(r11, r1)     // Catch:{ Exception -> 0x004f }
            io.reactivex.Observable r0 = io.reactivex.Observable.create(r0)     // Catch:{ Exception -> 0x004f }
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.c     // Catch:{ Exception -> 0x004f }
            io.reactivex.Observable r0 = r0.subscribeOn(r1)     // Catch:{ Exception -> 0x004f }
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.a()     // Catch:{ Exception -> 0x004f }
            io.reactivex.Observable r0 = r0.observeOn(r1)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$9 r1 = new com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$9     // Catch:{ Exception -> 0x004f }
            r1.<init>()     // Catch:{ Exception -> 0x004f }
            r0.subscribe(r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x03a5:
            r0 = r22
            com.google.gson.JsonElement r1 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x03b4
            com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x03b4:
            r0 = r21
            com.google.gson.JsonElement r1 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x03c3
            com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x03c3:
            r0 = r20
            com.google.gson.JsonElement r1 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            if (r1 == 0) goto L_0x03d6
            com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x03d3:
            r1 = r19
            goto L_0x03d9
        L_0x03d6:
            java.lang.String r0 = "null"
            goto L_0x03d3
        L_0x03d9:
            com.google.gson.JsonElement r2 = r9.get(r1)     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x03e6
            com.google.gson.JsonElement r1 = r9.get(r1)     // Catch:{ Exception -> 0x004f }
            r1.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x03e6:
            r0.getClass()     // Catch:{ Exception -> 0x004f }
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x03ed:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.webtool.e r0 = new com.ktakilat.loan.webtool.e     // Catch:{ Exception -> 0x004f }
            r1 = 2
            r0.<init>(r11, r1)     // Catch:{ Exception -> 0x004f }
            r1 = 1
            com.ktakilat.loan.weiget.GpsUtil.a(r12, r0, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x03fc:
            com.ktakilat.cbase.http.BaseResponse r0 = new com.ktakilat.cbase.http.BaseResponse     // Catch:{ Exception -> 0x004f }
            r0.<init>()     // Catch:{ Exception -> 0x004f }
            r1 = r18
            com.google.gson.JsonElement r2 = r9.get(r1)     // Catch:{ Exception -> 0x004f }
            if (r2 != 0) goto L_0x040a
            goto L_0x0412
        L_0x040a:
            com.google.gson.JsonElement r1 = r9.get(r1)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r1.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x0412:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x004f }
            if (r1 != 0) goto L_0x04ee
            r0.setCode(r5)     // Catch:{ Exception -> 0x004f }
            r1 = 0
            r0.setSuccess(r1)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.cbase.http.ResponseCodeDeal.a(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0424:
            com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004f }
            r0.i()     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x042b:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            java.lang.Class<com.ktakilat.loan.banks.BanksActivity> r0 = com.ktakilat.loan.banks.BanksActivity.class
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            r1.<init>(r12, r0)     // Catch:{ Exception -> 0x004f }
            r0 = 7000(0x1b58, float:9.809E-42)
            r12.startActivityForResult(r1, r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x043c:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            int r0 = com.ktakilat.loan.normal_ui.SearchAddressActivity.t     // Catch:{ Exception -> 0x004f }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            java.lang.Class<com.ktakilat.loan.normal_ui.SearchAddressActivity> r1 = com.ktakilat.loan.normal_ui.SearchAddressActivity.class
            r0.<init>(r12, r1)     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = "input"
            r0.putExtra(r1, r5)     // Catch:{ Exception -> 0x004f }
            r1 = 5001(0x1389, float:7.008E-42)
            r12.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0454:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            android.net.Uri r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch:{ Exception -> 0x004f }
            r0.<init>(r10, r1)     // Catch:{ Exception -> 0x004f }
            r1 = 6000(0x1770, float:8.408E-42)
            r12.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0465:
            r0 = r17
            com.google.gson.JsonElement r1 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            if (r1 != 0) goto L_0x046f
            r8 = -1
            goto L_0x0477
        L_0x046f:
            com.google.gson.JsonElement r0 = r9.get(r0)     // Catch:{ Exception -> 0x004f }
            int r8 = r0.getAsInt()     // Catch:{ Exception -> 0x004f }
        L_0x0477:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            x2 r0 = new x2     // Catch:{ Exception -> 0x004f }
            r1 = 1
            r0.<init>(r1)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.normal_ui.GoogleMapActivity.C(r8, r0, r12)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x0484:
            r3 = r16
            r1 = 0
            com.google.gson.JsonElement r0 = r9.get(r3)     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x048f
            r3 = r1
            goto L_0x0497
        L_0x048f:
            com.google.gson.JsonElement r0 = r9.get(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = r0.getAsString()     // Catch:{ Exception -> 0x004f }
        L_0x0497:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            int r0 = com.ktakilat.loan.widgets.CityPickerActivity.g     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)     // Catch:{ Exception -> 0x004f }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            java.lang.Class<com.ktakilat.loan.widgets.CityPickerActivity> r1 = com.ktakilat.loan.widgets.CityPickerActivity.class
            r0.<init>(r12, r1)     // Catch:{ Exception -> 0x004f }
            if (r3 == 0) goto L_0x04af
            java.lang.String r1 = "TITLE"
            r0.putExtra(r1, r3)     // Catch:{ Exception -> 0x004f }
        L_0x04af:
            r1 = 5000(0x1388, float:7.006E-42)
            r12.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x04b5:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            int r0 = com.ktakilat.loan.normal_ui.TDLivenessGuideActivity.d     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = "act"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)     // Catch:{ Exception -> 0x004f }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004f }
            java.lang.Class<com.ktakilat.loan.normal_ui.TDLivenessGuideActivity> r1 = com.ktakilat.loan.normal_ui.TDLivenessGuideActivity.class
            r0.<init>(r12, r1)     // Catch:{ Exception -> 0x004f }
            r1 = 11451400(0xaebc08, float:1.6046829E-38)
            r12.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x04cd:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.webtool.e r0 = new com.ktakilat.loan.webtool.e     // Catch:{ Exception -> 0x004f }
            r1 = 1
            r0.<init>(r11, r1)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.weiget.CameraPhotoUtil.b(r12, r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x04da:
            com.ktakilat.cbase.utils.KeybordUtils.a(r12)     // Catch:{ Exception -> 0x004f }
            java.io.File r0 = r13.f574a     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.webtool.e r1 = new com.ktakilat.loan.webtool.e     // Catch:{ Exception -> 0x004f }
            r4 = 0
            r1.<init>(r11, r4)     // Catch:{ Exception -> 0x004f }
            com.ktakilat.loan.weiget.CameraPhotoUtil.a(r12, r0, r1)     // Catch:{ Exception -> 0x004f }
            goto L_0x04ee
        L_0x04e9:
            r0.toString()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x04ee:
            return
        L_0x04ef:
            r3 = r4
            r1 = 0
            r4 = 0
            java.lang.String r9 = (java.lang.String) r9
            r11.getClass()
            java.lang.String r5 = "cancelStr"
            com.google.gson.JsonObject r6 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x052c }
            r6.<init>()     // Catch:{ Exception -> 0x052c }
            com.ktakilat.loan.webtool.CommonWebViewSetting r0 = com.ktakilat.loan.webtool.CommonWebViewSetting.this     // Catch:{ Exception -> 0x050f }
            boolean r0 = com.ktakilat.loan.webtool.CommonWebViewSetting.a(r0, r12)     // Catch:{ Exception -> 0x050f }
            if (r0 == 0) goto L_0x0513
            com.google.gson.JsonElement r0 = com.google.gson.JsonParser.parseString(r12)     // Catch:{ Exception -> 0x050f }
            com.google.gson.JsonObject r6 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x050f }
            goto L_0x0513
        L_0x050f:
            r0 = move-exception
            com.ktakilat.cbase.utils.LogUtil.a(r0)     // Catch:{ Exception -> 0x052c }
        L_0x0513:
            int r0 = r9.hashCode()     // Catch:{ Exception -> 0x052c }
            r7 = 1121770310(0x42dcdb46, float:110.42827)
            if (r0 == r7) goto L_0x052f
            r7 = 1190842281(0x46facfa9, float:32103.83)
            if (r0 == r7) goto L_0x0522
            goto L_0x0539
        L_0x0522:
            java.lang.String r0 = "showSingleSelectDialog"
            boolean r0 = r9.equals(r0)     // Catch:{ Exception -> 0x052c }
            if (r0 == 0) goto L_0x0539
            r8 = 1
            goto L_0x053a
        L_0x052c:
            r0 = move-exception
            goto L_0x05cf
        L_0x052f:
            java.lang.String r0 = "showTipDialog"
            boolean r0 = r9.equals(r0)     // Catch:{ Exception -> 0x052c }
            if (r0 == 0) goto L_0x0539
            r8 = 0
            goto L_0x053a
        L_0x0539:
            r8 = -1
        L_0x053a:
            com.ktakilat.cbase.ui.BaseActivity r0 = r11.b
            if (r8 == 0) goto L_0x059f
            r7 = 1
            if (r8 == r7) goto L_0x0543
            goto L_0x05d4
        L_0x0543:
            com.google.gson.JsonElement r7 = r6.get(r3)     // Catch:{ Exception -> 0x052c }
            if (r7 != 0) goto L_0x054b
            r3 = r1
            goto L_0x0553
        L_0x054b:
            com.google.gson.JsonElement r3 = r6.get(r3)     // Catch:{ Exception -> 0x052c }
            java.lang.String r3 = r3.getAsString()     // Catch:{ Exception -> 0x052c }
        L_0x0553:
            com.google.gson.JsonElement r7 = r6.get(r5)     // Catch:{ Exception -> 0x052c }
            if (r7 != 0) goto L_0x055b
            r5 = r1
            goto L_0x0563
        L_0x055b:
            com.google.gson.JsonElement r5 = r6.get(r5)     // Catch:{ Exception -> 0x052c }
            java.lang.String r5 = r5.getAsString()     // Catch:{ Exception -> 0x052c }
        L_0x0563:
            com.google.gson.JsonElement r7 = r6.get(r2)     // Catch:{ Exception -> 0x052c }
            if (r7 != 0) goto L_0x056a
            goto L_0x0572
        L_0x056a:
            com.google.gson.JsonElement r1 = r6.get(r2)     // Catch:{ Exception -> 0x052c }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x052c }
        L_0x0572:
            java.lang.String r2 = "items"
            com.google.gson.JsonElement r2 = r6.get(r2)     // Catch:{ Exception -> 0x052c }
            com.google.gson.JsonArray r2 = r2.getAsJsonArray()     // Catch:{ Exception -> 0x052c }
            int r6 = r2.size()     // Catch:{ Exception -> 0x052c }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x052c }
            r10 = 0
        L_0x0583:
            int r4 = r2.size()     // Catch:{ Exception -> 0x052c }
            if (r10 >= r4) goto L_0x0596
            com.google.gson.JsonElement r4 = r2.get(r10)     // Catch:{ Exception -> 0x052c }
            java.lang.String r4 = r4.getAsString()     // Catch:{ Exception -> 0x052c }
            r6[r10] = r4     // Catch:{ Exception -> 0x052c }
            r4 = 1
            int r10 = r10 + r4
            goto L_0x0583
        L_0x0596:
            com.ktakilat.loan.webtool.f r2 = new com.ktakilat.loan.webtool.f     // Catch:{ Exception -> 0x052c }
            r2.<init>(r11, r1)     // Catch:{ Exception -> 0x052c }
            com.ktakilat.loan.weiget.dialog.DialogUtils.j(r0, r3, r6, r5, r2)     // Catch:{ Exception -> 0x052c }
            goto L_0x05d4
        L_0x059f:
            com.google.gson.JsonElement r2 = r6.get(r3)     // Catch:{ Exception -> 0x052c }
            if (r2 != 0) goto L_0x05a7
            r3 = r1
            goto L_0x05af
        L_0x05a7:
            com.google.gson.JsonElement r1 = r6.get(r3)     // Catch:{ Exception -> 0x052c }
            java.lang.String r3 = r1.getAsString()     // Catch:{ Exception -> 0x052c }
        L_0x05af:
            java.lang.String r1 = "descript"
            com.google.gson.JsonElement r1 = r6.get(r1)     // Catch:{ Exception -> 0x052c }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x052c }
            com.ktakilat.cbase.weight.DanaDialog r2 = new com.ktakilat.cbase.weight.DanaDialog     // Catch:{ Exception -> 0x052c }
            r2.<init>(r0)     // Catch:{ Exception -> 0x052c }
            r2.l = r3     // Catch:{ Exception -> 0x052c }
            r2.k = r1     // Catch:{ Exception -> 0x052c }
            r1 = 2131755408(0x7f100190, float:1.9141694E38)
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x052c }
            r2.n = r0     // Catch:{ Exception -> 0x052c }
            r2.show()     // Catch:{ Exception -> 0x052c }
            goto L_0x05d4
        L_0x05cf:
            r0.toString()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x05d4:
            return
        L_0x05d5:
            r11.getClass()
            java.lang.String r0 = "0"
            com.ktakilat.cbase.datacollect.KtaCollect.n_request_permission(r12, r0)
            com.tbruyelle.rxpermissions2.RxPermissions r0 = new com.tbruyelle.rxpermissions2.RxPermissions
            com.ktakilat.cbase.ui.BaseActivity r1 = r11.b
            r0.<init>(r1)
            java.lang.String[] r1 = new java.lang.String[]{r12}
            io.reactivex.Observable r0 = r0.b(r1)
            com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$1 r1 = new com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$1
            java.lang.String r9 = (java.lang.String) r9
            r1.<init>(r12, r9)
            r0.subscribe(r1)
            return
        L_0x05f7:
            r4 = 0
            java.lang.String r9 = (java.lang.String) r9
            r11.getClass()
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x0637 }
            r1.<init>()     // Catch:{ Exception -> 0x0637 }
            com.ktakilat.loan.webtool.CommonWebViewSetting r0 = com.ktakilat.loan.webtool.CommonWebViewSetting.this     // Catch:{ Exception -> 0x0613 }
            boolean r0 = com.ktakilat.loan.webtool.CommonWebViewSetting.a(r0, r12)     // Catch:{ Exception -> 0x0613 }
            if (r0 == 0) goto L_0x0617
            com.google.gson.JsonElement r0 = com.google.gson.JsonParser.parseString(r12)     // Catch:{ Exception -> 0x0613 }
            com.google.gson.JsonObject r1 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x0613 }
            goto L_0x0617
        L_0x0613:
            r0 = move-exception
            com.ktakilat.cbase.utils.LogUtil.a(r0)     // Catch:{ Exception -> 0x0637 }
        L_0x0617:
            com.ktakilat.loan.weiget.ShareUtil r0 = new com.ktakilat.loan.weiget.ShareUtil     // Catch:{ Exception -> 0x0637 }
            com.ktakilat.cbase.ui.BaseActivity r2 = r11.b     // Catch:{ Exception -> 0x0637 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0637 }
            int r2 = r9.hashCode()     // Catch:{ Exception -> 0x0637 }
            r3 = -375745017(0xffffffffe99a9607, float:-2.3360383E25)
            if (r2 == r3) goto L_0x063a
            r3 = 320732196(0x131dfc24, float:1.99405E-27)
            if (r2 == r3) goto L_0x062d
            goto L_0x0644
        L_0x062d:
            java.lang.String r2 = "shareChannel"
            boolean r2 = r9.equals(r2)     // Catch:{ Exception -> 0x0637 }
            if (r2 == 0) goto L_0x0644
            r2 = 1
            goto L_0x0645
        L_0x0637:
            r0 = move-exception
            goto L_0x06a3
        L_0x063a:
            java.lang.String r2 = "shareDialog"
            boolean r2 = r9.equals(r2)     // Catch:{ Exception -> 0x0637 }
            if (r2 == 0) goto L_0x0644
            r2 = 0
            goto L_0x0645
        L_0x0644:
            r2 = -1
        L_0x0645:
            if (r2 == 0) goto L_0x069f
            r3 = 1
            if (r2 == r3) goto L_0x064b
            goto L_0x06a8
        L_0x064b:
            java.lang.String r2 = "channel"
            com.google.gson.JsonElement r1 = r1.get(r2)     // Catch:{ Exception -> 0x0637 }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x0637 }
            int r2 = r1.hashCode()     // Catch:{ Exception -> 0x0637 }
            switch(r2) {
                case 3321844: goto L_0x067e;
                case 28903346: goto L_0x0673;
                case 497130182: goto L_0x0668;
                case 1934780818: goto L_0x065d;
                default: goto L_0x065c;
            }     // Catch:{ Exception -> 0x0637 }
        L_0x065c:
            goto L_0x0689
        L_0x065d:
            java.lang.String r2 = "whatsapp"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0637 }
            if (r1 == 0) goto L_0x0689
            r1 = 2
            r8 = 3
            goto L_0x068b
        L_0x0668:
            java.lang.String r2 = "facebook"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0637 }
            if (r1 == 0) goto L_0x0689
            r1 = 2
            r8 = 0
            goto L_0x068b
        L_0x0673:
            java.lang.String r2 = "instagram"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0637 }
            if (r1 == 0) goto L_0x0689
            r1 = 2
            r8 = 2
            goto L_0x068b
        L_0x067e:
            java.lang.String r2 = "line"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0637 }
            if (r1 == 0) goto L_0x0689
            r1 = 2
            r8 = 4
            goto L_0x068b
        L_0x0689:
            r1 = 2
            r8 = -1
        L_0x068b:
            if (r8 == r1) goto L_0x06a8
            r1 = 3
            if (r8 == r1) goto L_0x069b
            r1 = 4
            if (r8 == r1) goto L_0x0697
            r0.a()     // Catch:{ Exception -> 0x0637 }
            goto L_0x06a8
        L_0x0697:
            r0.b()     // Catch:{ Exception -> 0x0637 }
            goto L_0x06a8
        L_0x069b:
            r0.c()     // Catch:{ Exception -> 0x0637 }
            goto L_0x06a8
        L_0x069f:
            r0.d()     // Catch:{ Exception -> 0x0637 }
            goto L_0x06a8
        L_0x06a3:
            r0.toString()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x06a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.webtool.d.run():void");
    }

    public /* synthetic */ d(CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface, String str, String str2, int i) {
        this.c = i;
        this.d = jsCallAndroidInterface;
        this.e = str;
        this.f = str2;
    }
}
