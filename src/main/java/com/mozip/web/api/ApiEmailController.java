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

    // 메일 보내는 컨트롤러
    @PostMapping("/email")
    public ResponseEntity<?> getEmail(@RequestParam("memberId") int memberId, @RequestParam("projectId") int projectId) {
        int resultCode = emailService.emailValidation(memberId, projectId);
        if(resultCode != 1)
            emailService.emailSender(memberId, projectId);
        return ResponseEntity.ok().body(new CMRespDto<>(1, "통신성공!", resultCode));
    }

}
