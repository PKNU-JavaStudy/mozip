package com.mozip.dto.req;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UpdateMypageEditDto {
    private int id;
    private String email;
    private int career;
    private String githubLink;
    private String position;
    private Object info;

    private List<String> skills;
}
