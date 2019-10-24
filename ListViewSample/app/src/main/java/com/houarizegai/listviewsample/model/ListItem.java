package com.houarizegai.listviewsample.model;

public class ListItem {
    private String name;
    private String description;

    public ListItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String
    toString() {
        return "ListItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
