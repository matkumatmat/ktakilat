package com.google.zxing;

import java.util.List;

public enum DecodeHintType {
    OTHER(Object.class),
    PURE_BARCODE(r5),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(r5),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(r14),
    ASSUME_CODE_39_CHECK_DIGIT(r5),
    ASSUME_GS1(r5),
    RETURN_CODABAR_START_END(r5),
    NEED_RESULT_POINT_CALLBACK(ResultPointCallback.class),
    ALLOWED_EAN_EXTENSIONS(r14);
    
    public final Class c;

    /* access modifiers changed from: public */
    DecodeHintType(Class cls) {
        this.c = cls;
    }

    public Class<?> getValueType() {
        return this.c;
    }
}
