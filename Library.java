import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("The book has been successfully added.");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                book.displayInfo();
            }
        }
    }



    // Search for a book by title, author, or ISBN
    public Book searchBook(String query) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) ||
                    book.getAuthor().equalsIgnoreCase(query) ||
                    book.getIsbn().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null; // Return null if no book is found
    }

    // Remove a book by ISBN
    public boolean removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Book successfully removed.");
                return true;
            }
        }
        System.out.println("No book found with this ISBN.");
        return false;
    }

    // Edit a book by ISBN
    public boolean editBook(String isbn, String newTitle, String newAuthor) {
        Book book = searchBook(isbn);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            System.out.println("Book successfully updated.");
            return true;
        }
        System.out.println("No book found with this ISBN.");
        return false;
    }



}
