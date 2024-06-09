package com.mozip.dto.req;

import lombok.Data;

@Data
public class FindEmailDto {
    private String username;
    private String phone;

    public FindEmailDto(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }
}
