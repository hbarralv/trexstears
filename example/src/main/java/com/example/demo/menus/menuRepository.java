package com.example.demo.menus;

import com.example.demo.menus.menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface menuRepository extends JpaRepository<menu, Long> {

    @Query("FROM menu c WHERE c.nombre like :title")
    List<menu> findByTitleContaining(@Param("title") String title);

    @Query("FROM menu c WHERE c.precio <= :precio")
    List<menu> findByPrecioLessThan(@Param("precio") double precio);

    @Query("FROM menu c ORDER BY nombre ASC")
    public List<menu> findAllSortByName();
}

