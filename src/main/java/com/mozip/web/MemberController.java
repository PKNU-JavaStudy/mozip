package com.mozip.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Member 테이블과 관련된 URL 매핑(mypage, mypage_edit)
 */
@RequiredArgsConstructor
@Controller
public class MemberController {

    // mypage 페이지
    @GetMapping("/member/memberId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String myPageForm(){
        return "member/mypage";
    }

    // mypage_edit 페이지
    @GetMapping("/member/edit/memberId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String myPageEditForm(){
        return "member/mypage_edit";
    }
}
