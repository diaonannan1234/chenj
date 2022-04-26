package com.chen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactoryResultRepository extends JpaRepository<FactoryResult,String> {

    @Query("select f.fiscalPeriod " +
            ",f.projectNumber " +
            ",f.projectName " +
            ",f.materialCode " +
            ",f.materialName" +
            ",f.count" +
            ", f.device " +
            ", sum(f.manHour)" +
            ",sum(f.directRegularSalary)" +
            ",sum(f.directLaborSalary)" +
            ",sum(f.indirectRegularSalary)" +
            ",sum(f.indirectLaborSalary)" +
            ",sum(f.waterElectricity)" +
            ",sum(f.tool)" +
            ",sum(f.consume)" +
            ",sum(f.repair)" +
            ",sum(f.mealFee)" +
            ",sum(f.insurance)" +
            ",sum(f.office)" +
            ",sum(f.travel)" +
            ",sum(f.labour)" +
            ",sum(f.otherDepreciation)" +
            ",sum(f.deviceDepreciation) from FactoryResult f where f.year = :year and f.month = :month group by f.device")
    List<Object[]> findAllByGroup(@Param("year") int year, @Param("month") int month);

    @Query("select f from FactoryResult f where f.year = :year and f.month = :month")
    List<FactoryResult> findAll(@Param("year") int year, @Param("month") int month);
}
