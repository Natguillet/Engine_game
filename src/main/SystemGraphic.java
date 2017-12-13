package main;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.entityFolder.Board;

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
        //ajout des sous fonctions
      //  GraphicBoard(root);
        Board board = new Board(3,3,600,600, root);
        //board.getGraphic().ChangeColor(Color.BLUE); // change la couleur du plateau
        board.changeAllCaseColor(Color.GREY); //change la couleur des cases
        primaryStage.setScene(scene);
        primaryStage.show();
	}

   /* public void GraphicBoard(Group root){
        GraphicBoard myBoard = new GraphicBoard(800, 600 , 8, 6);//on créé un objet clavier
        root.getChildren().add(myBoard);
    }
*/

}
