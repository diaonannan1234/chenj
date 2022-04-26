package com.chen;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

//一厂
@Entity
@Table(name = "T_FIRST_FACTORY")
public class FirstFactory implements Serializable {


    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private int year;

    private int month;

    //会计期间
    private String fiscalPeriod;

    //项目号
    private String projectNumber;
    // 项目名称
    private String projectName;
    //物料编码
    private String  materialCode;

    // 物料名称
    private String materialName;
    // 数量
    private int count;
    // 设备
    private String device;
    // 工时
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal manHour;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getFiscalPeriod() {
        return fiscalPeriod;
    }

    public void setFiscalPeriod(String fiscalPeriod) {
        this.fiscalPeriod = fiscalPeriod;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public BigDecimal getManHour() {
        return manHour;
    }

    public void setManHour(BigDecimal manHour) {
        this.manHour = manHour;
    }

    @Override
    public String toString() {
        return "FirstFactory{" +
                ", fiscalPeriod='" + fiscalPeriod + '\'' +
                ", projectNumber='" + projectNumber + '\'' +
                ", projectName='" + projectName + '\'' +
                ", materialCode='" + materialCode + '\'' +
                ", materialName='" + materialName + '\'' +
                ", count=" + count +
                ", device='" + device + '\'' +
                ", manHour=" + manHour +
                '}';
    }
}
