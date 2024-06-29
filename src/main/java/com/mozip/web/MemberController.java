package com.mozip.web;

import com.mozip.config.auth.PrincipalDetails;
import com.mozip.handler.ex.CustomException;
import com.mozip.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Member 테이블과 관련된 URL 매핑(mypage, mypage_edit)
 */
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public String myPageForm(@PathVariable("memberId") int memberId, Model model) {
        model.addAttribute("member", memberService.getUserInfo(memberId));
        return "member/mypage";
    }

    @GetMapping("/member/edit/{memberId}")
    public String myPageEditForm(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable("memberId") int memberId, Model model) {
        if (principalDetails == null || principalDetails.getMember().getId() != memberId)
            throw new CustomException("접근권한이 없습니다!");
        model.addAttribute("member", memberService.editUserInfo(memberId));
        return "member/mypage_edit";
    }

    @PostMapping("/member/delete")
    public String memberDelete(@RequestParam("memberId") int memberId){
        System.out.println("===========");
        System.out.println(memberId);
        System.out.println("===========");

        return "redirect:/";
    }
}