package com.company.model;

import java.util.Date;

public class ProductModel {

    private long id;
    private ProductTypes type;
    private Date date;
    private double price;

    public ProductModel(ProductTypes type, double price) {
        this.type = type;
        this.price = price;
    }

    public ProductModel(long id, ProductTypes type, Date date, double price) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductTypes getType() {
        return type;
    }

    public void setType(ProductTypes type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
