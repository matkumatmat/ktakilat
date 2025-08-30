package com.google.i18n.phonenumbers.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {

    /* renamed from: a  reason: collision with root package name */
    public final LRUCache f320a;

    public static class LRUCache<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public LinkedHashMap f321a;
        public int b;

        public final synchronized void a(String str, Pattern pattern) {
            this.f321a.put(str, pattern);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.i18n.phonenumbers.internal.RegexCache$LRUCache, java.lang.Object] */
    public RegexCache(int i) {
        ? obj = new Object();
        obj.b = i;
        obj.f321a = new LinkedHashMap<Object, Object>(e.b(i, 4, 3, 1)) {
            public final boolean removeEldestEntry(Map.Entry entry) {
                if (size() > LRUCache.this.b) {
                    return true;
                }
                return false;
            }
        };
        this.f320a = obj;
    }

    public final Pattern a(String str) {
        Object obj;
        LRUCache lRUCache = this.f320a;
        synchronized (lRUCache) {
            obj = lRUCache.f321a.get(str);
        }
        Pattern pattern = (Pattern) obj;
        if (pattern != null) {
            return pattern;
        }
        Pattern compile = Pattern.compile(str);
        this.f320a.a(str, compile);
        return compile;
    }
}
