package com.mcp.AI_assisted.resume.screening.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CandidateResponse {

    private String name;

    private int score;

    private List<String> skills;

    private List<String> missingSkills;
}