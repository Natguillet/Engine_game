package main.entityFolder;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import main.Graphic.GraphicBoard;
import main.Graphic.GraphicCase;
import main.entityFolder.Pawn;

public class Case extends main.Entity{

    //numéro de la case dans le plateau
    int numberCaseX;
    int numberCaseY;
    //un pion peut aller sur cette case
    boolean playable;
    // présence ou non d'un pion
    boolean pawnPlaced;
    Pawn pawn;
    //numerote les cases
    int numberGameCase;
    GraphicCase graphic;

    public GraphicCase getGraphic() {
        return graphic;
    }


    public Case(int numberCasex, int numberCasey, boolean playable, int numberGameCase , int posx, int posy, int caseHeight, int caseWidth, Group board){
        this.numberCaseX = numberCasex;
        this.numberCaseY = numberCasey;
        this.playable = playable;
        this.numberGameCase = numberGameCase;
        this.pawnPlaced = false;
        graphic = new GraphicCase(posx, posy, caseHeight, caseWidth);
        board.getChildren().add(graphic);

    }

    public Case(int numberCasex, int numberCasey, boolean playable, int numberGameCase, Group board){
        this.numberCaseX = numberCasex;
        this.numberCaseY = numberCasey;
        this.playable = playable;
        this.numberGameCase = numberGameCase;
        this.pawnPlaced = false;
        graphic = new GraphicCase(5, 5,10,10);
        board.getChildren().add(graphic);
    }

    public int getNumberCase() {
        return numberGameCase;
    }

    public boolean isPawnPlaced() {
        return pawnPlaced;
    }

    public void placePawn(Pawn pawn) {
        this.pawn = pawn;
        this.pawnPlaced = true;
    }

    public Pawn getPawn() {
        return pawn;
    }
}
