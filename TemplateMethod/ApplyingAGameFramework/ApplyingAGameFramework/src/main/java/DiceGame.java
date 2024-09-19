import java.util.Random;

public class DiceGame extends Game{
    private int[] playerScores;
    private int maxTurns;
    private int currentTurn;

    @Override
    public void initializeGame(int numberOfPlayers) {
        playerScores = new int[numberOfPlayers];
        maxTurns = numberOfPlayers;
        currentTurn = 0;
        System.out.println("Game starts with " + numberOfPlayers+ " players." );
    }

    @Override
    public boolean endOfGame() {
        return currentTurn >= maxTurns;
    }

    @Override
    public void playSingleTurn(int player) {
        Random random = new Random();
        int roll = random.nextInt(6) + 1;
        playerScores[player] = roll;
        System.out.println("Player " + (player + 1) + " rolled a " + roll);
        currentTurn++;

    }

    @Override
    public void displayWinner() {
        int highestScore = 0;
        int winner = -1;
        for (int i = 0; i < playerScores.length; i++) {
            if (playerScores[i] > highestScore) {
                highestScore = playerScores[i];
                winner = i;
            }
        }
        System.out.println("Player " + (winner + 1) + " wins with a roll of " + highestScore);
    }

}
