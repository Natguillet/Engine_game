import java.util.Iterator;

public class Board extends Entity {

    public Board(String name) {
        super(name);
    }

    public GraphicBoardComponent getGraphicComponent() {

        GraphicBoardComponent component = null;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicBoardComponent) {
                component = (GraphicBoardComponent) tmp;
                found = true;
            }
        }

        return component;
    }
}
