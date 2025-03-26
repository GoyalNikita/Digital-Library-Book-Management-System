import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(scanner);
        LibraryApplication app = new LibraryApplication(library, scanner);
        app.run();
        scanner.close(); // Ensure the scanner is closed properly
    }
}
