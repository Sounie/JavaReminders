public class Instances {
    public static class Language {
        public String hello() {
            return "hello";
        }
    }

    public static class French extends Language {
        @Override
        public String hello() {
            return "Bonjour";
        }
    }

    public static void main(String... args) {
        Language lang1 = new Language();

        Language lang2 = new French();

        System.out.println("lang2 instanceof Language " + (lang2 instanceof Language));

        // The class of lang1 is compatible with the instance lang2
        System.out.println("lang1.getClass().isInstance(lang2) " + (lang1.getClass().isInstance(lang2)));
    }
}
