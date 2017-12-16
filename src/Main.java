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
    List<Pawn> pawnList;

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
        
        //Instantiate GameController

        GameController gameController = new GameController("game controller");
        GameControllerComponent gameControllerComponent = new GameControllerComponent(gameController,pawnList);
        gameController.getComponents().add(gameControllerComponent);
        entities.add(gameController);

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

                // instantiate the pawn
                Pawn aPawn = new Pawn("pawn_" + i + "_" + j, aCase);
                pawnList.add(aPawn);
                aPawn.getComponents().add(new GraphicPawnComponent(aPawn, posX + caseWidth / 2, posY + caseHeight / 2, (java.lang.Math.min(caseHeight, caseWidth)) / 2 - 10, Color.TRANSPARENT));
                // TO DO: InputPawnComponent?
                aCase.getChildren().add(aPawn);
                entities.add(aPawn);

                posY += caseHeight;
            }
            posX += caseWidth;
        }

        //Add players
        PlayerManager playerManager = new PlayerManager("playerManager");
        PlayerComponent Player1 = new PlayerComponent(playerManager, Color.BLUE);
        PlayerComponent Player2 = new PlayerComponent(playerManager, Color.GREEN);

        SystemLogic systemLogic = new SystemLogic();
        SystemGraphic systemGraphic = new SystemGraphic();
        SystemInput systemInput = new SystemInput(playerManager.componentNumber());

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
