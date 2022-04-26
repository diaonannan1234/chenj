package com.chen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FirstFactoryRepository extends JpaRepository<FirstFactory,String> , JpaSpecificationExecutor<FirstFactory> {

    @Query("select f from FirstFactory f where f.year = :year and f.month = :month")
    List<FirstFactory> findAll(@Param("year") int year,@Param("month") int month);
}
