package com.mozip.domain.keep;

import org.apache.ibatis.annotations.Param;

public interface KeepRepository {
    // 북마크 하기
    void addBookmark(@Param("dto") Keep dto);

    // 북마크 취소
    void deleteBookmark(@Param("dto") Keep dto);

    // 사용자가 해당 프로젝트에 북마크를 누른적이 있는지 체크
    int checkBookmark(@Param("projectId") int projectId, @Param("memberId") int memberId);

    // 현재까지 저장되어있는 북마크 가져와서 띄우기
    int keepCount(@Param("projectId") int projectId, @Param("memberId") int memberId);

}
