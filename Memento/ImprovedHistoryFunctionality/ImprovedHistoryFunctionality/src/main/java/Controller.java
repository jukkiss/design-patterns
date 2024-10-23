import java.util.ArrayList;
import java.util.List;
//Caretaker
public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    //Redo History
    private List<IMemento> redoHistory;


    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        //Clear redo history on new change
        clearRedoHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        clearRedoHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento currentState = model.createMemento();
            //Save current state to redo stack
            redoHistory.add(currentState);

            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento currentState = model.createMemento();
            //Save current state to undo stack
            history.add(currentState);

            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    public void restoreStateFromHistory(int index) {
        if (index >= 0 && index < history.size()) {
            IMemento selectedState = history.get(index);
            model.restoreState(selectedState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    //Clear redo stack on new action
    private void clearRedoHistory() {
        redoHistory.clear();
    }

    public List<IMemento> getHistory() {
        return history;
    }
}
