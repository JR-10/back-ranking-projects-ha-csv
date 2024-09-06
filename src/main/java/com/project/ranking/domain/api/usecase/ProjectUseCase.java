package com.project.ranking.domain.api.usecase;

import com.project.ranking.domain.api.IProjectServicePort;
import com.project.ranking.domain.model.Project;
import com.project.ranking.domain.spi.IProjectPersistencePort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectUseCase implements IProjectServicePort {

    private final IProjectPersistencePort projectPersistencePort;

    public ProjectUseCase(IProjectPersistencePort projectPersistencePort) {
        this.projectPersistencePort = projectPersistencePort;
    }


    @Override
    public List<Project> getAllProjects() {
        return projectPersistencePort.getAllProjects();
    }

    @Override
    public List<Project> getProjectsByFilter(Long numElements, String nameCategory) {
        return projectPersistencePort.getAllProjects().stream()
                .filter(project -> project.getCategory().equalsIgnoreCase(nameCategory))
                .sorted(Comparator.comparingLong(Project::getRating).reversed())
                .limit(numElements)
                .collect(Collectors.toList());
    }
}
