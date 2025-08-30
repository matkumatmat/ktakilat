package com.tbruyelle.rxpermissions2;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.text.TextUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RxPermissions {
    public static final Object b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final RxPermissionsFragment f638a;

    /* renamed from: com.tbruyelle.rxpermissions2.RxPermissions$2  reason: invalid class name */
    class AnonymousClass2 implements ObservableTransformer<Object, Permission> {
        public final ObservableSource a(Observable observable) {
            RxPermissions.a((RxPermissions) null, observable, (String[]) null);
            throw null;
        }
    }

    public RxPermissions(Activity activity) {
        RxPermissionsFragment rxPermissionsFragment = (RxPermissionsFragment) activity.getFragmentManager().findFragmentByTag("RxPermissions");
        if (rxPermissionsFragment == null) {
            rxPermissionsFragment = new RxPermissionsFragment();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction().add(rxPermissionsFragment, "RxPermissions").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        this.f638a = rxPermissionsFragment;
    }

    public static Observable a(RxPermissions rxPermissions, Observable observable, final String[] strArr) {
        Object obj;
        Observable just;
        Observable observable2;
        rxPermissions.getClass();
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            obj = b;
            if (i >= length) {
                just = Observable.just(obj);
                break;
            }
            if (!rxPermissions.f638a.c.containsKey(strArr[i])) {
                just = Observable.empty();
                break;
            }
            i++;
        }
        if (observable == null) {
            observable2 = Observable.just(obj);
        } else {
            observable2 = Observable.merge(observable, just);
        }
        return observable2.flatMap(new Function<Object, Observable<Permission>>() {
            public final Object apply(Object obj) {
                RxPermissionsFragment rxPermissionsFragment;
                RxPermissions rxPermissions = RxPermissions.this;
                rxPermissions.getClass();
                String[] strArr = strArr;
                ArrayList arrayList = new ArrayList(strArr.length);
                ArrayList arrayList2 = new ArrayList();
                int length = strArr.length;
                int i = 0;
                while (true) {
                    rxPermissionsFragment = rxPermissions.f638a;
                    if (i >= length) {
                        break;
                    }
                    String str = strArr[i];
                    rxPermissionsFragment.getClass();
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 < 23 || rxPermissionsFragment.getActivity().checkSelfPermission(str) == 0) {
                        arrayList.add(Observable.just(new Permission(str, true, false)));
                    } else if (i2 < 23 || !rxPermissionsFragment.getActivity().getPackageManager().isPermissionRevokedByPolicy(str, rxPermissionsFragment.getActivity().getPackageName())) {
                        HashMap hashMap = rxPermissionsFragment.c;
                        PublishSubject publishSubject = (PublishSubject) hashMap.get(str);
                        if (publishSubject == null) {
                            arrayList2.add(str);
                            publishSubject = new PublishSubject();
                            PublishSubject publishSubject2 = (PublishSubject) hashMap.put(str, publishSubject);
                        }
                        arrayList.add(publishSubject);
                    } else {
                        arrayList.add(Observable.just(new Permission(str, false, false)));
                    }
                    i++;
                }
                if (!arrayList2.isEmpty()) {
                    String[] strArr2 = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    TextUtils.join(", ", strArr2);
                    rxPermissionsFragment.getClass();
                    rxPermissionsFragment.requestPermissions(strArr2, 42);
                }
                return Observable.concat(Observable.fromIterable(arrayList));
            }
        });
    }

    public final Observable b(final String... strArr) {
        return Observable.just(b).compose(new ObservableTransformer<Object, Boolean>() {

            /* renamed from: com.tbruyelle.rxpermissions2.RxPermissions$1$1  reason: invalid class name */
            class AnonymousClass1 implements Function<List<Permission>, ObservableSource<Boolean>> {
                public final Object apply(Object obj) {
                    List<Permission> list = (List) obj;
                    if (list.isEmpty()) {
                        return Observable.empty();
                    }
                    for (Permission permission : list) {
                        if (!permission.b) {
                            return Observable.just(Boolean.FALSE);
                        }
                    }
                    return Observable.just(Boolean.TRUE);
                }
            }

            /* JADX WARNING: type inference failed for: r0v2, types: [io.reactivex.functions.Function, java.lang.Object] */
            public final ObservableSource a(Observable observable) {
                RxPermissions rxPermissions = RxPermissions.this;
                String[] strArr = strArr;
                return RxPermissions.a(rxPermissions, observable, strArr).buffer(strArr.length).flatMap(new Object());
            }
        });
    }
}
