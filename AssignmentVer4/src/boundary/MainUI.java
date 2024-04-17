package boundary;

public class MainUI extends MenuUI{
    public void mainMenu(){
        System.out.println("= University Management System =");
        System.out.println("1 : Student Registration Management");
        System.out.println("2 : Course Management");
        System.out.println("3 : Tutorial Group Management");
        System.out.println("4 : Teaching Assignment");
        System.out.println("5 : Assignment Team Management");
        System.out.println("0 : Quit System");
    }
    
    public int getMainMenuChoice(){
        int choice;
        
        mainMenu();
        
        int[] option = {1,2,3,4,5,0};
        
        choice = choiceGetter(option);
        
        return choice;
    }
    
    public void quitMenu(){
        System.out.println("Are you sure you want to QUIT the system?");
        System.out.println("1 : YES");
        System.out.println("0 : NO");
    }
    
    public int getQuitMenuChoice(){
        int choice;
        
        quitMenu();
        
        int[] option = {0,1};
        
        choice = choiceGetter(option);
        
        return choice;
    }
}
