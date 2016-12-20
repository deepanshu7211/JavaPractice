package dp.dp_pz;

/**
 * Created by deepanshu.saxena on 15/07/16.
 */
public class PizzaBuilder {
    Pizza pizza = new Pizza();


    public PizzaBuilder withSize(Size size) {
        pizza.setSize(size);
        pizza.addToPrice(size.getCost());
        return this;

    }

    public PizzaBuilder withCrust(Crust crust) {
        pizza.setCrust(crust);
        pizza.addToPrice(crust.getCost());
        return this;
    }

    public PizzaBuilder withCheese(Cheese cheese) {
        pizza.setCheese(cheese);
        pizza.addToPrice(cheese.getCost());
        return this;
    }

    public Pizza build() {
        return pizza;
    }

    public int calculatedPrice() {
        return pizza.getTotalPrice();

    }
}
