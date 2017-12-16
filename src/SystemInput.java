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
        ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();
        for (Entity entity: entities) {
            for (Component component: entity.getComponents()) {
                if(component instanceof IInputComponent){
                    if(((IInputComponent) component).isClicked()) {
                        if(entity instanceof Case) {
                            if(!((Case) entity).hasPawn()) {
                                Color playerPawnColor = Color.DARKBLUE; // TO DO: get current player's pawn color
                                Pawn aPawn = new Pawn("pawn_" + currentPlayer, currentPlayer);
                                aPawn.getComponents().add(new GraphicPawnComponent(aPawn, ((Case) entity).getPosX() + ((Case) entity).getHeight() / 2, ((Case) entity).getPosY() + ((Case) entity).getWidth() / 2, ((Case) entity).getCaseMinDimension() / 2 - 1, playerPawnColor));
                                // TO DO: InputPawnComponent?
                                ((Case) entity).addPawn(currentPlayer);
                                entitiesToAdd.add(aPawn);
                            }
                        }
                    }
                    if(((IInputComponent) component).isDragged()) {
                        // TO DO WHEN USER DRAG ON ENTITY
                    }
                }
            }
        }
        entities.addAll(entitiesToAdd);

        if(currentPlayer < nbPlayers - 2)
            currentPlayer++;
        else
            currentPlayer = 0;
    }
}
