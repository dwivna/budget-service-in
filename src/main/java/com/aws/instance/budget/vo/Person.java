package com.aws.instance.budget.vo;

import java.util.List;

import com.aws.instance.budget.entity.PersonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<FinancialYear> financialYears;

    public Person apply(PersonEntity entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.middleName = entity.getMiddleName();
        this.lastName = entity.getLastName();
        this.financialYears = entity.getFinancialYears();
        return this;
    }
}
