package com.khazova.bicycles.service;

import com.khazova.bicycles.model.dto.ModelDto;
import com.khazova.bicycles.model.dto.ModelWithId;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BicycleService {

    ModelWithId newBicycle(ModelDto bicycle);

    boolean deleteBicycle(String id);

    boolean updateBicycle(String id, ModelDto model);

    ModelDto findBicycleById(String id);

    List<ModelDto> findAllBicyclesByName(String name);

    List<ModelDto> findAllBicycles(Pageable pageable);

}
