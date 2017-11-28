import static java.lang.Thread.sleep;
public class Main {


    public static void main(String[] args) {
        int desiredRate = 60;
        double timeNeeded = 1000000000/desiredRate;
        ISystem[] systems = {new SystemLogic()};
        Entity test = new Entity();
        Entity[] entities = {test};

        entities[0].getComponents().add(new HelloWorldComponent(test));
        while(true){ // Loop game
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
