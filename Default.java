
interface MyInterface {
    
    void abstractMethod();

    
    default void defaultMethod() {
        System.out.println("This is the default method in the interface.");
    }
}



class MyClass implements MyInterface {
    
    
    public void abstractMethod() {
        System.out.println("Implementation of the abstract method.");
    }
}


public class main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.abstractMethod();    
        obj.defaultMethod();     
    }
}
 
    

