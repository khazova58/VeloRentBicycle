package com.khazova.bicycles.model.mapper;

import com.khazova.bicycles.model.dto.ModelDto;
import com.khazova.bicycles.model.dto.ModelWithId;
import com.khazova.bicycles.model.entity.Bicycle;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface Map {

    Bicycle mapToEntity(ModelDto entityDto);

    ModelWithId mapToModelWithId(Bicycle entity);



    Bicycle requestMapToEntity(ModelDto model, @MappingTarget Bicycle foundEntity);

    ModelDto mapToModelDto(Bicycle entity);
}
