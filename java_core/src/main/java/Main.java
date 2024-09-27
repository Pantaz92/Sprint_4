import model.Apple;
import model.Food;
import model.Meat;
import model.service.ShoppingCart;

import static model.constants.Colour.COLOUR_GREEN;
import static model.constants.Colour.COLOUR_RED;

public class Main {
    public static void main(String[] args) {
        Food meat = new Meat(5, 100);
        Food redApple = new Apple(10, 50, COLOUR_RED);
        Food greenApple = new Apple(8, 60, COLOUR_GREEN);

        Food[] someFood = {meat, redApple, greenApple};

        ShoppingCart cart = new ShoppingCart(someFood);
        double totalPriceWithNoDiscount = cart.getTotalPriceNoDiscount();
        double totalPriceWithDiscount = cart.getTotalPriceWithDiscount();
        double totalPriceVeganNoDiscount = cart.getTotalPriceVeganNoDiscount();

        System.out.printf("Общая сумма товаров без скидки: %.2f%n", totalPriceWithNoDiscount);
        System.out.printf("Общая сумма товаров со скидкой: %.2f%n", totalPriceWithDiscount);
        System.out.printf("общая сумма вегетарианских товаров без скидки: %.2f%n", totalPriceVeganNoDiscount);
    }
}
