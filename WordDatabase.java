import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordDatabase {
    private List<String> words;

    public WordDatabase() {
        words = new ArrayList<>();
        words.add("procesor");
        words.add("programowanie");
        words.add("stackoverflow");
        words.add("komputer");
        words.add("grafika");
        words.add("klawiatura");
        words.add("myszka");
        words.add("ekran");
        words.add("internet");
        words.add("bazadanych");
        words.add("kodowanie");
        words.add("website");
    }
    

    public String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public void addWord(String word) {
        words.add(word);
    }

    public List<String> getWords() {
        return words;
    }
}
