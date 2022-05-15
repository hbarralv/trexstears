package com.example.demo.platos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface platoRepository extends JpaRepository <plato, Long> {
    @Query("FROM plato s WHERE s.codigo LIKE :codigo_input")
    public List<plato> findByCodeContaining(@Param("codigo_input") String codigo_input);

    @Query("FROM menu c WHERE c.nombre like :title")
    List<plato> findByTitleContaining(@Param("title") String title);

    @Query("FROM menu c WHERE c.precio <= :precioventa")
    List<plato> getPlatoByPrecio(@Param("precioventa") double precioventa);

    @Query("FROM menu c ORDER BY nombre ASC")
    public List<plato> findAllSortByName();

}



