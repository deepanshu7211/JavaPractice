package dp.strategy;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class DuckMain {
    public static void main(String[] args) {

        Duck duck = new MallardDuck();
        duck.display();
        duck.swim();
        duck.setFlyBehaviour(new FlyWithWings());
        duck.performFly();
        duck.setFlyBehaviour(new FlyWithNoWings());
        duck.performFly();

        duck.setQuackBehaviour(new MuteQuack());
        duck.performQuack();
    }
}
