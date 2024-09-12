

public class IntermediateState extends CharacterState {

    public IntermediateState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training Intermediate level");
        character.gainExp(20);
        if (character.getExpPoints() >= 60) {
            System.out.println("Leveling up to Expert");
            character.setState(new ExpertState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditating");
        character.gainHealth(10);
    }

    @Override
    public void fight() {
        System.out.println("Intermediate can't fight");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Actions: Train, Meditate");
    }
}
