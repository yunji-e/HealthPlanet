package com.dongduk.HealthPlanet.dao.jpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.domain.SportsCategory;
import com.dongduk.HealthPlanet.dao.UserDao;

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
    @Override
    public List<Post> findParticipationList(int id) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT po FROM Post po JOIN Participate pa ON po.postid = pa.postid WHERE pa.id = :id ORDER BY po.state ASC, po.schedule DESC", Post.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    // 나의 찜 목록
    @Override
    public List<Post> findWishList(int id) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT po FROM Post po JOIN Wish w ON po.postid = w.postid WHERE w.id = :id ORDER BY po.state ASC, po.schedule DESC", Post.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    // 내 모임 목록 조회
    @Override
    public List<Post> findMyPostList(int id) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT po FROM Post po WHERE po.custid = :id ORDER BY po.state ASC, po.schedule DESC", Post.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    // 내 모임 조회
    @Override
    @Transactional
    public Post findMyPost(int id, int postid) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT po FROM Post po WHERE po.custid = :id AND po.postid = :postid", Post.class);
        query.setParameter("id", id);
        query.setParameter("postid", postid);
        Post post = query.getSingleResult();

        Query query2 = em.createQuery("SELECT count(p) FROM Participate p WHERE p.postid = :postid AND p.state = 1");
        query2.setParameter("postid", postid);
        long applicant = (long) query2.getSingleResult();
        post.setApplicant((int) applicant);

        SportsCategory sc = em.find(SportsCategory.class, post.getEvent());
        post.setSportname(sc.getSportname());

        return post;
    }

    // 내 모임 수정(수정하기 버튼 -> 수정페이지)
    @Override
    public Post findUpdatePost(int postid) throws DataAccessException {
        return em.find(Post.class, postid);
    }

    // 내 모임 수정(수정페이지 -> 수정완료)
    @Override
    public void UpdatePost(Post post) throws DataAccessException {
        em.merge(post);
    }

    // 내 모임 삭제
    @Override
    public void deletePost(int postid) throws DataAccessException {
        Post post = em.find(Post.class, postid);
        if (post != null) {
            em.remove(post);
        }
    }
}

