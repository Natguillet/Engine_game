package main.entityFolder;

import javafx.scene.Group;
import main.Graphic.GraphicBoard;
import main.Graphic.GraphicCase;

public class Case extends main.Entity{

    //numéro de la case dans le plateau
    int numberCaseX;
    int numberCaseY;
    //un pion peut aller sur cette case
    boolean playable;
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
       graphic = new GraphicCase(posx, posy, caseHeight, caseWidth , board);
        board.getChildren().add(graphic);
    }

    public Case(int numberCasex, int numberCasey, boolean playable, int numberGameCase, Group board){
        this.numberCaseX = numberCasex;
        this.numberCaseY = numberCasey;
        this.playable = playable;
        this.numberGameCase = numberGameCase;
        graphic = new GraphicCase(5, 5,10,10, board );
        board.getChildren().add(graphic);
    }
}
