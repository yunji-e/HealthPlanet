package com.dongduk.HealthPlanet.dao;

import java.util.List;

import com.dongduk.HealthPlanet.domain.Post;

public interface PostPreviewDao {
    List<Post> findPopularPreviewList(String sort, int count) throws Exception;
}
