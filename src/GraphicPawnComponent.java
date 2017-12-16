import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class GraphicPawnComponent extends Component implements IGraphicComponent {

    Circle pawnShape;
    Color color;
    int radius;
    int centerX;
    int centerY;

    public GraphicPawnComponent(Entity entity, int x, int y, int pawnRad, Color pawnCol){
        super(entity);
        this.centerX = x;
        this.centerY = y;
        this.radius = pawnRad;
        this.color = pawnCol;

        pawnShape = new Circle();
        pawnShape.setRadius(radius);
        pawnShape.setFill(color);
        pawnShape.setCenterX(centerX);
        pawnShape.setCenterY(centerY);
    }

    public void ChangeOrigin(int x , int y){
        this.centerX = x;
        this.centerY = y;
        pawnShape.setCenterX(x);
        pawnShape.setCenterY(y);
    }

    public void ChangeSize(int Radius){
        this.radius = Radius;
        pawnShape.setRadius(Radius);
    }

    public void ChangeColor(Color color){
        this.color = color;
        pawnShape.setFill(color);
    }

    @Override
    public Shape getFigure() {
        return pawnShape;
    }

    @Override
    public void onClick() {
        System.out.println("Pawn click");
        // if the pawn is not visible, i.e. not placed by a player
        if(color == Color.TRANSPARENT) {
            ((Pawn) entity).getParentCase().getGraphicComponent().onClick();
        }
        else {
            // TO DO: click on placed pawn?
        }
    }
}
