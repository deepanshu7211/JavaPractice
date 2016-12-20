package dp.strategy;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
abstract public class Duck {
    private FlyBehaviour flyBehaviour;

    private QuackBehaviour quackBehaviour;

    public abstract void swim();

    public abstract void display();

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
