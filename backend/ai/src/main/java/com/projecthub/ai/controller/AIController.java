package com.projecthub.ai.controller;

import com.projecthub.ai.dto.AiInsightRequest;
import com.projecthub.ai.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("ai")
@RequiredArgsConstructor
public class AIController {
    private final AiService aiService;

    @PostMapping("/abstract-insights")
    public String getAbstractInsights(
            @RequestBody AiInsightRequest request) {

        return aiService.generateAbstractInsights(request);
    }

    @PostMapping("/project-insights")
    public String getProjectInsights(@RequestBody AiInsightRequest aiInsightRequest){
       return aiService.generateProjectInsights(aiInsightRequest);
    }
}
