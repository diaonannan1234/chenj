package com.chen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlatFormHourRepository extends JpaRepository<PlatformHour,String> {

    @Query("select f from PlatformHour f where f.year = :year and f.month = :month")
    List<PlatformHour> findAll(@Param("year") int year, @Param("month") int month);
}
