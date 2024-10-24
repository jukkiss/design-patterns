import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class HistoryWindow {

    private ListView<String> historyListView;
    private Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;
        historyListView = new ListView<>();

        // Fill ListView with state metadata (e.g., timestamps or descriptions)
        for (int i = 0; i < controller.getHistory().size(); i++) {
            historyListView.getItems().add("State " + (i + 1));
        }

        // DateTimeFormatter to display the timestamp nicely
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Fill ListView with metadata (timestamps of saved states)
        for (IMemento memento : controller.getHistory()) {
            String metadata = "Saved at: " + memento.getTimestamp().format(formatter);
            historyListView.getItems().add(metadata);
        }
        // Set action to restore state on item click
        historyListView.setOnMouseClicked(event -> {
            int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                controller.restoreStateFromHistory(selectedIndex);
            }
        });

        // Create and show a new window for the history
        Stage stage = new Stage();
        stage.setTitle("History Window");
        Scene scene = new Scene(historyListView, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
