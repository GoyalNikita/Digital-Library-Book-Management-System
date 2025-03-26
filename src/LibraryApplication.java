import java.util.Scanner;

public class LibraryApplication {
    private final Library library;
    private final Scanner scanner;
    private boolean isRunning;

    public LibraryApplication(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
        this.isRunning = true;
    }

    public void run() {
        while (isRunning) {
            displayMenu();
            int choice = getUserChoice();
            processUserChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Digital Library Book Management System =====");
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Update Book Details");
        System.out.println("5. Remove Book Record");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private int getUserChoice() {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return choice;
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                scanner.next(); // Discard invalid input
            }
        }
    }

    private void processUserChoice(int choice) {
        switch (choice) {
            case 1 -> library.addBook();
            case 2 -> library.viewAllBooks();
            case 3 -> library.searchBook();
            case 4 -> library.updateBook();
            case 5 -> library.deleteBook();
            case 6 -> {
                System.out.println("Exiting the system... Thank you!");
                isRunning = false;
            }
            default -> System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

