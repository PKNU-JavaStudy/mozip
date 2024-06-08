package com.mozip.web.api;

import com.mozip.dto.CMRespDto;
import com.mozip.dto.req.UpdateMypageEditDto;
import com.mozip.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiMemberController {

    private final MemberService memberService;

    @PostMapping("/api/member/edit")
    public ResponseEntity<?> edti(@RequestBody UpdateMypageEditDto updateMypageEditDto){
        System.out.println("===========");
        System.out.println("updateMypageDto = " + updateMypageEditDto);
        System.out.println("===========");
        memberService.updateMemberInfo(updateMypageEditDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"통신성공", null));
    }
}
