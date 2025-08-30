package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;

final class zznn {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zznl zznl, String str) {
        StringBuilder s = e.s("# ", str);
        zzc(zznl, s, 0);
        return s.toString();
    }

    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            zzd(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                zzlg zzlg = zzlg.zzb;
                sb.append(zzof.zza(new zzlf(((String) obj).getBytes(zzmo.zza))));
                sb.append('\"');
            } else if (obj instanceof zzlg) {
                sb.append(": \"");
                sb.append(zzof.zza((zzlg) obj));
                sb.append('\"');
            } else if (obj instanceof zzme) {
                sb.append(" {");
                zzc((zzme) obj, sb, i + 2);
                sb.append(StringUtils.LF);
                zzd(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                zzb(sb, i3, "key", entry.getKey());
                zzb(sb, i3, "value", entry.getValue());
                sb.append(StringUtils.LF);
                zzd(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(zznl zznl, StringBuilder sb, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zznl zznl2 = zznl;
        StringBuilder sb2 = sb;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zznl.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 4), zzme.zzcr(method2, zznl2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 3), zzme.zzcr(method, zznl2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzcr = zzme.zzcr(method4, zznl2, new Object[0]);
                    if (method5 == null) {
                        if (zzcr instanceof Boolean) {
                            if (!((Boolean) zzcr).booleanValue()) {
                            }
                        } else if (zzcr instanceof Integer) {
                            if (((Integer) zzcr).intValue() == 0) {
                            }
                        } else if (zzcr instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzcr).floatValue()) == 0) {
                            }
                        } else if (!(zzcr instanceof Double)) {
                            if (zzcr instanceof String) {
                                z = zzcr.equals("");
                            } else if (zzcr instanceof zzlg) {
                                z = zzcr.equals(zzlg.zzb);
                            } else if (zzcr instanceof zznl) {
                                if (zzcr == ((zznl) zzcr).zzcE()) {
                                }
                            } else if ((zzcr instanceof Enum) && ((Enum) zzcr).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzcr).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzme.zzcr(method5, zznl2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i3, substring, zzcr);
                }
            }
            i2 = 3;
        }
        if (zznl2 instanceof zzmb) {
            Iterator zzc = ((zzmb) zznl2).zzb.zzc();
            if (zzc.hasNext()) {
                zzmc zzmc = (zzmc) ((Map.Entry) zzc.next()).getKey();
                throw null;
            }
        }
        zzoi zzoi = ((zzme) zznl2).zzc;
        if (zzoi != null) {
            zzoi.zzj(sb2, i3);
        }
    }

    private static void zzd(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }
}
