package LibrarySystem;

public class DVD extends LibraryItem {
    private int duration;
    private String genre;

    public DVD(String title, int year, int duration, String genre) {
        super(title, year);
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD: " + getTitle() +
                ", Year: " + getYear() +
                ", Duration: " + this.duration + " mins" +
                ", Genre: " + this.genre);
    }
}
