package com.aws.instance.budget.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryDeductions {
    private Double providendFund;
    private Double virtualProvidendFund;
    private Double professionalTax;
    private Double nationalPensionScheme;
}
