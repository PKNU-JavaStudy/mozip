package com.mozip.service;

import com.mozip.domain.project.ProjectRepository;
import com.mozip.domain.teamnote.TeamnoteRepository;
import com.mozip.dto.resp.TeamnoteListDto;
import com.mozip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TeamService {
    // TODO : 추후 구현기능이 수정.
    private final TeamnoteRepository teamnoteRepository;

    public List<TeamnoteListDto> findTeamNoteList(int memberId) {
        List<TeamnoteListDto> teamNoteList = teamnoteRepository.findTeamNoteList(memberId);
        for (TeamnoteListDto teamnoteListDto : teamNoteList) {
            teamnoteListDto.setProjectInfo(teamnoteListDto.getProjectInfo());
        }
        return teamNoteList;
    }
}
