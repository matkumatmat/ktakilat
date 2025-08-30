package com.google.zxing.multi.qrcode;

import com.google.zxing.Result;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.Serializable;
import java.util.Comparator;

public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {

    public static final class SAComparator implements Serializable, Comparator<Result> {
        public final int compare(Object obj, Object obj2) {
            Result result = (Result) obj2;
            ((Result) obj).getClass();
            throw null;
        }
    }
}
