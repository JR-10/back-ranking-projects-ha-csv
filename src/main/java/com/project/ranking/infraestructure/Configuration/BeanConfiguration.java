package com.project.ranking.infraestructure.Configuration;

import com.project.ranking.domain.api.IProjectServicePort;
import com.project.ranking.domain.api.usecase.ProjectUseCase;
import com.project.ranking.domain.spi.IProjectPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {



    @Bean
    public IProjectServicePort projectServicePort(IProjectPersistencePort projectPersistencePort) {
        return new ProjectUseCase(projectPersistencePort);
    }

}
