public class Game {
    public static void main(String[] args) {
        // Create and display a CityMap
        Map cityMap = new CityMap(5, 5);
        System.out.println("City Map:");
        cityMap.display();

        // Create and display a WildernessMap
        Map wildernessMap = new WildernessMap(5, 5);
        System.out.println("Wilderness Map:");
        wildernessMap.display();
    }
}
