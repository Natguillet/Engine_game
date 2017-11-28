import java.lang.System;

public class HelloWorldComponent extends Component implements ILogicComponent {

    public HelloWorldComponent(Entity entity) {
        super(entity);
    }

    @Override
    public void update() {
        System.out.println("Hello World!");
    }
}
