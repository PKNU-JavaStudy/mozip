package com.mozip.service;

import com.mozip.domain.member.MemberRepository;
import com.mozip.dto.req.MypageEditDto;
import com.mozip.dto.resp.MypageDto;
import com.mozip.dto.resp.NewMemberListDto;
import com.mozip.dto.req.UpdateMypageEditDto;
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

    public MypageEditDto editUserInfo(int id) {
        MypageEditDto editMember = memberRepository.editUserInfo(id);
        editMember.setInfo(Util.clobToString((NClob) editMember.getInfo()));
        editMember.setSkills(memberRepository.findSkill(editMember.getId()));
        return memberRepository.editUserInfo(id);

    }
    @Transactional
    public UpdateMypageEditDto updateInfo(int memberId) {
        UpdateMypageEditDto updateMember = memberRepository.updateInfo(memberId);
        updateMember.setInfo(memberRepository.getUserInfo(updateMember.getId()));
        updateMember.setSkills(memberRepository.findSkill(updateMember.getId()));
        updateMember.setInfo(Util.clobToString((NClob) updateMember.getInfo()));
        return memberRepository.updateInfo(memberId);
    }

}


