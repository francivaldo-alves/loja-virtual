package com.f3pro.backend.repository;

import com.f3pro.backend.entity.Categoria;
import com.f3pro.backend.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao,Long>{

    
}
