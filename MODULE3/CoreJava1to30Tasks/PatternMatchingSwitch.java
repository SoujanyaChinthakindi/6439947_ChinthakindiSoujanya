public class PatternMatchingSwitch {
    public static void identifyObject(Object obj) {
        if (obj == null) {
            System.out.println("Object is null");
            return;
        }
        switch (obj) {
            case Integer i -> System.out.println("This is an Integer: " + i);
            case String s -> System.out.println("This is a String: " + s);
            case Double d -> System.out.println("This is a Double: " + d);
            default -> System.out.println("Unknown type: " + obj.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        identifyObject(10);
        identifyObject("Hi");
        identifyObject(3.14);
        identifyObject(true);
        identifyObject(null);
    }
}
