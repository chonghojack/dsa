package dao;

import adt.*;
import entity.*;

public class FacultyInitializer {
    public static Faculty[] facultyList = {
        new Faculty("FOCS", "Faculty of Computer Science"),
        new Faculty("FOFB", "Faculty of Finance and Business")
    };
    
  
    
    
    
    public static ListInterface<Faculty> initializeFaculty(){
        ListInterface<Faculty> faculties = new DoublyLinkedList<>();
        facultyList[0].addProgrammes(ProgrammeInitializer.programmeList[0]);
        facultyList[0].addProgrammes(ProgrammeInitializer.programmeList[1]);
        facultyList[1].addProgrammes(ProgrammeInitializer.programmeList[2]);
        facultyList[1].addProgrammes(ProgrammeInitializer.programmeList[3]);

        faculties.add(facultyList);
        
        return faculties;
    }
}
