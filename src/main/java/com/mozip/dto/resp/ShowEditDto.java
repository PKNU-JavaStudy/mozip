package com.mozip.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShowEditDto {
    private int id;
    private String projectType; // 프로젝트 타입(프로젝트/스터디)
    private String projectName; // 프로젝트 제목
    private LocalDateTime createdAt; // 생성일(프로젝트 시작날짜)
    private LocalDateTime modifiedShow; // 자랑 버튼 누른 일자(프로젝트 종료일)
    private int recruitCount; // 모집인원(subscribe 테이블과 조인) 수 = 진행멤버
    private String projectProcess; // 진행방식PROJECT(온/오프)
    private String projectPurpose; // 프로젝트 목적
    private int projectTime; // 프로젝트 참여시간
    private Object projectInfo; // 프로젝트 소개

    private String createdChangeAt;
    private String modifiedChangeAt;
    private List<String> skills; // 프로젝트에서 사용한 기술 스택(java, react 등..)(project_skill 테이블과 조인)
    private List<String> recruitRole; // 프로젝트 모집 분야(프론트, 백엔드 등)(recruit_role 테이블과 조인)
}
