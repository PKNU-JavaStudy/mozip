package com.mozip.web;
// 클라이언트의 요청을 응답해주는 역할(조건문 많이 씀-로그인 하면 해당유저의 정보만 가져와서 띄워주는 느낌)

import com.mozip.config.auth.PrincipalDetails;
import com.mozip.handler.ex.CustomException;
import com.mozip.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class TeamController {

    private final TeamService teamService;

    // TODO : 추후 기능 변경
    @GetMapping("/teamnote/{memberId}")
    public String teamnoteListForm(@PathVariable("memberId") int memberId,
                                   Model model,
                                   @AuthenticationPrincipal PrincipalDetails principalDetails) {
        if (principalDetails.getMember() == null) throw new CustomException("로그인이 필요합니다 !");

        model.addAttribute("teamnoteList", teamService.findTeamNoteList(memberId));
        return "/team/teamnote_list";
    }
}
