package control;

//Author : CHONG HO JACK

import adt.*;
import entity.*;
import boundary.CourseManagementUI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;

public class CourseManagementSubsystem {
    private CourseManagementUI cmUI = new CourseManagementUI();
    
    ListInterface<Faculty> facultyList = Driver.facultyList;
    ListInterface<Programme> programmeList = Driver.programmeList;
    ListInterface<Course> courseList = Driver.courseList;
    ListInterface<ProgrammeCourse> programmeCourse = Driver.programmeCourse;
     
    public void runCourseManagementSubsystem(){
        int quit = 0;
        do{
            System.out.println("\n");
            int choice = cmUI.getMenuChoice();
            
            switch(choice){
                case 1 ->  {
                    //add a programme to course
                    task1();
                }

                case 2 ->  {
                    //remove a programe from a course
                    task2();
                }

                case 3 ->  {
                    //add a new course to a program
                    task3();
                }

                case 4 ->  {
                    //remove a course from a programme
                    task4();
                }

                case 5 ->  {
                    //amend course details for a programme
                    task5();

                }
                
                case 6 ->  {
                    //list courses take by different faculties
                    task6();
                }
                
                case 7 ->  {
                    //list all course for a program
                    task7();
                    
                }
                
                case 8 ->  {
                    //generate report
                    task8();

                }

                case 0 ->  {
                    //back
                    quit = 1;
                }  

                default ->  {
                }
            }
        }while(quit == 0);
    }
    
    // add programme to course
    public void task1(){
        int quit = 0;
        
        do{
            System.out.println("\n");
            System.out.println("Select programme : "); 
            int noOfList = listAllProgramme();
            System.out.println("\nEnter selected programme NO to add to course or 0 to return.");
            
            int input1 = cmUI.getSelection(noOfList);
            
            if(!isReturn(input1)){
                do{
                    System.out.println("\n");
                    System.out.println("Select Course");
                    int noOfList2 = listAllCourse();
                    System.out.println("\nEnter Course NO to add programme or 0 to return.");

                    int input2 = cmUI.getSelection(noOfList2);
                    
                    if(!isReturn(input2)){
                        if(addProgrammeToCourse(input1, input2)){
                            System.out.println("Record added Successfully!");
                        }else{
                            System.out.println("Failed to add Record!");
                        };
                        quit = 1;
                    }else{
                        quit = 1;
                    }

                }while(quit == 0);
            }else{
                quit = 1;
            }
        } while(quit == 0);
    }
    
    // remove programme from course
    public void task2(){
        int quit = 0;
        
        do{
            System.out.println("\n");
            System.out.println("Select course : "); 
            int noOfList = listAllCourse();
            System.out.println("\nEnter selected Course NO to show programme(s) or 0 to return.");
            
            int input1 = cmUI.getSelection(noOfList);
            
            if(!isReturn(input1)){
                do{
                    System.out.println("\n");
                    System.out.println("Select Programme from selected course");
                    int noOfList2 = listProgrammeByCourse(input1);
                    System.out.println("\nEnter selected Programme NO to remove or 0 to return.");

                    int input2 = cmUI.getSelection(noOfList2);
                    
                    if(!isReturn(input2)){
                        if(removeProgrammeFromCourse(input1, input2)){
                            System.out.println("Programme deleted Successfully from Course!");
                        }else{
                            System.out.println("Failed to delete Record!");
                        };
                        quit = 1;
                    }else{
                        quit = 1;
                    }

                }while(quit == 0);
            }else{
                quit = 1;
            }
        } while(quit == 0);   
    }
    
    // add new course to programme
    public void task3(){
        int quit = 0;
        
        do{
            if(createNewCourse()){
                System.out.println("\n");
                System.out.println("Select Programme :");
                int i = listAllProgramme();
                System.out.println("\nEnter selected Programme NO to add course or 0 to return.");
                
                int input = cmUI.getSelection(i);

                if(!isReturn(input)){
                    if(addCourseToProgramme(courseList.getNumberOfEntries(), input)){
                        System.out.println("Course added successfully!");
                    }else{
                        System.out.println("Failed to add course!");
                    }
                    quit = 1;       
                }else{
                    quit = 1;
                }   
            }else{
                System.out.println("Course not created");
                quit = 1;
            }
        }while(quit == 0);
    }
    
    // remove course from programme
    public void task4(){
        int quit = 0;
        
        do{
            System.out.println("\n");
            System.out.println("Select programme : "); 
            int noOfList = listAllProgramme();
            System.out.println("\nEnter selected Programme NO to show course(s) or 0 to return.");
            
            int input1 = cmUI.getSelection(noOfList);
            
            if(!isReturn(input1)){
                do{
                    System.out.println("\n");
                    System.out.println("Select Course from selected programme");
                    int noOfList2 = listCourseByProgramme(input1);
                    System.out.println("\nEnter selected Course NO to remove or 0 to return.");
                        
                    int input2 = cmUI.getSelection(noOfList2);
                    
                    if(!isReturn(input2)){
                        if(removeCourseFromProgramme(input1, input2)){
                            System.out.println("Course deleted Successfully from Programme!");
                        }else{
                            System.out.println("Failed to delete Record!");
                        };
                        quit = 1;
                    }else{
                        quit = 1;
                    }

                }while(quit == 0);
            }else{
                quit = 1;
            }
        } while(quit == 0);
    }
    
    // amend course details for a programme
    public void task5(){
        int quit = 0;
            
        do{
            System.out.println("\n");
            System.out.println("Select programme : "); 
            int noOfList = listAllProgramme();
            System.out.println("\nEnter selected Programme NO to show course(s) or 0 to return.");
            
            int input1 = cmUI.getSelection(noOfList);
            
            if(!isReturn(input1)){
                do{
                    System.out.println("\n");
                    System.out.println("Select Course from selected programme");
                    int noOfList2 = listCourseByProgramme(input1);
                    System.out.println("\nEnter selected Course NO to amend or 0 to return.");
                        
                    int input2 = cmUI.getSelection(noOfList2);
                    
                    if(!isReturn(input2)){
                        Programme selectedProgramme = programmeList.getEntry(input1);
                        ProgrammeCourse selectedProgrammeCourse = null;
                        
                        Iterator<ProgrammeCourse> iterator = programmeCourse.getIterator();
                        int counter = 0;
                        int i = 0;
                        while(iterator.hasNext()){
                            ProgrammeCourse current = iterator.next();
                            i++;
                            if(current.getProgramme().equals(selectedProgramme)){
                                counter++;
                                if(counter == input2){
                                    selectedProgrammeCourse = current;
                                    break;
                                }
                            }
                        }
                        if(selectedProgrammeCourse != null){
                            amendProgrammeCourse(selectedProgrammeCourse);
                            System.out.println("Course Amended Successfully from Programme!");
                            System.out.println("Amend Result : ");
                            selectedProgrammeCourse.display();
                        }else{
                            System.out.println("Course not found!");
                        }
                    }else{
                        quit = 1;
                    }

                }while(quit == 0);
            }else{
                quit = 1;
            }
        }while(quit == 0);
    }
    
    //list courses take by different faculties
    public void task6(){
        int quit = 0;
        
        do{
            System.out.println("\n");
            System.out.println("Select Faculty : ");
            int noOfList = listAllFaculty();
            
            System.out.println("\nEnter selected Faculty NO to show course(s) or 0 to return.");
            
            int input = cmUI.getSelection(noOfList);
            
            if(!isReturn(input)){
                listCourseByFaculty(input);
                
                CourseManagementUI.pressToContinue();
            }else{
                quit = 1;
            }
            
            
        }while(quit == 0);
    };
    
    //list all course for a programme
    public void task7(){
        int quit = 0;
        
        do{
            System.out.println("\n");
            System.out.println("Select programme : "); 
            int noOfList = listAllProgramme();
            System.out.println("\nEnter selected programme NO to view course(s) or 0 to return.");
            
            int input1 = cmUI.getSelection(noOfList);
            
            if(!isReturn(input1)){
                listCourseByProgramme(input1);
                CourseManagementUI.pressToContinue();
                quit = 1;
            }else{
                quit = 1;
            }
        }while(quit == 0);
    }
    
    //generate report
    public void task8(){
        
        System.out.printf("%-80s\n"         , "================================================================================");
        System.out.printf("%-80s\n"         , "           TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY           ");
        System.out.printf("%-80s\n"         , "                           COURSE MANAGEMENT SUBSYSTEM                          ");
        System.out.printf("%-80s\n"         , "                                                                                ");
        System.out.printf("%-80s\n"         , "                              COURSE SUMMARY REPORT                             ");
        System.out.printf("%-80s\n"         , "                           ---------------------------                          ");
        System.out.printf("%-14s%-65s\n"    , "Generated at : ", getCurrentDayDateTime());
        System.out.printf("%-80s\n"         , "      CODE                COURSE NAME                FEE/CREDITHOUR   PROGRAMME ");
        System.out.printf("%-80s\n"         , "    -------- -------------------------------------- ---------------- -----------");
        Iterator<Course> iterator1 = courseList.getIterator();
        int i = 1;
        while(iterator1.hasNext()){
            int count = 0;
            Course current1 = iterator1.next();
            Iterator<ProgrammeCourse> iterator2 = programmeCourse.getIterator();
            while(iterator2.hasNext()){
                ProgrammeCourse current2 = iterator2.next();
                if(current2.getCourse().equals(current1)){
                    count ++ ;
                }
            }
            System.out.printf(" %-2d %-8s %-38s %-4s%-7.2f%-11s%-3d\n", i, current1.getId(), current1.getName(), "",current1.getFeePerCreditHours(),"", count );
            i++;
        }
        System.out.printf("%-80s\n"         , "================================================================================");

                                    
                                     
        CourseManagementUI.pressToContinue();
    };
    
    public static String getCurrentDayDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Create a DateTimeFormatter with a custom pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy, h:mma", Locale.ENGLISH);

        // Format the current date and time using the formatter
        String formattedDateTime = currentDateTime.format(formatter);

        // Return the formatted date and time
        return formattedDateTime;
    }
    
    public boolean amendProgrammeCourse(ProgrammeCourse selectedProgrammeCourse){
        int quit = 0;
        do{
            selectedProgrammeCourse.display();
            int input = cmUI.getAmendCourseSelection();
            
            if(!isReturn(input)){
                switch(input){
                    case 1 ->  {
                        int newCreditHour = cmUI.getCreditHour();
                        selectedProgrammeCourse.setCreditHours(newCreditHour);
                    }
                    case 2 ->  {
                        double newCourseFee = cmUI.getProgrammeCourseFee();
                        selectedProgrammeCourse.setFee(newCourseFee);
                    }
                    case 3 ->  {
                        if(selectedProgrammeCourse.getType().equals("MAIN")){
                            selectedProgrammeCourse.setType("ELECTIVE");
                        }else{
                            selectedProgrammeCourse.setType("MAIN");
                        }
                        System.out.println("Type changed");
                    }
                }
            }else{
                quit = 1;
            }
        }while(quit == 0);
        
        return true;
    }
    
    
    public boolean createNewCourse(){
        System.out.println("= Create a new course =");
        String courseCode = cmUI.getCourseCode();
        while(isCourseCodeDuplicate(courseCode)){
            System.out.println("Course code duplicated!");
            courseCode = cmUI.getCourseCode();
        }
        String courseName = cmUI.getCourseName();
        double fee = cmUI.getCourseFee();
        
        Course newCourse = new Course(courseCode, courseName, fee);
        newCourse.display();
        
        if(cmUI.getCreateMenu() == 1){
            courseList.add(newCourse);
            return true;
        }
        else{
            System.out.println("Action Retrived!");
            return false;
        }
    }
    
    public boolean isCourseCodeDuplicate(String code){
        Iterator<Course> iterator = courseList.getIterator();
        
        while(iterator.hasNext()){
            Course current = iterator.next();
            if(current.getId().equals(code)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean addCourseToProgramme(int courseEntry, int programmeEntry){
        Course selectedCourse = courseList.getEntry(courseEntry); 
        Programme selectedProgramme = programmeList.getEntry(programmeEntry);

        if(isProgramCourseExist(selectedProgramme,selectedCourse)){
            System.out.println("Record Exist!");
            return false;
        }
        else{
            System.out.println("\n");
            System.out.println("----------------------------------------");
            System.out.println("Adding " + selectedCourse.getName() + " Course to " + selectedProgramme.getName() + " Programme");
            System.out.println("----------------------------------------");
            int creditHour = cmUI.getCreditHour();
            System.out.println("\n");
            String type = null;
            switch(cmUI.getSelectType()){
                case 1 -> type = "MAIN";
                case 2 -> type = "ELECTIVE";
            }
            System.out.println("\n");
            ProgrammeCourse newProgramCourse = new ProgrammeCourse(selectedProgramme, selectedCourse, type, creditHour);
            newProgramCourse.display();
            if(cmUI.getAddMenu() == 1){
                programmeCourse.add(newProgramCourse);
                return true;
            }else{
                System.out.println("Action retrived");
                return false;
            }
        }
    };
    
    public boolean addProgrammeToCourse(int programmeEntry, int courseEntry){
        Programme selectedProgramme = programmeList.getEntry(programmeEntry);
        Course selectedCourse = courseList.getEntry(courseEntry);
        
        if(isProgramCourseExist(selectedProgramme,selectedCourse)){
            System.out.println("Record Exist!");
            return false;
        }
        else{
            System.out.println("\n");
            System.out.println("----------------------------------------");
            System.out.println("Adding " + selectedProgramme.getName() + " Programme to " + selectedCourse.getName() + "Course");
            System.out.println("----------------------------------------");
            int creditHour = cmUI.getCreditHour();
            System.out.println("\n");
            String type = null;
            switch(cmUI.getSelectType()){
                case 1 -> type = "MAIN";
                case 2 -> type = "ELECTIVE";
            }
            System.out.println("\n");
            ProgrammeCourse newProgramCourse = new ProgrammeCourse(selectedProgramme, selectedCourse, type, creditHour);
            newProgramCourse.display();
            if(cmUI.getAddMenu() == 1){
                programmeCourse.add(newProgramCourse);
                return true;
            }else{
                System.out.println("Action retrived");
                return false;
            }
        }
    };
    
    public boolean removeProgrammeFromCourse(int courseEntry, int programmeEntry) {
        Course selectedCourse = courseList.getEntry(courseEntry);
        ProgrammeCourse selectedProgrammeCourse = null;
        
        Iterator<ProgrammeCourse> iterator = programmeCourse.getIterator();
        int counter = 0;
        int i = 0;
        while(iterator.hasNext()){
            ProgrammeCourse current = iterator.next();
            i++;
            if(current.getCourse().equals(selectedCourse)){
                counter++;
                if(counter == programmeEntry){
                    selectedProgrammeCourse = current;
                    break;
                }
            }
        }
        
        if(selectedProgrammeCourse != null){
            selectedProgrammeCourse.display();
            if(cmUI.getRemoveMenu() == 1){
                programmeCourse.remove(i);
                return true;
            }else{
                System.out.println("Action retrived");
                return false;
            }  
        }
        else{
            System.out.println("Record does not exist!");
            return false;
        }
    }
    
    public boolean removeCourseFromProgramme(int programmeEntry, int courseEntry) {
        Programme selectedProgramme = programmeList.getEntry(programmeEntry);
        ProgrammeCourse selectedProgrammeCourse = null;
        
        Iterator<ProgrammeCourse> iterator = programmeCourse.getIterator();
        int counter = 0;
        int i = 0;
        while(iterator.hasNext()){
            ProgrammeCourse current = iterator.next();
            i++;
            if(current.getProgramme().equals(selectedProgramme)){
                counter++;
                if(counter == courseEntry){
                    selectedProgrammeCourse = current;
                    break;
                }
            }
        }
        
        if(selectedProgrammeCourse != null){
            selectedProgrammeCourse.display();
            if(cmUI.getRemoveMenu() == 1){
                programmeCourse.remove(i);
                return true;
            }else{
                System.out.println("Action retrived");
                return false;
            }  
        }
        else{
            System.out.println("Record does not exist!");
            return false;
        }
    }
    
    public boolean isProgramCourseExist(Programme programme, Course course){
        Iterator<ProgrammeCourse> iterator = programmeCourse.getIterator();
        while(iterator.hasNext()){
            ProgrammeCourse current = iterator.next();
            if(current.getProgramme().equals(programme) && current.getCourse().equals(course)){
                return true;
            }
                
        }
        return false;
    };
    
    public int listAllProgramme(){
        Iterator<Programme> iterator = programmeList.getIterator();
        int i = 0;
        System.out.printf("%-3s%-6s%-30s\n","NO", "ID", "Programme Name");
        while(iterator.hasNext()){
            Programme current = iterator.next();
            System.out.printf("%-3d%-6s%-30s\n", i + 1, current.getId(), current.getName());
            i++;
        }
        
        return i;
    }
    
    public int listProgrammeByCourse(int selectedCourseEntry){
        Iterator<ProgrammeCourse> iterator = programmeCourse.getIterator();
        int i = 0;
        System.out.printf("%-3s%-6s%-30s\n","NO", "ID", "Course Name");
        while(iterator.hasNext()){
            ProgrammeCourse current = iterator.next();
            if(current.getCourse().equals(courseList.getEntry(selectedCourseEntry))){
                System.out.printf("%-3d%-6s%-30s\n", i + 1, current.getProgramme().getId(), current.getProgramme().getName());
                i++;
            }
        }
        return i;
    }
    
    public int listAllCourse(){
        Iterator<Course> iterator = courseList.getIterator();
        int i = 0;
        System.out.printf("%-3s%-9s%-30s\n","NO", "ID", "Course Name");
        while(iterator.hasNext()){
            Course current = iterator.next();
            System.out.printf("%-3d%-9s%-30s\n", i + 1,current.getId(), current.getName());
            i++;
        }        
        return i;
    }
    
    public int listCourseByProgramme(int selectedProgrammeEntry){
        Iterator<ProgrammeCourse> iterator = programmeCourse.getIterator();
        int i = 0;
        System.out.printf("%-3s%-9s%-30s\n","NO", "ID", "Course Name");
        while(iterator.hasNext()){
            ProgrammeCourse current = iterator.next();
            if(current.getProgramme().equals(programmeList.getEntry(selectedProgrammeEntry))){
                System.out.printf("%-3d%-9s%-30s\n", i + 1, current.getCourse().getId(), current.getCourse().getName());
                i++;
            }
        }
        return i;
    }
    
    public void listCourseByFaculty(int facultyEntry) {
        Faculty selectedFaculty = facultyList.getEntry(facultyEntry);
        Iterator<Programme> iterator = selectedFaculty.getProgrammes().getIterator();
        System.out.printf("%-4s%-25s%-3s%-8s %-25s\n", "ID", " Programme", "NO", "Code", "Course");
        while (iterator.hasNext()) {
            Programme current = iterator.next();
            int i = 1;
            Iterator<ProgrammeCourse> iterator2 = programmeCourse.getIterator();
            while (iterator2.hasNext()) {
                ProgrammeCourse current2 = iterator2.next(); // Move to the next ProgrammeCourse
                if (current2.getProgramme().equals(current)) {
                    if (i == 1) {
                        System.out.printf("%-4s%-25s%-3d%-8s %-25s\n", current.getId(), current.getName(), i, current2.getCourse().getId(), current2.getCourse().getName());
                        i++;
                    } else {
                        System.out.printf("%-4s%-25s%-3d%-8s %-25s\n", "", "", i, current2.getCourse().getId(), current2.getCourse().getName());
                        i++;
                    }
                }
            }
            System.out.println("");
        }
    }
    
    public int listAllFaculty(){
        Iterator<Faculty> iterator = facultyList.getIterator();
        int i = 0;
        System.out.printf("%-3s%-9s%-30s\n","NO", "ID", "Faculty Name");
        while(iterator.hasNext()){
            Faculty current = iterator.next();
            System.out.printf("%-3d%-9s%-30s\n", i + 1,current.getId(), current.getName());
            i++;
        }        
        return i;
    }
    
    public boolean isReturn(int input){
        boolean valid = false;
        if(input == 0){
            valid  = true;
        }
        
        return valid;
    }
    
    public static void main(String[] args){
        CourseManagementSubsystem cm = new CourseManagementSubsystem();
        
        cm.runCourseManagementSubsystem();
    }
}
