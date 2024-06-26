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

    /**
     * <h3>북마크 실행 및 취소 메서드</h3>
     * <li>사용자가 북마크를 누른 이력이 있으면 취소, 없으면 북마크를 실행</li>
     * @param keep
     * @return boolean
     */
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

    /**
     * <h3>북마크 갯수 가져오는 메서드</h3>
     * <li>프로젝트ID값을 통해 북마크 갯수를 가져온다.</li>
     * @param projectId
     * @param memberId
     * @return int
     */
    public int keepCount(int projectId, int memberId) {
        return keepRepository.keepCount(projectId, memberId);
    }
}
