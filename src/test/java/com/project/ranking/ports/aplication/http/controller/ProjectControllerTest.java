package com.project.ranking.ports.aplication.http.controller;

import com.project.ranking.domain.api.IProjectServicePort;
import com.project.ranking.domain.model.Project;
import com.project.ranking.ports.aplication.http.dto.response.ProjectResponseDto;
import com.project.ranking.ports.aplication.http.mapper.IProjectResponseMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class ProjectControllerTest {

    @Mock
    private IProjectServicePort projectService;

    @Mock
    private IProjectResponseMapper projectResponseMapper;

    @InjectMocks
    private ProjectController projectController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        // Clean up resources if needed
    }


    @Test
    void getProjectByFilter() {

        List<Project> projects = Arrays.asList(new Project(), new Project());
        List<ProjectResponseDto> projectResponseDto = Arrays.asList(new ProjectResponseDto(), new ProjectResponseDto());

        when(projectService.getAllProjects()).thenReturn(projects);
        when(projectResponseMapper.projectToProjectResponseDto(projects)).thenReturn(projectResponseDto);

        ResponseEntity<List<ProjectResponseDto>> response = projectController.getAllProjects();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
    }

    @Test
    void getProjectByFilterReturnsFilteredProjects() {
        List<Project> projects = Arrays.asList(new Project(), new Project());
        List<ProjectResponseDto> projectResponseDto = Arrays.asList(new ProjectResponseDto(), new ProjectResponseDto());

        when(projectService.getProjectsByFilter(2L, "Category1")).thenReturn(projects);
        when(projectResponseMapper.projectToProjectResponseDto(projects)).thenReturn(projectResponseDto);

        ResponseEntity<List<ProjectResponseDto>> response = projectController.getProjectByFilter(2L, "Category1");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
    }
}