package com.mozip.web.api;

import com.mozip.dto.CMRespDto;
import com.mozip.service.EmailService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ApiEmailController {
    private final EmailService emailService;


    @GetMapping("/email/{memberId}")
    public ResponseEntity<?> getEmail(@PathVariable int memberId) {
        emailService.emailSender(memberId);

        return new ResponseEntity<>(new CMRespDto<>(1,"통신성공!",null), HttpStatus.OK);
    }

    //카카오 로그인 컨트롤러 (일단 임시로 여기 넣음)
    @RestController
    @RequestMapping("/auth/kakao")
    public static class KakaoController {

        @PostMapping("/userinfo")
        public Map<String, Object> receiveUserInfo(@RequestBody Map<String, Object> userInfo, HttpSession session) {
            // 세션에 사용자 정보 저장
            System.out.println("UserInfo received: " + userInfo); // 응답을 로그로 출력
            session.setAttribute("userInfo", userInfo);
            return Map.of("success", true);
        }
    }
}
