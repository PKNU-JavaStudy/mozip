package com.mozip.domain.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.NClob;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Project {
    private Long id;
    private String projectName; // 프로젝트명
    private String project_type; // 프로젝트 타입
    private String subject; // 프로젝트 주제
    private String projectPurpose; // 프로젝트 수행목적
    private int projectTime; // 참여시간
    private int recruitCount; // 모집인원
    private String projectProcess; // 진행방식
    private int exceptDate; // 예상기간
    private LocalDateTime exceptTime; // 프로젝트 시작예정 날짜
    private NClob projectInfo; // 프로젝트 소개
    private int status; // 프로젝트 모집완료 여부
    private int ownerId; // 프로젝트 작성자 PK
    private int views; // 프로젝트 조회수
    private String githubLink; // 깃허브 링크
    private int isShow; // 프로젝트자랑 등록 여부
    private String imageURL; // 썸네일 이미지 경로
    private LocalDateTime modifiedShow; // 프로젝트 자랑 등록날짜
    private LocalDateTime createdAt; // 생성일
}
