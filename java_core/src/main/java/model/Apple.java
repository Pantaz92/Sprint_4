package model;

import static model.constants.Colour.COLOUR_RED;
import static model.constants.Discount.SIXTY_PERCENT_DISCOUNT;
import static model.constants.Discount.ZERO_PERCENT_DISCOUNT;

public class Apple extends Food {
    private final String colour;

    public Apple(int amount, double price, String colour) {
        super(amount, price);
        this.colour = colour;
        this.isVegetarian = true;
    }

    @Override
    public double getDiscount() {
        if (colour.equals(COLOUR_RED)) {
            return SIXTY_PERCENT_DISCOUNT;
        }
        return ZERO_PERCENT_DISCOUNT;
    }
}
