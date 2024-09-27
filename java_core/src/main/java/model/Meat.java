package model;

import static model.constants.Discount.ZERO_PERCENT_DISCOUNT;

public class Meat extends Food {

    public Meat(int amount, double price) {
        super(amount, price);
        this.isVegetarian = false;
    }

    @Override
    public double getDiscount() {
        return ZERO_PERCENT_DISCOUNT;
    }
}
