public class Character {
    private String name;
    private int expPoints;
    private int healthPoints;
    private CharacterState state;

    public Character (String name) {
        this.name = name;
        this.expPoints = 0;
        this.healthPoints = 100;
        this.state = new NoviceState(this);
    }

    public void train() {
        state.train();
    }

    public void fight() {
        state.fight();
    }

    public void meditate() {
        state.meditate();
    }

    public void setState (CharacterState state) {
        this.state = state;
    }

    public void gainExp(int points) {
        this.expPoints += points;
        System.out.println(name + "got " + points + ". Total: " + expPoints);
    }

    public void gainHealth(int points) {
        this.healthPoints += points;
        System.out.println(name + "got " + points + ". Total: " + healthPoints);
    }

    public void looseHealth(int points) {
        this.healthPoints -= points;
        System.out.println(name + "lost " + points + ". Total: " + healthPoints);
    }

    public int getExpPoints() {
        return expPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void displayStatus() {
        System.out.println("Character: " + name);
        System.out.println("Level: " + state.getLevelName());
        System.out.println("Experience Points: " + expPoints);
        System.out.println("Health Points: " + healthPoints);
        state.displayAvailableActions();
    }
}
