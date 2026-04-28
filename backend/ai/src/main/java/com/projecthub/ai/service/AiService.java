package com.projecthub.ai.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.projecthub.ai.client.AbstractClient;
import com.projecthub.ai.dto.AiInsightRequest;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiService {
    private final AbstractClient abstractClient;
    private final GeminiService geminiService;
    private final Client client;





    private String buildPrompt(
            AiInsightRequest req,
            String pastAbstracts) {

        return """
    You are an academic project reviewer.

    RULES (VERY IMPORTANT):
    - Be concise.
    - Do NOT exceed 120 words.
    - Do NOT explain theory.
    - Use simple bullet points only.
    - No introductions or conclusions.
    - Follow the OUTPUT FORMAT strictly.

    CURRENT PROJECT:
    Title: %s
    Abstract: %s
    Technologies: %s

    PREVIOUS APPROVED PROJECTS (same department):
    %s

    OUTPUT FORMAT (STRICT JSON):
    {
      "similarityPercentage": number,
      "overlappingPoints": [string, string],
      "improvementSuggestions": [string, string, string],
      "recommendedTechnologies": [string, string,string],
      "finalVerdict": string
    }
    """
                .formatted(
                        req.getTitle(),
                        req.getAbstractText(),
                        req.getTechnologies(),
                        pastAbstracts
                );
    }

//    public void



    public String generateAbstractInsights(AiInsightRequest req) {

        // 1️⃣ Get past abstracts
        String pastAbstracts =
                abstractClient.getApprovedAbstracts(
                        req.getDepartment()

                );

        // 2️⃣ Build prompt
        String prompt = buildPrompt(req, pastAbstracts);

        // 3️⃣ Call Gemini (YOU ALREADY DID THIS PART)
        return geminiService.getInsights(prompt);
    }


    public String generateProjectInsightsPrompt(AiInsightRequest aiInsightRequest){

        return  """
    You are an academic project reviewer.

    RULES (VERY IMPORTANT):
    - Be concise.
    - Do NOT exceed 120 words.
    - Do NOT explain theory.
    - Use simple bullet points only.
    - No introductions or conclusions.
    - Follow the OUTPUT FORMAT strictly.

    CURRENT PROJECT:
    Title: %s
    Abstract: %s
    Technologies: %s

    PREVIOUS APPROVED PROJECTS:
    %s

    OUTPUT FORMAT (STRICT JSON):
    {
      "improvementSuggestions": [string, string, string],
      "recommendedTechnologies": [string, string, string]
    }
    """
                .formatted(
                       null,
                        aiInsightRequest.getTitle(),
                        aiInsightRequest.getAbstractText(),
                        aiInsightRequest.getTechnologies()

        );

    }


    public String generateProjectInsights(AiInsightRequest aiInsightRequest){
        String prompt=generateProjectInsightsPrompt(aiInsightRequest);
        return geminiService.getInsights(prompt);
    }

}
