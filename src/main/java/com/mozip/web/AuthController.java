package com.mozip.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 로그인, 회원가입, 아이디찾기, 비밀번호 찾기 URL 이 해당 컨트롤러로 옴
 */
@RequiredArgsConstructor
@Controller
public class AuthController {

    // find_id 페이지
    @GetMapping("/auth/findId")
    public String findIdForm(){
        return "auth/find_id";
    }

    // find_password 페이지
    @GetMapping("/auth/findPw")
    public String findPwForm(){
        return "auth/find_password";
    }

    // join 페이지
    @GetMapping("/auth/join")
    public String joinForm(){
        return "auth/join";
    }

    // login 페이지
    @GetMapping("/auth/login")
    public String loginForm(){
        return "auth/login";
    }
}
