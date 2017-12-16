public class GameOver extends Entity{
    public GameOver(String name) {
        super(name);
    }

    public GraphicGameOverComponent getGraphicComponent() {

        for(Component it : getComponents()) {
            if(it instanceof GraphicGameOverComponent) {
                return (GraphicGameOverComponent) it;
            }
        }
        return null;
    }
}
