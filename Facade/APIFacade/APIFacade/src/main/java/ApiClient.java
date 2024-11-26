
public class ApiClient {

    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        String jokeUrl = "https://api.chucknorris.io/jokes/random";
        try {
            String joke = facade.getAttributeValueFromJson(jokeUrl, "value");
            System.out.println("Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            System.err.println("Error fetching joke: " + e.getMessage());
        }

        String fxRateUrl = "https://api.exchangerate-api.com/v4/latest/USD";
        try {
            String rate = facade.getAttributeValueFromJson(fxRateUrl, "rates");
            System.out.println("Exchange rates: " + rate);
        } catch (Exception e) {
            System.err.println("Error fetching exchange rates: " + e.getMessage());
        }
    }
}
