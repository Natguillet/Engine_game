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

        // Instantiate Entity Board and his graphic component
        Board board = new Board("board");
        GraphicBoardComponent graphicBoardComponent = new GraphicBoardComponent(board, gameBoardWidth, gameBoardHeight);
        graphicBoardComponent.ChangeColor(Color.BLUE);
        board.getComponents().add(graphicBoardComponent);
        entities.add(board);

        // Instantiate Cases and their graphic components
        int caseMinDim = java.lang.Math.min(caseHeight, caseWidth);
        int pawnMargin = caseMinDim / 20; // 5 percent of the case's smaller dimension
        int posX = boardMargin;
        for(int i = 0; i < nbCaseX; i++){
            int posY = boardMargin;
            for(int j = 0; j < nbCaseY; j++){
                Case aCase = new Case("case_" + i + "_" + j, i, j);
                aCase.getComponents().add(new GraphicCaseComponent(aCase, posX, posY,caseHeight,caseWidth));
                aCase.getComponents().add(new InputCaseComponent(aCase));
                entities.add(aCase);

                // instantiate the pawn
                Pawn aPawn = new Pawn("pawn_" + i + "_" + j, aCase);
                aPawn.getComponents().add(new GraphicPawnComponent(aPawn, posX + caseWidth / 2, posY + caseHeight / 2, caseMinDim / 2 - pawnMargin, Color.TRANSPARENT));
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
