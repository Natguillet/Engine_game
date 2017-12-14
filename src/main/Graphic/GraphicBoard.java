package main.Graphic;


import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.ILogicComponent;

public class GraphicBoard extends Parent implements ILogicComponent{

    Rectangle fondBoard;
    Color color;
    int Width;
    int Height;
    int originX;
    int originY;

    public GraphicBoard(int x , int y, Group root){
        fondBoard = new Rectangle();
        color = Color.BLACK;
        Width = x;
        Height = y;
        originX = 50;
        originY = 50;

        fondBoard.setWidth(Width);
        fondBoard.setHeight(Height);
        fondBoard.setFill(color);


        fondBoard.setX(originX);
        fondBoard.setY(originY);
        this.getChildren().add(fondBoard);
    }

    public void ChangeOrigin(int x , int y){
        this.originX = x;
        this.originY = y;
        fondBoard.setX(x);
        fondBoard.setY(y);
    }

    public void ChangeSize(int Width, int Height){
        this.Width = Width;
        this.Height = Height;
        fondBoard.setWidth(Width);
        fondBoard.setHeight(Height);
    }

    public void ChangeColor(Color color){
        this.color = color;
        fondBoard.setFill(color);
    }

    @Override
    public void update(){

    }
}
