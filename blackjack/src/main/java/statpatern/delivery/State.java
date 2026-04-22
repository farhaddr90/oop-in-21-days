package statpatern.delivery;

public interface State {
    void prev(Package pkg);

    void next(Package pkg);

    void printState();
}
