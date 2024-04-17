package entity;

import adt.*;

public class ProgrammeCourse {
    private Programme programme;
    private Course course;
    private int creditHours;
    private double fee;
    private String type; //main / elective
    private ListInterface<Group> groupList;
    private ListInterface<StudentDetail> studentList;

    public ProgrammeCourse() {
    }

    public ProgrammeCourse(Programme programme, Course course, int creditHours, double fee, String type, ListInterface<Group> groupList, ListInterface<StudentDetail> studentList) {
        this.programme = programme;
        this.course = course;
        this.creditHours = creditHours;
        this.fee = creditHours * course.getFeePerCreditHours();
        this.type = type;
        this.groupList = groupList;
        this.studentList = studentList;
    }

    public ProgrammeCourse(Programme programme, Course course, String type,int creditHours) {
        this.programme = programme;
        this.course = course;
        this.type = type;
        this.creditHours = creditHours;
        this.fee = creditHours * course.getFeePerCreditHours();
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
        this.fee = creditHours * course.getFeePerCreditHours();
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ListInterface<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(ListInterface<Group> groupList) {
        this.groupList = groupList;
    }

    public ListInterface<StudentDetail> getStudentList() {
        return studentList;
    }

    public void setStudentList(ListInterface<StudentDetail> studentList) {
        this.studentList = studentList;
    }
    
    //function
    public void display(){
        System.out.printf("%-40s\n", "----------------------------------------");
        System.out.printf("%-1s%-10s%-1s%-27s%-1s\n", "|", "Programme", ":", this.getProgramme().getName(), "|");
        System.out.printf("%-1s%-10s%-1s%-27s%-1s\n", "|", "Course", ":", this.getCourse().getName(), "|");
        System.out.printf("%-1s%-10s%-1s%-27s%-1s\n", "|", "Type", ":", this.type, "|");        
        System.out.printf("%-1s%-10s%-1s%-27d%-1s\n", "|", "CreditHour", ":", this.creditHours, "|");
        System.out.printf("%-1s%-10s%-1s%-27.2f%-1s\n", "|", "Fee", ":", this.fee, "|");
        System.out.printf("%-40s\n", "----------------------------------------");
    
    }
    
    
}
