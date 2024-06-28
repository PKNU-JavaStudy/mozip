package com.mozip.dto.req.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinMemberDto {

    @NotBlank(message = "이메일은 필수입니다!")
    @Email
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다!")
    @Size(min = 5, max = 80)
    private String password;

    @NotBlank(message = "이름은 필수입니다!")
    @Size(min = 2, max = 5)
    private String username;

    @NotBlank(message = "전화번호는 필수입니다!")
    @Pattern(regexp = "^[0-9]{3}[0-9]{4}[0-9]{4}")
    private String phone;
}
