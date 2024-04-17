package entity;

import adt.*;

public class Faculty {
    private String id;
    private String name;
    private ListInterface<Programme> programmeList;

    public Faculty() {
    }

    public Faculty(String id, String name) {
        this.id = id;
        this.name = name;
        this.programmeList = new DoublyLinkedList<>();
    }    

    public Faculty(String id, String name, DoublyLinkedList<Programme> programmes) {
        this.id = id;
        this.name = name;
        this.programmeList = programmes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListInterface<Programme> getProgrammes() {
        return programmeList;
    }

    public void setProgrammes(DoublyLinkedList<Programme> programmes) {
        this.programmeList = programmes;
    }
    
    //function
    public void addProgrammes(Programme newEntry){
        this.programmeList.add(newEntry);
    }
}
