package utility;

import adt.*;
import entity.*;
import dao.*;

public class Tester {
    
    
    public void runTester(){
        Test1 stud1 = new Test1("Chong Ho Jack1");
        Test1 stud2 = new Test1("Chong Ho Jack2");
        Test1 stud3 = new Test1("Chong Ho Jack3");
        Test1 stud4 = new Test1("Chong Ho Jack4");
        
        Test3 test3 = new Test3();
        //Test2 test2 = new Test2(stud1);
        
//        System.out.println(test2.getPointedObject().getName());
//        
//        test1.setName("Chia Ser Yong");
//        
//        System.out.println(test2.getPointedObject().getName());
    }
    
    public static void main(String[] args){
        Tester tester = new Tester();
        tester.runTester();
    }
}
