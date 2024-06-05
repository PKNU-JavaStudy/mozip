package com.mozip.web.api;

import com.mozip.dto.CMRespDto;
import com.mozip.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ApiProjectController {
    private final ProjectService projectService;

    @GetMapping("/recruit/{projectId}")
    public ResponseEntity<?> recruitDone(@PathVariable("projectId") String projectId) {
        System.out.println("===========================");
        System.out.println("projectId = " + projectId);
        System.out.println("===========================");

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공!",null));
    }
}
