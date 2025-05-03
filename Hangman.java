import java.util.Arrays;
import java.util.Scanner;
import javax.print.attribute.SetOfIntegerSyntax;

public class Hangman {

  public static String[] words = {
    "ant",
    "baboon",
    "badger",
    "bat",
    "bear",
    "beaver",
    "camel",
    "cat",
    "clam",
    "cobra",
    "cougar",
    "coyote",
    "crow",
    "deer",
    "dog",
    "donkey",
    "duck",
    "eagle",
    "ferret",
    "fox",
    "frog",
    "goat",
    "goose",
    "hawk",
    "lion",
    "lizard",
    "llama",
    "mole",
    "monkey",
    "moose",
    "mouse",
    "mule",
    "newt",
    "otter",
    "owl",
    "panda",
    "parrot",
    "pigeon",
    "python",
    "rabbit",
    "ram",
    "rat",
    "raven",
    "rhino",
    "salmon",
    "seal",
    "shark",
    "sheep",
    "skunk",
    "sloth",
    "snake",
    "spider",
    "stork",
    "swan",
    "tiger",
    "toad",
    "trout",
    "turkey",
    "turtle",
    "weasel",
    "whale",
    "wolf",
    "wombat",
    "zebra",
  };

  public static String[] gallows = {
    "+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",
    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",
    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",
    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",
    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "     |\n" +
    "     |\n" +
    " =========\n",
    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",
    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/ \\  |\n" +
    "     |\n" +
    " =========\n",
  };

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nWelcome to the hang man game");

    String word = randomWord();

    char[] placeholders = new char[word.length()];
    for (int i = 0; i < word.length(); i++) {
      placeholders[i] = '_';
    }
    int MissesChance = 0;
    char[] missedGuesses = new char[6];
    while (MissesChance < 6) {
      System.out.println(gallows[MissesChance]);
      System.out.println("\nThe Word is: ");
      printPlaceholders(placeholders);
      System.out.println("\n");

      System.out.println("Misses");
      printMissedGuesses(missedGuesses);
      System.out.println("\n");

      System.out.println("Guess: ");
      char guess = scan.nextLine().charAt(0);
      System.out.println("\n");

      if (checkGuess(word, guess)) {
        updatePlaceholders(word, placeholders, guess);
      } else {
        missedGuesses[MissesChance] = guess;
        MissesChance++;
      }
      if (Arrays.equals(placeholders, word.toCharArray())) {
        System.out.print(gallows[MissesChance]);
        System.out.print("\nWord:   ");
        printPlaceholders(placeholders);
        System.out.println("\nROCKED IT!");
        break;
      }
      if (MissesChance == 6) {
        System.out.print(gallows[6]);
        System.out.println("\nRIP!");
        System.out.println("\nThe word was: '" + word + "'");
      }
    }

    scan.close();
  }

  public static String randomWord() {
    int numWords = words.length;
    double random = Math.random();
    int Elemetn = (int) (numWords * random);
    return words[Elemetn];
  }

  public static boolean checkGuess(String word, char guess) {
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == guess) {
        return true;
      }
    }
    return false;
  }

  public static void updatePlaceholders(
    String word,
    char[] placeholders,
    char guess
  ) {
    for (int j = 0; j < word.length(); j++) {
      if (word.charAt(j) == guess) {
        placeholders[j] = guess;
      }
    }
  }

  public static void printPlaceholders(char[] printPlaceholders) {
    for (int i = 0; i < printPlaceholders.length; i++) {
      System.out.print(" " + printPlaceholders[i]);
    }
    System.out.print("\n");
  }

  public static void printMissedGuesses(char[] MissesChance) {
    for (int i = 0; i < MissesChance.length; i++) {
      System.out.println(MissesChance[i]);
    }
  }
}
