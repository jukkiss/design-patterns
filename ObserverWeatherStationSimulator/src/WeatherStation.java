import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private int temperature;
    private List<Observer> observers = new ArrayList<>();
    private boolean running = true;

    public WeatherStation() {
        this.temperature = new Random().nextInt(41); // Initial random temperature between 0 and 40
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        while (running) {
            // randomly change temp
            int change = random.nextBoolean() ? 1 : -1;
            temperature = Math.max(0, Math.min(40, temperature + change)); // Keep within range 0 to 40
            // notify
            notifyObservers();

            // random delay
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
