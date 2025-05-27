public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int castedInt = (int) myDouble;
        System.out.println("Double to int: " + castedInt);
        int myInt = 42;
        double castedDouble = (double) myInt;
        System.out.println("Int to double: " + castedDouble);
    }
}
