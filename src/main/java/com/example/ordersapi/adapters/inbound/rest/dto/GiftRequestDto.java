package com.example.ordersapi.adapters.inbound.rest.dto;

public class GiftRequestDto {

    private String product;
    private int quantity;
    private String description;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description){this.description = description;}

    public String getDescription() {return description;}
}
