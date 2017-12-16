import java.util.ArrayList;

public class Entity {
    private String name;
    private ArrayList<Component> components = new ArrayList<>();
    private ArrayList<Entity> children = new ArrayList<>();

    public Entity(String name) {
        this.name = name;
    }

    public ArrayList<Entity> getChildren() {
        return children;
    }

    public int componentNumber(){
        return components.size();
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public String getName() {
        return name;
    }
}

