package com.mozip.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@Data
public class UpdateMypageEditDto {
    private int memberId;

    @NotBlank(message = "이메일은 필수입니다!")
    @Email
    private String email;

    @NotNull(message = "경력선택은 필수입니다!")
    private Integer career;

    @NotBlank(message = "깃허브링크는 필수입니다!")
    private String githubLink;

    @NotNull(message = "직군선택은 필수입니다!")
    private String position;

    @NotBlank(message = "자기소개는 필수입니다!")
    @Size(min = 1, max = 150)
    private String info;

    @NotNull(message = "기술스택은 필수입니다!")
    private List<String> skills;
}
