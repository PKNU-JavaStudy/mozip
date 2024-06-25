package com.mozip.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginDto {

    @NotBlank(message = "이메일은 필수입니다!")
    @Email
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다!")
    @Size(min = 5, max = 80)
    private String password;
}
