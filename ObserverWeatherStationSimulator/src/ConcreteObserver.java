public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " temp update: " + temperature + "Cels");
    }
}
