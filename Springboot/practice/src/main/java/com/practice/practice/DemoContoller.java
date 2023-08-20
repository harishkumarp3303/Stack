package com.practice.practice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Person{
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    

}

/**
 * Contoller
 */
@RestController
@CrossOrigin(origins = "*")
public class DemoContoller {

    @PostMapping("addperson")
    public ResponseEntity<Person>  addPerson(@RequestBody() Person person){
        System.out.println(person.name);
        System.out.println(person.age);
        return ResponseEntity.ok(person);
    }
    @GetMapping("getperson")
    public String  getPerson(){
 
        return "Person getting successfully";
    }


}