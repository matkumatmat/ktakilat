package com.google.zxing.datamatrix.decoder;

public final class Version {

    /* renamed from: a  reason: collision with root package name */
    public final int f416a;

    public static final class ECB {

        /* renamed from: a  reason: collision with root package name */
        public final int f417a;

        public ECB(int i, int i2) {
            this.f417a = i;
        }
    }

    static {
        new Version(1, new ECBlocks(5, new ECB(1, 3)));
        new Version(2, new ECBlocks(7, new ECB(1, 5)));
        new Version(3, new ECBlocks(10, new ECB(1, 8)));
        new Version(4, new ECBlocks(12, new ECB(1, 12)));
        new Version(5, new ECBlocks(14, new ECB(1, 18)));
        new Version(6, new ECBlocks(18, new ECB(1, 22)));
        new Version(7, new ECBlocks(20, new ECB(1, 30)));
        new Version(8, new ECBlocks(24, new ECB(1, 36)));
        new Version(9, new ECBlocks(28, new ECB(1, 44)));
        new Version(10, new ECBlocks(36, new ECB(1, 62)));
        new Version(11, new ECBlocks(42, new ECB(1, 86)));
        new Version(12, new ECBlocks(48, new ECB(1, 114)));
        new Version(13, new ECBlocks(56, new ECB(1, 144)));
        new Version(14, new ECBlocks(68, new ECB(1, 174)));
        new Version(15, new ECBlocks(42, new ECB(2, 102)));
        new Version(16, new ECBlocks(56, new ECB(2, 140)));
        new Version(17, new ECBlocks(36, new ECB(4, 92)));
        new Version(18, new ECBlocks(48, new ECB(4, 114)));
        new Version(19, new ECBlocks(56, new ECB(4, 144)));
        new Version(20, new ECBlocks(68, new ECB(4, 174)));
        new Version(21, new ECBlocks(56, new ECB(6, 136)));
        new Version(22, new ECBlocks(68, new ECB(6, 175)));
        new Version(23, new ECBlocks(62, new ECB(8, 163)));
        new Version(24, new ECBlocks(new ECB(8, 156), new ECB(2, 155)));
        new Version(25, new ECBlocks(7, new ECB(1, 5)));
        new Version(26, new ECBlocks(11, new ECB(1, 10)));
        new Version(27, new ECBlocks(14, new ECB(1, 16)));
        new Version(28, new ECBlocks(18, new ECB(1, 22)));
        new Version(29, new ECBlocks(24, new ECB(1, 32)));
        new Version(30, new ECBlocks(28, new ECB(1, 49)));
    }

    public Version(int i, ECBlocks eCBlocks) {
        this.f416a = i;
        for (ECB ecb : eCBlocks.f418a) {
            int i2 = ecb.f417a;
        }
    }

    public final String toString() {
        return String.valueOf(this.f416a);
    }

    public static final class ECBlocks {

        /* renamed from: a  reason: collision with root package name */
        public final ECB[] f418a;

        public ECBlocks(int i, ECB ecb) {
            this.f418a = new ECB[]{ecb};
        }

        public ECBlocks(ECB ecb, ECB ecb2) {
            this.f418a = new ECB[]{ecb, ecb2};
        }
    }
}
