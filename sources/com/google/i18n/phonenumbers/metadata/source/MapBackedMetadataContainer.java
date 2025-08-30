package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.concurrent.ConcurrentHashMap;

final class MapBackedMetadataContainer<T> implements MetadataContainer {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f328a = new ConcurrentHashMap();
    public final KeyProvider b;

    /* renamed from: com.google.i18n.phonenumbers.metadata.source.MapBackedMetadataContainer$1  reason: invalid class name */
    class AnonymousClass1 implements KeyProvider<String> {
        public final Object a(Phonemetadata.PhoneMetadata phoneMetadata) {
            return phoneMetadata.getId();
        }
    }

    /* renamed from: com.google.i18n.phonenumbers.metadata.source.MapBackedMetadataContainer$2  reason: invalid class name */
    class AnonymousClass2 implements KeyProvider<Integer> {
        public final Object a(Phonemetadata.PhoneMetadata phoneMetadata) {
            return Integer.valueOf(phoneMetadata.getCountryCode());
        }
    }

    public interface KeyProvider<T> {
        Object a(Phonemetadata.PhoneMetadata phoneMetadata);
    }

    public MapBackedMetadataContainer(KeyProvider keyProvider) {
        this.b = keyProvider;
    }

    public final void a(Phonemetadata.PhoneMetadata phoneMetadata) {
        this.f328a.put(this.b.a(phoneMetadata), phoneMetadata);
    }
}
