package com.project.ranking.domain.model;

import java.util.UUID;

public class Project {

    private Long id;
    private UUID projectId;
    private String name;
    private Long rating;
    private String category;

    public Project() {
    }

    public Project(Long id, UUID projectId, String name, Long rating, String category) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.rating = rating;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
