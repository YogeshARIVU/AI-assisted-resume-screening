package com.mcp.AI_assisted.resume.screening.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillExtractionService {

    private static final List<String> SKILLS =
            List.of(
                    "Java",
                    "Spring",
                    "Spring Boot",
                    "AWS",
                    "Docker",
                    "Kubernetes",
                    "React",
                    "SQL",
                    "Microservices"
            );

    public List<String> extractSkills(
            String text
    ) {

        List<String> detectedSkills =
                new ArrayList<>();

        for (String skill : SKILLS) {

            if (text.toLowerCase()
                    .contains(skill.toLowerCase())) {

                detectedSkills.add(skill);
            }
        }

        return detectedSkills;
    }
}