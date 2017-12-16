import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.paint.Color;

public class Case extends Entity {

    int idX;
    int idY;
    Pawn pawn;

    public Case(String name, int x, int y) {
        super(name);
        this.idX = x;
        this.idY = y;
        this.pawn = null;
    }

    public boolean addPawn(int playerID) {
        if (pawn == null) {
            // calcul du rayon du pion
            int radiusPawn = getCaseMinDimension() / 2 - 1;

            // créer et ajouter le nouveau pion
            this.pawn = new Pawn("pawn" + playerID, playerID);
            // 2 joueurs -> playerID = 0 ou 1
            // à modifier si plus de deux joueurs
            if (playerID == 0)
                pawn.getComponents().add(new GraphicPawnComponent(pawn, idX, idY, radiusPawn, Color.DARKBLUE));
            else
                pawn.getComponents().add(new GraphicPawnComponent(pawn, idX, idY, radiusPawn, Color.DARKRED));
            return true;
        } else {
            System.out.println("A pawn is already placed on that cell.");
            return false;
        }
    }

    public int getHeight() {
        int height = 0;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicCaseComponent) {
                height = ((GraphicCaseComponent) tmp).getCaseHeight();
                found = true;
            }
        }

        return height;
    }

    public int getWidth() {
        int width = 0;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicCaseComponent) {
                width = ((GraphicCaseComponent) tmp).getCaseWidth();
                found = true;
            }
        }

        return width;
    }

    public int getCaseMinDimension() {

        int height = 0;
        int width = 0;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicCaseComponent) {
                height = ((GraphicCaseComponent) tmp).getCaseHeight();
                width = ((GraphicCaseComponent) tmp).getCaseWidth();
                found = true;
            }
        }

        return java.lang.Math.min(height, width);
    }

    public int getPosX() {
        int posX = 0;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicCaseComponent) {
                posX = ((GraphicCaseComponent) tmp).getPosX();
                found = true;
            }
        }

        return posX;
    }

    public int getPosY() {
        int posY = 0;
        boolean found = false;
        Iterator<Component> componentIt = getComponents().iterator();

        while(componentIt.hasNext() && !found) {
            Component tmp = componentIt.next();
            if(tmp instanceof GraphicCaseComponent) {
                posY = ((GraphicCaseComponent) tmp).getPosY();
                found = true;
            }
        }

        return posY;
    }

    public boolean hasPawn() {
        return (this.pawn != null);
    }
}
