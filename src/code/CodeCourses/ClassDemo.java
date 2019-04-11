package code.CodeCourses;

public class ClassDemo {
    public static void main(String[] args) {
        method1();
    }

    static void method1() {
        A a = new A();
        a.setName("Foo");
        System.out.printf(a.getName());
        method2(a);
        System.out.println(a.getName());
    }

    static void method2(A a) {
        a.setName("Bar");
    }
}

class A {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

