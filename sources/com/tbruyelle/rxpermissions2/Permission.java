package com.tbruyelle.rxpermissions2;

public class Permission {

    /* renamed from: a  reason: collision with root package name */
    public final String f637a;
    public final boolean b;
    public final boolean c;

    public Permission(String str, boolean z, boolean z2) {
        this.f637a = str;
        this.b = z;
        this.c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Permission permission = (Permission) obj;
        if (this.b == permission.b && this.c == permission.c) {
            return this.f637a.equals(permission.f637a);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f637a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0);
    }

    public final String toString() {
        return "Permission{name='" + this.f637a + "', granted=" + this.b + ", shouldShowRequestPermissionRationale=" + this.c + '}';
    }
}
