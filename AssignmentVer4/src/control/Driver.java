package control;

import adt.*;
import entity.*;
import dao.*;
import boundary.MainUI;
import java.util.Iterator;

public class Driver {
    private MainUI mainUI = new MainUI();
    private final StudentRegistrationManagementSubsystem studentManagementSubsystem = new StudentRegistrationManagementSubsystem();
    private final CourseManagementSubsystem courseManagementSubsystem = new CourseManagementSubsystem(); 
    private final TutorialGroupManagementSubsystem tutorialGroupManagementSubsystem = new TutorialGroupManagementSubsystem();
    private final TeachingAssignmentSubsystem teachingAssignmentSubsystem = new TeachingAssignmentSubsystem();
    private final AssignmentTeamManagementSubsystem assignmentTeamManagementSubsystem = new AssignmentTeamManagementSubsystem();
    
    //add initializer here
    public static ListInterface<Faculty> facultyList = FacultyInitializer.initializeFaculty();
    public static ListInterface<Programme> programmeList = ProgrammeInitializer.initializeProgramme();
    public static ListInterface<Course> courseList = CourseInitializer.initializeCourse();
    public static ListInterface<ProgrammeCourse> programmeCourse = ProgrammeCourseInitializer.initializeProgrammeCourse();
    
    public void runMainMenu(){
        int quit = 0;
        do{
            System.out.println("\n");
            int choice = mainUI.getMainMenuChoice();
            
            switch(choice){
                case 1 : {
                    //run student management subsystem
                    Iterator<ProgrammeCourse> iterator = programmeCourse.getIterator();
                    while(iterator.hasNext()){
                        ProgrammeCourse current = iterator.next();
                        System.out.println(current.getCourse().getName() + current.getProgramme().getName() + current.getCreditHours() + current.getType());
                    }
                    //studentManagementSubsystem.runStudentRegistrationManagementSubsystem();
                    break;
                }

                case 2 : {
                    //run course management subsystem
                    courseManagementSubsystem.runCourseManagementSubsystem();
                    System.out.println("\n");
                    break;
                }

                case 3 : {
                    //run tutorial management subsystem
                    tutorialGroupManagementSubsystem.runTutorialGroupManagementSubsystem();
                    break;
                }

                case 4 : {
                    //run teaching assignment subsystem
                    teachingAssignmentSubsystem.runTeachingAssignmentSubsystem();
                    break;
                }

                case 5 : {
                    //run assignment team management subsystem
                    assignmentTeamManagementSubsystem.runAssignmentTeamManagementSubsystem();
                    break;
                }
                

                case 0 : {
                    //save and quit
                    quit = runQuitMenu();
                    break;
                }  

                default : {
                    
                    break;
                }
            }
        }while(quit == 0);
        
        System.out.println("Shutting down....Have a nice day");
    }
    
    public int runQuitMenu(){
        int choice = mainUI.getQuitMenuChoice();
        int quit = 0;
        switch(choice){
            case 1 : {
                //save and quit
                quit = 1;
                break;
            }
            case 0 : {
                quit = 0;
            }
            default : {
                quit = 0;
            }
        }
        
        return quit;
    }
    
    public static void main(String[] args){
        Driver mainControl = new Driver();
        
        try{
            mainControl.runMainMenu();
        }catch(Exception e){
            System.out.println("Error Occurs");
        }    
    }
}
