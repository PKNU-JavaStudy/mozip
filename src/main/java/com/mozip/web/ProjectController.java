package com.mozip.web;

import com.mozip.domain.member.Member;

import com.mozip.handler.ex.CustomException;
import com.mozip.service.MemberService;
import com.mozip.service.ProjectService;
import com.mozip.util.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Project 테이블과 관련된 URL매핑(recruit_create,detail,list / show_crate,detail,list)
 */
@RequiredArgsConstructor
@Controller
public class ProjectController {
    private final ProjectService projectService;
    private final MemberService memberService;

    // 메인페이지
    @GetMapping("/")
    public String index(Model model) {
        // 새로운 모집글
        model.addAttribute("newProject", projectService.findNewProject());

        // 인기 모집글
        model.addAttribute("hotProject", projectService.findHotProject());

        // 새로운 멤버 데이터
        model.addAttribute("newMember", memberService.newMemberList());

        return "index";
    }

    // recruit_create 페이지: 로그인한 유저만 접근
    @GetMapping("/project/create")
    public String recruitCreateForm(@SessionAttribute(name= SessionConst.LOGIN_MEMBER, required=false) Member loginMember) {
        if (loginMember == null) {
            throw new CustomException("로그인이 필요합니다");
        }
        return "/project/recruit_create";
    }

    // recruit_detail 페이지
    @GetMapping("/project/{projectId}")
    public String recruitDetailForm(@PathVariable("projectId") int projectId, Model model){
        // 조회수 증가
        projectService.increaseView(projectId);
        model.addAttribute("project", projectService.findProjectDetail(projectId));
        return "/project/recruit_detail";
    }

    // recruit_list 페이지
    @GetMapping("/project")
    public String recruitListForm(Model model){
        model.addAttribute("allProject", projectService.findAllProject());
        return "/project/recruit_list";
    }

    // show_detail 페이지
    @GetMapping("/project/show/{projectId}")
    public String showDetailForm(@PathVariable("projectId") int projectId, Model model){
        // 조회수 증가
        projectService.increaseView(projectId);
        model.addAttribute("showDetail", projectService.findShowDetail(projectId));
        return "/project/show_detail";
    }

    // show_list 페이지
    @GetMapping("/project/show")
    public String showListForm(Model model){
        // 모든 프로젝트 자랑
        model.addAttribute("allShows", projectService.findAllShowProject());
        // 인기 프로젝트 자랑
        model.addAttribute("HotShows", projectService.findHotShow());

        return "/project/show_list";
    }
}
