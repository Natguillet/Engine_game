package main.entityFolder;

public class Board extends main.Entity {

    Case[][] board;
    public Board(int nbCaseX , int nbCaseY){
        super();
        board = new Case[nbCaseX][nbCaseY];

        //Initialisation of board
        int k = 0;
        for(int i = 0; i < nbCaseX; i++){
            for(int j = 0; j < nbCaseY; j++){
                board[i][j] = new Case(i, j ,true, k);
                k++;
            }
        }

    }
}
