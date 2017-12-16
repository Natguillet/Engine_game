import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application{

    List<Entity> entities;

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

        entities = new ArrayList<>();

        // Instantiate Entity Board and his graphic component
        Board board = new Board("board");
        GraphicBoardComponent graphicBoardComponent = new GraphicBoardComponent(board, 600,600);
        graphicBoardComponent.ChangeColor(Color.BLUE);
        board.getComponents().add(graphicBoardComponent);
        entities.add(board);

        // Instantiate Cases and their graphic components
        int nbCaseX = 3;
        int nbCaseY = 3;
        int caseHeight = 600/nbCaseY;
        int caseWidth = 600/nbCaseX;
        int posX = 50;
        for(int i = 0; i < nbCaseX; i++){
            int posY = 50;
            for(int j = 0; j < nbCaseY; j++){
                Case aCase = new Case("case_" + i + "_" + j, i, j);
                aCase.getComponents().add(new GraphicCaseComponent(aCase, posX, posY,caseHeight,caseWidth));
                aCase.getComponents().add(new InputCaseComponent(aCase));
                entities.add(aCase);
                posY = posY + caseHeight;
            }
            posX = posX + caseWidth;
        }

        SystemLogic systemLogic = new SystemLogic();
        SystemGraphic systemGraphic = new SystemGraphic();
        SystemInput systemInput = new SystemInput(2); // number of players to be handled by the logic system

        ISystem[] systems = {systemLogic, systemGraphic, systemInput};

        // Initialize all graphic components
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
