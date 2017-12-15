package main.Graphic;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.ILogicComponent;

public class GraphicCase extends Parent implements ILogicComponent{

    int posX;
    int posY;
    int caseHeight;
    int caseWidth;
    Rectangle caseBack;
    Color color;


    public GraphicCase(int x , int y, int caseHeight, int caseWidth){
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

        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                appuyer();
            }
        });
        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getHeight() {
        return caseHeight;
    }

    public int getWidth() {
        return caseWidth;
    }

    public void appuyer(){
        caseBack.setFill(Color.RED);
        //ajout d'un pion

    }

    public void relacher(){
        caseBack.setFill(Color.GREY);

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
