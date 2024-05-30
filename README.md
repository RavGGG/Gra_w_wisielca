2. Gra w wisielca


Mój projekt to konsolowa wersja gry wisielca napisana w Javie.


Lista zaimplementowanych funkcjonalności.

1. Losowy wybór słowa z wbudowanej bazy słów.
2. Możliwość dodawania własnego słowa do bazy słów.
3. Wybór poziomu trudnosci, który wpływa na ilość dostępnych żyć.
4. Dostęp do statystyk.
5. Prosty interfejs.


Klasa Main.

WordDataBase wordDatabase - obiekt, który zarządza bazą słów.
Statistic statistic - obiekt, ktory przechowuje statystyki gry.
Game game - Obiekt, który zawiera logikę gry. Wykorzystuje obiekt wordDatabase i statistic.
Scanner scanner - wprowadzanie danych z klawiatury.

Pętla while działa do momentu, gdy wybierzemy opcje zakończenia programu.Wewnątrz tej petli jest menu z opcjami do wyboru.
1) Nowa Gra 
- wybór poziomu trudnosci EASY, MEDIUM, HARD.
-rozpoczęcie nowej gry, wywołując game.startNewGame(difficulty)
-sprawdzane sa odgadywane słowa dopóki gra się nie skończy game.isGameOver()
-po zakończniu gry wyświetlany jest wynik (game.isGameOver)

2) Dodaj słowo do bazy
- podane słowo dodawane jest do bazy słow wordDatabase.addWord(newWord)
- wyświetla się komunikat o poprawnym dodaniu słowa.

3) Wyświetl statystyki
- wyświetlane są statystyki gry (wygrane,przegrane, średnia liczba prób odgadnięca hasła na gre)

4)Resetuj statystyki
-resetuje statystyki do 0 , statistics.reset() oraz informuje o poprawności zresetowania.

5)Wyświetl wszystkie słowa w bazie
- wyświetla wszystkei dostępne słowa w bazie.

6) Wyjście
- zakończenie działania programu z informacją o zakończeniu.


Klasa Game

Pola:

word- Przechowuje słowo do odgadnięcia.
guessedWord- przechowuje odgadnięte litery jako tablicę znaków.
wrongGuesses- lista niepoprawnych liter zgadywanych przez gracza.
attemptsLeft- liczba pozostałych prób.
difficulty- poziom trudności gry.
wordDatabase- odwołanie do bazy słów.
statistics- odniesienie do obiektu przechowującego statystyki.

Metody:

Game(WordDatabase wordDatabase, Statistics statistics) - konstruktor inicjalizujący bazę słów i statystyki.
startNewGame(DifficultyLevel difficulty)- rozpoczyna nową grę, losując słowo i ustawiając liczbę prób na podstawie poziomu trudności.
setAttemptsBasedOnDifficulty() - ustawia liczbę prób w zależności od poziomu trudności.
guessLetter(char letter) - metoda która obsługuje zgadywanie litery przez użytkownika.
isGameOver() - sprawdza, czy gra się zakończyła (wygrana lub przegrana).
isGameWon() - sprawdza, czy gracz odgadł całe słowo.
getGuessedWord() - zwraca obecny stan odgadniętego słowa.
getWrongGuesses() - zwraca listę niepoprawnych liter.
getAttemptsLeft() - zwraca liczbę pozostałych prób.
getWord() - zwraca słowo do odgadnięcia.


Klasa WordDatabase

Pola:

words - lista przechowujaca słowa

Metody:

WordDataBase() - konstruktor, który tworzy bazę danych z przykładowymi słowami.
getRandomWord() - zwraca losowe słowo z bazy.
addWord(String word) - dodaje nowe słowo do bazy.
getWords() - zwraca listę wszystkich słów w bazie.

Klasa Statistics

Pola:

wins - liczba wygranych gier.
losses - liczba przegranych gier.
totalAttempts - łączna liczba prób we wszystkich grach.


Metody:

recordWin(int attempts) - zapisuje wygraną grę i aktualizuje liczbę prób.
recordLoss(int attempts) - zapisuje przegraną grę i aktualizuje liczbę prób.
getWins() - zwraca liczbę wygranych.
getLosses() - zwraca liczbę porażek.
getAverageAttemptsPerGame() - zwraca średnią liczbę prób na grę.
reset() - resetuje statystyki.


Klasa DifficultyLevel

W klasie tej wykorzystałem 3 Enumy  (EASY, MEDIUM, HARD), które reprezentują poziom trudności gry.Każdy poziom trudności ma inna liczbę prób na grę.



