package com.chen;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

//一厂
@Data
public class FirstFactoryExcel {

    public FirstFactory conv(int year,int month){

        FirstFactory firstFactory = new FirstFactory();
        firstFactory.setFiscalPeriod(this.fiscalPeriod);
        firstFactory.setProjectNumber(this.projectNumber);
        firstFactory.setProjectName(this.projectName);
        firstFactory.setMaterialCode(this.materialCode);
        firstFactory.setMaterialName(this.materialName);
        firstFactory.setCount(this.count);
        firstFactory.setDevice(this.device);
        firstFactory.setManHour(new BigDecimal(this.getManHour()));
        firstFactory.setYear(year);
        firstFactory.setMonth(month);
        return firstFactory;
    }

    //会计期间
    @ExcelProperty(index = 0)
    private String fiscalPeriod;

    //项目号
    @ExcelProperty(index = 1)
    private String projectNumber;
    // 项目名称
    @ExcelProperty(index = 2)
    private String projectName;
    //物料编码
    @ExcelProperty(index = 3)
    private String  materialCode;

    // 物料名称
    @ExcelProperty(index = 4)
    private String materialName;
    // 数量
    @ExcelProperty(index = 5)
    private int count;
    // 设备
    @ExcelProperty(index = 6)
    private String device;
    // 工时
    @ExcelProperty(index = 7)
    private Double manHour;


}
