package com.mozip.web.api;

import com.mozip.config.auth.PrincipalDetails;
import com.mozip.dto.CMRespDto;
import com.mozip.dto.req.member.UpdateMypageEditDto;
import com.mozip.handler.ex.CustomValidationException;
import com.mozip.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class ApiMemberController {

    private final MemberService memberService;

    // 회원정보 수정
    @PostMapping("/api/member/edit")
    public ResponseEntity<?> memberEdit(@Valid @RequestBody UpdateMypageEditDto updateMypageEditDto,
                                        BindingResult bindingResult) {
        memberService.updateMemberInfo(updateMypageEditDto);
        return ResponseEntity.ok().body(new CMRespDto<>(1, "통신성공", null));
    }

    // 회원프로필 이미지
    @PostMapping("/api/member/profile")
    public ResponseEntity<?> profileImg(@RequestParam("file") MultipartFile file,
                                        @AuthenticationPrincipal PrincipalDetails principalDetails) {
        // 이미지가 첨부되지 않았다면 에러
        if (file.isEmpty() || file == null) {
            throw new CustomValidationException("이미지가 첨부되지 않았습니다", null);
        }
        memberService.profileImageUpload(file, principalDetails.getMember().getId()); // 이미지 저장
        return ResponseEntity.ok().body(new CMRespDto<>(1, "통신성공", null));
    }
}
