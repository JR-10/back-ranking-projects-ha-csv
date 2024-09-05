package com.project.ranking.domain.api;

import com.project.ranking.domain.model.Project;

import java.util.List;

/*
* Interface que funciona como puerta de entrada para las operaciones de los proyectos en el dominio
* */
public interface IProjectServicePort {

    // operacion para listar los proyectos
    List<Project> getAllProjects();
}
