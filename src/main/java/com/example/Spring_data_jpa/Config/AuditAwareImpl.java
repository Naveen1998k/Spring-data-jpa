package com.example.Spring_data_jpa.Config;

import com.example.Spring_data_jpa.entity.Product;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {



        return Optional.of("Admin"); // Replace with actual logic to get the current user
    }
}
//2025-06-22T11:32:11.533+00:00
//2025-06-22T11:34:26.434+00:00"