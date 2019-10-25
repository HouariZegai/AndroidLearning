package com.houarizegai.listviewproducts.model;

public class Product {
    private String name;
    private String cost;
    private int img;

    public Product(String name, String cost, int img) {
        this.name = name;
        this.cost = cost;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
