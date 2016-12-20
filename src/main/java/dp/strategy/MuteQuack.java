package dp.strategy;

/**
 * Created by deepanshu.saxena on 03/06/16.
 */
public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Mute Quack... ");
    }
}
