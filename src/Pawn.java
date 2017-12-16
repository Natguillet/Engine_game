import java.util.Iterator;

public class Pawn extends Entity {

    Case parentCase;

    public Pawn(String name, Case parent) {
        super(name);
        this.parentCase = parent;
    }

    public GraphicPawnComponent getGraphicComponent() {

        GraphicPawnComponent component = null;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicPawnComponent) {
                component = (GraphicPawnComponent) tmp;
                found = true;
            }
        }

        return component;
    }

    public Case getParentCase() {
        return this.parentCase;
    }

}
