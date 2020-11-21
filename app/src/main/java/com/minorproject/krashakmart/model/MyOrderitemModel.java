package com.minorproject.krashakmart.model;

public class MyOrderitemModel {
    private int productimage;
    private String producttitle;
    private String deliverystatus;
private int rating;

    public MyOrderitemModel(int productimage, String producttitle, String deliverystatus,int rating) {
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.deliverystatus = deliverystatus;
        this.rating=rating;
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

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
