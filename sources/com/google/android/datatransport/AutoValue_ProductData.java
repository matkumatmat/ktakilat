package com.google.android.datatransport;

import androidx.annotation.Nullable;

final class AutoValue_ProductData extends ProductData {
    private final Integer productId;

    public AutoValue_ProductData(@Nullable Integer num) {
        this.productId = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductData)) {
            return false;
        }
        Integer num = this.productId;
        Integer productId2 = ((ProductData) obj).getProductId();
        if (num != null) {
            return num.equals(productId2);
        }
        if (productId2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public Integer getProductId() {
        return this.productId;
    }

    public int hashCode() {
        int i;
        Integer num = this.productId;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        return i ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.productId + "}";
    }
}
