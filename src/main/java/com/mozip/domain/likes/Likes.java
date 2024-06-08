package com.mozip.domain.likes;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Likes {
    private int id;
    private int memberId;
    private int projectId;
}
