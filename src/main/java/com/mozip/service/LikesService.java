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

    // 좋아요 수 저장
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

    // 좋아요 수 가져오기
    public int likeCount(int projectId) {
        return likesRepository.likeCount(projectId);
    }
}
