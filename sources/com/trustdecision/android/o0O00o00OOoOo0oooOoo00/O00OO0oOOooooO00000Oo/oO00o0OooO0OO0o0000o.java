package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.location.Location;
import android.location.LocationManager;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.File;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONObject;

public class oO00o0OooO0OO0o0000o {
    public static final List O0oOO0ooO;
    public Class[] O00OO0oOOooooO00000Oo;
    private Map o00ooooooO00OO0O00 = new HashMap();
    public String o0O00o00OOoOo0oooOoo00;
    public int o0Oo0OO00O0O000ooOO0;
    public String oO00o0OooO0OO0o0000o;

    static {
        ArrayList arrayList = new ArrayList();
        O0oOO0ooO = arrayList;
        Class<ContentResolver> cls = ContentResolver.class;
        Class<String> cls2 = String.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(0, Settings.System.class.getName(), o0O00o00OOoOo0oooOoo00("3f4a596f6f4e534f41", 78), new Class[]{cls, cls2}));
        arrayList.add(new oO00o0OooO0OO0o0000o(1, SharedPreferences.Editor.class.getName(), o0O00o00OOoOo0oooOoo00("2832361010312c303e", 49), new Class[]{cls2, cls2}));
        Class<TelephonyManager> cls3 = TelephonyManager.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(3, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f2e3d0b0a3b3d3c3d37272b3b1701", 42), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(4, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f57446d70525e012a6e4d5a5242", 83), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(5, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f5f4c6d7c4e42575b7170", 91), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(6, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f13003328171b17393d1914332a091e1606", 23), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(7, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f6271475a645e56777b686d425b786f6777", 102), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(8, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f27341f0e34263d383c0d093f3e3f232e151f39", 35), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(9, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f02113a2b1103181d19243f151713151b1d3c2f0c08", 6), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(10, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f594a7c615f79644e4c484e404667745753", 93), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(11, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f4c5f6a76494f457f63475b", 72), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(12, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f1b082332081a0104002634100c", 31), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(13, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f465573624d446467484651594245", 66), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(14, cls3.getName(), o0O00o00OOoOo0oooOoo00("3f50436273414d5854646e5b405144414561614553485453", 84), new Class[0]));
        Class<WifiInfo> cls4 = WifiInfo.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(15, cls4.getName(), o0O00o00OOoOo0oooOoo00("3f7a6941547a5a5d786e6f6e78", 126), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(16, cls4.getName(), o0O00o00OOoOo0oooOoo00("3f5d4e62666e7a5f4948495f", 89), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(17, cls4.getName(), o0O00o00OOoOo0oooOoo00("3f6b784e697364", 111), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(18, cls4.getName(), o0O00o00OOoOo0oooOoo00("3f77644364756f78", 115), new Class[0]));
        Class<WifiManager> cls5 = WifiManager.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(19, cls5.getName(), o0O00o00OOoOo0oooOoo00("3f2f3c1a012c2d262b3a302b2c0a0a2524", 43), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(20, cls5.getName(), o0O00o00OOoOo0oooOoo00("3f594a6b775048627c5352", 93), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(21, cls5.getName(), o0O00o00OOoOo0oooOoo00("3f6b784e596b66555e7f6f70716e", 111), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(22, NetworkInterface.class.getName(), o0O00o00OOoOo0oooOoo00("3f25361d0c36243f3a3e05003d36303320252131", 33), new Class[0]));
        Class<Proxy> cls6 = Proxy.class;
        Class<Context> cls7 = Context.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(23, cls6.getName(), o0O00o00OOoOo0oooOoo00("3f4f5c716a514a", 75), new Class[]{cls7}));
        arrayList.add(new oO00o0OooO0OO0o0000o(24, cls6.getName(), o0O00o00OOoOo0oooOoo00("3f6e7d4853716a", 106), new Class[]{cls7}));
        arrayList.add(new oO00o0OooO0OO0o0000o(25, System.class.getName(), o0O00o00OOoOo0oooOoo00("3f3b281d1b24262c2e3f34", 63), new Class[]{cls2}));
        Class<PackageManager> cls8 = PackageManager.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(26, cls8.getName(), o0O00o00OOoOo0oooOoo00("3f0a19352f150f1d0508011f2a390a00020e0a23270400", 14), new Class[]{cls2}));
        String name = cls8.getName();
        String o0O00o00OOoOo0oooOoo002 = o0O00o00OOoOo0oooOoo00("3f6a794c596a60626e6a444f6061", 110);
        Class cls9 = Integer.TYPE;
        arrayList.add(new oO00o0OooO0OO0o0000o(27, name, o0O00o00OOoOo0oooOoo002, new Class[]{cls2, cls9}));
        arrayList.add(new oO00o0OooO0OO0o0000o(28, cls8.getName(), o0O00o00OOoOo0oooOoo00("3f1f0c203a001a08101d141c292c1f15171b1f0b", 27), new Class[]{cls9}));
        arrayList.add(new oO00o0OooO0OO0o0000o(29, File.class.getName(), o0O00o00OOoOo0oooOoo00("3f677450467479667c647450547079", 99), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(30, ActivityManager.class.getName(), o0O00o00OOoOo0oooOoo00("3f637047467a616666685254737979", 103), new Class[]{cls9}));
        arrayList.add(new oO00o0OooO0OO0o0000o(31, ComponentName.class.getName(), o0O00o00OOoOo0oooOoo00("3f3a291c093a30323e3a13173430", 62), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(32, Modifier.class.getName(), o0O00o00OOoOo0oooOoo00("314265774d45474b", 94), new Class[]{cls9}));
        arrayList.add(new oO00o0OooO0OO0o0000o(33, Debug.class.getName(), o0O00o00OOoOo0oooOoo00("31624f597f6f6a787a6f49547978737e6f6979", 126), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(34, Process.class.getName(), o0O00o00OOoOo0oooOoo00("35665b4b7f", 116), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(35, TimeZone.class.getName(), o0O00o00OOoOo0oooOoo00("3f1e0d3a2f0a24351c090a0d", 26), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(36, TimeZone.class.getName(), o0O00o00OOoOo0oooOoo00("3f7d6e4f6878784d686078766b", 121), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(37, Locale.class.getName(), o0O00o00OOoOo0oooOoo00("3f57446d785a5c47415357", 83), new Class[0]));
        Class<Intent> cls10 = Intent.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(38, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f24371b013c372d3c", 32), new Class[]{cls2}));
        if (Build.VERSION.SDK_INT < 28) {
            arrayList.add(new oO00o0OooO0OO0o0000o(39, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f5c4f6f6352584d", 88), new Class[]{cls2}));
            arrayList.add(new oO00o0OooO0OO0o0000o(2, o0O00o00OOoOo0oooOoo00("390b0e121902094e451859792e0e03150c3926191b111302190812", 2), o0O00o00OOoOo0oooOoo00("3f7665", 114), new Class[]{cls2, cls2}));
            arrayList.add(new oO00o0OooO0OO0o0000o(63, o0O00o00OOoOo0oooOoo00("397d78646f747f38336e2f0f587875637a4f506f6d6765746f7e64", 116), o0O00o00OOoOo0oooOoo00("3f5e4d", 90), new Class[]{cls2}));
        }
        arrayList.add(new oO00o0OooO0OO0o0000o(40, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f4457706b46454f42496d7b4a4055", 64), new Class[]{cls2, Boolean.TYPE}));
        arrayList.add(new oO00o0OooO0OO0o0000o(41, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f3e2d0a07312d1c01303a2f", 58), new Class[]{cls2, Byte.TYPE}));
        arrayList.add(new oO00o0OooO0OO0o0000o(42, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f7f6c5a467a607b4c40717b6e", 123), new Class[]{cls2, Short.TYPE}));
        arrayList.add(new oO00o0OooO0OO0o0000o(43, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f1d0e2834160c282213190c", 25), new Class[]{cls2, Character.TYPE}));
        arrayList.add(new oO00o0OooO0OO0o0000o(44, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f43507c665b707c4d4752", 71), new Class[]{cls2, cls9}));
        arrayList.add(new oO00o0OooO0OO0o0000o(45, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f37240d16343c1708393326", 51), new Class[]{cls2, Long.TYPE}));
        arrayList.add(new oO00o0OooO0OO0o0000o(46, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f40537068414c57737f4e4451", 68), new Class[]{cls2, Float.TYPE}));
        arrayList.add(new oO00o0OooO0OO0o0000o(47, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f1d0e2f34050811163f2213190c", 25), new Class[]{cls2, Double.TYPE}));
        arrayList.add(new oO00o0OooO0OO0o0000o(48, cls10.getName(), o0O00o00OOoOo0oooOoo00("3f4a596f6f4e534f416a75444e5b", 78), new Class[]{cls2}));
        arrayList.add(new oO00o0OooO0OO0o0000o(49, Display.class.getName(), o0O00o00OOoOo0oooOoo00("3f4c5f6d70435e52", 72), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(50, Display.class.getName(), o0O00o00OOoOo0oooOoo00("3f43507d6c4d4f4e5d", 71), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(51, BluetoothAdapter.class.getName(), o0O00o00OOoOo0oooOoo00("3f233014042137363721", 39), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(52, Settings.Secure.class.getName(), o0O00o00OOoOo0oooOoo00("3f15063030110c101e", 17), new Class[]{cls, cls2}));
        arrayList.add(new oO00o0OooO0OO0o0000o(53, ActivityManager.class.getName(), o0O00o00OOoOo0oooOoo00("3f34270f1e3e342b3d06113e3f", 48), new Class[]{ActivityManager.MemoryInfo.class}));
        Class<StatFs> cls11 = StatFs.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(54, cls11.getName(), o0O00o00OOoOo0oooOoo00("3f4053746c414e4a7a78515d", 68), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(55, cls11.getName(), o0O00o00OOoOo0oooOoo00("3f04173028050a0e3e3c15192f25070f", 0), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(56, cls11.getName(), o0O00o00OOoOo0oooOoo00("3f3a290e163b34301014222322", 62), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(57, cls11.getName(), o0O00o00OOoOo0oooOoo00("3f1704233b16191d3d390f0e0f2d36141c", 19), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(58, cls11.getName(), o0O00o00OOoOo0oooOoo00("3f4a597d7f5f404d454b46416f664b444050", 78), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(59, cls11.getName(), o0O00o00OOoOo0oooOoo00("3f736044466679747c727f78565f727d79694e527078", 119), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(60, Location.class.getName(), o0O00o00OOoOo0oooOoo00("3f2c3f16033b33332f3f2f", 40), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(61, Location.class.getName(), o0O00o00OOoOo0oooOoo00("3f20331a01232b2c3f233323", 36), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(62, InetAddress.class.getName(), o0O00o00OOoOo0oooOoo00("313a1f03203f322322280a052036373620", 38), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(64, LocationManager.class.getName(), o0O00o00OOoOo0oooOoo00("3f57446d7847526a70544d4c7776595740485354", 83), new Class[]{cls2}));
        Class<Camera> cls12 = Camera.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(65, cls12.getName(), o0O00o00OOoOo0oooOoo00("2b3f380d0b3e3a36253b0a183425282e3e", 47), new Class[]{SurfaceTexture.class}));
        Class<Camera.PreviewCallback> cls13 = Camera.PreviewCallback.class;
        arrayList.add(new oO00o0OooO0OO0o0000o(66, cls12.getName(), o0O00o00OOoOo0oooOoo00("2b717643457074786b7553456a676964656f5b597a7b4d5074676470", 97), new Class[]{cls13}));
        arrayList.add(new oO00o0OooO0OO0o0000o(67, cls12.getName(), o0O00o00OOoOo0oooOoo00("39494c6b6e414c424f4e44657b5f4c4f5b", 74), new Class[]{byte[].class}));
        arrayList.add(new oO00o0OooO0OO0o0000o(68, cls12.getName(), o0O00o00OOoOo0oooOoo00("2b1c1b2e281d191506183e28070a04090802", 12), new Class[]{cls13}));
        arrayList.add(new oO00o0OooO0OO0o0000o(69, cls12.getName(), o0O00o00OOoOo0oooOoo00("2b2b2c061c360b063a26191f2a2e22312f091f303d333e3f35", 59), new Class[]{cls13}));
        arrayList.add(new oO00o0OooO0OO0o0000o(70, cls12.getName(), o0O00o00OOoOo0oooOoo00("2c322d29121e2d30262030", 33), new Class[]{Camera.ShutterCallback.class}));
        arrayList.add(new oO00o0OooO0OO0o0000o(71, cls12.getName(), o0O00o00OOoOo0oooOoo00("2b3f2d2b3e1c1a2f2b27342a", 62), new Class[0]));
        arrayList.add(new oO00o0OooO0OO0o0000o(72, cls12.getName(), o0O00o00OOoOo0oooOoo00("2b5354616752565a495776685f4659485d", 67), new Class[]{SurfaceHolder.class}));
        arrayList.add(new oO00o0OooO0OO0o0000o(73, CameraManager.class.getName(), o0O00o00OOoOo0oooOoo00("37131907212e00041b1f", 10), new Class[]{cls2, CameraDevice.StateCallback.class, Handler.class}));
        arrayList.add(new oO00o0OooO0OO0o0000o(74, CameraManager.class.getName(), o0O00o00OOoOo0oooOoo00("375a504e6867494d5256", 67), new Class[]{cls2, Executor.class, CameraDevice.StateCallback.class}));
        arrayList.add(new oO00o0OooO0OO0o0000o(75, CaptureRequest.Builder.class.getName(), o0O00o00OOoOo0oooOoo00("396560505573756271", 102), new Class[]{Surface.class}));
        arrayList.add(new oO00o0OooO0OO0o0000o(76, CaptureRequest.Builder.class.getName(), o0O00o00OOoOo0oooOoo00("3a7c776e63", 109), new Class[0]));
    }

    public oO00o0OooO0OO0o0000o() {
    }

    private static String o0O00o00OOoOo0oooOoo00(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 6);
            byte b2 = (byte) (bArr[0] ^ 88);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int o0Oo0OO00O0O000ooOO0(String str) {
        for (oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o : O0oOO0ooO) {
            if (str.contains(oo00o0oooo0oo0o0000o.o0O00o00OOoOo0oooOoo00) && str.contains(oo00o0oooo0oo0o0000o.oO00o0OooO0OO0o0000o) && str.contains(o0Oo0OO00O0O000ooOO0(oo00o0oooo0oo0o0000o.O00OO0oOOooooO00000Oo))) {
                return oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0;
            }
        }
        return -1;
    }

    public String toString() {
        return new JSONObject(this.o00ooooooO00OO0O00).toString();
    }

    public oO00o0OooO0OO0o0000o(int i, String str, String str2, Class[] clsArr) {
        this.o0Oo0OO00O0O000ooOO0 = i;
        this.o0O00o00OOoOo0oooOoo00 = str;
        this.oO00o0OooO0OO0o0000o = str2;
        this.O00OO0oOOooooO00000Oo = clsArr;
    }

    private static String o0Oo0OO00O0O000ooOO0(Class[] clsArr) {
        StringBuilder sb = new StringBuilder();
        for (Class cls : clsArr) {
            if (sb.length() > 0) {
                sb.append(o0O00o00OOoOo0oooOoo00("74", 108));
            }
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    public void o0Oo0OO00O0O000ooOO0() {
        this.o00ooooooO00OO0O00.clear();
    }

    public void o0Oo0OO00O0O000ooOO0(String str, int i) {
        if (this.o00ooooooO00OO0O00.containsKey(str)) {
            Set set = (Set) this.o00ooooooO00OO0O00.get(str);
            if (set != null) {
                set.add(Integer.valueOf(i));
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i));
        this.o00ooooooO00OO0O00.put(str, hashSet);
    }
}
