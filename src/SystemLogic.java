
import java.util.List;

public class SystemLogic implements ISystem {
    @Override
    public void iterate(List<Entity> entites) {
        for (Entity entity: entites) {
            for (Component component: entity.getComponents()) {
                if(component instanceof ILogicComponent){
                    ((ILogicComponent) component).update();
                }
            }
        }
    }
}
