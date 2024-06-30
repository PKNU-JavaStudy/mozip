package com.mozip.dto.req.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FindEmailDto {

    @NotBlank(message = "이름은 필수입니다!")
    @Size(min = 2, max = 5, message = "이름은 최소 2글자, 최대 5글자 사이입니다.")
    private String username;

    @NotBlank(message = "전화번호는 필수입니다!")
    @Pattern(regexp = "^[0-9]{3}[0-9]{4}[0-9]{4}", message = "전화번호 형식이 잘못되었습니다!")
    private String phone;

    public FindEmailDto(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }
}
