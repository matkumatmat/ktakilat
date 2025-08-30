package com.google.i18n.phonenumbers.metadata.source;

import com.google.i18n.phonenumbers.Phonemetadata;

final class CompositeMetadataContainer implements MetadataContainer {

    /* renamed from: a  reason: collision with root package name */
    public final MapBackedMetadataContainer f326a = new MapBackedMetadataContainer(new Object());
    public final MapBackedMetadataContainer b = new MapBackedMetadataContainer(new Object());

    public final void a(Phonemetadata.PhoneMetadata phoneMetadata) {
        MapBackedMetadataContainer mapBackedMetadataContainer = this.b;
        if (!((String) mapBackedMetadataContainer.b.a(phoneMetadata)).equals("001")) {
            mapBackedMetadataContainer.a(phoneMetadata);
        } else {
            this.f326a.a(phoneMetadata);
        }
    }
}
