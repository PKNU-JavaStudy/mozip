package com.mozip.dto.req;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@Data
public class UpdateMypageEditDto {
    private int memberId;
    private String email;
    private int career;
    private String githubLink;
    private String position;
    private String info;

    private List<String> skills;
}
