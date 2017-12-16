import javafx.scene.paint.Color;

import java.io.Console;

public class GameControllerComponent extends Component implements  ILogicComponent {


    public Pawn[] buttonList;
    public String playerSide;
    public GameControllerComponent(Entity entity, Pawn[] buttonList) {
        super(entity);
        this.buttonList = buttonList;
    }

    @Override
    public void update() {
        if (win())
        {
            System.out.println("WIN");
        }
    }


    public void awake()
    {
        setGameControllerReferenceOnButtons();
        playerSide = "RED";
    }
    public void win()
    {
        if( buttonList[0].getComponents() == buttonList[1] && buttonList[1] == buttonList[2]) {
                gameOver();
            }
        else if( buttonList[3] == buttonList[4] && buttonList[4] == buttonList[5]) {
            gameOver();
        else if( buttonList[6] == buttonList[7] && buttonList[7] == buttonList[8]) {
            gameOver();
        }
        else if( buttonList[0] == buttonList[3] && buttonList[3] == buttonList[6]) {
                gameOver();
        }
        else if( buttonList[1] == buttonList[4] && buttonList[4] == buttonList[7]) {
                gameOver();
        }
        else if( buttonList[2] == buttonList[5] && buttonList[5] == buttonList[8]) {
                gameOver();
        }
        else if( buttonList[0] == buttonList[4] && buttonList[4] == buttonList[8]) {
                gameOver();
        }
        else if( buttonList[2] == buttonList[4] && buttonList[4] == buttonList[6]) {
                gameOver();
        }
        else
        {
            ChangeSides();
        }
        }
    }

    public void setGameControllerReferenceOnButtons()
    {
        for (int i=0;i<buttonList.length;i++)
        {
            //buttonList[i].GetComponentInParent<GridSpace>().SetGameControllerReference(this);
        }
    }

    public String getPlayerSide()
    {
        return playerSide;
    }

    public void gameOver()
    {
            //buttonList[i].GetComponentInParent<Button>().interactable = false;
    }

    public void ChangeSides ()
    {
        if (playerSide == "RED")
        {
            playerSide = "BLUE";
        }
        else
        {
            playerSide ="RED";
        }
    }
}
