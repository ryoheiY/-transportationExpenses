package com.ryo.transportationexpensesapp.repository;

import com.ryo.transportationexpensesapp.model.TransportationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransportationFormEntityRepository extends JpaRepository<TransportationFormEntity, Long> {
    List<TransportationFormEntity> findByDepartureDateBetweenAndUserId(Date year, Date month, String userId);

    List<TransportationFormEntity> findByDepartureDateBetween(Date year, Date month);
}
