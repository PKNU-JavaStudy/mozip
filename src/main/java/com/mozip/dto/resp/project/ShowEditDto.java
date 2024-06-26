package com.mozip.dto.resp.project;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ShowEditDto {
    // TODO : 프로젝트 수정은 회의 후 컬럼 및 로직 수정이 필요함!!
    private int id;
    private String projectType; // 프로젝트 타입(프로젝트/스터디)
    private String projectName; // 프로젝트 제목
    private int recruitCount; // 모집인원(subscribe 테이블과 조인) 수 = 진행멤버
    private String projectProcess; // 진행방식PROJECT(온/오프)
    private String projectPurpose; // 프로젝트 목적
    private int projectTime; // 프로젝트 참여시간
    private String projectInfo; // 프로젝트 소개

    @NotNull
    private String createdChangeAt;

    @NotNull
    private String modifiedChangeAt;

    @NotNull
    private List<String> skills; // 프로젝트에서 사용한 기술 스택(java, react 등..)(project_skill 테이블과 조인)

    @NotNull
    private List<String> recruitRole; // 프로젝트 모집 분야(프론트, 백엔드 등)(recruit_role 테이블과 조인)

    private Timestamp createdAt; // 생성일(프로젝트 시작날짜)
    private Timestamp modifiedShow; // 자랑 버튼 누른 일자(프로젝트 종료일)
}
