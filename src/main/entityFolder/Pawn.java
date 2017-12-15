package main.entityFolder;

import javafx.scene.Group;
import main.Graphic.GraphicCase;
import main.Graphic.GraphicPawn;
import javafx.scene.paint.Color;
import java.lang.Math;

public class Pawn extends main.Entity {

    int numCase;
    GraphicPawn graphic;

    public GraphicPawn getGraphic() {
        return graphic;
    }

    public Pawn(Case spawnCase, Color pawnColor, Group board) {
        this.numCase = spawnCase.getNumberCase();

        // Initialisation de la partie graphique
        GraphicCase graphicCase = spawnCase.getGraphic();
        int height = graphicCase.getHeight();
        int width = graphicCase.getWidth();
        int radius = java.lang.Math.min(height, width) - 1;
        graphic = new GraphicPawn(graphicCase.getPosX() + height / 2, graphicCase.getPosY() + width / 2, radius, pawnColor);
        board.getChildren().add(graphic);
    }

    public int getNumCase() {
        return numCase;
    }
}
