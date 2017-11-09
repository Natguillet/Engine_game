import java.util.ArrayList;

public class Entity {
    private ArrayList<Component> components = new ArrayList<>();
    private ArrayList<Entity> children = new ArrayList<>();

    public ArrayList<Component> getComponents() {
        return components;
    }

}

