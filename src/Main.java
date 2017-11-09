import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Test test = new Test("test");
        Entity entity = new Entity();
        entity.getComponents().add(test);
        while(true){ // Loop game
            for (Component component: entity.getComponents()) {
                if(component instanceof ILogicComponent){
                    ((ILogicComponent) component).update();
                }
            }
        }
    }
}
