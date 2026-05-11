package com.ecom_project.shopify.dto;

import com.ecom_project.shopify.util.Category;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private String name;
    private Integer price;
    private boolean available;
    private Category category;
    private String description;

    public ProductDTO(String name, Integer price, boolean available, Category category, String description) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.category = category;
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", description='" + description + '\'' +
                '}';
    }
}
