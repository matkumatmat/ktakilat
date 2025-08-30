package com.baidu.idl.face.platform.common;

import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.network.LogRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LogHelper {
    private static final String TAG = "LogHelper";
    private static ArrayList<Integer> logLivenessLiveness = new ArrayList<>();
    private static HashMap<String, Object> logMap = new HashMap<>();
    private static HashMap<String, Integer> logTipsMap = new HashMap<>();

    public static void addLivenessLog(int i) {
        ArrayList<Integer> arrayList = logLivenessLiveness;
        if (arrayList != null && !arrayList.contains(Integer.valueOf(i))) {
            logLivenessLiveness.add(Integer.valueOf(i));
        }
    }

    public static void addLog(String str, Object obj) {
        HashMap<String, Object> hashMap = logMap;
        if (hashMap != null) {
            hashMap.put(str, obj);
        }
    }

    public static void addLogWithKey(String str, Object obj) {
        HashMap<String, Object> hashMap = logMap;
        if (hashMap != null && !hashMap.containsKey(str)) {
            logMap.put(str, obj);
        }
    }

    public static void addTipsLogWithKey(String str) {
        HashMap<String, Integer> hashMap = logTipsMap;
        if (hashMap == null || hashMap.containsKey(str)) {
            HashMap<String, Integer> hashMap2 = logTipsMap;
            if (hashMap2 != null && hashMap2.containsKey(str)) {
                logTipsMap.put(str, Integer.valueOf(logTipsMap.get(str).intValue() + 1));
                return;
            }
            return;
        }
        logTipsMap.put(str, 1);
    }

    public static void clear() {
        logMap = new HashMap<>();
        logLivenessLiveness = new ArrayList<>();
        logTipsMap = new HashMap<>();
    }

    private static String getLog() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("{");
            int i = 0;
            for (Map.Entry next : logMap.entrySet()) {
                if (i != logMap.size() - 1) {
                    if (next.getValue() instanceof String) {
                        sb.append(((String) next.getKey()) + ":'" + next.getValue() + "'");
                    } else {
                        sb.append(((String) next.getKey()) + ":" + next.getValue());
                    }
                    sb.append(",");
                } else if (next.getValue() instanceof String) {
                    sb.append(((String) next.getKey()) + ":'" + next.getValue() + "'");
                } else {
                    sb.append(((String) next.getKey()) + ":" + next.getValue());
                }
                i++;
            }
            ArrayList<Integer> arrayList = logLivenessLiveness;
            if (arrayList != null && arrayList.size() > 0) {
                sb.append(",lv:[");
                for (int i2 = 0; i2 < logLivenessLiveness.size(); i2++) {
                    if (i2 == logLivenessLiveness.size() - 1) {
                        sb.append(logLivenessLiveness.get(i2));
                    } else {
                        sb.append(logLivenessLiveness.get(i2) + ",");
                    }
                }
                sb.append("]");
            }
            HashMap<String, Integer> hashMap = logTipsMap;
            if (hashMap != null) {
                if (hashMap.size() > 0) {
                    sb.append(",msg:{");
                    sb.append(getTipsMessage());
                    sb.append("}");
                }
            }
            sb.append("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logMap = new HashMap<>();
        logLivenessLiveness = new ArrayList<>();
        logTipsMap = new HashMap<>();
        return sb.toString();
    }

    private static String getTipsKey(String str) {
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye.name())) {
            return ConstantHelper.LOG_TIPS_LEFTEYE_OCC;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye.name())) {
            return ConstantHelper.LOG_TIPS_RIGHTEYE_OCC;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionNose.name())) {
            return ConstantHelper.LOG_TIPS_NOSE_OCC;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionMouth.name())) {
            return ConstantHelper.LOG_TIPS_MOUTH_OCC;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour.name())) {
            return ConstantHelper.LOG_TIPS_LEFTFACE_OCC;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour.name())) {
            return ConstantHelper.LOG_TIPS_RIGHTFACE_OCC;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour.name())) {
            return ConstantHelper.LOG_TIPS_CHIN_OCC;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePoorIllumination.name())) {
            return ConstantHelper.LOG_TIPS_LIGHTUP;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeImageBlured.name())) {
            return ConstantHelper.LOG_TIPS_STAYSTILL;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooFar.name())) {
            return ConstantHelper.LOG_TIPS_MOVECLOSE;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeTooClose.name())) {
            return ConstantHelper.LOG_TIPS_MOVEFURTHER;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.name())) {
            return ConstantHelper.LOG_TIPS_HEADUP;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.name())) {
            return ConstantHelper.LOG_TIPS_HEADDOWN;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.name())) {
            return ConstantHelper.LOG_TIPS_TURNLEFT;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.name())) {
            return ConstantHelper.LOG_TIPS_TURNRIGHT;
        }
        if (TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.name()) || TextUtils.equals(str, FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.name())) {
            return ConstantHelper.LOG_TIPS_MOVEFACE;
        }
        return "";
    }

    private static String getTipsMessage() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : logTipsMap.entrySet()) {
            String tipsKey = getTipsKey((String) next.getKey());
            if (!TextUtils.isEmpty(tipsKey)) {
                StringBuilder s = e.s(tipsKey, ":");
                s.append(next.getValue());
                sb.append(s.toString());
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void sendLog() {
        LogRequest.sendLogMessage(getLog());
    }
}
