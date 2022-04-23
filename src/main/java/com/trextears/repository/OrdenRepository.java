package com.trextears.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trextears.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}