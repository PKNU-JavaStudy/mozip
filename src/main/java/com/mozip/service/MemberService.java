package com.mozip.service;

import com.mozip.domain.member.Member;
import com.mozip.domain.member.MemberRepository;
import com.mozip.domain.project.ProjectRepository;
import com.mozip.dto.req.member.MypageEditDto;
import com.mozip.dto.resp.member.MypageDto;
import com.mozip.dto.resp.member.NewMemberListDto;
import com.mozip.dto.req.member.UpdateMypageEditDto;
import com.mozip.dto.resp.project.ShowListDto;
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

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    /**
     * <h3>메인페이지 - 새 멤버 가져오는 메서드</h3>
     * <li>마이페이지를 수정한 멤버중 가장 최근에 가입한 6명의 Member 데이터를 가져온다.</li>
     * @return List<>
     */
    public List<NewMemberListDto> newMemberList() {
        List<NewMemberListDto> newMembers = memberRepository.newMemberList();
        
        for (NewMemberListDto newMember : newMembers) {
            newMember.setInfo(newMember.getInfo());
        }
        return newMembers;
    }

    /**
     * <h3>마이페이지 - 멤버 정보를 가져오는 메서드</h3>
     * <li>멤버의 ID 를 통해 화면에 뿌려줄 데이터들을 가져온다.</li>
     * @param memberId
     * @return MypageDto
     */
    public MypageDto getUserInfo(int memberId) {
        MypageDto findMember = memberRepository.getUserInfo(memberId);
        findMember.setBookmarks(memberRepository.getUserBookmarks(findMember.getId()));
        findMember.setMyProjectList(memberRepository.getUserProject(findMember.getId()));
        findMember.setSkills(memberRepository.getUserSkill(findMember.getId()));
        findMember.setInfo(findMember.getInfo());

        return findMember;
    }

    /**
     * <h3>마이페이지 수정 - 멤버 정보를 가져오는 메서드</h3>
     * <li>마이페이지 정보 수정 전 기존 데이터를 가져온다.</li>
     * @param id
     * @return MypageEditDto
     */
    public MypageEditDto editUserInfo(int id) {
        MypageEditDto editMember = memberRepository.editUserInfo(id);
        editMember.setInfo(editMember.getInfo());
        editMember.setSkills(memberRepository.findSkill(editMember.getId()));

        return memberRepository.editUserInfo(id);

    }

    // 마이페이지 수정: 유저 정보 업데이트 메서드

    /**
     * 마이페이지 수정 - 멤버 정보를 수정하는 메서드
     * <li>정보수정 페이지에서 입력받은 새로운 데이터로 수정</li>
     * @param dto
     */
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

    /**
     * <h3>프로필 이미지 저장 메서드</h3>
     * <li>1. 프로필 이미지를 받아 UUID 를 통해 새로운 이름을 만든다.</li>
     * <li>2. 이미지가 저장되는 경로에 이미지 저장</li>
     * @param file
     * @param memberId
     */
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

    @Transactional
    public void deleteMember(int memberId) {
        // SUBSCRIBE 테이블에 관련된 member 데이터 삭제
        memberRepository.deleteSubscribe(memberId);
        // BOOKMARK 테이블에 관련된 member 데이터 삭제
        memberRepository.deleteBookmark(memberId);
        // MEMBER_SKILL 테이블에 관련된 member 데이터 삭제
        memberRepository.deleteSkills(memberId);
        // MEMBER 가 작성한 프로젝트 삭제
        projectRepository.deleteByOwnerId(memberId);
        // MEMBER 삭제
        memberRepository.deleteMember(memberId);
    }

    public List<ShowListDto> findProjectList(int memberId) {
        List<ShowListDto> projectList = projectRepository.findProjectListById(memberId);
        for (ShowListDto project : projectList) {
            project.setLikes(projectRepository.findLikeCount(project.getId()));
            project.setSkills(projectRepository.findProjectSkills(project.getId()));
        }

        return projectList;
    }
}


