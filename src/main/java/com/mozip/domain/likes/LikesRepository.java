package com.mozip.domain.likes;

import com.mozip.dto.req.ProjectLikeDto;
import org.apache.ibatis.annotations.Param;

public interface LikesRepository {
    // 좋아요
    void addLike(@Param("dto") Likes dto);

    // 좋아요 취소
    void deleteLike(@Param("dto") Likes dto);

    // 사용자가 해당 프로젝트에 좋아요를 누른적이 있는지 체크
    int checkLike(@Param("projectId") int projectId, @Param("memberId") int memberId);

    // 현재까지 저장되어있는 좋아요 개수 가져오기
    int likeCount(@Param("projectId") int projectId);
}
