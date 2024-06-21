
package com.dongduk.HealthPlanet.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.HealthPlanet.domain.Post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import com.dongduk.HealthPlanet.dao.UserDao;

@Repository
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private PostRepository postRepository;

    // 내가 참여한 모임 목록 조회
    @Override
    public List<Post> findParticipationList(int id) throws DataAccessException {
        TypedQuery<Post> query = em.createQuery("SELECT new com.dongduk.HealthPlanet.domain.Post(po.postid, po.title, po.schedule, po.state, c.custid) "
                + "FROM Customer c "
                + "JOIN Participate pa ON c.id = pa.id "
                + "JOIN Post po ON po.postid = pa.postid "
                + "WHERE c.id = ?1 "
                + "ORDER BY po.state ASC, po.schedule DESC", Post.class);
        query.setParameter(1, id);
        List<Post> postList = query.getResultList();
        return postList;
    }

    // 나의 찜 목록
    @Override
    public List<Post> findWishList(int id) throws DataAccessException {
        // 예제 구현: 필요에 따라 수정
        TypedQuery<Post> query = em.createQuery("SELECT new com.dongduk.HealthPlanet.domain.Post(po.postid, po.title, po.schedule, po.state, c.custid) "
                + "FROM Customer c, Post po, Wish w "
                + "WHERE c.id = w.id AND po.postid = w.postid AND c.id = ?1 "
                + "ORDER BY po.state ASC, po.schedule DESC", Post.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    // 내 모임 목록 조회
    @Override
    public List<Post> findMyPostList(int id) throws DataAccessException {
        // 예제 구현: 필요에 따라 수정
        return postRepository.findMeetings(1, "morning", 10, 1000);
    }

    // 내 모임 조회
    @Override
    @Transactional
    public Post findMyPost(int id, int postid) throws DataAccessException {
        // 예제 구현: 필요에 따라 수정
        List<Post> posts = postRepository.findMeetings(1, "morning", 10, 1000);
        return posts.isEmpty() ? null : posts.get(0);
    }

    // 내 모임 수정(수정하기 버튼 -> 수정페이지)
    @Override
    public Post findUpdatePost(int postid) throws DataAccessException {
        return postRepository.findById(postid).orElse(null);
    }

    // 내 모임 수정(수정페이지 -> 수정완료)
    @Override
    public void UpdatePost(Post post) throws DataAccessException {
        postRepository.save(post);
    }

    // 내 모임 삭제
    @Override
    public void deletePost(int postid) throws DataAccessException {
        postRepository.deleteById(postid);
    }
}

