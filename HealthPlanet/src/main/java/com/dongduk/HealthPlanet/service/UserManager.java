package com.dongduk.HealthPlanet.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.dongduk.HealthPlanet.dao.userDAO;
import com.dongduk.HealthPlanet.domain.*;

public class UserManager {
	private static UserManager userMan = new UserManager();
	private userDAO userDAO;

	private UserManager() {
		try {
			userDAO = new userDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	// 내가 참여한 모임 목록 조회
	public List<Post> findParticipationList(int id) throws SQLException {
	    return userDAO.findParticipationList(id);
	}
	
	// 나의 찜 목록
	public List<Post> findWishList(int id) throws SQLException {
	    return userDAO.findWishList(id);
	}

	// 내 모임 목록 조회
	public List<Post> findMyPostList(int id) throws SQLException {
	    return userDAO.findMyPostList(id);
	}
	
	// 내 모임 조회
	public Post findMyPost(int id, int postid) throws SQLException {
	    return userDAO.findMyPost(id, postid);
	}
	
	// 내 모임 수정(수정하기 버튼 -> 수정페이지)
	public Post findUpdatePost(int postid) throws SQLException {
	    return userDAO.findUpdatePost(postid);
	}
	
	// 내 모임 수정(수정페이지 -> 수정완료 버튼)
	public int updatePost(int postid, String title, Date schedule, String time, String place, int headcount, int cost, String body, String sportname) throws SQLException {
	    return userDAO.UpdatePost(postid, title, schedule, time, place, headcount, cost, body, sportname);
	}
	
	// 내 모임 삭제
   public int deletePost(int postId) throws SQLException {
       return userDAO.deletePost(postId);
   }
}
