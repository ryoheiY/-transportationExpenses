package com.ryo.transportationexpensesapp.repository;

import com.ryo.transportationexpensesapp.model.TransportationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransportationFormEntityRepository extends JpaRepository<TransportationFormEntity, Long> {
    List<TransportationFormEntity> findTop10ByUserId(String userId);

    List<TransportationFormEntity> findByUserIdAndDepartureDateBetween(String userId, Date year, Date month);

    List<TransportationFormEntity> findByDepartureDateBetween(Date year, Date month);
}
