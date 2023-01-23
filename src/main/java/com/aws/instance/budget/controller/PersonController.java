package com.aws.instance.budget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.instance.budget.service.IPersonService;
import com.aws.instance.budget.vo.Person;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private IPersonService personService;
    
    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable Integer id){
        return personService.getPerson(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return person;
    }

    @PutMapping(path = "/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Integer id){
        return person;
    }

    @DeleteMapping(path = "/{id}")
    public String deletePerson(@PathVariable Integer id){
        return "Deleted " + id + " Successfully.";
    }
}
