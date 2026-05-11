package com.mcp.AI_assisted.resume.screening.service;

import com.mcp.AI_assisted.resume.screening.dto.CandidateResponse;
import com.mcp.AI_assisted.resume.screening.model.Candidate;
import com.mcp.AI_assisted.resume.screening.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository repository;

    public CandidateResponse analyzeCandidate(
            List<String> extractedSkills,
            List<String> jdSkills
    ) {

        List<String> missingSkills =
                new ArrayList<>();

        int matchedSkills = 0;

        for (String skill : jdSkills) {

            if (extractedSkills.contains(skill)) {
                matchedSkills++;
            } else {
                missingSkills.add(skill);
            }
        }

        int score =
                (matchedSkills * 100)
                        / jdSkills.size();

        Candidate candidate =
                Candidate.builder()
                        .name("Detected Candidate")
                        .score(score)
                        .skills(extractedSkills)
                        .build();

        repository.save(candidate);

        return CandidateResponse.builder()
                .name(candidate.getName())
                .score(score)
                .skills(extractedSkills)
                .missingSkills(missingSkills)
                .build();
    }
}