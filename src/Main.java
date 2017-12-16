import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application{

    List<Entity> entities;
    List<Pawn> paws;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tic-Tac-Toe");

        // Game data
        int wholeBoardWidth = 700;
        int wholeBoardHeight = 700;
        int boardMargin = 50;
        int gameBoardWidth = wholeBoardWidth - boardMargin * 2;
        int gameBoardHeight = wholeBoardHeight - boardMargin * 2;
        int nbCaseX = 3;
        int nbCaseY = 3;

        // Board rescaling
        int caseHeight = gameBoardHeight / nbCaseY;
        int caseWidth = gameBoardWidth / nbCaseX;
        if(gameBoardWidth % nbCaseX != 0) {
            gameBoardWidth = caseWidth * nbCaseX;
            wholeBoardWidth = gameBoardWidth + boardMargin * 2;
        }
        if(gameBoardHeight % nbCaseY != 0) {
            gameBoardHeight = caseHeight * nbCaseY;
            wholeBoardHeight = gameBoardHeight + boardMargin * 2;
        }

        Group root = new Group();
        Scene scene = new Scene(root, wholeBoardWidth, wholeBoardHeight, Color.LIGHTBLUE);
        primaryStage.setScene(scene);

        final long startNanoTome = System.nanoTime();

        entities = new ArrayList<>();
        paws = new ArrayList<>();

        // Instantiate Entity Board and his graphic component
        Board board = new Board("board");
        GraphicBoardComponent graphicBoardComponent = new GraphicBoardComponent(board, gameBoardWidth, gameBoardHeight);
        graphicBoardComponent.ChangeColor(Color.BLUE);
        board.getComponents().add(graphicBoardComponent);
        entities.add(board);

        GraphicPointComponent points = new GraphicPointComponent(board, 5,5, 0);
        board.getComponents().add(points);

        GraphicPointComponent points2 = new GraphicPointComponent(board, 635,5, 0);
        board.getComponents().add(points2);

        // Instantiate Cases and their graphic components
        int caseMinDim = java.lang.Math.min(caseHeight, caseWidth);
        int pawnMargin = caseMinDim / 20; // 5 percent of the case's smaller dimension
        int posX = boardMargin;
        for(int i = 0; i < nbCaseX; i++){
            int posY = boardMargin;
            for(int j = 0; j < nbCaseY; j++){
                Case aCase = new Case("case_" + i + "_" + j, i, j);
                aCase.getComponents().add(new GraphicCaseComponent(aCase, posX, posY,caseHeight,caseWidth,true));
                aCase.getComponents().add(new InputCaseComponent(aCase));

                // instantiate the pawn
                Pawn aPawn = new Pawn("pawn_" + i + "_" + j, aCase);
                aCase.getComponents().add(new GameCaseComponent(aCase, aPawn));
                entities.add(aCase);
                aPawn.getComponents().add(new GraphicPawnComponent(aPawn, posX + caseWidth / 2, posY + caseHeight / 2, caseMinDim / 2 - pawnMargin, Color.TRANSPARENT));
                // TO DO: InputPawnComponent?
                aCase.getChildren().add(aPawn);
                paws.add(aPawn);
                entities.add(aPawn);

                posY += caseHeight;
            }
            posX += caseWidth;
        }

        //Add players
        PlayerManager playerManager = new PlayerManager("playerManager");
        PlayerComponent Player1 = new PlayerComponent(playerManager, Color.BLUE);
        PlayerComponent Player2 = new PlayerComponent(playerManager, Color.GREEN);

        //Intantiate gameCOntroller
        GameController gameController = new GameController("game controller");
        GameControllerComponent gameControllerComponent = new GameControllerComponent(gameController, paws);
        gameController.getComponents().add(gameControllerComponent);
        gameControllerComponent.awake();
        entities.add(gameController);

        SystemLogic systemLogic = new SystemLogic();
        SystemGraphic systemGraphic = new SystemGraphic();
        //SystemInput systemInput = new SystemInput(gameController);

        ISystem[] systems = {systemLogic, systemGraphic};

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
