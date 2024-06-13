package com.dongduk.HealthPlanet.model.dao.jpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.SportsCategory;
import com.dongduk.HealthPlanet.model.dao.UserDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class JpaUserDao implements UserDao {
    
    @PersistenceContext
    private EntityManager em;
    
    // 내가 참여한 모임 목록 조회
    public List<Post> findParticipationList(int id) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT po.postid, title, schedule, po.state, custid "
                + "FROM CUSTOMER c, POST po, PARTICIPATE pa "
                + "WHERE c.id = pa.id AND po.postid = pa.postid AND c.id = ?1"
                + "ORDER BY state ASC, schedule DESC", Post.class);
        query.setParameter(1, id);
        List<Post> postList = query.getResultList();
        return postList;
    }

    // 나의 찜 목록
    public List<Post> findWishList(int id) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT po.postid, title, schedule, po.state, custid "
                + "FROM CUSTOMER c, POST po, WISH w "
                + "WHERE c.id = w.id AND po.postid = w.postid AND c.id = ?1"
                + "ORDER BY state ASC, schedule DESC", Post.class);
        query.setParameter(1, id);
        List<Post> postList = query.getResultList();
        return postList;
    }
    
    // 내 모임 목록 조회
    public List<Post> findMyPostList(int id) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT postid, title, schedule, custid "
                + "FROM CUSTOMER JOIN POST USING(id) "
                + "WHERE id = ?1 "
                + "ORDER BY state ASC, schedule DESC", Post.class);
        query.setParameter(1, id);
        List<Post> postList = query.getResultList();
        return postList;
    }
    
    // 내 모임 조회
    @Transactional
    public Post findMyPost(int id, int postid) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT * FROM CUSTOMER JOIN POST USING(id) "
                + "WHERE id = ?1 AND postid = ?2", Post.class);
        query.setParameter(1, id);
        query.setParameter(2, postid);
        Post post = (Post) query.getSingleResult();
        
        Query query2 = em.createQuery("SELECT count(*) AS applicant FROM PARTICIPATE "
                + "WHERE postid = ?1 AND state = 1");
        query2.setParameter(1, postid);
        int applicant = (int) query2.getSingleResult();
        post.setApplicant(applicant);
        
        SportsCategory sc = em.find(SportsCategory.class, post.getEvent());
        post.setSportname(sc.getSportname());
        
        return post;
    }
    
    // 내 모임 수정(수정하기 버튼 -> 수정페이지)
    public Post findUpdatePost(int postid) throws DataAccessException {
        return em.find(Post.class, postid);
    }
    
    // 내 모임 수정(수정페이지 -> 수정완료)
    public void UpdatePost(Post post) throws DataAccessException {
        em.merge(post);
    }
    
    // 내 모임 삭제
    public void deletePost(int postid) throws DataAccessException {
        Post post = em.find(Post.class, postid);
        em.remove(post);
    }
    
}
