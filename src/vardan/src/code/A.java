package code;

public class A {

    public static void main(String[] args) {
        B a = new B();
        a.printName();

    }

    public void printName() {
        System.out.println("A");
    }
}

class B extends A {

    public void printName() {
        System.out.println("B");
    }

}
