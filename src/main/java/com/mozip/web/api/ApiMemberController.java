package com.mozip.web.api;

import com.mozip.dto.CMRespDto;
import com.mozip.dto.req.UpdateMypageEditDto;
import com.mozip.handler.ex.CustomValidationException;
import com.mozip.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class ApiMemberController {

    private final MemberService memberService;

    // 회원정보 수정
    @PostMapping("/api/member/edit")
    public ResponseEntity<?> memberEdit(@ModelAttribute UpdateMypageEditDto updateMypageEditDto,
                                  @RequestParam("file") MultipartFile file){
        // 이미지가 첨부되지 않았다면 에러
        if(file.isEmpty()){
            throw new CustomValidationException("이미지가 첨부되지 않았습니다", null);
        }
        memberService.updateMemberInfo(updateMypageEditDto);
        memberService.profileImageUpload(file, updateMypageEditDto.getMemberId()); // 이미지 저장

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공", null));
    }
}
