/**
 * This demonstrates how Java polymorphism is limited to the compile time type.
 */
public class CompileTimeResolution {

    public static void main(String[] args) {
        SomethingA a = new SomethingA();
        SomethingA b = new SomethingB();
        SomethingA c = new SomethingC();

        sayHello(a);
        sayHello(b);

        // Explicitly casting to the runtime type of the object makes no difference
        sayHello(c.getClass().cast(c));
    }

    private static void sayHello(SomethingA a) {
        System.out.println("Hello A");
    }

    // Never called
    private static void sayHello(SomethingB b) {
        System.out.println("Hello B");
    }

    // Never called
    private static void sayHello(SomethingC c) {
        System.out.println("Hello C");
    }

    static class SomethingA {

    }

    static class SomethingB extends SomethingA {

    }

    static class SomethingC extends SomethingB {

    }
}
