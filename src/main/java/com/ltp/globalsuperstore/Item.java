package com.ltp.globalsuperstore;

import java.util.Date;
import java.util.UUID;

public class Item {
    private String category;
    private String name;
    private String price;
    private String discount;
    private String orderDate;

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Item(){
        this.id = UUID.randomUUID().toString();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

