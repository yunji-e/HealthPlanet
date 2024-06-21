package com.dongduk.HealthPlanet.dao;

import org.springframework.dao.DataAccessException;

import com.dongduk.HealthPlanet.domain.Post;

public interface PostDao {

    // 모임 조회
    public Post findPost(int postid) throws DataAccessException;
    
    // 모임 신청
    public int participatePost(int id, int postid) throws DataAccessException;
    
    // 모임 신청 취소
    public int cancelPost(int id, int postid) throws DataAccessException;
    
    // 찜하기
    public int addWish(int id, int postid) throws DataAccessException;
    
    // 찜 삭제
    public int deleteWish(int id, int postid) throws DataAccessException;
 
}
