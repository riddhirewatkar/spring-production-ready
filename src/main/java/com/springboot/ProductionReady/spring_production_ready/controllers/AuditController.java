package com.springboot.ProductionReady.spring_production_ready.controllers;

import com.springboot.ProductionReady.spring_production_ready.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/posts/{postId}")
    List<PostEntity> getPostsRevision(@PathVariable Long postId) {
        AuditReader reader =  AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> numbers = reader.getRevisions(PostEntity.class, postId);
        return numbers.stream()
                .map(readers -> reader.find(PostEntity.class, postId, readers))
                .collect(Collectors.toList());
    }
}
