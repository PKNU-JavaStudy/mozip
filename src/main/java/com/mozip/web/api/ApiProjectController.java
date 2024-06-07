package com.mozip.web.api;

import com.mozip.dto.CMRespDto;
import com.mozip.dto.req.ProjectCreateDto;
import com.mozip.dto.req.ProjectLikeDto;
import com.mozip.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ApiProjectController {
    private final ProjectService projectService;

    @PostMapping("/project/create")
    public ResponseEntity<?> createProject(@RequestBody ProjectCreateDto dto) {
        int projectId = projectService.createProject(dto);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공",projectId));
    }

    // 좋아요, 좋아요 취소 구분하여 처리
    @PostMapping("/like")
    public ResponseEntity<?> likeProject(@RequestBody ProjectLikeDto projectLikeDto){
        projectService.likeValidation(projectLikeDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공", projectService.likeCount(projectLikeDto.getProjectId())));
    }
}
