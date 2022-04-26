package com.chen;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

//汇总结果
@Entity
@Table(name = "T_Factory_Result")
public class FactoryResult {
    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    @ExcelIgnore
    private String id;
    @ExcelIgnore
    private int year;
    @ExcelIgnore
    private int month;
     public FactoryResult(){}
    public FactoryResult(FirstFactory first) {
        this();
        this.setFiscalPeriod(first.getFiscalPeriod());
        this.setProjectName(first.getProjectName());
        this.setProjectNumber(first.getProjectNumber());
        this.setMaterialCode(first.getMaterialCode());
        this.setMaterialName(first.getMaterialName());
        this.setCount(first.getCount());
        this.setDevice(first.getDevice());
        this.setManHour(first.getManHour());
        this.setYear(first.getYear());
        this.setMonth(first.getMonth());
    }

    public FactoryResult(Object[] ob) {

            this.fiscalPeriod = (String)(ob[0]);
            this.projectNumber = (String)(ob[1]);
            this.projectName = (String)(ob[2]);
            this.materialCode = (String)(ob[3]);
            this.materialName = (String)(ob[4]);
            this.count = (int)(ob[5]);
            this.device = (String)(ob[6]);
            this.manHour = ob[7] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.directRegularSalary = ob[8] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.directLaborSalary = ob[9] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.indirectRegularSalary = ob[10] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.indirectLaborSalary = ob[11] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.waterElectricity = ob[12] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.tool = ob[13] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.consume = ob[14] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.repair = ob[15] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.mealFee = ob[16] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.insurance = ob[17] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.office = ob[18] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.travel = ob[19] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.labour = ob[20] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.otherDepreciation = ob[21] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;
            this.deviceDepreciation = ob[22] == null ? BigDecimal.ZERO : (BigDecimal)ob[7] ;

    }

    private BigDecimal s1(BigDecimal a){

         return a.multiply(this.getManHour());
     }

    public void sum(PlatformHour h){
         if(h == null) return;
         this.directRegularSalary = this.s1(h.getDirectRegularSalary());
        this.directLaborSalary = this.s1(h.getDirectLaborSalary());
        // 间接人工正式工资
        this.indirectRegularSalary = this.s1(h.getIndirectRegularSalary());
        // 间接人工劳务工资
        this.indirectLaborSalary = this.s1(h.getIndirectLaborSalary());
        // 水电
        this.waterElectricity = this.s1(h.getWaterElectricity());
        // 刀具
        this.tool = this.s1(h.getTool());
        // 消耗
        this.consume = this.s1(h.getConsume() );
        // 修理
        this.repair = this.s1(h.getRepair());
        // 餐费
        this.mealFee = this.s1(h.getMealFee());
        // 保险
        this.insurance = this.s1(h.getInsurance());
        // 办公
        this.office = this.s1(h.getOffice());
        // 差施
        this.travel = this.s1(h.getTravel() );
        // 劳保
        this.labour = this.s1(h.getLabour() );
        // 其他折旧
        this.otherDepreciation = this.s1(h.getOtherDepreciation());
        // 设备折旧
        this.deviceDepreciation = this.s1(h.getDeviceDepreciation());
    }



    //会计期间
    @ExcelProperty("会计期间")
    private String fiscalPeriod;

    //项目号
    @ExcelProperty("项目号")
    private String projectNumber;
    // 项目名称
    @ExcelProperty("项目名称")
    private String projectName;
    //物料编码
    @ExcelProperty("物料编码")
    private String  materialCode;

    // 物料名称
    @ExcelProperty("物料名称")
    private String materialName;
    // 数量
    @ExcelProperty("数量")
    private int count;
    // 设备
    @ExcelProperty("设备")
    private String device;
    // 工时
    @ExcelProperty("工时")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal manHour;
    // 直接人工正式工资
    @ExcelProperty("直接人工正式工资")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal directRegularSalary;
    // 直接人工劳务工资
    @ExcelProperty("直接人工劳务工资")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal directLaborSalary;
    // 间接人工正式工资
    @ExcelProperty("间接人工正式工资")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal indirectRegularSalary;
    // 间接人工劳务工资
    @ExcelProperty("间接人工劳务工资")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal  indirectLaborSalary;
    // 水电
    @ExcelProperty("水电")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal waterElectricity;
    // 刀具
    @ExcelProperty("刀具")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal tool;
    // 消耗
    @ExcelProperty("消耗")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal consume;
    // 修理
    @ExcelProperty("修理")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal repair;
    // 餐费
    @ExcelProperty("餐费")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal mealFee;
    // 保险
    @ExcelProperty("保险")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal insurance;
    // 办公
    @ExcelProperty("办公")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal office;
    // 差施
    @ExcelProperty("差施")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal travel;
    // 劳保
    @ExcelProperty("劳保")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal labour;
    // 其他折旧
    @ExcelProperty("其他折旧")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal otherDepreciation;
    // 设备折旧
    @ExcelProperty("设备折旧")
    @Column(columnDefinition="decimal(18,2)")
    private BigDecimal deviceDepreciation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
