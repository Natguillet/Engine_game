import java.util.Iterator;

public class GameController extends Entity {
    public GameController(String name) {
        super(name);
    }

    public GameControllerComponent getLogicComponent() {
        for(Component it : getComponents()) {
            if(it instanceof GameControllerComponent) {
                return (GameControllerComponent) it;
            }
        }
        return null;
    }
}
