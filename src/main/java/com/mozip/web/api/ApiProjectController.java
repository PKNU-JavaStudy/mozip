package com.mozip.web.api;

import com.mozip.dto.CMRespDto;
import com.mozip.dto.req.ProjectCreateDto;
import com.mozip.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

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

}
