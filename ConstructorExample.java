class Car {
    String model;
    int year;

    // Default constructor
    Car() {
        model = "Unknown";
        year = 0;
    }

    // Parameterized constructor
    Car(String m, int y) {
        model = m;
        year = y;
    }

    // Copy constructor
    Car(Car c) {
        model = c.model;
        year = c.year;
    }

    void display() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        // Using default constructor
        Car car1 = new Car();
        car1.display();

        // Using parameterized constructor
        Car car2 = new Car("Toyota", 2022);
        car2.display();

        // Using copy constructor
        Car car3 = new Car(car2);
        car3.display();
    }
}

    

