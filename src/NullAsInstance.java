/**
 * Null isn't an instanceof anything, but the declared type is still applicable.
 */
public class NullAsInstance {
    public static void main(String[] args) {
        Object nullObject = null;

        String nullString = null;

        System.out.println("Is nullObject instanceof Object? " + (nullObject instanceof Object));
        System.out.println("Is nullString instanceof String? " + (nullString instanceof String));

        foo(nullObject);

        foo(nullString);
    }

    // Does get called
    public static void foo(String string) {
        System.out.println("hey it's a String!");
    }

    // Gets called
    public static void foo(Object object) {
        System.out.println("hey it's an Object!");
    }
}
