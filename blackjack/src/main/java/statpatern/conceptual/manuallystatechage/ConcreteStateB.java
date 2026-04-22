package statpatern.conceptual.manuallystatechage;

public class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("State B behavior");
    }
}