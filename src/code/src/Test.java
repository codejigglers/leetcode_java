class Base {
    protected Base() {
    }

    public Base(int i) {
        foo(i);
    }

    public void foo(int i) {
        System.out.println("Base value is " + i);
    }

    public void foo(String s) {
        System.out.println("Base string is " + s);
    }

}

class Sub extends Base {
    public void foo(int j) {
        System.out.println("Sub value is " + j);
    }
}

public class Test{
    public static void main(String args[]) {
        Base b1 = new Base();
        Base b2 = new Sub();
        b1.foo(2);
        b2.foo(7);
        b2.foo("2");
    }
}