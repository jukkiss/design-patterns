public class MasterState extends CharacterState {

    public MasterState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("You are a Master. No need for training");
    }

    @Override
    public void meditate() {
        System.out.println("You are a Master. No need for meditating. You are zen.");
    }

    @Override
    public void fight() {
        System.out.println("You are a Master. No need to fight no more");
        character.gainExp(40);
        character.looseHealth(20);
    }

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("You are a Master. Game is over");
    }
}
