package com.project.ranking.domain.api;

import com.project.ranking.domain.model.Project;

import java.util.List;

public interface IProjectServicePort {

    List<Project> getAllProjects();

    List<Project> getProjectsByFilter(Long numElements, String nameCategory);

}
