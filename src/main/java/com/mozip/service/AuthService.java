package com.mozip.service;

import com.mozip.domain.member.AuthRepository;
import com.mozip.domain.member.Role;
import com.mozip.dto.req.project.FindEmailDto;
import com.mozip.dto.req.member.JoinMemberDto;
import com.mozip.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * <h3>회원가입 메서드</h3>
     * <li>1. 입력받은 DTO 에 email 값으로 중복체크</li>
     * <li>2. 비밀번호 암호화</li>
     * <li>3. 권한 체크</li>
     * @param joinMemberDto
     */
    @Transactional
    public void joinUser(JoinMemberDto joinMemberDto) {
        // 아이디 중복 체크
        if(authRepository.findByEmail(joinMemberDto.getEmail())!=null)
            throw new CustomApiException("이메일 중복입니다 !");

        // 비밀번호 암호화
        joinMemberDto.setPassword(bCryptPasswordEncoder.encode(joinMemberDto.getPassword()));

        // 권한체크
        if(joinMemberDto.getEmail().equals("admin@admin.com"))
            authRepository.joinMember(joinMemberDto, Role.ADMIN.getValue());
        else
            authRepository.joinMember(joinMemberDto,Role.USER.getValue());

    }

    /**
     * <h3>이메일찾기 메서드</h3>
     * <li>수정 필요함!</li>
     * @param findEmailDto
     * @return String
     */
    public String findMemberEmail(FindEmailDto findEmailDto) {
        return authRepository.findMemberEmail(findEmailDto);
    }
}
