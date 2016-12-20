package binding_annot;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */
public class PlayerModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(Player.class).annotatedWith(Good.class).to(Gplayer.class);
        binder.bind(Player.class).annotatedWith(Bad.class).to(BPlayer.class);
    }
}
