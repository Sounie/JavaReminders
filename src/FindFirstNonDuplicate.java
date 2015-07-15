import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


/**
 * Inspired by a not-so-elegant example solution that I saw online.
 *
 * This implementation only needs to pass through the input String once, as LinkedHashMap preserves ordering.
 */
public class FindFirstNonDuplicate {
    public static void main(String args[]) {
        String input = "Some text with some letters in it. So how did it go?";

        Optional<Character> firstNonDup = firstNonDuplicate(input);

        if (firstNonDup.isPresent()) {
            System.out.println("Found first non-duplicate character '" + firstNonDup.get() + "'");
        } else {
            System.out.println("Sorry, there were no non-duplicate characters.");
        }
    }

    // Returns first non duplicate character if one exists, otherwise returns null
    private static Optional<Character> firstNonDuplicate(String input) {
        LinkedHashMap<Character, Integer> characterOccurences = new LinkedHashMap<>();

        for (Character c : input.toCharArray()) {
            characterOccurences.put(c, characterOccurences.getOrDefault(c, 0) + 1);
        }

        return characterOccurences.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey);
    }
}
