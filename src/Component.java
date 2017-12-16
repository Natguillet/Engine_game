abstract class Component {
    public Entity entity;

    public Component(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
