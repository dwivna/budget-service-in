package com.aws.instance.budget.controller;

import java.util.List;

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
    public Person getPerson(@PathVariable String id) {
        return personService.getPerson(id);
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping(path = "/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String id) {
        return personService.updatePerson(person, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
        return "Deleted person having ID " + id + " successfully.";
    }
}
