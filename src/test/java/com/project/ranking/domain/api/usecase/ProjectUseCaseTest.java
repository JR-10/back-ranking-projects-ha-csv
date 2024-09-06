package com.project.ranking.domain.api.usecase;

import com.project.ranking.domain.model.Project;
import com.project.ranking.domain.spi.IProjectPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class ProjectUseCaseTest {

    private final IProjectPersistencePort projectPersistencePortMock = mock(IProjectPersistencePort.class, "projectPersistencePort");

    @Test
    void getAllProjects() {
        List<Project> projectList = new ArrayList<>();
        when(projectPersistencePortMock.getAllProjects()).thenReturn(projectList);
        ProjectUseCase target = new ProjectUseCase(projectPersistencePortMock);

        List<Project> result = target.getAllProjects();

        assertThat(result, equalTo(projectList));
        verify(projectPersistencePortMock).getAllProjects();
    }


    @Test
    void getProjectsByFilter_returnsFilteredProjects() {
        List<Project> projectList = List.of(
                new Project(1L, UUID.randomUUID(), "Project1", 5L, "Category1"),
                new Project(2L, UUID.randomUUID(), "Project2", 10L, "Category1"),
                new Project(3L, UUID.randomUUID(), "Project3", 3L, "Category2")
        );
        when(projectPersistencePortMock.getAllProjects()).thenReturn(projectList);
        ProjectUseCase target = new ProjectUseCase(projectPersistencePortMock);

        List<Project> result = target.getProjectsByFilter(2L, "Category1");

        assertEquals(2, result.size());
        assertEquals("Project2", result.get(0).getName());
        assertEquals("Project1", result.get(1).getName());
        verify(projectPersistencePortMock).getAllProjects();
    }
}