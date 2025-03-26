import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
    private final Map<String, Book> bookCollection;
    private final Scanner scanner; // Injected dependency

    public Library(Scanner scanner) {
        this.bookCollection = new HashMap<>();
        this.scanner = scanner;
    }

    // Adding a book to the collection
    public void addBook() {
        System.out.println("\nAdding a new book...");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine().trim();

        if (bookCollection.containsKey(bookId)) {
            System.out.println("Book already exists! Try again.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine().trim();
        System.out.print("Enter Availability (Available/Checked Out): ");
        String availability = scanner.nextLine().trim();

        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Title and Author cannot be empty.");
            return;
        }

        try {
            Book newBook = new Book(bookId, title, author, genre, availability);
            bookCollection.put(bookId, newBook);
            System.out.println("Book added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // View all books
    public void viewAllBooks() {
        if (bookCollection.isEmpty()) {
            System.out.println("\nNo books found.");
        } else {
            System.out.println("\nLibrary Collection:");
            bookCollection.values().forEach(System.out::println);
        }
    }

    // Search for a book by ID or title
    public void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String searchKey = scanner.nextLine().trim();

        for (Book book : bookCollection.values()) {
            if (book.getBookId().equalsIgnoreCase(searchKey) || book.getTitle().equalsIgnoreCase(searchKey)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Update book details
    public void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookId = scanner.nextLine().trim();

        if (!bookCollection.containsKey(bookId)) {
            System.out.println("Book not found.");
            return;
        }

        Book book = bookCollection.get(bookId);

        System.out.print("Enter New Title (Leave blank to keep the same): ");
        String newTitle = scanner.nextLine().trim();
        if (!newTitle.isEmpty()) book.setTitle(newTitle);

        System.out.print("Enter New Author (Leave blank to keep the same): ");
        String newAuthor = scanner.nextLine().trim();
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);

        System.out.print("Enter New Genre (Leave blank to keep the same): ");
        String newGenre = scanner.nextLine().trim();
        if (!newGenre.isEmpty()) book.setGenre(newGenre);

        System.out.print("Enter New Availability (Available/Checked Out): ");
        String newAvailability = scanner.nextLine().trim();
        try {
            book.setAvailabilityStatus(newAvailability);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Book updated successfully!");
    }

    // Delete a book
    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookId = scanner.nextLine().trim();

        if (bookCollection.remove(bookId) != null) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }
}

