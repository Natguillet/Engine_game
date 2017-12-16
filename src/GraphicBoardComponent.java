import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class GraphicBoardComponent extends Component implements IGraphicComponent{

    Rectangle fondBoard;
    Color color;
    int width;
    int height;
    int originX;
    int originY;

    public GraphicBoardComponent(Entity entity, int width, int height) {
        super(entity);
        fondBoard = new Rectangle();
        color = Color.BLACK;
        this.width = width;
        this.height = height;
        originX = 50;
        originY = 50;

        fondBoard.setWidth(width);
        fondBoard.setHeight(height);
        fondBoard.setFill(color);

        fondBoard.setX(originX);
        fondBoard.setY(originY);
    }

    public void ChangeOrigin(int x , int y){
        this.originX = x;
        this.originY = y;
        fondBoard.setX(x);
        fondBoard.setY(y);
    }

    public void ChangeSize(int Width, int Height){
        this.width = Width;
        this.height = Height;
        fondBoard.setWidth(Width);
        fondBoard.setHeight(Height);
    }

    public void ChangeColor(Color color){
        this.color = color;
        fondBoard.setFill(color);
    }

    @Override
    public void onClick() {
        System.out.println("Board click");
    }

    @Override
    public Shape getFigure() {
        return fondBoard;
    }
}
