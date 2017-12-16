import javafx.scene.paint.Color;
import java.util.List;

public class GameControllerComponent extends Component implements  ILogicComponent {


    public List<Pawn> buttonList;
    public Color playerSide;
    public GameControllerComponent(Entity entity, List<Pawn> buttonList) {
        super(entity);
        this.buttonList = buttonList;
        playerSide = Color.RED;
    }

    @Override
    public void update() {

    }

    public void awake() {
        setGameControllerReferenceOnButtons();
    }

    public void endTurn()
    {
        if(  buttonList.get(0).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(0).getGraphicComponent().color == buttonList.get(1).getGraphicComponent().color && buttonList.get(1).getGraphicComponent().color == buttonList.get(2).getGraphicComponent().color) {
                gameOver();
            }
        else if(  buttonList.get(3).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(3).getGraphicComponent().color == buttonList.get(4).getGraphicComponent().color && buttonList.get(4).getGraphicComponent().color == buttonList.get(5).getGraphicComponent().color) {
            gameOver();
        }
        else if( buttonList.get(6).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(6).getGraphicComponent().color == buttonList.get(7).getGraphicComponent().color && buttonList.get(7).getGraphicComponent().color == buttonList.get(8).getGraphicComponent().color) {
            gameOver();
        }
        else if(  buttonList.get(0).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(0).getGraphicComponent().color == buttonList.get(3).getGraphicComponent().color && buttonList.get(3).getGraphicComponent().color == buttonList.get(6).getGraphicComponent().color) {
                gameOver();
        }
        else if( buttonList.get(1).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(1).getGraphicComponent().color == buttonList.get(4).getGraphicComponent().color && buttonList.get(4).getGraphicComponent().color == buttonList.get(7).getGraphicComponent().color) {
                gameOver();
        }
        else if( buttonList.get(2).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(2).getGraphicComponent().color == buttonList.get(5).getGraphicComponent().color && buttonList.get(5).getGraphicComponent().color == buttonList.get(8).getGraphicComponent().color) {
                gameOver();
        }
        else if( buttonList.get(0).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(0).getGraphicComponent().color == buttonList.get(4).getGraphicComponent().color && buttonList.get(4).getGraphicComponent().color == buttonList.get(8).getGraphicComponent().color) {
                gameOver();
        }
        else if( buttonList.get(2).getGraphicComponent().color != Color.TRANSPARENT && buttonList.get(2).getGraphicComponent().color == buttonList.get(4).getGraphicComponent().color && buttonList.get(4).getGraphicComponent().color == buttonList.get(6).getGraphicComponent().color) {
                gameOver();
        }
        else
        {
            ChangeSides();
        }
    }

    public void setGameControllerReferenceOnButtons()
    {
        for (int i=0;i<buttonList.size();i++)
        {
            buttonList.get(i).getParentCase().getLogicComponent().SetGameControllerReference((GameController) this.entity);
        }
    }

    public Color getPlayerSide()
    {
        return playerSide;
    }

    public void gameOver()
    {
            for (int i=0;i< buttonList.size();i++)
            {
                buttonList.get(i).getParentCase().getGraphicComponent().isClickable=false;
            }
            System.out.println("game OVER");
    }

    public void ChangeSides ()
    {
        if (playerSide == Color.RED)
        {
            playerSide = Color.BLUE;
        }
        else
        {
            playerSide = Color.RED;
        }
    }
}
