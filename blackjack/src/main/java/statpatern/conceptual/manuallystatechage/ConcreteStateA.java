package statpatern.conceptual.manuallystatechage;

public class ConcreteStateA implements State {

    @Override
    public void handle(Context context) {
        System.out.println("State A behavior");
    }
}