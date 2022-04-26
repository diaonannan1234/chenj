package com.chen;

import java.math.BigDecimal;

public class SumResultExcel {

    private String device;

    private double deviceDepreciation;

    private double directLaborSalary;

    private double indirectLaborSalary;

    public SumResultExcel(Object[] ob) {
       this.device = (String)(ob[0]);
       this.deviceDepreciation = ((BigDecimal)ob[1]) == null ? 0f : ((BigDecimal)ob[1]).doubleValue();
       this.directLaborSalary = ((BigDecimal)ob[1]) == null ? 0f : ((BigDecimal)ob[1]).doubleValue();
       this.indirectLaborSalary = ((BigDecimal)ob[1]) == null ? 0f : ((BigDecimal)ob[1]).doubleValue();
    }

    public String getDevice() {
        return device;
    }


    public Double getDeviceDepreciation() {
        return deviceDepreciation;
    }


    public Double getDirectLaborSalary() {
        return directLaborSalary;
    }


    public Double getIndirectLaborSalary() {
        return indirectLaborSalary;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setDeviceDepreciation(double deviceDepreciation) {
        this.deviceDepreciation = deviceDepreciation;
    }

    public void setDirectLaborSalary(double directLaborSalary) {
        this.directLaborSalary = directLaborSalary;
    }

    public void setIndirectLaborSalary(double indirectLaborSalary) {
        this.indirectLaborSalary = indirectLaborSalary;
    }
}
