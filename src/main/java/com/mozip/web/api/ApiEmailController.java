package com.mozip.web.api;

import com.mozip.dto.CMRespDto;
import com.mozip.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
