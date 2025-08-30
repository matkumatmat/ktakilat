package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.WireFormat;

public final class ResourceProto {
    static {
        DescriptorProtos.FieldOptions defaultInstance = DescriptorProtos.FieldOptions.getDefaultInstance();
        ResourceReference b = ResourceReference.b();
        ResourceReference b2 = ResourceReference.b();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, b, b2, (Internal.EnumLiteMap<?>) null, 1055, fieldType, ResourceReference.class);
        GeneratedMessageLite.newRepeatedGeneratedExtension(DescriptorProtos.FileOptions.getDefaultInstance(), ResourceDescriptor.b(), (Internal.EnumLiteMap<?>) null, 1053, fieldType, false, ResourceDescriptor.class);
        GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.MessageOptions.getDefaultInstance(), ResourceDescriptor.b(), ResourceDescriptor.b(), (Internal.EnumLiteMap<?>) null, 1053, fieldType, ResourceDescriptor.class);
    }
}
