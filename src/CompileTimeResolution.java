/**
 * This demonstrates how Java polymorphism applies to the compile time type.
 */
public class CompileTimeResolution {

    public static void main(String args[]) {
        SomethingA a = new SomethingA();
        SomethingA b = new SomethingB();
        SomethingA c = new SomethingC();

        sayHello(a);
        sayHello(b);
        sayHello(c.getClass().cast(c));
    }

    private static void sayHello(SomethingA a) {
        System.out.println("Hello A");
    }

    private static void sayHello(SomethingB b) {
        System.out.println("Hello B");
    }

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
