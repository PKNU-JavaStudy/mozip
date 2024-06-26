package com.mozip.config.auth;

import com.mozip.domain.member.AuthRepository;
import com.mozip.domain.member.Member;
import com.mozip.domain.member.Role;
import com.mozip.dto.req.member.JoinMemberDto;
import com.mozip.handler.ex.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final AuthRepository authRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Object attributes = oAuth2User.getAttributes().get("properties");
        Map<String, Object> properties = (Map<String, Object>) attributes;


        String email = properties.get("nickname") + "@kakao.com";

        if (authRepository.findByEmail(email) != null) { // 이전에 가입 했던 유저
            Member member = authRepository.findMember(email).orElseThrow(() -> {
                throw new CustomException("가입하신 회원정보가 없습니다!");
            });
            return new PrincipalDetails(member, properties);
        } else { // 처음 가입하는 유저
            String username = (String) properties.get("nickname");
            String password = bCryptPasswordEncoder.encode((String) properties.get("nickname"));
            String phone = "01000000000";

            JoinMemberDto joinMemberDto = JoinMemberDto.builder().email(email).password(password).username(username).phone(phone).build();
            authRepository.joinMember(joinMemberDto, Role.USER.getValue());

            Member member = authRepository.findMember(email).orElseThrow(() -> {
                throw new CustomException("가입하신 회원정보가 없습니다!");
            });
            return new PrincipalDetails(member, properties);
        }
    }
}
