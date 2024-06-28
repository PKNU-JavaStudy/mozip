package com.mozip.service;

import com.mozip.domain.likes.Likes;
import com.mozip.domain.likes.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;


    /**
     * <h3>좋아요 및 좋아요 취소 메서드</h3>
     * <li>프로젝트 ID 와 유저ID를 통해 좋아요를 눌렀는지 검증 후 실행 및 취소</li>
     * @param likes
     * @return int
     */
    @Transactional
    public int likeValidation(Likes likes) {
        // 좋아요를 누른 기록에 projectId와 memberId가 존재하지 않으면
        if (likesRepository.checkLike(likes.getProjectId(), likes.getMemberId()) != 0) {
            likesRepository.deleteLike(likes);
            return -1; // 좋아요 취소
        } else {
            likesRepository.addLike(likes);
            return 1; // 좋아요
        }
    }

    /**
     * <h3>좋아요 갯수 가져오는 메서드</h3>
     * <li>프로젝트ID를 통해 해당 프로젝트 좋아요갯수를 가져온다.</li>
     * @param projectId
     * @return int
     */
    public int likeCount(int projectId) {
        return likesRepository.likeCount(projectId);
    }
}
