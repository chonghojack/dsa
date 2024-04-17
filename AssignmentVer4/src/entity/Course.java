package entity;

import adt.*;

public class Course {
    private String id;
    private String name;
    private ListInterface<Tutor> tutorList;   
    private double feePerCreditHours;
    private static int DEFAULTCH = 2;
    
    public Course() {
    }

    public Course(String id, String name, double feePerCreditHours) {
        this.id = id;
        this.name = name;
        this.feePerCreditHours = feePerCreditHours;
    }

    public Course(String id, String name, ListInterface<Tutor> tutorList, double feePerCreditHours) {
        this.id = id;
        this.name = name;
        this.tutorList = tutorList;
        this.feePerCreditHours = feePerCreditHours;
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

    public ListInterface<Tutor> getTutorList() {
        return tutorList;
    }

    public void setTutorList(ListInterface<Tutor> tutorList) {
        this.tutorList = tutorList;
    }

    public double getFeePerCreditHours() {
        return feePerCreditHours;
    }

    public void setFeePerCreditHours(double feePerCreditHours) {
        this.feePerCreditHours = feePerCreditHours;
    }

    public static int getDEFAULTCH() {
        return DEFAULTCH;
    }

    public static void setDEFAULTCH(int DEFAULTCH) {
        Course.DEFAULTCH = DEFAULTCH;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", tutorList=" + tutorList + ", feePerCreditHours=" + feePerCreditHours + '}';
    }
    
    //function
    public void display(){
        System.out.printf("%-40s\n", "----------------------------------------");
        System.out.printf("%-1s%-15s%-1s%-22s%-1s\n", "|", "Code", ":", this.id, "|");
        System.out.printf("%-1s%-15s%-1s%-22s%-1s\n", "|", "Name", ":", this.name, "|");
        System.out.printf("%-1s%-15s%-1s%-22.2f%-1s\n", "|", "Fee/CreditHour", ":", this.feePerCreditHours, "|");
        System.out.printf("%-40s\n", "----------------------------------------");

    }
    
    
}
