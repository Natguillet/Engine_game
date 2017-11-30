package main.entityFolder;

public class Case extends main.Entity{

    //numéro de la case dans le plateau
    int numberCaseX;
    int numberCaseY;
    //un pion peut aller sur cette case
    boolean playable;
    //numerote les cases
    int numberGameCase;

    public Case(int x, int y, boolean playable, int numberGameCase){
        numberCaseX = x;
        numberCaseY = y;
       this.playable = playable;
       this.numberGameCase = numberGameCase;
    }
}
