public class _06_Loops {
    // Loops in Java are used to execute a block of code repeatedly until a specified condition is met.
    //  There are three main types of loops in Java: for loop, while loop, and do-while loop.
    public static void main(String[] args) {

        // For loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Count: " + i);
        }

        // While loop
        int i = 0;
        while (i < 3) {
            System.out.println("While: " + i);
            i++;
        }
    }
}
