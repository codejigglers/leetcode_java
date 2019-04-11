import java.util.HashMap;
import java.util.HashSet;

public class FormatTest {

    public static void main(String[] args) {

        new Throwable().getStackTrace();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet2.add("A");
        hashSet2.add("B");

        for(String i : hashSet) {
            if(i.equals("A")) {
                hashSet2.remove(i);
            }
        }

        printName();
    }
    public static void printName() {
        printStack();
        printSurname();
        System.out.println();
    }

    public static void printSurname() {
        printStack();
        System.out.println("Sur");
    }

    public static void printStack() {
        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            System.out.println(ste);
        }
    }
}
