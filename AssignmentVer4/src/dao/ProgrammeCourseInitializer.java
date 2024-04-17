package dao;

import adt.*;
import entity.*;

public class ProgrammeCourseInitializer {
    public static ProgrammeCourse[] programmeCourseList = {
        new ProgrammeCourse(ProgrammeInitializer.programmeList[0],CourseInitializer.courseList[0], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[0],CourseInitializer.courseList[1], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[0],CourseInitializer.courseList[5], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[0],CourseInitializer.courseList[6], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[0],CourseInitializer.courseList[4], "ELECTIVE",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[1],CourseInitializer.courseList[0], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[1],CourseInitializer.courseList[1], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[1],CourseInitializer.courseList[5], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[1],CourseInitializer.courseList[6], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[1],CourseInitializer.courseList[4], "ELECTIVE",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[2],CourseInitializer.courseList[2], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[2],CourseInitializer.courseList[3], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[2],CourseInitializer.courseList[4], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[2],CourseInitializer.courseList[6], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[2],CourseInitializer.courseList[5], "ELECTIVE",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[3],CourseInitializer.courseList[2], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[3],CourseInitializer.courseList[3], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[3],CourseInitializer.courseList[4], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[3],CourseInitializer.courseList[6], "MAIN",2),
        new ProgrammeCourse(ProgrammeInitializer.programmeList[3],CourseInitializer.courseList[5], "ELECTIVE",2) 
    };
    
    public static ListInterface<ProgrammeCourse> initializeProgrammeCourse(){
        ListInterface<ProgrammeCourse> programmesCourses = new DoublyLinkedList<>();
        
        programmesCourses.add(programmeCourseList);
        
        return programmesCourses;
    }
}
