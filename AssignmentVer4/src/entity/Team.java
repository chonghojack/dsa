package entity;

import adt.*;

public class Team {
    private String id;
    private static int TEAMSIZE = 5;
    private DoublyLinkedList<Student> members;
    
    //class fucntion
    public void addMember(Student newStudent){
        this.members.add(newStudent);
    }
}
