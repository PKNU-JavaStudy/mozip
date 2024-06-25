package com.mozip.dto.resp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class ProjectEditDto {
    private int id;

    @NotBlank(message = "프로젝트 타입은 필수입니다!")
    private String projectType;

    @NotBlank(message = "프로젝트 제목은 필수입니다!")
    @Size(min = 5, max = 50)
    private String projectName;

    @NotBlank(message = "프로젝트 주제는 필수입니다!")
    private String subject;

    @NotNull(message = "모집인원은 필수입니다!")
    private String recruitCount;

    @NotBlank(message = "수행목적은 필수입니다!")
    private String projectPurpose;

    @NotNull(message = "참여시간은 필수입니다!")
    private Integer projectTime;

    @NotBlank(message = "수행목적은 필수입니다!")
    private String projectProcess;

    @NotNull(message = "예상기간은 필수입니다!")
    private Integer exceptDate;

    private LocalDateTime exceptTime;

    @NotBlank(message = "프로젝트 소개는 필수입니다!")
    private String projectInfo;

    @NotNull(message = "시작예정 선택은 필수입니다!")
    private String exceptChangeTime; // LocalDateTime 을 String 으로 바꿔서 input태그(date속성)에 담을 수 있음

    @NotNull(message = "기술스택은 필수입니다!")
    private List<String> skills;

    @NotNull(message = "모집분야는 필수입니다!")
    private List<String> recruitRole;
}
