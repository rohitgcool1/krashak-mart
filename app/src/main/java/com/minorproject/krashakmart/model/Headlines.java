package com.minorproject.krashakmart.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Headlines {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResults")
    @Expose
    private String totalResults;

    @SerializedName("articles")
    @Expose
    private List<com.minorproject.krashakmart.model.Articles> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<com.minorproject.krashakmart.model.Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<com.minorproject.krashakmart.model.Articles> articles) {
        this.articles = articles;
    }
}

