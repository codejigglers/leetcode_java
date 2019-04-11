public class Animal {

    boolean name;

    public Animal(boolean name) {
        this.name = name;
    }


}


class Dog extends Animal {



    public Dog() {
        super(true);
    }
}