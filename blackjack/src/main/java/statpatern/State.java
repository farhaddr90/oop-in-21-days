package statpatern;

public interface State {
    void prev(Package pkg);

    void next(Package pkg);

    void printState();
}
