import java.util.ArrayList;

/**
 * Trying out some things in ArrayList
 */
public class ArrayListApi {
    public static void main(String args[]) {
       trimToSize();
    }

    private static void trimToSize() {
        ArrayList<String> words = new ArrayList<>();

        words.add("Something");
        words.add("simple");
        words.add("blarg");

        // No way of inspecting the effect of trimToSize, presumably most useful in low memory environments
        words.trimToSize();
    }


    private static void replaceAll() {
        ArrayList<String> items = new ArrayList();

        items.add("Hello");
        items.add("World");

        items.replaceAll(s -> s.toUpperCase());

        for (String item : items) {
            System.out.println(item);
        }
    }
}
