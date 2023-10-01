package com.khazova.bicycles.repo;

import com.khazova.bicycles.model.entity.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Bicycle, String> {

    @Query(value = """
            SELECT o FROM Bicycle o
            WHERE :name IS NULL OR LOWER(o.name) LIKE LOWER(CONCAT('%', :name, '%')) 
                        """)
    List<Bicycle> findAllByNameIgnoreCase(@Param("name") String name);


}
