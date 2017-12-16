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

        return component;
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
