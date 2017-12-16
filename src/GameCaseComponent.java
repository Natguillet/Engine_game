import javafx.scene.paint.Color;

public class GameCaseComponent extends Component implements ILogicComponent {

    private GameController gameController;
    public Pawn pawn;
    //public Case aCase;
    public Color playerSide;

    public GameCaseComponent(Entity entity, Pawn pawn) {
        super(entity);
        this.pawn = pawn;
    }

    public void SetGameControllerReference(GameController controller)
    {
        gameController = controller;
        playerSide = gameController.getLogicComponent().getPlayerSide();
    }

    public void setSpace()
    {
        playerSide = gameController.getLogicComponent().getPlayerSide();
        ((Pawn) entity.getChildren().get(0)).getGraphicComponent().ChangeColor(playerSide);
        gameController.getLogicComponent().endTurn();
    }

    @Override
    public void update() {

    }
}
