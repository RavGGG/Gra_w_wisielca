public class Statistics {
    private int wins;
    private int losses;
    private int totalAttempts;

    public void recordWin(int attempts) {
        wins++;
        totalAttempts += attempts;
    }

    public void recordLoss(int attempts) {
        losses++;
        totalAttempts += attempts;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public double getAverageAttemptsPerGame() {
        if (wins + losses == 0) {
            return 0;
        }
        return (double) totalAttempts / (wins + losses);
    }

    public void reset() {
        wins = 0;
        losses = 0;
        totalAttempts = 0;
    }
}
