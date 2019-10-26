package com.houarizegai.spinnerdemo.model;

public class Product {
    private String name;
    private String details;
    private int img;

    public Product(String name, String details, int img) {
        this.name = name;
        this.details = details;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
