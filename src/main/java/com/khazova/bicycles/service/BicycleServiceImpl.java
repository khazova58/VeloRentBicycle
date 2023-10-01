package com.khazova.bicycles.service;

import com.khazova.bicycles.exception.BusinessError;
import com.khazova.bicycles.exception.ServiceException;
import com.khazova.bicycles.model.dto.ModelDto;
import com.khazova.bicycles.model.dto.ModelWithId;
import com.khazova.bicycles.model.entity.Bicycle;
import com.khazova.bicycles.model.mapper.Map;
import com.khazova.bicycles.repo.Repo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BicycleServiceImpl implements BicycleService {

    private final Repo repository;
    private final Map mapper;

    public BicycleServiceImpl(Repo repository, Map mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ModelWithId newBicycle(ModelDto dto) {
        Bicycle entity = mapper.mapToEntity(dto);
        repository.save(entity);
        return mapper.mapToModelWithId(entity);
    }

    @Override
    @Transactional
    public boolean deleteBicycle(String id) {
        Bicycle foundEntity = getEntityById(id);
        repository.delete(foundEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateBicycle(String id, ModelDto model) {
        Bicycle foundEntity = getEntityById(id);
        repository.save(mapper.requestMapToEntity(model, foundEntity));
        return true;
    }

    @Override
    public ModelDto findBicycleById(String id) {
        Bicycle foundBicycle = repository.findById(id).orElseThrow(() -> new ServiceException(BusinessError.BICYCLE_NOT_FOUND, id));
        return mapper.mapToModelDto(foundBicycle);
    }

    @Override
    public List<ModelDto> findAllBicyclesByName(String name) {
        List<Bicycle> foundBicycles = repository.findAllByNameIgnoreCase(name);
        List<ModelDto> dtoList = foundBicycles.stream()
                .map(entity -> mapper.mapToModelDto(entity))
                .toList();
        return dtoList;
    }

    @Override
    public List<ModelDto> findAllBicycles(Pageable pageable) {
        Page<Bicycle> all = repository.findAll(pageable);
        return all.stream().map(entity -> mapper.mapToModelDto(entity)).toList();
    }

    private Bicycle getEntityById(String id) {
        return repository.findById(id).orElseThrow(() -> new ServiceException(BusinessError.BICYCLE_NOT_FOUND, id));
    }
}
