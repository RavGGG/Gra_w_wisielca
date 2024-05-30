import java.util.ArrayList;
import java.util.List;

public class Game {

    private String word;
    private char[] guessedWord;
    private List<Character> wrongGuesses;
    private int attemptsLeft;
    private DifficultyLevel difficulty;
    private WordDatabase wordDatabase;
    private Statistics statistics;



    public Game(WordDatabase wordDatabase, Statistics statistics) {
        this.wordDatabase = wordDatabase;
        this.statistics = statistics;
        this.wrongGuesses = new ArrayList<>();
    }

    public void startNewGame(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
        this.word = wordDatabase.getRandomWord();
        this.guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        this.wrongGuesses.clear();
        setAttemptsBasedOnDifficulty();
    }

    private void setAttemptsBasedOnDifficulty() {
        switch (difficulty) {
            case EASY:
                attemptsLeft = 11;
                break;
            case MEDIUM:
                attemptsLeft = 7;
                break;
            case HARD:
                attemptsLeft = 4;
                break;
        }
    }

    public boolean guessLetter(char letter) {
        boolean correct = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedWord[i] = letter;
                correct = true;

            }
        }
        if (!correct) {
            wrongGuesses.add(letter);
            attemptsLeft--;
        }
        return correct;
    }

    public boolean isGameOver() {
        boolean gameOver = attemptsLeft <= 0 || new String(guessedWord).equals(word);
        if (gameOver) {
            if (isGameWon()) {
                statistics.recordWin(word.length() - attemptsLeft);
            } else 
            {
                statistics.recordLoss(word.length() - attemptsLeft);
            }
        }
        return gameOver;
    }

    public boolean isGameWon() {
        return new String(guessedWord).equals(word);
    }

    public String getGuessedWord() {
        return new String(guessedWord);
    }

    public List<Character> getWrongGuesses() {
        return wrongGuesses;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getWord() {
        return word;
    }
}
