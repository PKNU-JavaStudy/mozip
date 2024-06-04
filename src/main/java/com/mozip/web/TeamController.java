package com.mozip.web;
// 클라이언트의 요청을 응답해주는 역할(조건문 많이 씀-로그인 하면 해당유저의 정보만 가져와서 띄워주는 느낌)

import com.mozip.domain.member.Member;
import com.mozip.dto.resp.TeamnoteListDto;
import com.mozip.handler.ex.CustomException;
import com.mozip.service.ProjectService;
import com.mozip.service.TeamService;
import com.mozip.util.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

/**
 * Team Note 테이블과 관련된 URL 매핑(teamnote , teamnote_list
 */
@RequiredArgsConstructor
@Controller
public class TeamController {

    private final TeamService teamService;

    // teamnote_list 페이지
    @GetMapping("/teamnote/{memberId}")
    public String teamnoteListForm(@PathVariable("memberId") int memberId, Model model, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        if (loginMember == null) throw new CustomException("로그인이 필요합니다 !");

        model.addAttribute("teamnoteList", teamService.findTeamNoteList(memberId));
        return "/team/teamnote_list";
    }

    // teamnote 페이지
    @GetMapping("/teamnote/teamId")  // TODO : {}로 묶어야함(쿼리 파라미터)
    public String teamnoteForm() {
        return "/team/teamnote";
    }
}
