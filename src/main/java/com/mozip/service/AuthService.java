package com.mozip.service;

import com.mozip.domain.member.JoinRepository;
import com.mozip.dto.resp.JoinMemberDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthService {
    private final JoinRepository joinRepository;

    public void joinUser(JoinMemberDto joinMemberDto) {
        // 비밀번호 암호화
        joinMemberDto.setPassword(BCrypt.hashpw(joinMemberDto.getPassword(), BCrypt.gensalt()));
        joinRepository.joinMember(joinMemberDto);
    }
}
