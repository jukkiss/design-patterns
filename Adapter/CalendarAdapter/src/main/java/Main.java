
public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        dateAdapter.setYear(2023);
        dateAdapter.setMonth(11);
        dateAdapter.setDay(6);

        System.out.println("Initial Date: " + dateAdapter.getYear() + "-" + dateAdapter.getMonth() + "-" + dateAdapter.getDay());

        dateAdapter.advanceDays(10);

        System.out.println("Date after advancing 10 days: " + dateAdapter.getYear() + "-" + dateAdapter.getMonth() + "-" + dateAdapter.getDay());
    }
}
