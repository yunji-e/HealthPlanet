package com.dongduk.HealthPlanet.dao.jpa;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.dao.PostDao;
import com.dongduk.HealthPlanet.domain.Participate;
import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.domain.SportCategory;
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
        TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p WHERE p.postid = ?1", Post.class);
        query.setParameter(1, postid);
        Post post = (Post) query.getSingleResult();
        
        Query query2 = em.createQuery("SELECT count(p) AS applicant FROM Participate p "
                + "WHERE p.postid = ?1 AND p.state = 1");
        query2.setParameter(1, postid);
//        int applicant = (int) query2.getSingleResult();
//        post.setApplicant(applicant);
        Long applicant = (Long) query2.getSingleResult();
        post.setApplicant(applicant.intValue()); // Long을 int로 변환하여 설정
        
//        SportCategory sc = em.find(SportCategory.class, post.getEvent());
//        post.setSportname(sc.getSportname());
        
        return post;
    }
    
    // 모임 신청
    @Transactional
    public int participatePost(int id, int postid) throws DataAccessException {
        Participate p = new Participate(postid, id, 1);
        em.persist(p);
        
        Query query = em.createQuery("UPDATE POST SET state = 1 WHERE postid = ?1 "
                + "AND headcount = (SELECT count(*) FROM PARTICIPATE WHERE postid = ?2)");
        return query.executeUpdate();
    }
    
    // 모임 신청 취소
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
