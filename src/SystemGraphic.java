import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

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
        Text txt = new Text("test");
        for (Entity entity: entites) {
            for (Component component: entity.getComponents()) {
                if(component instanceof IGraphicComponent){
                    ((IGraphicComponent) component).getFigure().setOnMousePressed(new EventHandler<MouseEvent>(){
                        public void handle(MouseEvent me){
                            ((IGraphicComponent) component).onClick();
                        }
                    });

                    ((IGraphicComponent) component).getFigure().setOnMouseReleased(new EventHandler<MouseEvent>(){
                        public void handle(MouseEvent me){
                            ((IGraphicComponent) component).onClickRelease();
                        }
                    });


                        stack.getChildren().add(((IGraphicComponent) component).getFigure());
                        stack.getChildren().add(((IGraphicComponent) component).getText());


                }
            }
        }
        return stack;
    }
}
