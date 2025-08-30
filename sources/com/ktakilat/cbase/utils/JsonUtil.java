package com.ktakilat.cbase.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class JsonUtil {
    public static String a(Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Exception e) {
            LogUtil.a(e);
            return null;
        }
    }

    public static List b(String str, TypeToken typeToken) {
        try {
            return (List) new Gson().fromJson(str, typeToken.getType());
        } catch (Exception e) {
            LogUtil.a(e);
            return null;
        }
    }

    public static Object c(String str, Class cls) {
        try {
            return new Gson().fromJson(str, cls);
        } catch (Exception e) {
            LogUtil.a(e);
            return null;
        }
    }
}
