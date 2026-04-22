package statpatern.delivery;

public class Package {
    private State state;

    public Package() {
        this.state = new OrderState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void previousState() {
        this.state.prev(this);
    }

    public void nextState() {
        this.state.next(this);
    }

    public void printState() {
        state.printState();
    }

    private class OrderState implements State {

        @Override
        public void prev(Package pkg) {
            System.out.println("This is the root state!");
        }

        @Override
        public void next(Package pkg) {
            pkg.setState(new DeliveringState());
        }

        @Override
        public void printState() {
            System.out.println("This package is ordered now.");
        }
    }

    public class DeliveringState implements State {
        @Override
        public void prev(Package pkg) {
            pkg.setState(new OrderState());
        }

        @Override
        public void next(Package pkg) {
            pkg.setState(new ReceivedState());
        }

        @Override
        public void printState() {
            System.out.println("This package is delivering now.");
        }
    }

    public class ReceivedState implements State {
        @Override
        public void prev(Package pkg) {
            pkg.setState(new DeliveringState());
        }

        @Override
        public void next(Package pkg) {
            System.out.println("This package is received now and has no any next state!");
        }

        @Override
        public void printState() {
            System.out.println("This package was received.");
        }
    }
}
