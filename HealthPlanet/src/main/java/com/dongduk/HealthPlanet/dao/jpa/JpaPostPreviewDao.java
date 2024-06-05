package com.dongduk.HealthPlanet.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.dao.PostPreviewDao;
import com.dongduk.HealthPlanet.domain.PostPreview;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class JpaPostPreviewDao implements PostPreviewDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<PostPreview> findPopularPreviewList(String sort) throws Exception{
        TypedQuery<PostPreview> query = em.createQuery(
                "select p from Post p "+
                "where p.state = 1 "+
                "order by 변수sort desc", PostPreview.class);
        //sort기준으로 내림차순 정렬, 상위 n개 조건 추가
        query.setParameter(1, sort);
        
        return query.getResultList();
    }
}
