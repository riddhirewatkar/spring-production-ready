package com.springboot.ProductionReady.spring_production_ready.repositories;

import com.springboot.ProductionReady.spring_production_ready.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
