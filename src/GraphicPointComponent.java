import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class GraphicPointComponent extends Component implements IGraphicComponent{

    Rectangle caseBack;
    int posx;
    int posy;
    Label text;
    //Label text;

    public GraphicPointComponent(Entity entity,int x, int y , int point) {
        super(entity);
        this.posx = x;
        this.posy = y;

        caseBack = new Rectangle();
        caseBack.setX(x);
        caseBack.setY(y);
        caseBack.setWidth(60);
        caseBack.setHeight(40);
        caseBack.setFill(Color.WHITE);
        caseBack.setAccessibleText("Points : " + point);
        text = new Label("Points : " + point);
       text.setTranslateX(x);
       text.setTranslateY(y);
       // text = new Label("point " + point);

    }

    @Override
    public Shape getFigure() {
        return caseBack;
    }

    @Override
    public Label getText(){
        return text;
    }

    public void setText(Label label){
        text = label;
    }
}
