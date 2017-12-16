import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Iterator;


public class GraphicCaseComponent extends Component implements IGraphicComponent {

    int posX;
    int posY;
    int caseHeight;
    int caseWidth;
    Rectangle caseBack;
    Color color;

    public GraphicCaseComponent(Entity entity, int x, int y, int caseHeight, int caseWidth) {
        super(entity);
        this.posX = x;
        this.posY = y;
        this.caseHeight = caseHeight;
        this.caseWidth = caseWidth;
        this.color = Color.WHITE;

        caseBack = new Rectangle();
        caseBack.setWidth(caseWidth);
        caseBack.setHeight(caseHeight);
        caseBack.setFill(color);
        caseBack.setStroke(Color.BLACK);
        caseBack.setStrokeWidth(4);

        caseBack.setX(posX);
        caseBack.setY(posY);
    }

    @Override
    public void onClick() {
        System.out.println("Case click");
        //caseBack.setFill(Color.RED);

        ((Case) entity).getInputComponent().Click();
    }

    @Override
    public void onClickRelease(){
        //caseBack.setFill(Color.WHITE);
    }


    @Override
    public Shape getFigure() {
        return caseBack;
    }

    public int getCaseHeight() {
        return caseHeight;
    }

    public int getCaseWidth() {
        return caseWidth;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void ChangeOrigin(int x , int y){
        this.posX = x;
        this.posY = y;
        caseBack.setX(x);
        caseBack.setY(y);
    }

    public void ChangeSize(int Width, int Height){
        this.caseWidth = Width;
        this.caseHeight = Height;
        caseBack.setWidth(Width);
        caseBack.setHeight(Height);
    }

    public void ChangeColor(Color color){
        this.color = color;
        caseBack.setFill(color);
    }
}
