package dp.factory;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */

public class ShapeFactory {

    public static Shape getShape(String type) {
        if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (type.equalsIgnoreCase("square")) {
            return new Square();
        } else {
            return null;
        }
    }
}
