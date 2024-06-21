package com.mozip.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProjectDetailDto {
    private int id;
    private String projectType; // 프로젝트 타입
    private int status; // 프로젝트 모집상태
    private String projectName; // 프로젝트 제목
    private String createdAt; // 생성일
    private int recruitCount; // 모집인원(subscribe 테이블과 조인) 수
    private int views; // 조회수
    private String projectProcess; // 진행방식PROJECT
    private String projectPurpose; // 프로젝트 목적
    private String exceptTime; // 시작예정
    private int exceptDate; // 예상기간
    private int projectTime; // 프로젝트 참여시간
    private String projectInfo;
    private int ownerId; // 작성자 아이디

    private List<ProjectMemberDto> members; // 참여지원자(project_member테이블과 조인) 정보 데이터
    private ProjectMemberDto ownerInfo; // 작성자 정보(member 테이블과 조인)
    private List<String> skills; // 프로젝트 사용하는 기술스택(project_skill 테이블과 조인)
    private List<String> recruitRoles; // 프로젝트 모집분야(recruit_role 테이블과 조인)
    private int projectMemberCount; // 현재 프로젝트에 참여중인 멤버수
    private List<Integer> projectMemberIds;

    public ProjectDetailDto(int id, String projectType, int status, String projectName, String createdAt, int recruitCount, int views, String projectProcess,
                            String projectPurpose, String exceptTime, int exceptDate, int projectTime, String projectInfo, int ownerId) {
        this.id = id;
        this.projectType = projectType;
        this.status = status;
        this.projectName = projectName;
        this.createdAt = createdAt;
        this.recruitCount = recruitCount;
        this.views = views;
        this.projectProcess = projectProcess;
        this.projectPurpose = projectPurpose;
        this.exceptTime = exceptTime;
        this.exceptDate = exceptDate;
        this.projectTime = projectTime;
        this.projectInfo = projectInfo;
        this.ownerId = ownerId;
    }
}



