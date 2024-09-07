public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation weatherStation = new WeatherStation();

        // create observers
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        // register observers
        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);

        // weather station on its thread
        Thread stationThread = new Thread(weatherStation);
        stationThread.start();

        // simulation run millsec
        Thread.sleep(10000);

        // remove observer
        System.out.println("Removing Observer 2");
        weatherStation.removeObserver(observer2);

        // continue missec
        Thread.sleep(10000);

        // stop
        weatherStation.stop();
        stationThread.join();
    }
}
