import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class GraphicGameOverComponent extends Component implements IGraphicComponent {

    int posX;
    int posY;
    int height;
    int width;
    Color color;
    boolean activate = true;

    Text text = new Text();

    public GraphicGameOverComponent(Entity entity, int posX, int posY) {
        super(entity);
        this.posX = posX;
        this.posY = posY;
        this.color = Color.BLACK;

        text.setX(posX);
        text.setY(posY);
        text.setText("");
        text.setFont(Font.font ("Verdana", 80));
        text.setFill(color);

        if(!activate) text.setOpacity(0);
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public Text getTextGameOver() {
        return text;
    }

    public void setActive(boolean activate) {
        this.activate = activate;
        if(!activate) text.setOpacity(0);
        else text.setOpacity(100);
    }

    @Override
    public Shape getFigure() {
        return text;
    }
}
