package dp.factory;

/**
 * Created by deepanshu.saxena on 04/06/16.
 */
public class Client {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("square");
        shape.draw();
    }
}
