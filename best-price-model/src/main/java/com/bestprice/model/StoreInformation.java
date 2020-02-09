package com.bestprice.model;

public class StoreInformation {
    private int storeId;
    private final String storeName;
    private long phone;
    private final String emailInfo;
    private int quantityAvailable;

    private StoreInformation(StoreInformationBuilder storeInformationBuilder) {
        this.storeName = storeInformationBuilder.storeName;
        this.phone = storeInformationBuilder.phone;
        this.emailInfo = storeInformationBuilder.emailInfo;
        this.quantityAvailable = storeInformationBuilder.quantityAvailable;
        this.phone = storeInformationBuilder.phone;
    }

    public String getStoreName() {
        return storeName;
    }

    public long getPhone() {
        return phone;
    }

    public String getEmailInfo() {
        return emailInfo;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }


    public static class StoreInformationBuilder {
        private final String storeName;
        private long phone;
        private String emailInfo;
        private int quantityAvailable;
        private int storeId;

        public StoreInformationBuilder(final String storeName, final int storeId) {
            this.storeName = storeName;
            this.storeId = storeId;
        }

        public StoreInformationBuilder emailInfo(String emailInfo) {
            this.emailInfo = emailInfo;
            return this;
        }
        public StoreInformationBuilder quantityAvailable(int quantityAvailable) {
            this.quantityAvailable = quantityAvailable;
            return this;
        }

        public StoreInformationBuilder phone(long phone) {
            this.phone = phone;
            return this;
        }

        public StoreInformation build() {
            StoreInformation storeInformation = new StoreInformation(this);
            return storeInformation;
        }
    }
}
