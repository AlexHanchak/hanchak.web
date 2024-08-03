package com.hanchak.web.services;

import org.springframework.stereotype.Service;

import com.hanchak.web.entity.Post;
import com.hanchak.web.repositories.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
