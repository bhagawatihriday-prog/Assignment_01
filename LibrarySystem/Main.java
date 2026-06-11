package LibrarySystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<LibraryItem> items = new ArrayList<>();

        while (true) {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Add DVD");
            System.out.println("3. Display All Items");
            System.out.println("4. Show Total Count");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Book Title: ");
                    String bTitle = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int bYear = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    items.add(new Book(bTitle, bYear, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter DVD Title: ");
                    String dTitle = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int dYear = sc.nextInt();

                    System.out.print("Enter Duration (mins): ");
                    int duration = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();

                    items.add(new DVD(dTitle, dYear, duration, genre));
                    System.out.println("DVD added successfully!");
                    break;

                case 3:
                    if (items.isEmpty()) {
                        System.out.println("No items in library.");
                    } else {
                        System.out.println("\n--- Library Items ---");
                        for (LibraryItem item : items) {
                            item.displayInfo(); // polymorphism
                        }
                    }
                    break;

                case 4:
                    System.out.println("Total items: " + LibraryItem.getItemCount());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
