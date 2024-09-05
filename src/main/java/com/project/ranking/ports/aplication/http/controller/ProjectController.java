package com.project.ranking.ports.aplication.http.controller;

import com.project.ranking.domain.api.IProjectServicePort;
import com.project.ranking.domain.model.Project;
import com.project.ranking.ports.aplication.http.dto.request.ProjectRequestDto;
import com.project.ranking.ports.aplication.http.dto.response.ProjectResponseDto;
import com.project.ranking.ports.aplication.http.mapper.IProjectRequestMapper;
import com.project.ranking.ports.aplication.http.mapper.IProjectResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    // inyectamos el puerto de servicio de proyecto y el mapeador de respuesta de proyecto
    private final IProjectServicePort projectService;
    private final IProjectResponseMapper projectResponseMapper;

    @GetMapping("/ranking")
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects(); // Obtenemos la lista de proyectos que bienen del puerto de servicio
        List<ProjectResponseDto> projectResponseDto = projectResponseMapper.projectToProjectResponseDto(projects); // Mapeamos la lista de proyectos a una lista de DTOs de respuesta
        return ResponseEntity.ok().body(projectResponseDto);
    }
}
