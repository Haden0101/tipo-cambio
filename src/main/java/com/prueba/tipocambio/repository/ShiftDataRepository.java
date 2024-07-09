package com.prueba.tipocambio.repository;

import com.prueba.tipocambio.domain.ShiftData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftDataRepository extends ReactiveCrudRepository<ShiftData, Long> {

}
