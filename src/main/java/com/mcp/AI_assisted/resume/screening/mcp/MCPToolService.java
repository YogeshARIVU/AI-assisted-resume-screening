package com.mcp.AI_assisted.resume.screening.mcp;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MCPToolService {

    public Map<String, Object> analyzeTool() {

        return Map.of(
                "tool", "resume-analysis",
                "status", "success"
        );
    }
}