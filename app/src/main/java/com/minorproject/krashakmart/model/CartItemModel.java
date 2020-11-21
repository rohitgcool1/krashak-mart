package com.minorproject.krashakmart.model;

public class CartItemModel {
    public static final int CART_ITEM=0;
    public static final int TOTAL_AMOUNT=1;

    private int type;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    ///cart item
    private int productImage;
    private String productTitle;
    private String productPrice;

    public CartItemModel(int type,int productImage,String productTitle,String productPrice) {
        this.type = type;
        this.productImage=productImage;
        this.productTitle=productTitle;
        this.productPrice=productPrice;
    }


    public int getProductImage() {
        return productImage;
    }
    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    ///cart item

    ///cart total amount
    private String totalitem_pice;
    private String totalAmount;

    public CartItemModel(int type, String totalitem_pice, String totalAmount) {
        this.type = type;
        this.totalitem_pice = totalitem_pice;
        this.totalAmount = totalAmount;

    }

    public String getTotalitem_pice() {
        return totalitem_pice;
    }

    public void setTotalitem_pice(String totalitem_pice) {
        this.totalitem_pice = totalitem_pice;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

///cart total amount




}
