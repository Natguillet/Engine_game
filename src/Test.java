import java.lang.System;

public class Test extends Component implements ILogicComponent {

    public Test(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println("Hello World!");
    }
}
