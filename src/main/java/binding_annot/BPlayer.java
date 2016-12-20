package binding_annot;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */

public class BPlayer implements Player {
    @Override
    public void bat() {
        System.out.println("bat bplayer");
    }

    @Override
    public void ball() {
        System.out.println("ball bplayer");
    }
}
