import java.util.Arrays;
import java.util.List;

/**
 * Show how Java sorts Strings in lexicographical order.
 */
public class StringComparison {
    public static void main(String[] args) {
        List<String> someStrings = Arrays.asList(new String[] { "Zebra", "aardvark", "apple", "GIRAFFE" });

        someStrings.sort(String::compareTo);

        System.out.println(someStrings);
    }
}
