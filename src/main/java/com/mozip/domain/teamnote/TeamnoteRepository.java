package com.mozip.domain.teamnote;

import com.mozip.dto.resp.TeamnoteListDto;

import java.util.List;

public interface TeamnoteRepository {
    // 팀노트 : 리스트 가져오기
    List<TeamnoteListDto> findTeamNoteList(int memberId);
}
