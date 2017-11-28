public class Main {

    public static void main(String[] args) {
        ISystem[] systems = {new SystemLogic()};
        Entity test = new Entity();
        Entity[] entities = {test};

        entities[0].getComponents().add(new HelloWorldComponent(test));
        while(true){ // Loop game
            for (ISystem system: systems) {
                system.iterate(entities);
            }
        }
    }
}
