import javafx.scene.control.Label;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public interface IGraphicComponent {
    Shape getFigure();

    default Label getText(){
        Label t= new Label("");
        return t;
    };
    default void onClick() {
    };



    default void onClickRelease(){
        //do nothing
    };

}
