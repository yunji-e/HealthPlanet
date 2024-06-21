package com.dongduk.HealthPlanet.dao.jpa;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.dao.PostDao;
import com.dongduk.HealthPlanet.domain.Participate;
import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.domain.SportsCategory;
import com.dongduk.HealthPlanet.domain.Wish;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class JpaPostDao implements PostDao {
    
    @PersistenceContext
    private EntityManager em;
    
    // 모임 조회
    public Post findPost(int postid) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT p FROM Customer c JOIN Post p ON c.id=p.id "
                + "WHERE p.postid = :postid", Post.class);
        query.setParameter("postid", postid);
        Post post = (Post) query.getSingleResult();
        
        Query query2 = em.createQuery("SELECT count(*) AS applicant FROM Participate "
                + "WHERE postid = ?1 AND state = 1");
        query2.setParameter(1, postid);
        long applicant = (long) query2.getSingleResult();
        post.setApplicant(applicant);
        
//        SportsCategory sc = em.find(SportsCategory.class, post.getEvent());
//        post.setSportname(sc.getSportname());
        
        return post;
    }
    
    //모임 조회(조회수up)
    @Transactional
    public int postViewCountUp(int postid) {
        Query query = em.createQuery("UPDATE Post SET view = view+1 WHERE postid = ?1");
        query.setParameter(1, postid);
        return query.executeUpdate();
    }
    
    // 모임 신청
    @Transactional
    public int participatePost(int id, int postid) throws DataAccessException {
        Participate p = new Participate(postid, id, 1);
        em.persist(p);
        
        Query query = em.createQuery("UPDATE Post SET state = 1 WHERE postid = ?1 "
                + "AND headcount = (SELECT count(*) FROM Participate WHERE postid = ?2)");
        query.setParameter(1, postid);
        query.setParameter(2, postid);
        return query.executeUpdate();
    }
    
    // 모임 신청 취소
    @Transactional
    public int cancelPost(int id, int postid) throws DataAccessException {
        Query query = em.createQuery("DELETE FROM PARTICIPATE WHERE postid = ?1 AND id = ?2");
        query.setParameter(1, postid);
        query.setParameter(2, id);
        query.executeUpdate();
        
        query = em.createQuery("UPDATE POST SET state = 0 WHERE postid = ?1 "
                + "AND headcount > (SELECT count(*) FROM PARTICIPATE WHERE postid = ?2)");
        query.setParameter(1, postid);
        query.setParameter(2, postid);
        return query.executeUpdate();
    }
    
    // 찜하기
    @Transactional
    public int addWish(int id, int postid) throws DataAccessException {
        Wish wish = new Wish(id, postid);
        em.persist(wish);
        
        Query query = em.createQuery("UPDATE Post SET wish = wish + 1 WHERE postid = ?1");
        query.setParameter(1, postid);
        return query.executeUpdate();
    }
    
    // 찜 삭제
    @Transactional
    public int deleteWish(int id, int postid) throws DataAccessException {
        Query query = em.createQuery("DELETE FROM Wish WHERE postid = ?1 AND id = ?2");
        query.setParameter(1, postid);
        query.setParameter(2, id);
        query.executeUpdate();
        
        query = em.createQuery("UPDATE Post SET wish = wish - 1 WHERE postid = ?1 ");
        query.setParameter(1, postid);
        return query.executeUpdate();
    }
    
}
