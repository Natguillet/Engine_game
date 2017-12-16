public interface IInputComponent {

    public void Click();
    default boolean isClicked() { return false; }
    default boolean isDragged() { return false; } // could return the data involved with the drag
}
