package com.bestprice.model;

public class StoreByPrice {
    private StoreInformation storeInformation;
    private int price;

    public StoreByPrice(StoreInformation storeInformation, int price) {
        this.storeInformation = storeInformation;
        this.price = price;
    }

    public StoreInformation getStoreInformation() {
        return storeInformation;
    }

    public int getPrice() {
        return price;
    }
}
