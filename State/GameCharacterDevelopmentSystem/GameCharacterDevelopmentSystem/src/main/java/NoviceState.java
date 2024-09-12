public class NoviceState extends CharacterState {

    public NoviceState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training novice level");
        character.gainExp(10);
        if (character.getExpPoints() >= 30) {
            System.out.println("Leveling up to intermediate");
            character.setState(new IntermediateState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("Novice can't meditate");
    }

    @Override
    public void fight() {
        System.out.println("Novice can't fight");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available actions: Train");
    }

}
