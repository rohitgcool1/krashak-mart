package com.minorproject.krashakmart.model;

import java.util.List;

public class HomePageModel {
    public static final int HORIZONTAL_PRODUCT_VIEW =0;
    public static final int GRID_PRODUCT_VIEW =1;

    private int type;

    public int getType() {
        return type;
    }

    ///Horizontal product layout & Grid product layout
    private String title;
    private List<ProductModel> productModelList;

    public HomePageModel(int type,String title,List<ProductModel> productModelList) {
        this.type=type;
        this.title=title;
        this.productModelList=productModelList;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<ProductModel> getProductModelList() {
        return productModelList;
    }
    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

   ///Horizontal product layout & Grid product layout


}
