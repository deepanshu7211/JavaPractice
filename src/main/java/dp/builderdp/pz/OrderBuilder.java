package dp.builderdp.pz;

/**
 * Created by deepanshu.saxena on 24/02/16.
 */
public class OrderBuilder {

    public OrderedItems buildPizza() {
        OrderedItems orderedItems = new OrderedItems();
        orderedItems.addItem(new SmallCheezePizza());
        orderedItems.addItem(new MediumCheezePizza());
        orderedItems.addItem(new SmallPepsi());

        return orderedItems;
    }
}
