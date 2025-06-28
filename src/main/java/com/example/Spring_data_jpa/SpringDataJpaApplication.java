package com.example.Spring_data_jpa;

import com.example.Spring_data_jpa.Config.AuditAwareImpl;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEncryptableProperties
@EnableJpaAuditing(auditorAwareRef = "auditorAware" )// This should match the bean name defined below)
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class SpringDataJpaApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditAwareImpl(); // Replace with actual logic to get the current user
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
