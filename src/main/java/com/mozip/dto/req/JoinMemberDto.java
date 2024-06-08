package com.mozip.dto.req;

import lombok.Data;

@Data
public class JoinMemberDto {
    private String email;
    private String password;
    private String username;
    private String phone;
}
