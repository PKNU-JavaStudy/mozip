package com.mozip.web;

import com.mozip.dto.resp.ProjectListDto;
import com.mozip.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Project 테이블과 관련된 URL매핑(recruit_create,detail,list / show_crate,detail,list)
 */
@RequiredArgsConstructor
@Controller
public class ProjectController {
    private final ProjectService projectService;

    // 메인페이지
    @GetMapping("/")
    public String index(Model model) { // Model 객체를 쓰기위해 파라미터로 받는다.
        // 새로운 모집글 데이터 로딩 후 model 에 담아서 View 전달

        List<ProjectListDto> dto = projectService.findNewProject(); // service 코드에서 필요 데이터를 받아온다.
        System.out.println("===============");
        for (ProjectListDto project : dto) {
            System.out.println(project);
        }
        System.out.println("===============");

        // 컨트롤러에서 데이터가 넘어오는 것을 확인하면 model 객체에 담아 key,value 형태로 view에 뿌려준다.
        model.addAttribute("newProject",projectService.findNewProject());

        return "index";
    }

    // recruit_create 페이지
    @GetMapping("/project/create") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String recruitCreateForm() {
        return "/project/recruit_create";
    }

    // recruit_detail 페이지
    @GetMapping("/project/projectId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String recruitDetailForm() {
        return "/project/recruit_detail";
    }

    // recruit_list 페이지
    @GetMapping("/project")
    public String recruitListForm() {
        return "/project/recruit_list";
    }

    // show_detail 페이지
    @GetMapping("/project/show/projectId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String showDetailForm() {
        return "/project/show_detail";
    }

    // show_list 페이지
    @GetMapping("/project/show")
    public String showListForm() {
        return "/project/show_list";
    }
}
