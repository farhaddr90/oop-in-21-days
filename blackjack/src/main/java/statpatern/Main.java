package statpatern;

public class Main {
    public static void main(String[] args) {
        Package aPackage = new Package();
        aPackage.printState();

        aPackage.nextState();
        aPackage.printState();

        aPackage.nextState();
        aPackage.printState();

        aPackage.nextState();
    }
}
