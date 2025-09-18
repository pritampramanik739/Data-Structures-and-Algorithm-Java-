public class OOPS {
    public static void main(String[] args) {
        book b1 = new book();
        b1.anything("verbal");
        b1.hd(700);
        System.out.print(b1.printt() + " ");
        System.out.println(b1.sdhugf() + " ");

        Student s1 = new Student();
        s1.arr[0] = 20;
        s1.arr[1] = 30;
        s1.arr[2] = 40;
        Student s2 = new Student("Pritam", 7);
        s2.name = "Pramanik";
        Student s3 = new Student(s1);
        s1.arr[0] = 100;
        System.out.println(s1.arr[0]);
        System.out.println(s3.arr[0]);

        Egale e = new Egale();
        e.eats();
        e.fly();
        e.sound();

        calculator c1 = new calculator();
        System.out.println(c1.sum(10, 20));
        System.out.println(c1.sum(10, 20, 30));
        System.out.println(c1.sum(10f, 40.8f));

        Integration i1 = new Integration();
        i1.solve();
        math m1 = new math();
        m1.solve();

        // bike ne =new bike(); [ can't create object of bike due to abstract----]
        bajaj bj = new bajaj();
        // bike-->honda-->bajaj
        bj.run();
         bj.engine();
        System.out.println(bj.color);
        // due to the constractor initially all are the same color blue until it's change manually

        beer b=new beer();
        b.eat();

    }
}

class book {

    private String name;
    private int price;

    //setters
    void anything(String name) {
        this.name = name;
    }

    //setters
    void hd(int price) {
        this.price = price;
    }

    //getters
    String printt() {
        return name;
    }

    //getters
    int sdhugf() {
        return price;
    }
}

class Student {

    String name;
    int roll;
    int[] arr = new int[3];

    //non parameterized constructor--> default 
    public Student() {
        System.out.println("Constructer is called");
    }

    //parameterized Constructor
    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    //copy Constructor
    Student(Student s1) {
        this.name = s1.name;
        this.roll = s1.roll;
        // -->[ this.arr = s1.arr;]<-- /*this is the example of shallow copy as here array is used if we change the array value after   assign  result will be affected   */

        //deep copy to solve the value change problem
        int j = 0;
        for (int i : s1.arr) {
            this.arr[j] = i;
            j++;
        }
    }

}

class Animal {

    Animal() {
        System.out.println("animal called--->");
    }

    void eats() {
        System.out.println("eats");
    }
}

class Bird extends Animal {

    void fly() {
        System.out.println("flys");
    }
}

class Egale extends Bird {

    void sound() {
        System.out.println("kkkkkkkkkkkkkk");
    }
}

/* multiple inheritence we can create through abstraction ----> interfaces method   */

// example of method overloading--->compile time error
class calculator {

    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

//method overriding ---> runtime error 
class math {

    void solve() {
        System.out.println("integration solve kor..");
    }
}

class Integration extends math {

    @Override
    void solve() {
        System.out.print("double derivative");
    }
}

// here it it is a abstract class
abstract class bike {

    String color;

    // here is the constractor--->
    bike() {
        System.out.println("broom broom");
        color = "blue";
    }

    // in the absract class their is a non abstract method ---
    void run() {
        System.out.println("go to the bridge");
    }

    // it is a abstract method---
    @SuppressWarnings("unused")
    abstract void engine();
}

class honda extends bike {

    honda() {
        System.out.println("go  go go");
    }

    @Override
    void engine() {
        System.out.println("chalta rahe..");
    }
}

class bajaj extends honda {

    bajaj() {
        System.out.println("gooooooooooooooooo");
    }
}

// 1st interface-->
interface nonveg {
    void eat();
}

// 2nd interface-->
interface veg {
    void sleep();
}
// example of multiple inheritence-->
class beer implements veg, nonveg {

    // in method section public keyword is neccesary because in the interface all methods are 
    // public if we don't add public keyword compile give the default specifier so that it gives error.
    @Override
    public void eat() {
        System.out.println("hdgvikueghguig");
    }
    @Override
    public void sleep() {
        System.out.println("gjsfbyvuesf");
    }
}


