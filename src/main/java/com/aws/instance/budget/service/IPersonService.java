package com.aws.instance.budget.service;

import java.util.List;

import com.aws.instance.budget.vo.Person;

public interface IPersonService {
    Person getPerson(String id);

    Person addPerson(Person person);

    Person updatePerson(Person person, String id);

    void deletePerson(String id);

    List<Person> getPersons();    
}
