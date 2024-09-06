package com.project.ranking.ports.aplication.http.controller;

import com.project.ranking.domain.api.IProjectServicePort;
import com.project.ranking.domain.model.Project;
import com.project.ranking.ports.aplication.http.dto.response.ProjectResponseDto;
import com.project.ranking.ports.aplication.http.mapper.IProjectResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final IProjectServicePort projectService;
    private final IProjectResponseMapper projectResponseMapper;

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        List<ProjectResponseDto> projectResponseDto = projectResponseMapper.projectToProjectResponseDto(projects);
        return ResponseEntity.ok().body(projectResponseDto);
    }

    @GetMapping("/getProjectsFilter")
    public ResponseEntity<List<ProjectResponseDto>> getProjectsByFilter(@RequestParam Long numElements, @RequestParam String nameCategory) {
        List<Project> projects = projectService.getProjectsByFilter(numElements, nameCategory);
        List<ProjectResponseDto> projectResponseDto = projectResponseMapper.projectToProjectResponseDto(projects);
        return ResponseEntity.ok().body(projectResponseDto);
    }
}
