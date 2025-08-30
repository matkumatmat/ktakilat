package com.google.i18n.phonenumbers.metadata;

import com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;
import com.google.i18n.phonenumbers.metadata.source.FormattingMetadataSourceImpl;
import com.google.i18n.phonenumbers.metadata.source.MetadataSourceImpl;
import com.google.i18n.phonenumbers.metadata.source.MultiFileModeFileNameProvider;
import com.google.i18n.phonenumbers.metadata.source.RegionMetadataSourceImpl;

public final class DefaultMetadataDependenciesProvider {
    public static final DefaultMetadataDependenciesProvider e = new DefaultMetadataDependenciesProvider();

    /* renamed from: a  reason: collision with root package name */
    public final MetadataParser f322a;
    public final ClassPathResourceMetadataLoader b;
    public final MultiFileModeFileNameProvider c;
    public final RegionMetadataSourceImpl d;

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.i18n.phonenumbers.metadata.init.MetadataParser] */
    /* JADX WARNING: type inference failed for: r1v0, types: [com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader, java.lang.Object] */
    public DefaultMetadataDependenciesProvider() {
        ? obj = new Object();
        this.f322a = obj;
        ? obj2 = new Object();
        this.b = obj2;
        MultiFileModeFileNameProvider multiFileModeFileNameProvider = new MultiFileModeFileNameProvider("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto");
        this.c = multiFileModeFileNameProvider;
        new MetadataSourceImpl(multiFileModeFileNameProvider, obj2, obj);
        this.d = new RegionMetadataSourceImpl(new MultiFileModeFileNameProvider("/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto"), obj2, obj);
        new FormattingMetadataSourceImpl(new MultiFileModeFileNameProvider("/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto"), obj2, obj);
    }
}
