package com.mozip.service;

import com.mozip.domain.member.AuthRepository;
import com.mozip.domain.member.Member;
import com.mozip.domain.member.Role;
import com.mozip.dto.req.FindEmailDto;
import com.mozip.dto.req.LoginDto;
import com.mozip.dto.req.JoinMemberDto;
import com.mozip.handler.ex.CustomException;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void joinUser(JoinMemberDto joinMemberDto) {
        // 아이디 중복 체크
        // TODO : 이메일 중복 알림창이 회원가입 알림창 이후에 나옴.
        if(authRepository.findByEmail(joinMemberDto.getEmail())!=null) throw new CustomException("이메일 중복입니다 !");

        // 비밀번호 암호화
        joinMemberDto.setPassword(bCryptPasswordEncoder.encode(joinMemberDto.getPassword()));

        // 권한체크
        if(joinMemberDto.getEmail().equals("admin@admin.com"))
            authRepository.joinMember(joinMemberDto, Role.ADMIN.getValue());
        else
            authRepository.joinMember(joinMemberDto,Role.USER.getValue());

    }

    public String findMemberEmail(FindEmailDto findEmailDto) {
        return authRepository.findMemberEmail(findEmailDto);
    }
}
