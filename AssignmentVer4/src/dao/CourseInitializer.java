package dao;

import adt.*;
import entity.*;

public class CourseInitializer {
    public static Course[] courseList = {
        new Course("BAMS1044", "Intorduction to Networking", 100),
        new Course("BACS6683", "Software Engineering", 120),
        new Course("BBBB1234", "Introduction to Economics", 110),
        new Course("AAAA1234", "Accounting", 110),
        new Course("EEEE1234", "Entrepreneurship", 90),
        new Course("DDDD1234", "Advanced Mathematics", 80),
        new Course("AACS1124", "Tertiary English", 150),
    };
    
    public static ListInterface<Course> initializeCourse(){
        ListInterface<Course> courses = new DoublyLinkedList<>();
        
        courses.add(courseList);
        
        return courses;
    }
}
