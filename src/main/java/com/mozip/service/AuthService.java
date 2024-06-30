package com.mozip.service;

import com.mozip.config.auth.PrincipalDetails;
import com.mozip.domain.member.AuthRepository;
import com.mozip.domain.member.Member;
import com.mozip.domain.member.Role;
import com.mozip.dto.req.member.FindPwDto;
import com.mozip.dto.req.project.FindEmailDto;
import com.mozip.dto.req.member.JoinMemberDto;
import com.mozip.handler.ex.CustomApiException;
import com.mozip.handler.ex.CustomException;
import com.mozip.handler.ex.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public String emailValidate(FindPwDto findPwDto) {
        // email , username, phone 으로 쿼리를 날려 유효한 사용자인지 체크
        String findEmail = authRepository.findByEmail(findPwDto.getEmail());
        if(findEmail !=null)
            return findEmail;
        else
            throw new CustomException("이메일이 없습니다!");

    }

    @Transactional
    public void updatePassword(String password, String confirmPassword, String email) {
        // 1. password , confirmPassword 같은지 체크 : 아니면 throw new CustomException("비밀번호가 일치하지않습니다!");
        if (!password.equals(confirmPassword))
            throw new CustomException("비밀번호가 일치하지 않습니다!");
        else
            authRepository.updateMemberPw(bCryptPasswordEncoder.encode(password), email);

    }

    public void updateSession(PrincipalDetails principalDetails) {
        Member findMember = authRepository.findMember(principalDetails.getMember().getEmail()).orElseThrow(() -> {
            throw new CustomApiException("찾으시는 객체가 없습니다!");
        });

        principalDetails.updateSession(findMember);
    }
}
