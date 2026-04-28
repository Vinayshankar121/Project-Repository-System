package com.projecthub.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PastAbstractDTO {
    private String title;
    private String abstractText;
    private String technologies;
}
