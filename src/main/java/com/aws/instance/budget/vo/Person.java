package com.aws.instance.budget.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private List<FinancialYear> financialYears;
}
