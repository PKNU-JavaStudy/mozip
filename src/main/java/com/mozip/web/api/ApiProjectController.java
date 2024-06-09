package com.mozip.web.api;

import com.mozip.domain.keep.Keep;
import com.mozip.domain.likes.Likes;
import com.mozip.dto.CMRespDto;
import com.mozip.dto.req.ProjectCreateDto;
import com.mozip.service.KeepService;
import com.mozip.service.LikesService;
import com.mozip.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ApiProjectController {
    private final ProjectService projectService;
    private final LikesService likesService;
    private final KeepService keepService;

    @PostMapping("/project/create")
    public ResponseEntity<?> createProject(@RequestBody ProjectCreateDto dto) {
        int projectId = projectService.createProject(dto);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공",projectId));
    }

    // 좋아요
    @PostMapping("/like")
    public ResponseEntity<?> likeProject(@RequestBody Likes likes){
        // 좋아요, 좋아요 취소 구분하여 처리
        likesService.likeValidation(likes);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공", likesService.likeCount(likes.getProjectId())));
    }

    // 프로젝트 삭제 메서드
    @DeleteMapping("/project/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable("projectId") int projectId) {

        projectService.deleteProject(projectId); // 프로젝트 삭제 로직

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공",projectId));
    }

    // 북마크
    @PostMapping("/keep")
    public ResponseEntity<?> keepProject(@RequestBody Keep keep){
        // 북마크, 북마크 취소 구분하여 처리
        keepService.keepValidation(keep);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공", keepService.keepCount(keep.getProjectId(), keep.getMemberId())));
    }
}
