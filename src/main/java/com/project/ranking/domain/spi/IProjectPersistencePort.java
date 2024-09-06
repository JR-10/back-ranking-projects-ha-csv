package com.project.ranking.domain.spi;

import com.project.ranking.domain.model.Project;

import java.util.List;

public interface IProjectPersistencePort {

    List<Project> getAllProjects();

}
