package boundary;

import java.util.Scanner;

public class CourseManagementUI extends MenuUI{
    Scanner input = new Scanner(System.in);
    public void title(){
        System.out.println("= Course Management Subsystem =");
    }
    public void menu(){
        title();
        System.out.println("1 : Add a programme to course");
        System.out.println("2 : Remove a programme from a course");
        System.out.println("3 : Add a new course to a programme");
        System.out.println("4 : Remove a course from a programme");
        System.out.println("5 : Amend course details for a programme");
        System.out.println("6 : List courses taken by different faculties");
        System.out.println("7 : List all course for a programme");
        System.out.println("8 : Generate report");
        System.out.println("0 : Back");
    } 
    
    public int getMenuChoice(){
        int choice;
        
        menu();
        
        int[] option = {1,2,3,4,5,6,7,8,0};
        
        choice = choiceGetter(option);
        
        return choice;
    }
    
    public int getSelection(int i){
        int selection;

        int[] option = new int[i + 1]; // Create an array of size i + 2

        // Populate the array with numbers from 1 to i
        for (int j = 1; j <= i; j++) {
            option[j - 1] = j;
        }

        // Add 0 at the end of the array
        option[i] = 0; 
        
        selection = choiceGetter(option);
        
        return selection;
    }
    
    public int getCreditHour(){
        int quit = 0;
        int creditHour = 0;
        do{
            System.out.print("Enter credit hour (1 -5): ");
                try{
                    creditHour = input.nextInt();
                    if(isValidCreditHour(creditHour)){
                        quit = 1;
                    }
                    else{
                        System.out.println("Credit Hour is between 1 to 5.");  
                    }
                }catch(Exception e){
                    System.out.println("Invalid Input");
                }
        }while(quit == 0);
        return creditHour;
    }
    
    public static boolean isValidCreditHour(int creditHour) {
        // Check if the credit hour is between 1 and 5 (inclusive)
        return creditHour >= 0 && creditHour <= 5;
    }
    
    public void selectType(){
        System.out.println("Select Course type");
        System.out.println("1 : Main Course");
        System.out.println("2 : Elective Course");        
    } 
    
    public int getSelectType(){
        selectType();
        int[] option = {1,2};
        int selection = choiceGetter(option);
        
        return selection; 
    }
    
    public void confirmMenu(){
        System.out.println("1 : Yes");
        System.out.println("0 : No");
    }
    
    public int getRemoveMenu(){
        System.out.println("Are you sure you want to remove?");
        confirmMenu();
        int[] option = {1,0};
        int selection = choiceGetter(option);
        
        return selection;        
    }
    
    public int getAddMenu(){
        System.out.println("Are you sure you want to add?");
        confirmMenu();
        int[] option = {1,0};
        int selection = choiceGetter(option);
        
        return selection;        
    }
    
    public int getCreateMenu(){
        System.out.println("Are you sure you want to create?");
        confirmMenu();
        int[] option = {1,0};
        int selection = choiceGetter(option);
        
        return selection;        
    }
    
    public String getCourseCode(){
        int quit = 0;
        String inputStr = null;
        do{
            System.out.print("Enter course code(Eg. BACS1024) :");
            inputStr = input.nextLine().toUpperCase();
            if(isCourseCodeValid(inputStr)){
                quit = 1;
            }else{
                System.out.println("Invalid course code! ");
                quit = 0;
            }                
        } while(quit == 0);
        return inputStr;
    }
    
    public static boolean isCourseCodeValid(String code) {
        // Check if the code has exactly 8 characters
        if (code.length() != 8) {
            return false;
        }

        // Check the first 4 characters are capital letters
        for (int i = 0; i < 4; i++) {
            char ch = code.charAt(i);
            if (ch < 'A' || ch > 'Z') {
                return false;
            }
        }

        // Check the last 4 characters are digits
        for (int i = 4; i < 8; i++) {
            char ch = code.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
            
        // If all checks pass, return true
        return true;
    }
    
    public String getCourseName(){
        int quit = 0;
        String inputStr = null;
        do{
            System.out.print("Enter course name :");
            inputStr = firstLetterToUpperCase(input.nextLine());
            if(!inputStr.isBlank()){
                quit = 1;
            }else{
                System.out.println("Cannot Be Blank!");
                quit = 0;
            }                
        } while(quit == 0);
        return inputStr;
    }
    
    //format phrase to uppercase for each word first letter
    public static String firstLetterToUpperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Return input if it is null or empty
        }

        // Split the input string into words
        String[] words = input.toLowerCase().split("\\s+");

        // Capitalize the first letter of each word
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) { // Skip empty strings
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
        }

        // Join the words back together
        return String.join(" ", words);
    }
    
    public double getCourseFee(){
        int quit = 0;
        double fee  = 0;
        do{
            System.out.print("Enter fee per credit hour: ");
                try{
                    fee = input.nextDouble();
                    if(isValidFee(fee)){
                        quit = 1;
                    }
                    else{
                        System.out.println("Invalid input");  
                    }
                }catch(Exception e){
                    System.out.println("Invalid Input");
                }
        }while(quit == 0);
        return fee;
    }
    
    public double getProgrammeCourseFee(){
        int quit = 0;
        double fee  = 0;
        do{
            System.out.print("Enter customize fee : ");
                try{
                    fee = input.nextDouble();
                    if(isValidFee(fee)){
                        quit = 1;
                    }
                    else{
                        System.out.println("Invalid input");  
                    }
                }catch(Exception e){
                    System.out.println("Invalid Input");
                }
        }while(quit == 0);
        return fee;
    }
    
    public static boolean isValidFee(double fee){
        return fee >= 0;
    }

    public void amendCourseMenu(){
        System.out.println("Select aspect to be ammended :");
        System.out.println("1 : Credit Hour");
        System.out.println("2 : Customize Course Fee");
        System.out.println("3 : Change Course Type(Main / Elective)");
        System.out.println("0 : Back");
    }
    
    public int getAmendCourseSelection(){
        amendCourseMenu();
        int[] option = {1,2,3,0};
        
        int choice = choiceGetter(option);
        
        return choice;
    }
    
    public static void pressToContinue(){
        MenuUI.pressToContinue();
    }
}
