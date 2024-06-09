package com.mozip.service;

import com.mozip.domain.keep.Keep;
import com.mozip.domain.keep.KeepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class KeepService {
    private final KeepRepository keepRepository;

    // 북마크 수 저장
    @Transactional
    public boolean keepValidation(Keep keep) {
        // 북마크를 누른 기록에 projectId와 memberId가 존재하지 않으면
        if (keepRepository.checkBookmark(keep.getProjectId(), keep.getMemberId()) != 0) {
            keepRepository.deleteBookmark(keep);
            return false; // 북마크 취소
        } else {
            keepRepository.addBookmark(keep);
            return true; // 북마크
        }
    }
    // 북마크 가져오기
    public int keepCount(int projectId, int memberId) {
        return keepRepository.keepCount(projectId, memberId);
    }
}
