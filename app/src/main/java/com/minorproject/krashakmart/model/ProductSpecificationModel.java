package com.minorproject.krashakmart.model;

public class ProductSpecificationModel {

    public static final int specificationtitle=0;
    public static final int specificationbody=1;

    private int type;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    ///Specification title
    private String title;

    public ProductSpecificationModel(int type,String title) {
        this.type=type;
        this.title=title;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
///Specification title

    ///Specification body
    private String featurename;
    private String featurevalue;

    public ProductSpecificationModel(int type,String featurename,String featurevalue) {
        this.type=type;
        this.featurename = featurename;
        this.featurevalue=featurevalue;
    }
    public String getFeaturename() {
        return featurename;
    }
    public void setFeaturename(String featurename) {
        this.featurename = featurename;
    }
    public String getFeaturevalue() {
        return featurevalue;
    }
    public void setFeaturevalue(String featurevalue) {
        this.featurevalue = featurevalue;
    }

    ///Specification body
}
