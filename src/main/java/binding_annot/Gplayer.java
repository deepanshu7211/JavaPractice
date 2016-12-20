package binding_annot;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */
public class Gplayer implements Player {
    @Override
    public void bat() {
        System.out.println("bat gplayer");
    }

    @Override
    public void ball() {
        System.out.println("ball gplayer");
    }
}
