package com.project.ranking.ports.persistence.adapter;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.project.ranking.domain.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class ProjectAdapterTest {

    private ProjectAdapter projectAdapter;
    private CSVReader mockCSVReader;

    @BeforeEach
    void setUp() {
        mockCSVReader = mock(CSVReader.class);
        projectAdapter = new ProjectAdapter() {
            protected CSVReader createCSVReader() throws IOException {
                return mockCSVReader;
            }
        };
    }

    @Test
    void getAllProjectsReturnsListOfProjects() throws IOException, CsvValidationException {
        UUID projectId1 = UUID.randomUUID();
        UUID projectId2 = UUID.randomUUID();

        when(mockCSVReader.readNext()).thenReturn(
                new String[]{"Name", "Rating", "Category", "ProjectId", "Id"},
                new String[]{"Project1", "5", "Category1", projectId1.toString(), "1"},
                new String[]{"Project2", "7", "Category2", projectId2.toString(), "2"},
                null
        );

        List<Project> projects = projectAdapter.getAllProjects();

        assertEquals(100, projects.size());

    }

}