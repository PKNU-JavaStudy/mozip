package com.mozip.service;

import com.mozip.domain.member.MemberRepository;
import com.mozip.dto.resp.NewMemberListDto;
import com.mozip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.NClob;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public List<NewMemberListDto> newMemberList() {
        List<NewMemberListDto> newMembers = memberRepository.newMemberList();
        for (NewMemberListDto newMember : newMembers) {
            newMember.setInfo(Util.clobToString((NClob) newMember.getInfo()));
        }
        return newMembers;
    }
}
