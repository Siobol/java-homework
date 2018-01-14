package org.vistula.promoitem;

import org.vistula.basket.BasketItem;

public class PromoItem extends BasketItem {
    private float discount;

    public PromoItem(float price, boolean ageRestrictedItem, float discount) {
        super(price, ageRestrictedItem);
        this.setPrice(price - ((discount / 100) * price));
        this.discount = discount;
    }

    public PromoItem() {
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}