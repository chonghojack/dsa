package dao;

import adt.*;
import entity.*;

public class ProgrammeInitializer {
    public static Programme[] programmeList = {
        new Programme("RSW", "Software Engineering", 3),
        new Programme("RDS", "Data Science", 3),
        new Programme("RFI", "Finance and Investment", 3),
        new Programme("REE", "Economics", 3),
    };
    
    public static ListInterface<Programme> programmeList1(){
        ListInterface<Programme> programmes = new DoublyLinkedList<>();
        programmes.add(programmeList[0]);
        programmes.add(programmeList[1]);
        
        return programmes;
    }
    
    public static ListInterface<Programme> programmeList2(){
        ListInterface<Programme> programmes = new DoublyLinkedList<>();
        programmes.add(programmeList[2]);
        programmes.add(programmeList[3]);
        
        return programmes;
    }
    
    
    public static ListInterface<Programme> initializeProgramme(){
        ListInterface<Programme> programmes = new DoublyLinkedList<>();
                
        programmes.add(programmeList);
        
        return programmes;
    }
}
