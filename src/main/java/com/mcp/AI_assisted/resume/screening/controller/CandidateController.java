package com.mcp.AI_assisted.resume.screening.controller;

import com.mcp.AI_assisted.resume.screening.dto.CandidateResponse;
import com.mcp.AI_assisted.resume.screening.mcp.MCPToolService;
import com.mcp.AI_assisted.resume.screening.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CandidateController {

    private final ResumeParserService parserService;

    private final SkillExtractionService skillService;

    private final CandidateService candidateService;

    private final RankingService rankingService;

    private final MCPToolService mcpToolService;

    @PostMapping("/upload")
    public String uploadResume(
            @RequestParam("file")
            MultipartFile file,

            @RequestParam("jdSkills")
            String jdSkills,

            Model model
    ) throws Exception {

        String text =
                parserService.parseResume(file);

        List<String> extractedSkills =
                skillService.extractSkills(text);

        List<String> jdSkillList =
                List.of(jdSkills.split(","));

        CandidateResponse response =
                candidateService.analyzeCandidate(
                        extractedSkills,
                        jdSkillList
                );

        model.addAttribute(
                "candidate",
                response
        );

        return "result";
    }

    @GetMapping("/ranking")
    public String ranking(
            Model model
    ) {

        model.addAttribute(
                "candidates",
                rankingService.rankCandidates()
        );

        return "ranking";
    }

    @GetMapping("/mcp")
    @ResponseBody
    public Object mcpTool() {

        return mcpToolService.analyzeTool();
    }
}