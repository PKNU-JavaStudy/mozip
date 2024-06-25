package com.mozip.config.auth;

import com.mozip.domain.member.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class PrincipalDetails implements UserDetails {
    @Override
    public String toString() {
        return "PrincipalDetails{" +
                "member=" + member +
                '}';
    }

    private final Member member;
    private final List<GrantedAuthority> authorities;

    public PrincipalDetails(Member member, List<GrantedAuthority> authorities) {
        this.member = member;
        this.authorities = authorities;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
