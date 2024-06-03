package com.mozip.web;

import com.mozip.domain.member.Member;
import com.mozip.domain.member.MemberRepository;
import com.mozip.dto.resp.MypageDto;
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

    // mypage 페이지
    @GetMapping("/member/{memberId}") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String myPageForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, @PathVariable int memberId, Model model){
        if (loginMember == null) throw new CustomException("로그인이 필요합니다 !");
        MypageDto userInfo = memberService.getUserInfo(memberId);
        System.out.println("userInfo = " + userInfo);
        model.addAttribute("userInfo", userInfo);
        return "member/mypage";
    }

    // mypage_edit 페이지
    @GetMapping("/member/edit/memberId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String myPageEditForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember){
        if (loginMember == null) throw new CustomException("로그인이 필요합니다 !");
        return "member/mypage_edit";
    }
}
