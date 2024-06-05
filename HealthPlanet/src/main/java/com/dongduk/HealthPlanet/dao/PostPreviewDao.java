package com.dongduk.HealthPlanet.dao;

import java.util.List;

import com.dongduk.HealthPlanet.domain.PostPreview;

public interface PostPreviewDao {
    List<PostPreview> findPopularPreviewList(String sort) throws Exception;
}
