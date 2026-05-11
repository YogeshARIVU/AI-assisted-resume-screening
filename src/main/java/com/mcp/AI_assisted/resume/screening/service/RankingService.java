package com.mcp.AI_assisted.resume.screening.service;

import com.mcp.AI_assisted.resume.screening.model.Candidate;
import com.mcp.AI_assisted.resume.screening.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final CandidateRepository repository;

    public List<Candidate> rankCandidates() {

        return repository.findAll()
                .stream()
                .sorted(
                        Comparator.comparingInt(
                                Candidate::getScore
                        ).reversed()
                )
                .toList();
    }
}