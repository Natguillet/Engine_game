import javafx.scene.paint.Color;

public class PlayerComponent extends Component{


    public PlayerComponent(Entity entity, Color color) {
        super(entity);
        number++;
    }

    private int points = 0;
    private int name;
    private Color color;
    private static int number = 0;


    public int getPoint() {
        return points;
    }

    public void setPoint(int point) {
        this.points = points;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
