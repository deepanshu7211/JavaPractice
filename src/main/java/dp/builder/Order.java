package dp.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class Order {
    private List<Item> itemList;

    public Order() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public int totalCost() {
        int total = 0;
        for (Item item : itemList) {
            total = total + item.cost();
        }

        return total;
    }

    public void showItems() {
        for (Item item : itemList) {
            System.out.println(item.name() + "  " + item.cost() + "  ");
            System.out.println(" \n ");
        }
    }
}
