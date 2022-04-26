package com.chen;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

//月台时价
@Data
public class PlatformHourExcel {

    private BigDecimal newBigDecimal(Double d){
        return new BigDecimal(d);
    }

    PlatformHour conv(){
        PlatformHour hour = new PlatformHour();
        hour.setDevice(this.device);
        hour.setManHour(newBigDecimal(this.manHour));
        hour.setDirectRegularSalary(newBigDecimal(this.directRegularSalary));
        hour.setDirectLaborSalary(newBigDecimal(this.directLaborSalary));
        hour.setIndirectRegularSalary(newBigDecimal(this.indirectRegularSalary));
        hour.setIndirectLaborSalary(newBigDecimal(this.indirectLaborSalary));
        hour.setWaterElectricity(newBigDecimal(this.waterElectricity));
        hour.setTool(newBigDecimal(this.tool));
        hour.setConsume(newBigDecimal(this.consume));
        hour.setRepair(newBigDecimal(this.repair));
        hour.setMealFee(newBigDecimal(this.mealFee));
        hour.setInsurance(newBigDecimal(this.insurance));
        hour.setOffice(newBigDecimal(this.office));
        hour.setTravel(newBigDecimal(this.travel));
        hour.setLabour(newBigDecimal(this.labour));
        hour.setOtherDepreciation(newBigDecimal(this.otherDepreciation));
        hour.setDeviceDepreciation(newBigDecimal(this.deviceDepreciation));
        return hour;
    }

   // 设备
   @ExcelProperty(index = 0)
    private String device;
    // 工时
    @ExcelProperty(index = 1)
    private double manHour;
    // 直接人工正式工资
    @ExcelProperty(index = 2)
    private double directRegularSalary;
    // 直接人工劳务工资
    @ExcelProperty(index = 3)
    private double directLaborSalary;
    // 间接人工正式工资
    @ExcelProperty(index = 4)
    private double indirectRegularSalary;
    // 间接人工劳务工资
    @ExcelProperty(index = 5)
    private double  indirectLaborSalary;
    // 水电
    @ExcelProperty(index = 6)
    private double waterElectricity;
    // 刀具
    @ExcelProperty(index = 7)
    private double tool;
    // 消耗
    @ExcelProperty(index = 8)
    private double consume;
    // 修理
    @ExcelProperty(index = 9)
    private double repair;
    // 餐费
    @ExcelProperty(index = 10)
    private double mealFee;
    // 保险
    @ExcelProperty(index = 11)
    private double insurance;
    // 办公
    @ExcelProperty(index = 12)
    private double office;
    // 差施
    @ExcelProperty(index = 13)
    private double travel;
    // 劳保
    @ExcelProperty(index = 14)
    private double labour;
    // 其他折旧
    @ExcelProperty(index = 15)
    private double otherDepreciation;
    // 设备折旧
    @ExcelProperty(index = 16)
    private double deviceDepreciation;

   }
