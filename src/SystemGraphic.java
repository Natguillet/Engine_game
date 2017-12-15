import javafx.scene.layout.StackPane;
import java.util.List;

public class SystemGraphic implements ISystem{


    @Override
    public void iterate(List<Entity> entites) {
        for (Entity entity: entites) {
            for (Component component: entity.getComponents()) {
                if(component instanceof IGraphicComponent){
                    ((IGraphicComponent) component).getFigure();
                }
            }
        }
    }

    public StackPane init(List<Entity> entites) {
        StackPane stack = new StackPane();
        for (Entity entity: entites) {
            for (Component component: entity.getComponents()) {
                if(component instanceof IGraphicComponent){
                    System.out.println(component);
                    stack.getChildren().add(((IGraphicComponent) component).getFigure());
                }
            }
        }
        System.out.println(stack.getChildren());
        return stack;
    }
}
