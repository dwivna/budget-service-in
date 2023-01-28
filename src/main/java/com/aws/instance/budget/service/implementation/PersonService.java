package com.aws.instance.budget.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import com.aws.instance.budget.entity.PersonEntity;
import com.aws.instance.budget.exception.NoPersonException;
import com.aws.instance.budget.repository.PersonRepository;
import com.aws.instance.budget.service.IPersonService;
import com.aws.instance.budget.vo.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPerson(String id) {
        try {
            Optional<PersonEntity> entityOptional = personRepository.findById(id);
            if (entityOptional.isPresent()) {
                PersonEntity entity = entityOptional.get();
                Person person = new Person();
                return person.apply(entity);
            } else {
                throw new NoPersonException("No person exist having id " + id);
            }
        } catch (Exception ae) {
            log.error("Exception while fetching data...", ae);
            throw new NoPersonException("No person exist having id " + id);
        }
    }

    @Override
    public Person addPerson(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setMiddleName(person.getMiddleName());
        personEntity.setLastName(person.getLastName());
        personEntity.setFinancialYears(person.getFinancialYears());
        return person.apply(personRepository.save(personEntity));
    }

    @Override
    public Person updatePerson(Person person, String id) {
        Person existPerson = getPerson(id);
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(existPerson.getId());
        personEntity.setFirstName(existPerson.getFirstName());
        personEntity.setMiddleName(existPerson.getMiddleName());
        personEntity.setLastName(existPerson.getLastName());
        personEntity.setFinancialYears(person.getFinancialYears());
        return person.apply(personRepository.save(personEntity));
    }

    @Override
    public void deletePerson(String id) {
        try {
            personRepository.deleteById(id);
        } catch (AmazonDynamoDBException ae) {
            log.error("Exception while deleting data...", ae);
            throw new NoPersonException("No person exist having id " + id);
        }
    }

    @Override
    public List<Person> getPersons() {
        Iterable<PersonEntity> personIterable = personRepository.findAll();
        List<PersonEntity> personEntities = new ArrayList<>();
        personIterable.forEach(personEntities::add);
        if(personEntities.isEmpty()) {
            throw new NoPersonException("No Data Found");
        }
        return personEntities.stream().map(entity -> {
            Person person = new Person();
            return person.apply(entity);
        }).collect(Collectors.toList());
    }

}
