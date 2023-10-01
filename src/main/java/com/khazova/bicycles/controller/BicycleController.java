package com.khazova.bicycles.controller;

import com.khazova.bicycles.model.dto.ModelDto;
import com.khazova.bicycles.model.dto.ModelWithId;
import com.khazova.bicycles.service.BicycleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/bicycles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Велосипед")
public class BicycleController {

    private final BicycleService service;

    public BicycleController(BicycleService service) {
        this.service = service;
    }

    @GetMapping("/id/")
    @Operation(summary = "Получить велосипед по id")
    public ModelDto findBicycleById(@RequestParam String id) {
        return service.findBicycleById(id);
    }

    @GetMapping("/byName/")
    @Operation(summary = "Найти велосипеды по названию")
    public List<ModelDto> findAllBicyclesByName(String name) {
        return service.findAllBicyclesByName(name);
    }

    @GetMapping("/all/")
    @Operation(summary = "Просмотреть все велосипеды")
    public List<ModelDto> findAllBicycles(@ParameterObject @PageableDefault(sort = "manufacturer", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllBicycles(pageable);
    }

    @PostMapping
    @Operation(summary = "Новый велосипед")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelWithId newBicycle(@RequestBody ModelDto model) {
        return service.newBicycle(model);
    }

    @PutMapping
    @Operation(summary = "Редактировать велосипед с заданным id")
    public boolean updateBicycle(@RequestParam String id, @RequestBody ModelDto model) {
        return service.updateBicycle(id, model);
    }

    @DeleteMapping
    @Operation(summary = "Удалить велосипед с заданным id")
    public boolean deleteBicycle(@RequestParam String id) {
        return service.deleteBicycle(id);
    }
}
