package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;

public final class FormattingMetadataSourceImpl implements FormattingMetadataSource {

    /* renamed from: a  reason: collision with root package name */
    public final MetadataBootstrappingGuard f327a;

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, com.google.i18n.phonenumbers.metadata.source.MapBackedMetadataContainer$KeyProvider] */
    public FormattingMetadataSourceImpl(MultiFileModeFileNameProvider multiFileModeFileNameProvider, ClassPathResourceMetadataLoader classPathResourceMetadataLoader, MetadataParser metadataParser) {
        new BlockingMetadataBootstrappingGuard(classPathResourceMetadataLoader, metadataParser, new MapBackedMetadataContainer(new Object()));
    }
}
