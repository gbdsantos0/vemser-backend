package com.dbc.veiculoprodutorconsumidor.repository;

import com.dbc.veiculoprodutorconsumidor.entity.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleEntity, Integer> {
}
