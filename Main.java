import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            // Display the main menu
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Display all books");
            System.out.println("2. Add a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Remove a book");
            System.out.println("5. Edit a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            switch (option) {
                case 1:// Display all books
                    library.displayBooks();
                    break;

                case 2:// add book
                    System.out.print("Enter the book's title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the book's author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the book's ISBN: ");
                    String isbn = scanner.nextLine();

                    boolean isAvailable = false;
                    while (true) {
                        System.out.print("Is the book available? (yes/no): ");
                        String disponibilityResponse = scanner.nextLine().toLowerCase();
                        if (disponibilityResponse.equals("yes")) {
                            isAvailable = true;
                            break;
                        } else if (disponibilityResponse.equals("no")) {
                            isAvailable = false;
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    }


                    library.addBook(new Book(title, author, isbn, isAvailable));
                    break;
                case 3:// serche book
                    System.out.print("Enter the title, author, or ISBN of the book to search for: ");
                    String query = scanner.nextLine();
                    Book foundBook = library.searchBook(query);
                    if (foundBook != null) {
                        System.out.println("Book found: ");
                        foundBook.displayInfo();
                    } else {
                        System.out.println("book not found.");
                    }
                    break;
                case 4://remove
                    System.out.print("Enter the ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    break;
                case 5:// edit book
                    System.out.print("Enter the ISBN of the book to edit: ");
                    String isbnToEdit = scanner.nextLine();
                    Book bookToEdit = library.searchBook(isbnToEdit);
                    if (bookToEdit != null) {
                        System.out.print("Enter the new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter the new author: ");
                        String newAuthor = scanner.nextLine();
                        library.editBook(isbnToEdit, newTitle, newAuthor);
                    } else {
                        System.out.println("No book found with this ISBN.");
                    }
                    break;
                case 6:// exite
                    System.out.println("Goodbye...<3!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 6.");
            }
        }
    }
}