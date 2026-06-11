package LibrarySystem;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, int year, String author) {
        super(title, year);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + getTitle() +
                ", Year: " + getYear() +
                ", Author: " + this.author);
    }
}
