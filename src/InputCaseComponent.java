public class InputCaseComponent extends Component implements IInputComponent {

    boolean caseClicked;

    public InputCaseComponent(Entity entity) {
        super(entity);
        this.caseClicked = false;
    }

    public void Click() {
        caseClicked = true;
    }

    public boolean isClicked() {
        return caseClicked;
    }
}
