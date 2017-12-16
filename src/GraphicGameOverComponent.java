import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;


public class GraphicGameOverComponent extends Component implements IGraphicComponent {

    int posX;
    int posY;
    int height;
    int width;
    Color color;
    boolean activate = true;

    Text text = new Text();

    public GraphicGameOverComponent(Entity entity, int posX, int posY, int height, int width) {
        super(entity);
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.color = Color.BLACK;
        text.setText("Win Text");

        if(!activate) text.setOpacity(0);
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void SetActive(boolean activate) {
        if(!activate) text.setOpacity(0);
    }

    @Override
    public Shape getFigure() {
        return text;
    }
}
