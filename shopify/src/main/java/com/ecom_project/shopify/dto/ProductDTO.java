package com.ecom_project.shopify.dto;

public class ProductDTO {
    private String name;
    private Integer price;
    private boolean available;
    private String description;

    public ProductDTO(String name, Integer price, boolean available, String description) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.description = description;
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
