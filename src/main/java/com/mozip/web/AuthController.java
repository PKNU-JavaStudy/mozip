package com.mozip.web;

import com.mozip.domain.member.Member;
import com.mozip.dto.req.LoginDto;
import com.mozip.dto.req.JoinMemberDto;
import com.mozip.service.AuthService;
import com.mozip.util.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 로그인, 회원가입, 아이디찾기, 비밀번호 찾기 URL 이 해당 컨트롤러로 옴
 */
@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    // find_id 페이지
    @GetMapping("/auth/findId")
    public String findIdForm() {
        return "auth/find_id";
    }

    // find_password 페이지
    @GetMapping("/auth/findPw")
    public String findPwForm() {
        return "auth/find_password";
    }

    // join 페이지
    @GetMapping("/auth/join")
    public String joinForm() {
        return "auth/join";
    }

    // 회원가입 처리
    @PostMapping("/auth/join")
    public String join(@ModelAttribute JoinMemberDto joinMemberDto) {
        authService.joinUser(joinMemberDto);
        return "redirect:/auth/login";
    }

    // login 페이지
    @GetMapping("/auth/login")
    public String loginForm() {
        return "auth/login";
    }

    // login 처리
    @PostMapping("/auth/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest req) {
        Member loginMember = authService.login(new LoginDto(email, password));
        if (loginMember != null) {
            HttpSession session = req.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        }
        // HTTP Session 이용
        return "redirect:/";
    }

    // logout
    @PostMapping("/auth/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) session.invalidate();

        return "redirect:/";
    }
}
