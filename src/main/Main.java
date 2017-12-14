package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import main.entityFolder.Board;

import static java.lang.Thread.sleep;
public class Main {

	public static boolean exit = false;

    static void InsideStart(Group root){

        Board board = new Board(3,3,600,600, root);
        board.getGraphic().ChangeColor(Color.BLUE); // change la couleur du plateau
        board.changeAllCaseColor(Color.GREY); //change la couleur des cases
    }

    public static void main(String[] args) {
        int desiredRate = 60;
        double timeNeeded = 1000000000/desiredRate;
        ISystem[] systems = {new SystemLogic()};
        Entity test = new Entity();
        Entity[] entities = {test};
        
        //a mettre dans une autre thread
       SystemGraphic.startApp(args);
        entities[0].getComponents().add(new HelloWorldComponent(test));

        
        while(!exit){ // Loop game
            double startLoopTime = java.lang.System.nanoTime();
            for (ISystem system: systems) {
                system.iterate(entities);
            }

            //fin de update/renderer/autre
            double endLoopTime = java.lang.System.nanoTime() - startLoopTime;
            while (timeNeeded - endLoopTime > 0) {
                Thread.yield();
                endLoopTime = java.lang.System.nanoTime();
            }
        }
    }
}
