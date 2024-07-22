package com.mozip.dto.req.project;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ShowUpdateDto {
    private String githubUrl;
    private int projectId;
}
