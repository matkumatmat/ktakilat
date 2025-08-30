package org.apache.commons.lang3;

public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i) {
        int i2;
        this._mask = i;
        if (i == 0) {
            i2 = 0;
        } else {
            i2 = Integer.numberOfTrailingZeros(i);
        }
        this._shift_count = i2;
    }

    public int clear(int i) {
        return i & (~this._mask);
    }

    public byte clearByte(byte b) {
        return (byte) clear(b);
    }

    public short clearShort(short s) {
        return (short) clear(s);
    }

    public int getRawValue(int i) {
        return i & this._mask;
    }

    public short getShortRawValue(short s) {
        return (short) getRawValue(s);
    }

    public short getShortValue(short s) {
        return (short) getValue(s);
    }

    public int getValue(int i) {
        return getRawValue(i) >> this._shift_count;
    }

    public boolean isAllSet(int i) {
        int i2 = this._mask;
        if ((i & i2) == i2) {
            return true;
        }
        return false;
    }

    public boolean isSet(int i) {
        if ((i & this._mask) != 0) {
            return true;
        }
        return false;
    }

    public int set(int i) {
        return i | this._mask;
    }

    public int setBoolean(int i, boolean z) {
        if (z) {
            return set(i);
        }
        return clear(i);
    }

    public byte setByte(byte b) {
        return (byte) set(b);
    }

    public byte setByteBoolean(byte b, boolean z) {
        if (z) {
            return setByte(b);
        }
        return clearByte(b);
    }

    public short setShort(short s) {
        return (short) set(s);
    }

    public short setShortBoolean(short s, boolean z) {
        if (z) {
            return setShort(s);
        }
        return clearShort(s);
    }

    public short setShortValue(short s, short s2) {
        return (short) setValue(s, s2);
    }

    public int setValue(int i, int i2) {
        int i3 = this._mask;
        return (i & (~i3)) | ((i2 << this._shift_count) & i3);
    }
}
