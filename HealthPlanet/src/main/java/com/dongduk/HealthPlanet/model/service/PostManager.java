package com.dongduk.HealthPlanet.model.service;

import java.sql.SQLException;

import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.dao.postDAO;

public class PostManager {
    private static PostManager postMan = new PostManager();
    private postDAO postDAO;
    
    private PostManager() {
        try {
            postDAO = new postDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static PostManager getInstance() {
        return postMan;
    }
    
    // 모임 조회
    public Post findPost(int postid) throws SQLException {
        return postDAO.findPost(postid);
    }
    
    // 모임 신청
    public int participatePost(int id, int postid) throws SQLException {
        return postDAO.participatePost(id, postid);
    }
    
    // 모임 신청 취소
    public int cancelPost(int id, int postid) throws SQLException {
        return postDAO.cancelPost(id, postid);
    }
    
    // 찜하기
    public int addWish(int id, int postid) throws SQLException {
        return postDAO.addWish(id, postid);
    }
    
    // 찜 삭제
    public int deleteWish(int id, int postid) throws SQLException {
        return postDAO.deleteWish(id, postid);
    }
}