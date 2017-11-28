import java.util.ArrayList;
import java.util.Timer;

import static java.lang.Thread.sleep;


public class Main {


    public static void main(String[] args) {
        int desiredRate = 60;
        double timeNeeded = 1000000000/desiredRate;


        Test test = new Test("test");


        Entity entity = new Entity();
        entity.getComponents().add(test);
        while(true){ // Loop game
            double startLoopTime = java.lang.System.nanoTime();
            for (Component component: entity.getComponents()) {
                if(component instanceof ILogicComponent){
                    ((ILogicComponent) component).update();
                }
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
