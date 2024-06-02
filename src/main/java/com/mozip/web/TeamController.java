package com.mozip.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Team Note 테이블과 관련된 URL 매핑(teamnote , teamnote_list
 */
@RequiredArgsConstructor
@Controller
public class TeamController {

    // teamnote_list 페이지
    @GetMapping("/teamnote")
    public String teamnoteListForm(){
        return "/team/teamnote_list";
    }

    // teamnote 페이지
    @GetMapping("/teamnote/teamId")  // TODO : {}로 묶어야함(쿼리 파라미터)
    public String teamnoteForm(){
        return "/team/teamnote";
    }
}
