import javafx.scene.shape.Shape;

public interface IGraphicComponent {
    Shape getFigure();
    default void onClick() {
        System.out.println("Default click");
    };
}
