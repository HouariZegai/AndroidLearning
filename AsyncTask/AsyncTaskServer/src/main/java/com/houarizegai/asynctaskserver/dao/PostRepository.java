package com.houarizegai.asynctaskserver.dao;

import com.houarizegai.asynctaskserver.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
