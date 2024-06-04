package com.mozip.service;

import com.mozip.domain.member.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EmailService {
    private final AuthRepository authRepository;

    public void emailSender(int memberId){
        String memberEmail = authRepository.findById(memberId);
        System.out.println(memberEmail);
    }
}
