import java.util.Iterator;

public class Case extends Entity {

    int idX;
    int idY;

    public Case(String name, int x, int y) {
        super(name);
        this.idX = x;
        this.idY = y;
    }

    public GraphicCaseComponent getGraphicComponent() {

        for(Component it : getComponents()) {
            if(it instanceof GraphicCaseComponent) {
                return (GraphicCaseComponent) it;
            }
        }

        /*
        GraphicCaseComponent component = null;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicCaseComponent) {
                component = (GraphicCaseComponent) tmp;
                found = true;
            }
        }

        return component;
        */
        return null;
    }

    public GameCaseComponent getLogicComponent() {

        GameCaseComponent component = null;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GameCaseComponent) {
                component = (GameCaseComponent) tmp;
                found = true;
            }
        }

        return component;
    }

    public InputCaseComponent getInputComponent() {

        for(Component it : getComponents()) {
            if(it instanceof InputCaseComponent) {
                return (InputCaseComponent) it;
            }
        }
        /*
        InputCaseComponent component = null;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof InputCaseComponent) {
                component = (InputCaseComponent) tmp;
                found = true;
            }
        }

        return component; */
        return null;
    }

    public Pawn getPawn() {

        for(Entity it : getChildren()) {
            if(it instanceof Pawn) {
                return (Pawn) it;
            }
        }
        /*
        Pawn pawn = null;
        boolean found = false;
        Iterator<Entity> entityIt = getChildren().iterator();

        while(entityIt.hasNext() && !found) {
            Entity tmp = entityIt.next();
            if(tmp instanceof Pawn) {
                pawn = (Pawn) tmp;
                found = true;
            }
        }

        return pawn;
        */
        return null;
    }

    public int getHeight() {
        return getGraphicComponent().getCaseHeight();
    }

    public int getWidth() {
        return getGraphicComponent().getCaseWidth();
    }

    public int getCaseMinDimension() {
        GraphicCaseComponent component = getGraphicComponent();
        return java.lang.Math.min(component.getCaseHeight(), component.getCaseWidth());
    }

    public int getPosX() {
        return getGraphicComponent().getPosX();
    }

    public int getPosY() {
        return getGraphicComponent().getPosY();
    }
}
