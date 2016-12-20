package dp.builderdp.pz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu.saxena on 24/02/16.
 */
public class OrderedItems {
    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public int cost() {
        int cost = 0;
        for (Item item : itemList) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : itemList) {
            System.out.print("Item is:" + item.name());
            System.out.print("Size is:" + item.size());
            System.out.println("Price is: " + item.price());
        }
    }
}
