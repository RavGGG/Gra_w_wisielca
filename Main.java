import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordDatabase wordDatabase = new WordDatabase();
        Statistics statistics = new Statistics();
        Game game = new Game(wordDatabase, statistics);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Witaj w grze w wisielca!");
            System.out.println("1. Nowa gra");
            System.out.println("2. Dodaj słowo do bazy");
            System.out.println("3. Wyświetl statystyki");
            System.out.println("4. Resetuj statystyki");
            System.out.println("5. Wyświetl wszystkie dostępne słowa:");
            System.out.println("6. Wyjście");
            System.out.print("Wybierz opcje: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();



            switch (choice) {
                case 1:
                    System.out.print("Wybierz poziom trudności (EASY, MEDIUM, HARD): ");
                    String difficultyInput = scanner.nextLine().toUpperCase();
                    DifficultyLevel difficulty = DifficultyLevel.valueOf(difficultyInput);
                    game.startNewGame(difficulty);
                    
                    while (!game.isGameOver()) {
                        System.out.println("Słowo: " + game.getGuessedWord());
                        System.out.println("Pozostałe próby: " + game.getAttemptsLeft());
                        System.out.println("Niepoprawne litery: " + game.getWrongGuesses());
                        System.out.print("Podaj literę: ");
                        char guess = scanner.nextLine().charAt(0);
                        game.guessLetter(guess);
                    }
                    
                    if (game.isGameWon()) {
                        System.out.println("Gratulacje! Wygrałeś!");
                    } else {
                        System.out.println("Niestety, przegrałeś. Słowo to: " + game.getWord());
                    }
                    break;
                case 2:
                    System.out.print("Podaj słowo do dodania: ");
                    String newWord = scanner.nextLine();
                    wordDatabase.addWord(newWord);
                    System.out.println("Dodano słowo: " + newWord);
                    break;
                case 3:
                    System.out.println("Statystyki:");
                    System.out.println("Zwycięstwa: " + statistics.getWins());
                    System.out.println("Porażki: " + statistics.getLosses());
                    System.out.println("Średnia liczba prób na grę: " + statistics.getAverageAttemptsPerGame());
                    break;
                case 4:
                    statistics.reset();
                    System.out.println("Statystyki zostały zresetowane.");
                    break;
                case 5:
                    System.out.println("Słowa w bazie:");
                    for (String word : wordDatabase.getWords()) {
                        System.out.println(word);
                    }
                    break;
                case 6:
                    System.out.println("Dziękujemy za grę!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");

            }
        }






    }
}
