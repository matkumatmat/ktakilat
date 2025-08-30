package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;

public final class RegionMetadataSourceImpl implements RegionMetadataSource {
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, com.google.i18n.phonenumbers.metadata.source.MapBackedMetadataContainer$KeyProvider] */
    public RegionMetadataSourceImpl(MultiFileModeFileNameProvider multiFileModeFileNameProvider, ClassPathResourceMetadataLoader classPathResourceMetadataLoader, MetadataParser metadataParser) {
        new BlockingMetadataBootstrappingGuard(classPathResourceMetadataLoader, metadataParser, new MapBackedMetadataContainer(new Object()));
    }
}
