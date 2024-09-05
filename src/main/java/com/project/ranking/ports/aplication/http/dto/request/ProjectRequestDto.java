package com.project.ranking.ports.aplication.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectRequestDto {

    private Long numElement;
    private String nameCategory;
}
