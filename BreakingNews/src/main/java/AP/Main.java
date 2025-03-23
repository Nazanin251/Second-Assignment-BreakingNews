package AP;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Initialize infrastructure with API key
        Infrastructure infrastructure = new Infrastructure("a426ee21d86b4f70be61a3c9622d7926");
        infrastructure.displayNewsList();

        if (infrastructure.getNewsList().isEmpty())
        {
            System.out.println("No news available");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number of the news article to read more:");

        // Validate user input
        while (!scanner.hasNextInt())
        {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= infrastructure.getNewsList().size())
        {
            infrastructure.getNewsList().get(choice - 1).displayNews();
        }
        else
        {
            System.out.println("Invalid selection.Please enter a number between 1 and " + infrastructure.getNewsList().size());
        }
        scanner.close();  // Close scanner to prevent memory leak
    }
}