import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class SystemInput implements ISystem {

    int nbPlayers;
    int currentPlayer;

    public SystemInput(int nbPlayers) {
        this.nbPlayers = nbPlayers;
        this.currentPlayer = 0;
    }

    @Override
    public void iterate(List<Entity> entities) {
        for (Entity entity: entities) {
            for (Component component: entity.getComponents()) {
                if(component instanceof IInputComponent){
                    if(((IInputComponent) component).isClicked()) {
                        if(entity instanceof Case) {
                            ((Case) entity).getGraphicComponent().ChangeColor(getPlayerPawnColor());
                        }
                    }
                }
            }
        }

        // update the current player
        if(currentPlayer < nbPlayers - 1)
            currentPlayer++;
        else
            currentPlayer = 0;
    }

    public Color getPlayerPawnColor() {

        // TO DO when player entity implemented: get current player's pawn color from entities

        return Color.DARKBLUE;
    }
}
