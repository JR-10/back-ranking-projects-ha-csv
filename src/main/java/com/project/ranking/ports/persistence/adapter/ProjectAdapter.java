package com.project.ranking.ports.persistence.adapter;


import com.project.ranking.domain.model.Project;
import com.project.ranking.domain.spi.IProjectPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProjectAdapter implements IProjectPersistencePort {

    private static final String CSV_FILE_PATH = "src/main/resources/data/projects.csv";


    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Project project = new Project();
                project.setName(line[0]);
                project.setRating(Long.parseLong(line[1]));
                project.setCategory(line[2]);
                project.setProjectId(UUID.fromString(line[3]));
                project.setId(Long.parseLong(line[4]));
                projects.add(project);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return projects;
    }

}
