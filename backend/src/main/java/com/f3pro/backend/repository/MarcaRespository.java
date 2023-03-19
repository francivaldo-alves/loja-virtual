package com.f3pro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.f3pro.backend.entity.Marca;

public interface MarcaRespository extends JpaRepository<Marca, Long>{
    
}
