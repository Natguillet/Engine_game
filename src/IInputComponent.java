public interface IInputComponent {

    public void Click();
    default boolean isClicked() { return false; }
}
