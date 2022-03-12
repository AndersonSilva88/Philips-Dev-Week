package com.anderson.devweekapplication.repository;

import com.anderson.devweekapplication.entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface RegiaoRepo extends JpaRepository<Regiao, Long>{
}
