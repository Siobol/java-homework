package org.vistula.basket;

public class BasketItem {

    private float price;
    private boolean ageRestrictedItem;

    public BasketItem(float price, boolean ageRestrictedItem) {
        this.price = price;
        this.ageRestrictedItem = ageRestrictedItem;
    }

    protected BasketItem() {
    }

    public float getPrice() {
        return price;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    public boolean isAgeRestrictedItem() {
        return ageRestrictedItem;
    }

    public void setAgeRestrictedItem(boolean ageRestrictedItem) {
        this.ageRestrictedItem = ageRestrictedItem;
    }

    @Override
    public String toString() {
        return price + " name of the item; ";
    }
}