package com.mozip.web;

import com.mozip.dto.resp.ProjectDetailDto;
import com.mozip.dto.resp.ProjectListDto;
import com.mozip.dto.resp.RecruitListDto;
import com.mozip.dto.resp.ShowListDto;
import com.mozip.service.MemberService;
import com.mozip.service.ProjectService;
import com.mozip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.NClob;
import java.util.List;

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
    public String index(Model model) { // Model 객체를 쓰기위해 파라미터로 받는다.
        // 새로운 모집글 데이터 로딩 후 model 에 담아서 View 전달

        // 컨트롤러에서 데이터가 넘어오는 것을 확인하면 model 객체에 담아 key,value 형태로 view에 뿌려준다.
        model.addAttribute("newProject", projectService.findNewProject());

        // 인기 모집글 데이터 로딩 후 model 에 담아서 View 전달(위 방식을 한줄로 바꾼방식)
        model.addAttribute("hotProject", projectService.findHotProject());

        // 새로운 멤버 데이터 로딩 후 model에 담아서 View 전달
        model.addAttribute("newMember", memberService.newMemberList());

        return "index";
    }

    // recruit_create 페이지
    @GetMapping("/project/create") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String recruitCreateForm() {
        return "/project/recruit_create";
    }

    // recruit_detail 페이지
    @GetMapping("/project/{projectId}") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String recruitDetailForm(@PathVariable int projectId, Model model){
        model.addAttribute("project", projectService.findProjectDetail(projectId));

        return "/project/recruit_detail";
    }

    // recruit_list 페이지
    @GetMapping("/project")
    public String recruitListForm(Model model){
        // 가져온 데이터를 모델에 추가하여 타임리프 템플릿에서 사용할 수 있게 함
        model.addAttribute("allProject", projectService.findAllProject());
        return "/project/recruit_list";
    }

    // show_detail 페이지
    @GetMapping("/project/show/projectId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String showDetailForm(){
        return "/project/show_detail";
    }

    // show_list 페이지
    @GetMapping("/project/show")
    public String showListForm(Model model){
        List<ShowListDto> allShows = projectService.findAllShowProject();
        // 모든 프로젝트 자랑
        model.addAttribute("allShows", allShows);
        // 인기 프로젝트 자랑
        model.addAttribute("HotShows", projectService.findHotShow());
        return "/project/show_list";
    }
}
