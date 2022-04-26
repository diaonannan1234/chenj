package com.chen;

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
    private String id;
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
        this.setManHour(first.getManHour().floatValue());
    }

    private float s1(BigDecimal a){
         BigDecimal b = new BigDecimal(this.getManHour());
         return a.multiply(b).floatValue();
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
    @Column(scale=2)
    private float manHour;
    // 直接人工正式工资
    @Column(scale=2)
    private float directRegularSalary;
    // 直接人工劳务工资
    @Column(scale=2)
    private float directLaborSalary;
    // 间接人工正式工资
    @Column(scale=2)
    private float indirectRegularSalary;
    // 间接人工劳务工资
    @Column(scale=2)
    private float  indirectLaborSalary;
    // 水电
    @Column(scale=2)
    private float waterElectricity;
    // 刀具
    @Column(scale=2)
    private float tool;
    // 消耗
    @Column(scale=2)
    private float consume;
    // 修理
    @Column(scale=2)
    private float repair;
    // 餐费
    @Column(scale=2)
    private float mealFee;
    // 保险
    @Column(scale=2)
    private float insurance;
    // 办公
    @Column(scale=2)
    private float office;
    // 差施
    @Column(scale=2)
    private float travel;
    // 劳保
    @Column(scale=2)
    private float labour;
    // 其他折旧
    @Column(scale=2)
    private float otherDepreciation;
    // 设备折旧
    @Column(scale=2)
    private float deviceDepreciation;

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

    public float getManHour() {
        return manHour;
    }

    public void setManHour(float manHour) {
        this.manHour = manHour;
    }

    public float getDirectRegularSalary() {
        return directRegularSalary;
    }

    public void setDirectRegularSalary(float directRegularSalary) {
        this.directRegularSalary = directRegularSalary;
    }

    public float getDirectLaborSalary() {
        return directLaborSalary;
    }

    public void setDirectLaborSalary(float directLaborSalary) {
        this.directLaborSalary = directLaborSalary;
    }

    public float getIndirectRegularSalary() {
        return indirectRegularSalary;
    }

    public void setIndirectRegularSalary(float indirectRegularSalary) {
        this.indirectRegularSalary = indirectRegularSalary;
    }

    public float getIndirectLaborSalary() {
        return indirectLaborSalary;
    }

    public void setIndirectLaborSalary(float indirectLaborSalary) {
        this.indirectLaborSalary = indirectLaborSalary;
    }

    public float getWaterElectricity() {
        return waterElectricity;
    }

    public void setWaterElectricity(float waterElectricity) {
        this.waterElectricity = waterElectricity;
    }

    public float getTool() {
        return tool;
    }

    public void setTool(float tool) {
        this.tool = tool;
    }

    public float getConsume() {
        return consume;
    }

    public void setConsume(float consume) {
        this.consume = consume;
    }

    public float getRepair() {
        return repair;
    }

    public void setRepair(float repair) {
        this.repair = repair;
    }

    public float getMealFee() {
        return mealFee;
    }

    public void setMealFee(float mealFee) {
        this.mealFee = mealFee;
    }

    public float getInsurance() {
        return insurance;
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }

    public float getOffice() {
        return office;
    }

    public void setOffice(float office) {
        this.office = office;
    }

    public float getTravel() {
        return travel;
    }

    public void setTravel(float travel) {
        this.travel = travel;
    }

    public float getLabour() {
        return labour;
    }

    public void setLabour(float labour) {
        this.labour = labour;
    }

    public float getOtherDepreciation() {
        return otherDepreciation;
    }

    public void setOtherDepreciation(float otherDepreciation) {
        this.otherDepreciation = otherDepreciation;
    }

    public float getDeviceDepreciation() {
        return deviceDepreciation;
    }

    public void setDeviceDepreciation(float deviceDepreciation) {
        this.deviceDepreciation = deviceDepreciation;
    }
}
