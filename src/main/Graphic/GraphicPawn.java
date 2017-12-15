package main.Graphic;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import main.ILogicComponent;

public class GraphicPawn extends Parent implements ILogicComponent {
    Circle pawnShape;
    Color color;
    int radius;
    int centerX;
    int centerY;

    public GraphicPawn(int x, int y, int pawnRad, Color pawnCol){
        this.centerX = x;
        this.centerY = y;
        this.radius = pawnRad;
        this.color = pawnCol;

        pawnShape = new Circle();
        pawnShape.setRadius(radius);
        pawnShape.setFill(color);
        pawnShape.setCenterX(centerX);
        pawnShape.setCenterY(centerY);

        this.getChildren().add(pawnShape);
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
}
