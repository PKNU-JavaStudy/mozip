package com.mozip.domain.keep;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Keep {
    private int id;
    private int memberId;
    private int projectId;
}
