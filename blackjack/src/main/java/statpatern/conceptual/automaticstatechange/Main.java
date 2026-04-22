package statpatern.conceptual.automaticstatechange;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.request();
        context.request();
        context.request();
    }
}
