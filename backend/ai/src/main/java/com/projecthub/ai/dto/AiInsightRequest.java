package com.projecthub.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AiInsightRequest {

    private String department;

    private String title;
    private String abstractText;
    private String technologies;
}
