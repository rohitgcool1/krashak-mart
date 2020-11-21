package com.minorproject.krashakmart.model;

public class WishlistModel {

    private int productimage;
    private String producttitle;
    private String rating;
    private int totalRating;
    private String productprice;
    private String paymntAvailable;

    public WishlistModel(int productimage, String producttitle, String rating, int totalRating, String productprice, String paymntAvailable) {
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.rating = rating;
        this.totalRating = totalRating;
        this.productprice = productprice;
        this.paymntAvailable = paymntAvailable;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getPaymntAvailable() {
        return paymntAvailable;
    }

    public void setPaymntAvailable(String paymntAvailable) {
        this.paymntAvailable = paymntAvailable;
    }
}
