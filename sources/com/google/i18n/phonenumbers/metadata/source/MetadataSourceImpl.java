package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.CountryCodeToRegionCodeMap;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;
import java.util.List;

public final class MetadataSourceImpl implements MetadataSource {

    /* renamed from: a  reason: collision with root package name */
    public final MultiFileModeFileNameProvider f329a;
    public final MetadataBootstrappingGuard b;

    public MetadataSourceImpl(MultiFileModeFileNameProvider multiFileModeFileNameProvider, ClassPathResourceMetadataLoader classPathResourceMetadataLoader, MetadataParser metadataParser) {
        BlockingMetadataBootstrappingGuard blockingMetadataBootstrappingGuard = new BlockingMetadataBootstrappingGuard(classPathResourceMetadataLoader, metadataParser, new CompositeMetadataContainer());
        this.f329a = multiFileModeFileNameProvider;
        this.b = blockingMetadataBootstrappingGuard;
    }

    public final Phonemetadata.PhoneMetadata a(int i) {
        List list = (List) CountryCodeToRegionCodeMap.a().get(Integer.valueOf(i));
        if (list == null || list.contains("001")) {
            String a2 = this.f329a.a(Integer.valueOf(i));
            return (Phonemetadata.PhoneMetadata) ((CompositeMetadataContainer) ((BlockingMetadataBootstrappingGuard) this.b).a(a2)).f326a.f328a.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException(i + " calling code belongs to a geo entity");
    }

    public final Phonemetadata.PhoneMetadata b(String str) {
        if (!str.equals("001")) {
            return (Phonemetadata.PhoneMetadata) ((CompositeMetadataContainer) ((BlockingMetadataBootstrappingGuard) this.b).a(this.f329a.a(str))).b.f328a.get(str);
        }
        throw new IllegalArgumentException(str.concat(" region code is a non-geo entity"));
    }
}
