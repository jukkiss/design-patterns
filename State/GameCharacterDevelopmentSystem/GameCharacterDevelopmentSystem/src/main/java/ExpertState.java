public class ExpertState extends CharacterState{

    public ExpertState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training Expert level");
        character.gainExp(30);
        if (character.getExpPoints() >= 100) {
            System.out.println("Leveling up to Expert");
            character.setState(new MasterState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditating");
    }

    @Override
    public void fight() {
        System.out.println("Fighting!");
        character.gainExp(40);
        character.looseHealth(20);
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available actions: Train, Meditate, Fight");
    }


}
