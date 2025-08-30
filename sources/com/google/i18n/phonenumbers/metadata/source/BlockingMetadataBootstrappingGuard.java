package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader;
import com.google.i18n.phonenumbers.metadata.init.MetadataParser;
import com.google.i18n.phonenumbers.metadata.source.MetadataContainer;
import java.util.concurrent.ConcurrentHashMap;

final class BlockingMetadataBootstrappingGuard<T extends MetadataContainer> implements MetadataBootstrappingGuard<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ClassPathResourceMetadataLoader f325a;
    public final MetadataParser b;
    public final MetadataContainer c;
    public final ConcurrentHashMap d = new ConcurrentHashMap();

    public BlockingMetadataBootstrappingGuard(ClassPathResourceMetadataLoader classPathResourceMetadataLoader, MetadataParser metadataParser, MetadataContainer metadataContainer) {
        this.f325a = classPathResourceMetadataLoader;
        this.b = metadataParser;
        this.c = metadataContainer;
    }

    public final MetadataContainer a(String str) {
        if (!this.d.containsKey(str)) {
            synchronized (this) {
                try {
                    if (!this.d.containsKey(str)) {
                        for (Phonemetadata.PhoneMetadata a2 : this.b.a(this.f325a.a(str))) {
                            this.c.a(a2);
                        }
                        this.d.put(str, str);
                    }
                } catch (IllegalArgumentException | IllegalStateException e) {
                    throw new IllegalStateException("Failed to read file " + str, e);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }
}
