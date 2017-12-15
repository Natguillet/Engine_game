package main.entityFolder;

import javafx.scene.paint.Color;
import main.Graphic.GraphicBoard;
import javafx.scene.Group;

public class Board extends main.Entity {

    Case[][] board;
    int height;
    int width;
    GraphicBoard graphic;

    public GraphicBoard getGraphic() {
        return graphic;
    }



    public Board(int nbCaseX , int nbCaseY, int width, int height, Group root){
        super();
        board = new Case[nbCaseX][nbCaseY];
        this.height = height;
        this.width = width;

        //Initialisation de la partie graphique
        graphic = new GraphicBoard(width, height);
        root.getChildren().add(graphic);

        //Initialisation of board
        int k = 0;
        int posx = 50;
        for(int i = 0; i < nbCaseX; i++){
            int posy = 50;
            for(int j = 0; j < nbCaseY; j++){
                board[i][j] = new Case(i, j ,true, k,  posx,  posy,  height/nbCaseY, width/nbCaseX, root);
                k++;
                posy = posy + height/nbCaseY;
            }
            posx = posx + width/nbCaseX;
        }


    }
    public void changeCaseColor(int Casex, int Casey, Color color){
        board[Casex][Casey].getGraphic().ChangeColor(color);
    }

    public void changeCaseSize(int Casex, int Casey, int x, int y){
        board[Casex][Casey].getGraphic().ChangeSize(x,y);
    }

    public void changeCaseOrigin(int Casex, int Casey, int x, int y){
        board[Casex][Casey].getGraphic().ChangeOrigin(x,y);
    }

    public void changeAllCaseColor(Color color){
        for(Case[] cases : board){
            for (Case item : cases){
                item.getGraphic().ChangeColor(color);
            }
        }
    }

    public void changeAllCaseSize(int x, int y){
        for(Case[] cases : board){
            for (Case item : cases){
                item.getGraphic().ChangeSize(x,y);
            }
        }
    }

    public void changeAllCaseOrigin(int x, int y){
        for(Case[] cases : board){
            for (Case item : cases){
                item.getGraphic().ChangeOrigin(x, y);
            }
        }
    }
}
