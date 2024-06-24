package com.mozip.web;

import com.mozip.config.auth.PrincipalDetails;
import com.mozip.domain.member.Member;

import com.mozip.dto.resp.ProjectDetailDto;
import com.mozip.dto.resp.ProjectMemberDto;
import com.mozip.dto.resp.ShowEditDto;
import com.mozip.handler.ex.CustomException;
import com.mozip.service.KeepService;
import com.mozip.service.MemberService;
import com.mozip.service.ProjectService;
import com.mozip.util.SessionConst;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project 테이블과 관련된 URL매핑(recruit_create,detail,list / show_crate,detail,list)
 */
@RequiredArgsConstructor
@Controller
public class ProjectController {
    private final ProjectService projectService;
    private final MemberService memberService;
    private final KeepService keepService;

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

    // 프로젝트모집 생성 페이지
    @GetMapping("/project/create")
    public String recruitCreateForm(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        if (principalDetails == null) {
            throw new CustomException("로그인이 필요합니다");
        }
        return "/project/recruit_create";
    }

    // 프로젝트모집 상세 페이지
    @GetMapping("/project/{projectId}")
    public String recruitDetailForm(@PathVariable("projectId") int projectId, Model model,
                                    @AuthenticationPrincipal PrincipalDetails principalDetails){
        // 조회수 증가
        projectService.increaseView(projectId);
        model.addAttribute("project",projectService.findProjectDetail(projectId));

        // 북마크
        if (principalDetails != null)
            model.addAttribute("isBookmark", keepService.keepCount(projectId, principalDetails.getMember().getId()));
        return "/project/recruit_detail";
    }

    // 프로젝트모집 목록 페이지
    @GetMapping("/project")
    public String recruitListForm(Model model){
        model.addAttribute("allProject", projectService.findAllProject());
        return "/project/recruit_list";
    }

    // 프로젝트모집 수정 페이지
    @GetMapping("/project/edit/{projectId}")
    public String recruitEditForm(@PathVariable("projectId") int projectId,
                                  @AuthenticationPrincipal PrincipalDetails principalDetails,
                                  Model model) {
        // Project의 OwnerId만 접근가능하게 해야함.
        if (!projectService.ownerCheck(projectId, principalDetails.getMember().getId()))
            throw new CustomException("접근 권한이 없습니다 !");
        model.addAttribute("project", projectService.findOriginProjectInfo(projectId));
        model.addAttribute("projectId", projectId);
        return "/project/recruit_edit";
    }

    // 프로젝트자랑 상세 페이지
    @GetMapping("/project/show/{projectId}")
    public String showDetailForm(@PathVariable("projectId") int projectId, Model model,
                                 @AuthenticationPrincipal PrincipalDetails principalDetails){
        // 조회수 증가
        projectService.increaseView(projectId);
        model.addAttribute("showDetail", projectService.findShowDetail(projectId));
        // 북마크
        if (principalDetails != null)
            model.addAttribute("isBookmark", keepService.keepCount(projectId, principalDetails.getMember().getId()));

        return "/project/show_detail";
    }

    // show_list 페이지
    @GetMapping("/project/show")
    public String showListForm(Model model) {
        // 모든 프로젝트 자랑
        model.addAttribute("allShows", projectService.findAllShowProject());
        // 인기 프로젝트 자랑
        model.addAttribute("HotShows", projectService.findHotShow());

        return "/project/show_list";
    }

    // 프로젝트 자랑 수정 전 데이터 가져오기
    @GetMapping("/project/show_edit/{projectId}")
    public String editSelectShow(@PathVariable("projectId") int projectId, Model model) {
        ShowEditDto attributeValue = projectService.editSelectShow(projectId);
        model.addAttribute("project", attributeValue);
        return "project/show_edit";  // 실제 뷰 템플릿 이름
    }

    // 사용자 초대 버튼 클릭
    @GetMapping("/email/suceess")
    public String emailView(){

        return "/project/EmailView";
    }
}
