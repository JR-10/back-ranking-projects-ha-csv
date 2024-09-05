package com.project.ranking.ports.aplication.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectResponseDto {

    private Long id;
    private UUID projectId;
    private String name;
    private Long rating;
    private String category;

}
