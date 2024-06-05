package com.mozip.service;

import com.mozip.domain.member.MemberRepository;
import com.mozip.dto.req.MypageEditDto;
import com.mozip.dto.resp.MypageDto;
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

    public MypageDto getUserInfo(int id) {
        MypageDto findMember = memberRepository.getUserInfo(id);
        findMember.setBookmarks(memberRepository.getUserBookmarks(findMember.getId()));
        findMember.setMyProjectList(memberRepository.getUserProject(findMember.getId()));
        findMember.setSkills(memberRepository.getUserSkill(findMember.getId()));
        findMember.setInfo(Util.clobToString((NClob) findMember.getInfo()));

        return findMember;
    }

    public MypageDto editUserInfo(int id) {
        MypageDto editMember = memberRepository.getUserInfo(id);
        editMember.setInfo(memberRepository.getUserInfo(id));
        editMember.setSkills(memberRepository.getUserSkill(editMember.getId()));

        return editMember;
    }

    public void updateUserInfo(MypageEditDto mypageEditDto) {
        memberRepository.updtaeUser(mypageEditDto);
    }
}

