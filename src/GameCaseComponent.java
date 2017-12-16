public class GameCaseComponent extends Component implements  ILogicComponent {

    private GameController gameController;
    private Pawn pawn;

    public GameCaseComponent(Entity entity) {
        super(entity);
    }

    public void SetGameControllerReference(GameController controller)
    {
        gameController = controller;
    }

    public void setSpace()
    {
        pawn.getComponents()
    }
    @Override
    public void update() {

    }
}
