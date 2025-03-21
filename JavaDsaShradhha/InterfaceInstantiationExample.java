// Define the Drawable interface  
interface Drawable {  
    int C=110;
    void draw();  
    default  void meth1(){
        System.out.println("hello");
    }
    private void meth2(){
        System.out.println("okkk");
    }
    public static void meth4(){System.out.println("uhy");}
    default void meth5(){System.out.println("uhy");}
    default void meth6(){meth2();}//default use private methods
}  
// Implement the Drawable interface in the Circle class  
class Circle implements Drawable {  
    @Override  
    public void draw() {  
        System.out.println("Drawing a circle");  
    }  
}  
// Implement the Drawable interface in the Rectangle class  
class Rectangle implements Drawable {  
    @Override  
    public void draw() {  
        System.out.println("Drawing a rectangle");  
    }  
}  
public class InterfaceInstantiationExample {  
    public static void main(String[] args) {  
        // Create objects of classes that implement the Drawable interface  
        Drawable drawable1 = new Circle();  
        Drawable drawable2 = new Rectangle();  
        // Invoke the draw() method on the drawable objects  
        drawable1.draw();  
        drawable2.draw();  
        Drawable.meth4();
        System.out.println(Drawable.C);
    }  
}