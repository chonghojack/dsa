/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import adt.*;

/**
 *
 * @author user
 */
public class Test2 {
    private Test1 pointedObject;
    private ListInterface<String> items; 
    private ListInterface<Test1> tests;

    public Test2(Test1 pointedObject) {
        this.pointedObject = pointedObject;
    }

    public Test1 getPointedObject() {
        return pointedObject;
    }

    public void setPointedObject(Test1 pointedObject) {
        this.pointedObject = pointedObject;
    }

    public Test2(Test1 pointedObject, ListInterface<String> items) {
        this.pointedObject = pointedObject;
        this.items = items;
    }

    public Test2(Test1 pointedObject, ListInterface<String> items, ListInterface<Test1> tests) {
        this.pointedObject = pointedObject;
        this.items = items;
        this.tests = tests;
    }

    public ListInterface<Test1> getTests() {
        return tests;
    }

    public void setTests(ListInterface<Test1> tests) {
        this.tests = tests;
    }
    
    

    public ListInterface<String> getItems() {
        return items;
    }

    public void setItems(ListInterface<String> items) {
        this.items = items;
    }
    
    public void addItem(String newItem){
        this.items.add(newItem);
    }
    
    public void addTest(Test1 newTest){
        this.tests.add(newTest);
    }
    
    
    
    
    
        
}
