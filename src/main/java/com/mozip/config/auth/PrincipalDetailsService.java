package com.mozip.config.auth;

import com.mozip.domain.member.AuthRepository;
import com.mozip.domain.member.Member;
import com.mozip.domain.member.Role;
import com.mozip.handler.ex.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = authRepository.findMember(email).orElseThrow(()->{
            throw new CustomException("찾으시는 사용자가 없습니다!");
        });

        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin@admin.com".equals(email))
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        else
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));

        return new PrincipalDetails(member, authorities);
    }
}
