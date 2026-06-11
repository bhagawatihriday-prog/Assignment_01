package LibrarySystem;

public abstract class LibraryItem {
    private String title;
    private int year;
    private static int itemCount = 0; // static counter

    // Constructor
    public LibraryItem(String title, int year) {
        this.title = title;
        this.year = year;
        itemCount++;
    }

    // Constructor Overloading (default values)
    public LibraryItem() {
        this("Unknown", 0);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public static int getItemCount() {
        return itemCount;
    }

    // Abstract method
    public abstract void displayInfo();
}
