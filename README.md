# Digital Library Management System

## Overview
This is a simple Digital Library Management System implemented in Java. The application allows users to manage books, including adding, viewing, searching, updating, and deleting book records.

## Features
- Add a new book with unique Book ID, Title, Author, Genre, and Availability Status
- View all available books in the library
- Search for a book by its ID or Title
- Update book details such as Title, Author, Genre, and Availability
- Remove a book from the library
- User-friendly CLI interface

## Technologies Used
- Java (JDK 17+ recommended)
- HashMap for book storage
- Scanner for user input handling

## Installation & Usage
### Prerequisites
Ensure you have Java installed on your system. You can check this by running:
```sh
java -version
```
If Java is not installed, download and install it from [Oracle's official site](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK.

### Clone the Repository
```sh
git clone https://github.com/your-username/digital-library.git
cd digital-library
```

### Compile and Run the Application
```sh
javac *.java
java LibraryApplication
```

## Class Structure
### `Book.java`
Defines the `Book` class with attributes such as `bookId`, `title`, `author`, `genre`, and `availabilityStatus`. It provides getters, setters, and validation logic.

### `Library.java`
Manages the collection of books, providing methods to add, view, search, update, and delete books.

### `LibraryApplication.java`
Serves as the main entry point of the application, handling user interaction and menu display.

## Example Usage
```
===== Digital Library Book Management System =====
1. Add New Book
2. View All Books
3. Search Book
4. Update Book Details
5. Remove Book Record
6. Exit
Choose an option:
```

## Future Enhancements
- Persist book records using a database (MySQL/PostgreSQL)
- Implement a graphical user interface (GUI)
- Add user authentication and roles

