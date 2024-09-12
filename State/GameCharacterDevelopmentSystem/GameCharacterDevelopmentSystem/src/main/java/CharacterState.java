public abstract class CharacterState {
    protected Character character;

    public CharacterState(Character character) {
        this.character = character;
    }

    public abstract void train();
    public abstract void fight();
    public abstract void meditate();
    public abstract String getLevelName();
    public abstract void displayAvailableActions();
}
