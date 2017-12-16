import javafx.scene.shape.Shape;

public class GraphicPawnComponent extends Component implements IGraphicComponent{
    public GraphicPawnComponent(Entity entity) {
        super(entity);
    }

    @Override
    public Shape getFigure() {
        return null;
    }
}
