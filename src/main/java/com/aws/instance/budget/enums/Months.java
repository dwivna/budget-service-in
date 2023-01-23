package com.aws.instance.budget.enums;

public enum Months {
    JAN(1),FEB(1),MAR(3),APR(4),MAY(5),
    JUN(6),JUL(7),AUG(8),SEP(9),OCT(10),
    NOV(11),DEC(12);

    private Integer value;

    private Months(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }
}
