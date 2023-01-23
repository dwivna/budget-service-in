package com.aws.instance.budget.service.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aws.instance.budget.enums.Months;
import com.aws.instance.budget.service.IPersonService;
import com.aws.instance.budget.vo.Investments;
import com.aws.instance.budget.vo.MonthlyRecord;
import com.aws.instance.budget.vo.Person;
import com.aws.instance.budget.vo.Salary;
import com.aws.instance.budget.vo.SalaryDeductions;
import com.aws.instance.budget.vo.FinancialYear;

@Service
public class PersonService implements IPersonService{

    @Override
    public Person getPerson(Integer id) {
        //Person
        Person person = new Person();
        person.setName("Abhinav Dwivedi");

        MonthlyRecord monthlyRecord = new MonthlyRecord();
    
        //Salary
        Salary salary = new Salary();
        salary.setBasicPay(75000.00);
        salary.setHouseRentAllowance(37500.00);
        salary.setSpecialAllowance(119833.33);

        monthlyRecord.setSalary(salary);
        //Salary Deductions
        SalaryDeductions deductions = new SalaryDeductions();
        deductions.setProfessionalTax(200.00);
        deductions.setProvidendFund(9000.00);
        deductions.setVirtualProvidendFund(5250.00);
        deductions.setNationalPensionScheme(7500.00);
        
        monthlyRecord.setDeductions(deductions);

        //Schemes
        Map<String,Double> schemes = new HashMap<>();
        schemes.put("nationalPensionSchemeTier2", 5000.00);
        schemes.put("lifeInsuranceCorporation1", 10911.00);
        schemes.put("publicProvidendFund", 10000.00);
        schemes.put("sukanyaSamridhiAccount", 12500.00);
        schemes.put("termInsurance", 2515.00);
        Investments investments = new Investments(schemes);
    
        monthlyRecord.setInvestments(investments);
        monthlyRecord.setMonth(Months.DEC.getValue());
        FinancialYear financialYear = new FinancialYear();
        List<MonthlyRecord> monthlyRecords = new ArrayList<>();
        monthlyRecords.add(monthlyRecord);
        
        financialYear.setMonthlyRecords(monthlyRecords);
        financialYear.setFinancialYear("2022-23");

        List<FinancialYear> financialYears = new ArrayList<>();
        financialYears.add(financialYear);
        person.setFinancialYears(financialYears);
        return person;
    }
    
}
