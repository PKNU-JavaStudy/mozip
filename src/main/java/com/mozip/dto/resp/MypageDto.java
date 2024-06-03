package com.mozip.dto.resp;

import java.util.List;

public class MypageDto {
    private int id;
    private String name;
    private int career;
    private Object info;
    private String position;
    private List<String> skills; // 프로젝트 사용하는 기술스택(project_skill 테이블과 조인)
    private int makeProject;    // 내가 만든 프로젝트 목록(project 테이블 조인)
    private int myBookmark;      // 북마크한 글 목록 (bookmark 테이블 조인)
    private List<String> bookmarks; // 북마크 리스트

    public MypageDto(int id, String name, int career, Object info, String position, List<String> skills, int makeProject, int myBookmark, List<String> bookmarks) {
        this.id = id;
        this.name = name;
        this.career = career;
        this.info = info;
        this.position = position;
        this.skills = skills;
        this.makeProject = makeProject;
        this.myBookmark = myBookmark;
        this.bookmarks = bookmarks;
    }

}
