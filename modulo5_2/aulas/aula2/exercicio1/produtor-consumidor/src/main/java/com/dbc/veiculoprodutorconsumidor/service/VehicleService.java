package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.DTO.VehicleDTO;
import com.dbc.veiculoprodutorconsumidor.entity.VehicleEntity;
import com.dbc.veiculoprodutorconsumidor.exception.RegraDeNegocioException;
import com.dbc.veiculoprodutorconsumidor.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ObjectMapper objectMapper;

    public VehicleDTO insertOne(VehicleDTO vehicleDTO){
        VehicleEntity vehicleToSave = objectMapper.convertValue(vehicleDTO, VehicleEntity.class);
        VehicleEntity vehicleSaved = vehicleRepository.save(vehicleToSave);
        VehicleDTO vehicleSavedDTO = objectMapper.convertValue(vehicleSaved, VehicleDTO.class);
        return vehicleSavedDTO;
    }

    public List<VehicleDTO> getAll(){
        return vehicleRepository.findAll().stream()
                .map(v->objectMapper.convertValue(v,VehicleDTO.class))
                .collect(Collectors.toList());
    }

    public Double getAvgSpeed() throws RegraDeNegocioException {
        return vehicleRepository.findAll().stream()
                .mapToDouble(v->v.getVelocidade())
                .average()
                .orElseThrow(()->new RegraDeNegocioException("problema ao calcular média de velocidade"));
    }

    public Double getRpm() throws RegraDeNegocioException {
        return vehicleRepository.findAll().stream()
                .mapToDouble(v->v.getRotacao())
                .average()
                .orElseThrow(()->new RegraDeNegocioException("problema ao calcular média de rpm"));
    }
    public Integer getReadCount(){
        return vehicleRepository.findAll().size();
    }
}
