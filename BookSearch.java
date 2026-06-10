import java.util.ArrayList;
import java.util.Scanner;

public class BookSearch {
    public static void main(String[] args) {

        ArrayList<String> books = new ArrayList<>();

        books.add("The Alchemist");
        books.add("Atomic Habits");
        books.add("Rich Dad Poor Dad");
        books.add("The Psychology of Money");
        books.add("Think and Grow Rich");
        books.add("Harry Potter and the Goblet of Fire");
        books.add("Java Programming");

        System.out.println("Available Books:");
        for (String book : books) {
            System.out.println(book);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter word to search in book titles: ");
        String keyword = sc.nextLine().toLowerCase();

        System.out.println("\nSearch Results:");
        boolean found = false;

        for (String book : books) {
            String[] words = book.toLowerCase().split(" "); // split title into words

            for (String word : words) {
                if (word.equals(keyword)) { // whole word match only
                    System.out.println(book);
                    found = true;
                    break;
                }
            }
        }

    
        if (!found) {
            System.out.println("No matching books found.");
        }

        sc.close();
    }
}
