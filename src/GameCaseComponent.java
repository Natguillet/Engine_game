import javafx.scene.paint.Color;

public class GameCaseComponent extends Component implements  ILogicComponent {

    private GameController gameController;
    private Pawn pawn;
    public Color playerSide;

    public GameCaseComponent(Entity entity) {
        super(entity);
    }

    public void SetGameControllerReference(GameController controller)
    {
        gameController = controller;
    }

    public void setSpace()
    {
        pawn.getGraphicComponent().color = playerSide;
    }

    @Override
    public void update() {

    }
}
