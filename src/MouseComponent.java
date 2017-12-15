import javafx.event.EventHandler;

import java.awt.event.MouseEvent;

public class MouseComponent extends Component implements ILogicComponent{
    public MouseComponent(Entity entity) {
        super(entity);
    }

    @Override
    public void update() {
        // enité on getcomponent if Systeam grpahique; graphique.getfigure.setOnmoupressed 
        entity.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                //appuyer();
            }
        });
    }
}
