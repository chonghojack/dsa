package boundary;

import java.util.Scanner;

public class MenuUI {
    Scanner input = new Scanner(System.in);
    
    public int choiceGetter(int[] choiceList) {
        int choice = 0;
        boolean valid = false; // Change here
        while (!valid) { // Change here
            System.out.print("Enter your choice: ");
            try {
                int userInput = input.nextInt();
                input.nextLine();
                if (isValidChoice(userInput, choiceList)) {
                    choice = userInput;
                    valid = true; // Set valid to true if input is valid
                } else {
                    System.out.println("Invalid choice! Please enter a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Please enter a valid option.");
                input.nextLine(); // Clear the input buffer
            }
        }
        return choice;
    }
    
    private boolean isValidChoice(int userInput, int[] choiceList) {
        for (int choice : choiceList) {
            if (userInput == choice) {
                return true;
            }
        }
        return false;
    }
    
    public static void pressToContinue() {
        System.out.println("Press <Enter> to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter
    }
}
