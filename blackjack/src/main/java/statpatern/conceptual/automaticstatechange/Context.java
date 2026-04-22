package statpatern.conceptual.automaticstatechange;

public class Context {
    private State currentState;
    public Context() {
        this.currentState = new ConcreteStateA();
    }

    private void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    private class ConcreteStateA implements State {

        @Override
        public void handle(Context context) {
            System.out.println("State A behavior");
            context.setCurrentState(new ConcreteStateB()); // transition
        }
    }

    private class ConcreteStateB implements State {
        @Override
        public void handle(Context context) {
            System.out.println("State B behavior");
            context.setCurrentState(new ConcreteStateA()); // transition
        }
    }

    public void request() {
        currentState.handle(this); // delegate to current state
    }
}
