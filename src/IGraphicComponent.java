import javafx.scene.shape.Shape;

public interface IGraphicComponent {
    public Shape getFigure();
    default void onClick() {
        System.out.println("Default click");
    };



    default void onClickRelease(){
        //do nothing
    };

}
