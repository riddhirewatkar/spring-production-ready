package com.springboot.ProductionReady.spring_production_ready.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareClass implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Riddhi");
    }
}
