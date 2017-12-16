import javafx.scene.paint.Color;
import java.util.List;

public class GameControllerComponent extends Component implements  ILogicComponent {


    public List<Pawn> buttonList;
    public Color playerSide;
    public GameOver gameOverPanel;
    private int moveCount = 0;

    public GameControllerComponent(Entity entity, List<Pawn> buttonList, GameOver gameOverPanel) {
        super(entity);
        this.buttonList = buttonList;
        this.gameOverPanel = gameOverPanel;
        gameOverPanel.getGraphicComponent().setActive(false);
        playerSide = Color.RED;
        moveCount = 0;
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
            moveCount ++;
            if (moveCount >= 9)
            {
                gameOverPanel.getGraphicComponent().setActive(true);
                gameOverPanel.getGraphicComponent().setText("It's a draw!");
            }
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
            gameOverPanel.getGraphicComponent().setActive(true);
            String winner;
            if(playerSide == Color.RED) winner = "Red";
            else winner = "Blue";
            gameOverPanel.getGraphicComponent().setText(winner + " Wins !");
            System.out.println("game OVER");
    }

    public void ChangeSides ()
    {
        System.out.println("CHange color");
        if (playerSide == Color.RED)
        {
            System.out.println("test de si rouge");
            playerSide = Color.BLUE;
        }
        else
        {
            playerSide = Color.RED;
        }
    }
}
