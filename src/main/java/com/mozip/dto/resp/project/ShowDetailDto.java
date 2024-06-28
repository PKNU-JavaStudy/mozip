package com.mozip.dto.resp.project;

import lombok.Data;
import java.util.List;

@Data
public class ShowDetailDto {

    private int id;
    private String projectType; // 프로젝트 타입(프로젝트/스터디)
    private String projectName; // 프로젝트 제목
    private String createdAt; // 생성일(프로젝트 시작날짜)
    private String modifiedShow;    // 자랑 버튼 누른 일자(프로젝트 종료일)
    private int recruitCount; // 모집인원(subscribe 테이블과 조인) 수 = 진행멤버
    private int views; // 조회수
    private String projectProcess; // 진행방식PROJECT(온/오프)
    private String projectPurpose; // 프로젝트 목적
    private int projectTime; // 프로젝트 참여시간
    private String projectInfo; // 프로젝트 소개
    private int ownerId; // 작성자 아이디
    private String githubLink; // 깃허브 링크 가져오기

    public ShowDetailDto(int id, String projectType, String projectName, String createdAt, String modifiedShow, int views, String projectProcess,
                         String projectPurpose, int projectTime, int recruitCount, String projectInfo, int ownerId, String githubLink) {
        this.id = id;
        this.projectType = projectType;
        this.projectName = projectName;
        this.createdAt = createdAt;
        this.modifiedShow = modifiedShow;
        this.views = views;
        this.projectProcess = projectProcess;
        this.projectPurpose = projectPurpose;
        this.projectTime = projectTime;
        this.recruitCount = recruitCount;
        this.projectInfo = projectInfo;
        this.ownerId = ownerId;
        this.githubLink= githubLink;
    }

    // 조인 쿼리
    private ProjectMemberDto ownerInfo; // 작성자 정보(이름, 프로필사진, 경력 및 스팩)(member 테이블과 조인)
    private List<String> skills; // 프로젝트에서 사용한 기술 스택(java, react 등..)(project_skill 테이블과 조인)
    private List<String> recruitRoles; // 프로젝트 모집 분야(프론트, 백엔드 등)(recruit_role 테이블과 조인)
    private int projectMemberCount; // 현재 프로젝트에 참여한 멤버수
    private int likes; // 좋아요 수 카운터
    private int bookmark;   // 북마크 수 카운터

}
