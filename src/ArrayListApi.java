import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Trying out some things in ArrayList
 */
public class ArrayListApi {
    public static void main(String args[]) {
        indexOfSortedList();
//       trimToSize();
    }

    private static void indexOfSortedList() {
        // indexOf is a bit naive, so let's see if a sorted list can be made to behave better
        ArrayList<Integer> sorted = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 50_000_000; i++) {
            sorted.add(i);

            // Introducing duplicates at random points
            if (random.nextBoolean()) {
                sorted.add(i);
            }
        }

        final Integer target = Integer.valueOf(48_000_000);

        long timeBefore = System.currentTimeMillis();
        int anIndex = Collections.binarySearch(sorted, target,
                (o1, o2) -> o1.compareTo(o2)
        );

        // We treat anIndex as starting position and move backwards until we establish the first instance
        while (anIndex > 0 && sorted.get(anIndex - 1).equals(target)) {
            anIndex--;
        }
        System.out.println("Duration binary approach " + (System.currentTimeMillis() - timeBefore));

        long timeBeforeIndexOf = System.currentTimeMillis();
        int indexOfVal = sorted.indexOf(target);

        System.out.println("Duration indexOf " + (System.currentTimeMillis() - timeBeforeIndexOf));

        System.out.println("IndexOf value " + indexOfVal);
        System.out.println("IndexOf verification: " + sorted.get(indexOfVal));

        System.out.println("Found at index " + anIndex);
        System.out.println("DEBUG - item was - " + sorted.get(anIndex));
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
