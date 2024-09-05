package com.project.ranking.domain.spi;

import com.project.ranking.domain.model.Project;

import java.util.List;

/*
* Interface que funciona como puente entre el dominio y la capa de persistencia
* */
public interface IProjectPersistencePort {

    // Metodo que se encarga de obtener la lista de
    List<Project> getAllProjects();

}
