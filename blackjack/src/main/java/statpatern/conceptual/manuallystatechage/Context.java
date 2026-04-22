package statpatern.conceptual.manuallystatechage;

public class Context {
    private State currentState;

    public Context(State initialState) {
        this.currentState = initialState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void request() {
        currentState.handle(this); // delegate to current state
    }
}
