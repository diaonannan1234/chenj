package com.chen;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//月台时价
@Entity
@Table(name = "T_Platform_Hour")
public class PlatformHour {

    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private int year;

    private int month;
   // 设备
    private String device;
    // 工时
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal manHour;
    // 直接人工正式工资
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal directRegularSalary;
    // 直接人工劳务工资
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal directLaborSalary;
    // 间接人工正式工资
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal indirectRegularSalary;
    // 间接人工劳务工资
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal  indirectLaborSalary;
    // 水电
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal waterElectricity;
    // 刀具
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal tool;
    // 消耗
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal consume;
    // 修理
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal repair;
    // 餐费
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal mealFee;
    // 保险
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal insurance;
    // 办公
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal office;
    // 差施
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal travel;
    // 劳保
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal labour;
    // 其他折旧
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal otherDepreciation;
    // 设备折旧
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal deviceDepreciation;

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

    public BigDecimal getDirectRegularSalary() {
        return directRegularSalary;
    }

    public void setDirectRegularSalary(BigDecimal directRegularSalary) {
        this.directRegularSalary = directRegularSalary;
    }

    public BigDecimal getDirectLaborSalary() {
        return directLaborSalary;
    }

    public void setDirectLaborSalary(BigDecimal directLaborSalary) {
        this.directLaborSalary = directLaborSalary;
    }

    public BigDecimal getIndirectRegularSalary() {
        return indirectRegularSalary;
    }

    public void setIndirectRegularSalary(BigDecimal indirectRegularSalary) {
        this.indirectRegularSalary = indirectRegularSalary;
    }

    public BigDecimal getIndirectLaborSalary() {
        return indirectLaborSalary;
    }

    public void setIndirectLaborSalary(BigDecimal indirectLaborSalary) {
        this.indirectLaborSalary = indirectLaborSalary;
    }

    public BigDecimal getWaterElectricity() {
        return waterElectricity;
    }

    public void setWaterElectricity(BigDecimal waterElectricity) {
        this.waterElectricity = waterElectricity;
    }

    public BigDecimal getTool() {
        return tool;
    }

    public void setTool(BigDecimal tool) {
        this.tool = tool;
    }

    public BigDecimal getConsume() {
        return consume;
    }

    public void setConsume(BigDecimal consume) {
        this.consume = consume;
    }

    public BigDecimal getRepair() {
        return repair;
    }

    public void setRepair(BigDecimal repair) {
        this.repair = repair;
    }

    public BigDecimal getMealFee() {
        return mealFee;
    }

    public void setMealFee(BigDecimal mealFee) {
        this.mealFee = mealFee;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public BigDecimal getOffice() {
        return office;
    }

    public void setOffice(BigDecimal office) {
        this.office = office;
    }

    public BigDecimal getTravel() {
        return travel;
    }

    public void setTravel(BigDecimal travel) {
        this.travel = travel;
    }

    public BigDecimal getLabour() {
        return labour;
    }

    public void setLabour(BigDecimal labour) {
        this.labour = labour;
    }

    public BigDecimal getOtherDepreciation() {
        return otherDepreciation;
    }

    public void setOtherDepreciation(BigDecimal otherDepreciation) {
        this.otherDepreciation = otherDepreciation;
    }

    public BigDecimal getDeviceDepreciation() {
        return deviceDepreciation;
    }

    public void setDeviceDepreciation(BigDecimal deviceDepreciation) {
        this.deviceDepreciation = deviceDepreciation;
    }
}
