package main.Graphic;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GraphicCase extends Parent{

    int posX;
    int posY;
    int caseHeight;
    int caseWidth;
    Rectangle caseBack;
    Color color;


    public GraphicCase(int x , int y, int caseHeight, int caseWidth, Group root){
        this.posX = x;
        this.posY = y;
        this.caseHeight = caseHeight;
        this.caseWidth = caseWidth;
        this.color = Color.WHITE;

        caseBack = new Rectangle();
        caseBack.setWidth(caseWidth);
        caseBack.setHeight(caseHeight);
        caseBack.setFill(color);
        caseBack.setX(posX);
        caseBack.setY(posY);
        this.getChildren().add(caseBack);
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
