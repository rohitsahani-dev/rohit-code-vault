// Basic OOP (class and object)
class Student {
    String name;
    int age;

// A method is a block of code that performs a specific task.
// It is defined within a class and can be called on an object of that class.
    void display() {
        System.out.println(name + " - " + age);
    }
}

public class _09_OOP_Basics {
    public static void main(String[] args) {
// An object is an instance of a class. 
// It is created using the new keyword followed by the class name and parentheses.
        Student s1 = new Student();
        
        s1.name = "Rohit";
        s1.age = 20;
        s1.display();
    }
}
