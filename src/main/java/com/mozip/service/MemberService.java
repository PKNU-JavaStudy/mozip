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
import java.util.UUID;

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
    // 마이페이지: 유저 정보를 가져오는 메서드
    public MypageDto getUserInfo(int id) {
        MypageDto findMember = memberRepository.getUserInfo(id);
        findMember.setBookmarks(memberRepository.getUserBookmarks(findMember.getId()));
        findMember.setMyProjectList(memberRepository.getUserProject(findMember.getId()));
        findMember.setSkills(memberRepository.getUserSkill(findMember.getId()));
        findMember.setInfo(Util.clobToString((NClob) findMember.getInfo()));

        return findMember;
    }
    // 마이페이지 수정: 유저 정보를 가져오는 메서드
    public MypageEditDto editUserInfo(int id) {
        MypageEditDto editMember = memberRepository.editUserInfo(id);
        editMember.setInfo(Util.clobToString((NClob) editMember.getInfo()));
        editMember.setSkills(memberRepository.findSkill(editMember.getId()));

        return memberRepository.editUserInfo(id);

    }
    // 마이페이지 수정: 유저 정보 업데이트 메서드
    @Transactional
    public void updateMemberInfo(UpdateMypageEditDto dto) {
        memberRepository.updateInfo(dto);
        // 1. 맴버ID -> MEMBER_SKILL 전부 삭제
        memberRepository.deleteSkills(dto.getMemberId());
        // 2. 각 스킬 list에 for문으로 insert 날리기
        for (String skill : dto.getSkills()) {

            memberRepository.insertSkills(dto.getMemberId(), skill);
        }
    }
}


