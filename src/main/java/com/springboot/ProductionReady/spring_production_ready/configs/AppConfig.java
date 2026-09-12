package com.springboot.ProductionReady.spring_production_ready.configs;

import com.springboot.ProductionReady.spring_production_ready.auth.AuditorAwareClass;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareClass")
public class AppConfig {
    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    @Bean
    public AuditorAwareClass getAuditorAwareClass() {
        return new AuditorAwareClass();
    }
}
