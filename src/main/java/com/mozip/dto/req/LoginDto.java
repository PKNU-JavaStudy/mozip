package com.mozip.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginDto {
    private String email;
    private String password;
}
