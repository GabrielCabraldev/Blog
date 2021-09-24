package com.br.blogDevs.service;

import com.br.blogDevs.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Integer id);
    Post save (Post post);
}
