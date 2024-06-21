

package com.dongduk.HealthPlanet.dao.jpa;

import java.util.List;
import java.util.Arrays;

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

    private static final List<String> ALLOWED_SORT_FIELDS = Arrays.asList("view", "wish");

    public List<Post> findPopularPreviewList(String sort, int count) throws Exception {
        if (!ALLOWED_SORT_FIELDS.contains(sort)) {
            throw new IllegalArgumentException("Invalid sort field: " + sort);
        }

        String queryString = "select p from Post p where p.state = 1 order by p." + sort + " desc";
        TypedQuery<Post> query = em.createQuery(queryString, Post.class);
        query.setMaxResults(count);

        return query.getResultList();
    }
}








