package model.service;

import model.Food;

public class ShoppingCart {
    private final Food[] someFood;

    public ShoppingCart(Food[] someFood) {
        this.someFood = someFood;
    }

    public double getTotalPriceNoDiscount() {
        double total = 0;
        for (Food food : someFood) {
            total += food.getAmount() * food.getPrice();
        }
        return total;
    }

    public double getTotalPriceWithDiscount() {
        double total = 0;
        for (Food food : someFood) {
            double discount = food.getDiscount();
            double priceWithDiscount = food.getPrice() * (1 - discount);
            total += food.getAmount() * priceWithDiscount;
        }
        return total; // вот тут я страдал просто если честно
    }

    public double getTotalPriceVeganNoDiscount() {
        double total = 0;
        for (Food food : someFood) {
            if (food.isVegetarian()) {
                total += food.getAmount() * food.getPrice();
            }
        }
        return total;
    }
}
