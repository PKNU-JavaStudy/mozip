package com.mozip.service;

import com.mozip.domain.member.AuthRepository;
import com.mozip.domain.member.Member;
import com.mozip.dto.req.LoginDto;
import com.mozip.dto.resp.JoinMemberDto;
import com.mozip.handler.ex.CustomException;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;

    @Transactional
    public Member login(LoginDto loginDto) {
        // 이메일 체크
        Member findMember = authRepository.findLoginMember(loginDto.getEmail()).orElseThrow(() -> {
            throw new CustomException("이메일 혹은 비밀번호가 맞지 않습니다!");
        });

        // 비밀번호 체크
        if(!BCrypt.checkpw(loginDto.getPassword(), findMember.getPassword())) {
            throw new CustomException("이메일 혹은 비밀번호가 맞지 않습니다!");
        }

        return findMember;
    }

    @Transactional
    public void joinUser(JoinMemberDto joinMemberDto) {
        // 아이디 중복 체크
        // TODO : 이메일 중복 알림창이 회원가입 알림창 이후에 나옴.
        if(!authRepository.findByEmail(joinMemberDto.getEmail()).isEmpty()) throw new CustomException("이메일 중복입니다 !");

        // 비밀번호 암호화
        joinMemberDto.setPassword(BCrypt.hashpw(joinMemberDto.getPassword(), BCrypt.gensalt()));
        authRepository.joinMember(joinMemberDto);
    }
}
