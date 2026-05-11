package com.mcp.AI_assisted.resume.screening.repository;

import com.mcp.AI_assisted.resume.screening.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository
        extends JpaRepository<Candidate, Long> {
}