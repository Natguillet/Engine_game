package main;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SystemGraphic extends Application implements ISystem{
    @Override
    public void iterate(Entity[] entites) {
    	


        }
    
    public static void startApp(String...args) {
    	 Application.launch(SystemGraphic.class, args);
    }
    
    @Override
    public void stop(){
        System.out.println("Stage is closing");
        Main.exit = true;
    }
    
    
	@Override
    public void start(Stage primaryStage) {


        Group root = new Group();
        Scene scene = new Scene(root, 700, 700, Color.LIGHTBLUE);
        Main.InsideStart(root);
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
