package org.example.entity;

public class ShareholderBrand {
    private int shareholder;
    private int brandId;

    public ShareholderBrand(int shareholder, int brandId) {
        this.shareholder = shareholder;
        this.brandId = brandId;
    }

    public int getShareholder() {
        return shareholder;
    }

    public void setShareholder(int shareholder) {
        this.shareholder = shareholder;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
