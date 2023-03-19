package com.f3pro.backend.repository;

import com.f3pro.backend.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{

    
}
