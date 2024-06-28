package com.mozip.domain.teamnote;

import com.mozip.dto.resp.TeamnoteListDto;

import java.util.List;

public interface TeamnoteRepository {
    // TODO : 다른 기능구현 예정
    List<TeamnoteListDto> findTeamNoteList(int memberId);
}
