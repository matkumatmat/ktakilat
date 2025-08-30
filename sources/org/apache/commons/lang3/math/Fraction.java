package org.apache.commons.lang3.math;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public final class Fraction extends Number implements Comparable<Fraction> {
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private transient int hashCode;
    private final int numerator;
    private transient String toProperString;
    private transient String toString;

    private Fraction(int i, int i2) {
        this.numerator = i;
        this.denominator = i2;
    }

    private static int addAndCheck(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    private Fraction addSub(Fraction fraction, boolean z) {
        BigInteger bigInteger;
        int i;
        int i2;
        Validate.notNull(fraction, "fraction", new Object[0]);
        if (this.numerator == 0) {
            if (z) {
                return fraction;
            }
            return fraction.negate();
        } else if (fraction.numerator == 0) {
            return this;
        } else {
            int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
            if (greatestCommonDivisor == 1) {
                int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
                int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
                if (z) {
                    i2 = addAndCheck(mulAndCheck, mulAndCheck2);
                } else {
                    i2 = subAndCheck(mulAndCheck, mulAndCheck2);
                }
                return new Fraction(i2, mulPosAndCheck(this.denominator, fraction.denominator));
            }
            BigInteger multiply = BigInteger.valueOf((long) this.numerator).multiply(BigInteger.valueOf((long) (fraction.denominator / greatestCommonDivisor)));
            BigInteger multiply2 = BigInteger.valueOf((long) fraction.numerator).multiply(BigInteger.valueOf((long) (this.denominator / greatestCommonDivisor)));
            if (z) {
                bigInteger = multiply.add(multiply2);
            } else {
                bigInteger = multiply.subtract(multiply2);
            }
            int intValue = bigInteger.mod(BigInteger.valueOf((long) greatestCommonDivisor)).intValue();
            if (intValue == 0) {
                i = greatestCommonDivisor;
            } else {
                i = greatestCommonDivisor(intValue, greatestCommonDivisor);
            }
            BigInteger divide = bigInteger.divide(BigInteger.valueOf((long) i));
            if (divide.bitLength() <= 31) {
                return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / i));
            }
            throw new ArithmeticException("overflow: numerator too large after multiply");
        }
    }

    public static Fraction getFraction(int i, int i2) {
        if (i2 != 0) {
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            return new Fraction(i, i2);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int i, int i2) {
        if (i2 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i == 0) {
            return ZERO;
        } else {
            if (i2 == Integer.MIN_VALUE && (i & 1) == 0) {
                i /= 2;
                i2 /= 2;
            }
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i, i2);
            return new Fraction(i / greatestCommonDivisor, i2 / greatestCommonDivisor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int greatestCommonDivisor(int r6, int r7) {
        /*
            java.lang.String r0 = "overflow: gcd is 2^31"
            if (r6 == 0) goto L_0x0057
            if (r7 != 0) goto L_0x0007
            goto L_0x0057
        L_0x0007:
            int r1 = java.lang.Math.abs(r6)
            r2 = 1
            if (r1 == r2) goto L_0x0056
            int r1 = java.lang.Math.abs(r7)
            if (r1 != r2) goto L_0x0015
            goto L_0x0056
        L_0x0015:
            if (r6 <= 0) goto L_0x0018
            int r6 = -r6
        L_0x0018:
            if (r7 <= 0) goto L_0x001b
            int r7 = -r7
        L_0x001b:
            r1 = 0
        L_0x001c:
            r3 = r6 & 1
            r4 = 31
            if (r3 != 0) goto L_0x002f
            r5 = r7 & 1
            if (r5 != 0) goto L_0x002f
            if (r1 >= r4) goto L_0x002f
            int r6 = r6 / 2
            int r7 = r7 / 2
            int r1 = r1 + 1
            goto L_0x001c
        L_0x002f:
            if (r1 == r4) goto L_0x0050
            if (r3 != r2) goto L_0x0035
            r0 = r7
            goto L_0x0038
        L_0x0035:
            int r0 = r6 / 2
            int r0 = -r0
        L_0x0038:
            r3 = r0 & 1
            if (r3 != 0) goto L_0x003f
            int r0 = r0 / 2
            goto L_0x0038
        L_0x003f:
            if (r0 <= 0) goto L_0x0043
            int r6 = -r0
            goto L_0x0044
        L_0x0043:
            r7 = r0
        L_0x0044:
            int r0 = r7 - r6
            int r0 = r0 / 2
            if (r0 != 0) goto L_0x0038
            int r6 = -r6
            int r7 = r2 << r1
            int r6 = r6 * r7
            return r6
        L_0x0050:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        L_0x0056:
            return r2
        L_0x0057:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 == r1) goto L_0x0067
            if (r7 == r1) goto L_0x0067
            int r6 = java.lang.Math.abs(r6)
            int r7 = java.lang.Math.abs(r7)
            int r7 = r7 + r6
            return r7
        L_0x0067:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.Fraction.greatestCommonDivisor(int, int):int");
    }

    private static int mulAndCheck(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mul");
    }

    private static int mulPosAndCheck(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    public Fraction abs() {
        if (this.numerator >= 0) {
            return this;
        }
        return negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction divideBy(Fraction fraction) {
        Validate.notNull(fraction, "fraction", new Object[0]);
        if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        }
        throw new ArithmeticException("The fraction to divide by must not be zero");
    }

    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator()) {
            return true;
        }
        return false;
    }

    public float floatValue() {
        return ((float) this.numerator) / ((float) this.denominator);
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getDenominator() + ((getNumerator() + 629) * 37);
        }
        return this.hashCode;
    }

    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i = this.numerator;
        if (i == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        } else if (i == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        } else if (i < 0) {
            return new Fraction(-this.denominator, -i);
        } else {
            return new Fraction(this.denominator, i);
        }
    }

    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public Fraction multiplyBy(Fraction fraction) {
        Validate.notNull(fraction, "fraction", new Object[0]);
        int i = this.numerator;
        if (i == 0 || fraction.numerator == 0) {
            return ZERO;
        }
        int greatestCommonDivisor = greatestCommonDivisor(i, fraction.denominator);
        int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
        return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
    }

    public Fraction negate() {
        int i = this.numerator;
        if (i != Integer.MIN_VALUE) {
            return new Fraction(-i, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i) {
        if (i == 1) {
            return this;
        }
        if (i == 0) {
            return ONE;
        }
        if (i >= 0) {
            Fraction multiplyBy = multiplyBy(this);
            if (i % 2 == 0) {
                return multiplyBy.pow(i / 2);
            }
            return multiplyBy.pow(i / 2).multiplyBy(this);
        } else if (i == Integer.MIN_VALUE) {
            return invert().pow(2).pow(-(i / 2));
        } else {
            return invert().pow(-i);
        }
    }

    public Fraction reduce() {
        int i = this.numerator;
        if (i == 0) {
            Fraction fraction = ZERO;
            if (equals(fraction)) {
                return this;
            }
            return fraction;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i), this.denominator);
        if (greatestCommonDivisor == 1) {
            return this;
        }
        return getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i = this.numerator;
            if (i == 0) {
                this.toProperString = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                int i2 = this.denominator;
                if (i == i2) {
                    this.toProperString = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                } else if (i == i2 * -1) {
                    this.toProperString = "-1";
                } else {
                    if (i > 0) {
                        i = -i;
                    }
                    if (i < (-i2)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            this.toProperString = getProperWhole() + StringUtils.SPACE + properNumerator + RemoteSettings.FORWARD_SLASH_STRING + getDenominator();
                        }
                    } else {
                        this.toProperString = getNumerator() + RemoteSettings.FORWARD_SLASH_STRING + getDenominator();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = getNumerator() + RemoteSettings.FORWARD_SLASH_STRING + getDenominator();
        }
        return this.toString;
    }

    public int compareTo(Fraction fraction) {
        if (this == fraction) {
            return 0;
        }
        int i = this.numerator;
        int i2 = fraction.numerator;
        if (i == i2 && this.denominator == fraction.denominator) {
            return 0;
        }
        return Long.compare(((long) i) * ((long) fraction.denominator), ((long) i2) * ((long) this.denominator));
    }

    public static Fraction getFraction(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i3 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        } else if (i2 >= 0) {
            long j = i < 0 ? (((long) i) * ((long) i3)) - ((long) i2) : (((long) i) * ((long) i3)) + ((long) i2);
            if (j >= -2147483648L && j <= 2147483647L) {
                return new Fraction((int) j, i3);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        } else {
            throw new ArithmeticException("The numerator must not be negative");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.lang3.math.Fraction getFraction(double r21) {
        /*
            r0 = 0
            int r3 = (r21 > r0 ? 1 : (r21 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x0008
            r0 = -1
            goto L_0x0009
        L_0x0008:
            r0 = 1
        L_0x0009:
            double r3 = java.lang.Math.abs(r21)
            r5 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x0088
            boolean r1 = java.lang.Double.isNaN(r3)
            if (r1 != 0) goto L_0x0088
            int r1 = (int) r3
            double r5 = (double) r1
            double r3 = r3 - r5
            int r5 = (int) r3
            double r6 = (double) r5
            double r6 = r3 - r6
            r8 = 0
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r11 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r21 = r3
            r13 = r11
            r8 = 1
            r15 = 1
            r16 = 1
            r11 = r9
            r9 = 0
            r10 = 0
        L_0x0035:
            double r2 = r11 / r6
            int r2 = (int) r2
            double r3 = (double) r2
            double r3 = r3 * r6
            double r3 = r11 - r3
            int r11 = r5 * r8
            int r11 = r11 + r9
            int r5 = r5 * r10
            int r5 = r5 + r15
            r9 = r2
            r17 = r3
            double r2 = (double) r11
            r19 = r6
            double r6 = (double) r5
            double r2 = r2 / r6
            r6 = r21
            double r3 = r6 - r2
            double r2 = java.lang.Math.abs(r3)
            r4 = 1
            int r12 = r16 + 1
            r15 = 25
            int r16 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r16 <= 0) goto L_0x0074
            r13 = 10000(0x2710, float:1.4013E-41)
            if (r5 > r13) goto L_0x0074
            if (r5 <= 0) goto L_0x0074
            if (r12 < r15) goto L_0x0065
            goto L_0x0074
        L_0x0065:
            r13 = r2
            r21 = r6
            r15 = r10
            r16 = r12
            r6 = r17
            r10 = r5
            r5 = r9
            r9 = r8
            r8 = r11
            r11 = r19
            goto L_0x0035
        L_0x0074:
            if (r12 == r15) goto L_0x0080
            int r1 = r1 * r10
            int r1 = r1 + r8
            int r1 = r1 * r0
            org.apache.commons.lang3.math.Fraction r0 = getReducedFraction(r1, r10)
            return r0
        L_0x0080:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Unable to convert double to fraction"
            r0.<init>(r1)
            throw r0
        L_0x0088:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "The value must not be greater than Integer.MAX_VALUE or NaN"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.Fraction.getFraction(double):org.apache.commons.lang3.math.Fraction");
    }

    public static Fraction getFraction(String str) {
        Validate.notNull(str, "str", new Object[0]);
        if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        }
        int indexOf = str.indexOf(32);
        if (indexOf > 0) {
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            String substring = str.substring(indexOf + 1);
            int indexOf2 = substring.indexOf(47);
            if (indexOf2 >= 0) {
                return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
            }
            throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 < 0) {
            return getFraction(Integer.parseInt(str), 1);
        }
        return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
    }
}
