package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.InteractionCheckResultModel;

public interface InteractionCheckResultRepository 
        extends JpaRepository<InteractionCheckResultModel, Long> {
}


