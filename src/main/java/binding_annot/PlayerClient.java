package binding_annot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Created by deepanshu.saxena on 28/10/15.
 */
public class PlayerClient {
    public static void main(String[] args) {
        PlayerModule playerModule = new PlayerModule();
        Injector injector = Guice.createInjector(new Module[]{playerModule});
        @Good Player player = (Player) injector.getInstance(Player.class);
        player.bat();
        player.ball();
    }
}
