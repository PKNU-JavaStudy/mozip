package com.mozip.service;

import com.mozip.domain.member.MemberRepository;
import com.mozip.dto.req.MypageEditDto;
import com.mozip.dto.resp.MypageDto;
import com.mozip.dto.resp.NewMemberListDto;
import com.mozip.dto.req.UpdateMypageEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    @Value("${file.path}")
    private String uploadFolder;

    private final MemberRepository memberRepository;

    public List<NewMemberListDto> newMemberList() {
        List<NewMemberListDto> newMembers = memberRepository.newMemberList();
        for (NewMemberListDto newMember : newMembers) {
            newMember.setInfo(newMember.getInfo());

        }
        return newMembers;
    }

    // 마이페이지: 유저 정보를 가져오는 메서드
    public MypageDto getUserInfo(int id) {
        MypageDto findMember = memberRepository.getUserInfo(id);
        findMember.setBookmarks(memberRepository.getUserBookmarks(findMember.getId()));
        findMember.setMyProjectList(memberRepository.getUserProject(findMember.getId()));
        findMember.setSkills(memberRepository.getUserSkill(findMember.getId()));
        findMember.setInfo(findMember.getInfo());


        return findMember;
    }

    // 마이페이지 수정: 유저 정보를 가져오는 메서드
    public MypageEditDto editUserInfo(int id) {
        MypageEditDto editMember = memberRepository.editUserInfo(id);
        editMember.setInfo(editMember.getInfo());
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

    // 프로필 이미지
    @Transactional
    public void profileImageUpload(MultipartFile file, int memberId){
        /**
         * UUID 를 사용하는 이유
         * 사용자는 서버에 이미지가 어떤이름으로 저장되는지 모르기에 같은 파일을 또 저장할 수 있다.
         * DB 에서는 구분해야 하기 때문에 UUID 식별자를 붙혀서 똑같은 이름의 파일을 구분한다.
         */
        UUID uuid = UUID.randomUUID();

        // getOriginalFilename()은 실제 파일명을 리턴해준다.
        String imageFileName = uuid + "_" + file.getOriginalFilename();

        // 실제 경로를 저장 Path(nio 패키지) : 파일이 저장되는 경로 + 파일 이름 = 실제 저장되는 경로
        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        // 통신 , I/O 가
        try {
            //write() 메서드는 실제 파일 경로와 실제 들어오는 파일을 Byte 로 바꾼것 , option 을 받는다.
            Files.write(imageFilePath, file.getBytes());
            memberRepository.updateProfileImg(imageFileName, memberId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


