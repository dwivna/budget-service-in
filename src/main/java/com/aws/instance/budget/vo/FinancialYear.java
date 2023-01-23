package com.aws.instance.budget.vo;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinancialYear {
    private String financialYear;
    private List<MonthlyRecord> monthlyRecords;
}
