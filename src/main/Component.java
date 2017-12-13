package main;

abstract class Component {
    public Entity entity;

    public Component(Entity entity) {
        this.entity = entity;
    }
}
