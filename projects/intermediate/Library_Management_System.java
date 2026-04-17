package projects.intermediate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int count;
    private boolean isBorrowed;
    private String dueDate;
    private String borrower;
    private String userId;

    // Getters and Setters
    public String getTitle() { 
        return title;
     }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getAuthor() { 
        return author;
     }
    public void setAuthor(String author) {
         this.author = author; 
        }

    public String getIsbn() {
         return isbn; 
        }
    public void setIsbn(String isbn) { 
        this.isbn = isbn;
     }

    public int getCount() { 
        return count;
     }
    public void setCount(int count) { 
        this.count = count;
     }

    public boolean isBorrowed() { 
        return isBorrowed; 
    }
    public void setBorrowed(boolean borrowed) { 
        isBorrowed = borrowed;
     }

    public String getDueDate() { 
        return dueDate;
     }
    public void setDueDate(String dueDate) {
         this.dueDate = dueDate;
         }

    public String getBorrower() { 
        return borrower; 
    }
    public void setBorrower(String borrower) {
         this.borrower = borrower;
         }

    public String getUserId() {
         return userId;
         }
    public void setUserId(String userId) {
         this.userId = userId;
         }

    // Borrow book
    public void borrowBook(String borrower, String userId) {
        if (count > 0) {
            this.borrower = borrower;
            this.userId = userId;
            this.isBorrowed = true;
            this.count--;
            this.dueDate = LocalDate.now().plusDays(14).toString();
            System.out.println("You have borrowed: " + title + ". Due: " + dueDate);
        } else {
            System.out.println("Sorry, " + title + " is not available.");
        }
    }

    // Return book
    public void returnBook() {
        if (isBorrowed) {
            this.isBorrowed = false;
            this.count++;
            System.out.println("You have returned: " + title);
            this.borrower = null;
            this.userId = null;
            this.dueDate = null;
        } else {
            System.out.println("This book was not borrowed.");
        }
    }
}

public class Library_Management_System {
    private static List<Book> books = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
          while (true) {
        addSampleBooks();
        System.out.println("Welcome to the Library Management System!");

      
            System.out.println("\n1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }
        }
    }

    private static void addSampleBooks() {
        Book b1 = new Book();
        b1.setTitle("War and Peace");
        b1.setAuthor("Leo Tolstoy");
        b1.setIsbn("978-0-14-044913-6");
        b1.setCount(3);
        books.add(b1);

        Book b2 = new Book();
        b2.setTitle("1984");
        b2.setAuthor("George Orwell");
        b2.setIsbn("978-0-452-28423-4");
        b2.setCount(4);
        books.add(b2);

        Book b3 = new Book();
        b3.setTitle("The Great Gatsby");
        b3.setAuthor("F. Scott Fitzgerald");
        b3.setIsbn("978-0-7432-7356-5");
        b3.setCount(2);
        books.add(b3);

        Book b4 = new Book();
        b4.setTitle("To Kill a Mockingbird");
        b4.setAuthor("Harper Lee");
        b4.setIsbn("978-0-06-112008-4");
        b4.setCount(5);
        books.add(b4);

        Book b5 = new Book();
        b5.setTitle("Brave New World");
        b5.setAuthor("Aldous Huxley");
        b5.setIsbn("978-0-06-085052-4");
        b5.setCount(3);
        books.add(b5);

        System.out.println("Sample books loaded into the library.");
    }

    private static void addBook() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter book title (or 'q' to stop): ");
            String title = sc.nextLine();
            if (title.equalsIgnoreCase("q")) break;

            Book book = new Book();
            book.setTitle(title);
            System.out.print("Enter book author: ");
            book.setAuthor(sc.nextLine());
            System.out.print("Enter book ISBN: ");
            book.setIsbn(sc.nextLine());
            System.out.print("Enter number of copies: ");
            book.setCount(sc.nextInt());
            sc.nextLine(); // Consume newline
            books.add(book);
            System.out.println("Book added successfully!");
        }
        sc.close();
    }

    private static void searchBook() {
        System.out.print("Enter book title to search: ");
        String title = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title)) {
                System.out.println("Title: " + book.getTitle() + 
                                 ", Author: " + book.getAuthor() + 
                                 ", Copies: " + book.getCount() + 
                                 ", Borrowed: " + book.isBorrowed());
                found = true;
            }
        }
        if (!found) System.out.println("No books found with that title.");
        sc.close();
    }

    private static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = sc.nextLine().toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(title)) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter your ID: ");
                String id = sc.nextLine();
                book.borrowBook(name, id);
                sc.close();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = sc.nextLine().toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(title) && book.isBorrowed()) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found or not borrowed.");
        sc.close();
    }
}   