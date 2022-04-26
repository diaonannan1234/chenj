package com.chen;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

//一厂
@Entity
@Table(name = "T_FIRST_FACTORY")
public class FirstFactory {


    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

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
}
