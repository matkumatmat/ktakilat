package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public interface Writer {
    BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap);
}
