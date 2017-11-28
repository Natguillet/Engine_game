public class SystemLogic implements ISystem {
    @Override
    public void iterate(Entity[] entites) {
        for (Entity entity: entites) {
            for (Component component: entity.getComponents()) {
                if(component instanceof ILogicComponent){
                    ((ILogicComponent) component).update();
                }
            }
        }
    }
}
