package com.minorproject.krashakmart.model;

public class Agri_machineModel {
    private int icon;
    private String name;

    public Agri_machineModel(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
