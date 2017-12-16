import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class SystemInput implements ISystem {

    GameController gameController;

    public SystemInput(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void iterate(List<Entity> entities) {
        for (Entity entity: entities) {
            for (Component component: entity.getComponents()) {
                if(component instanceof IInputComponent){
                    if(((IInputComponent) component).isClicked()) {
                        if(entity instanceof Case) {
                            ((Case) entity).getPawn().getGraphicComponent().ChangeColor(gameController.getLogicComponent().playerSide);
                        }
                    }
                }
            }
        }
    }
}
