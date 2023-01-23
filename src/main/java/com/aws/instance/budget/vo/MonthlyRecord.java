package com.aws.instance.budget.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonthlyRecord {
    private Integer month;
    private Salary salary;
    private SalaryDeductions deductions;
    private Investments investments;
}
