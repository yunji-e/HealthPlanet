package com.dongduk.HealthPlanet.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.dao.PostPreviewDao;
import com.dongduk.HealthPlanet.domain.Post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class JpaPostPreviewDao implements PostPreviewDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Post> findPopularPreviewList(String sort, int count) throws Exception{
        TypedQuery<Post> query = em.createQuery(
                "select p from Post p "+
                "where p.state = 1 AND rownum <= ?1"+
                "order by ?2 desc", Post.class);
        query.setParameter(1, count);
        query.setParameter(2, sort);
        
        return query.getResultList();
    }
}
