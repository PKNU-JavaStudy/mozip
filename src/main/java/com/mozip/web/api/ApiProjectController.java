package com.mozip.web.api;

import com.mozip.domain.likes.Likes;
import com.mozip.dto.CMRespDto;
import com.mozip.dto.req.ProjectCreateDto;
import com.mozip.dto.req.ProjectLikeDto;
import com.mozip.dto.resp.ProjectEditDto;
import com.mozip.dto.resp.ProjectMemberDto;
import com.mozip.service.LikesService;
import com.mozip.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ApiProjectController {
    private final ProjectService projectService;
    private final LikesService likesService;

    // 프로젝트 모집 완료
    @PatchMapping("/recruit/done")
    public ResponseEntity<?> recruitDone(@RequestParam("projectId") int projectId) {
        return ResponseEntity.ok().body(new CMRespDto<>(1, "통신성공!", projectService.recruitIsDone(projectId)));
    }

    // 프로젝트 생성
    @PostMapping("/project")
    public ResponseEntity<?> createProject(@RequestBody ProjectCreateDto dto) {
        int projectId = projectService.createProject(dto);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "통신성공", projectId));
    }

    // 프로젝트 수정
    @PatchMapping("/project/update")
    public ResponseEntity<?> updateRecruitProject(@RequestBody ProjectEditDto dto) {
        projectService.updateRecruitProject(dto);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "프로젝트 수정 성공!", dto.getId()));
    }

    @PostMapping("/like")
    public ResponseEntity<?> likeProject(@RequestBody Likes likes){
        // 좋아요, 좋아요 취소 구분하여 처리
        likesService.likeValidation(likes);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공", likesService.likeCount(likes.getProjectId())));
    }

    // 프로젝트 삭제 메서드
    @DeleteMapping("/show/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable("projectId") int projectId) {
        projectService.deleteProject(projectId); // 프로젝트 삭제 로직
        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공",projectId));
    }

    // 프로젝트 자랑 수정
    @PatchMapping("/show/{projectId}")
    public ResponseEntity<?> patchProject(@PathVariable("projectId") int projectId) {
        projectService.patchProject(projectId);
        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공",projectId));
    }

    // 프로젝트 참여 신청
    @PostMapping("/project/join")
    public ResponseEntity<?> projectJoin(@RequestParam("memberId") int memberId, @RequestParam("projectId") int projectId){
        return ResponseEntity.ok().body(new CMRespDto<>(1, "통신성공", projectService.projectJoin(memberId,projectId)));
    }

}
