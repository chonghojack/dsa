package entity;

import adt.*;

public class Programme {
    private String id;
    private String name;
    private int numberOfGroup;
    private ListInterface<Student> studentList;

    public Programme() {
    }

    public Programme(String id, String name, int numberOfGroup, ListInterface<Student> studentList) {
        this.id = id;
        this.name = name;
        this.numberOfGroup = numberOfGroup;
        this.studentList = studentList;
    }

    public Programme(String id, String name, int numberOfGroup) {
        this.id = id;
        this.name = name;
        this.numberOfGroup = numberOfGroup;
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

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public ListInterface<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ListInterface<Student> studentList) {
        this.studentList = studentList;
    }
    
    //function
    public void addStudent(Student newStudent){
        this.studentList.add(newStudent);
    }
    
}
