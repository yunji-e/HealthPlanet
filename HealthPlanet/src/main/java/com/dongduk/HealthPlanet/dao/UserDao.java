package com.dongduk.HealthPlanet.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.HealthPlanet.domain.*;

public interface UserDao {
    
    // 내가 참여한 모임 목록 조회
    public List<Post> findParticipationList(int id) throws DataAccessException;

    // 나의 찜 목록
    public List<Post> findWishList(int id) throws DataAccessException;
    
    // 내 모임 목록 조회
    public List<Post> findMyPostList(int id) throws DataAccessException;
    
    // 내 모임 조회
    public Post findMyPost(int id, int postid) throws DataAccessException;
    
    // 내 모임 수정(수정하기 버튼 -> 수정페이지)
    public Post findUpdatePost(int postid) throws DataAccessException;
    
    // 내 모임 수정(수정페이지 -> 수정완료)
    public void UpdatePost(Post post) throws DataAccessException;
    
    // 내 모임 삭제
    public void deletePost(int postid) throws DataAccessException;
    
}
