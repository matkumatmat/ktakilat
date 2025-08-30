package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;

public final class ClientProto {
    static {
        DescriptorProtos.MethodOptions defaultInstance = DescriptorProtos.MethodOptions.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
        GeneratedMessageLite.newRepeatedGeneratedExtension(defaultInstance, (MessageLite) null, (Internal.EnumLiteMap<?>) null, 1051, fieldType, false, String.class);
        WireFormat.FieldType fieldType2 = fieldType;
        GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.ServiceOptions.getDefaultInstance(), "", (MessageLite) null, (Internal.EnumLiteMap<?>) null, 1049, fieldType2, String.class);
        GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.ServiceOptions.getDefaultInstance(), "", (MessageLite) null, (Internal.EnumLiteMap<?>) null, 1050, fieldType2, String.class);
    }
}
