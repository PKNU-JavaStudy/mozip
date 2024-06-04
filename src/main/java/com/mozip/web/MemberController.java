package com.mozip.web;

import com.mozip.domain.member.Member;
import com.mozip.handler.ex.CustomException;
import com.mozip.service.MemberService;
import com.mozip.util.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Member 테이블과 관련된 URL 매핑(mypage, mypage_edit)
 */
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public String myPageForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, @PathVariable("memberId") int memberId, Model model) {
        if (loginMember == null) throw new CustomException("로그인이 필요합니다 !");
        if (loginMember.getId() != memberId) throw new CustomException("접근권한이 없습니다!");
        model.addAttribute("member", memberService.getUserInfo(memberId));
        return "member/mypage";
    }

    @GetMapping("/member/edit/memberId")
    public String myPageEditForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        if (loginMember == null) throw new CustomException("로그인이 필요합니다 !");
        return "member/mypage_edit";
    }
}
