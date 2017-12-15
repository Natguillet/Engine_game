import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tic-Tac-Toe");

        Group root = new Group();
        Scene scene = new Scene(root, 700,700, Color.LIGHTBLUE);
        primaryStage.setScene(scene);

        final long startNanoTome = System.nanoTime();

        List<Entity> entities = new ArrayList<>();

        // Instantiate Entity Board and this component
        Board board = new Board("board");
        GraphicBoardComponent graphicBoardComponent = new GraphicBoardComponent(board, 600,600);
        graphicBoardComponent.ChangeColor(Color.BLUE);
        board.getComponents().add(graphicBoardComponent);
        entities.add(board);

        // Instantiate Cases
        int nbCaseX = 3;
        int nbCaseY = 3;
        int caseHeight = 600/nbCaseY;
        int caseWidth = 600/nbCaseX;
        int posX = 50;
        for(int i = 0; i < nbCaseX; i++){
            int posY = 50;
            for(int j = 0; j < nbCaseY; j++){
                Case aCase = new Case("case" + i);
                aCase.getComponents().add(new GraphicCaseComponent(aCase, posX, posY,caseHeight,caseWidth));
                entities.add(aCase);
                posY = posY + caseHeight;
            }
            posX = posX + caseWidth;
        }

        SystemGraphic systemGraphic = new SystemGraphic();
        ISystem[] systems = {new SystemLogic(), systemGraphic};

        // Intialize all graphic component
        root.getChildren().addAll(systemGraphic.init(entities).getChildren());

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = currentNanoTime - startNanoTome / 1000000000.0;
                for (ISystem system: systems) {
                    system.iterate(entities);
                }
            }
        }.start();
        primaryStage.show();
    }
}
