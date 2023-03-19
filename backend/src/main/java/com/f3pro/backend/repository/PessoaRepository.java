package com.f3pro.backend.repository;

import com.f3pro.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

    
}
