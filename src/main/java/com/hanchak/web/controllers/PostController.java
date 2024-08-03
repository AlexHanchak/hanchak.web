package com.hanchak.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanchak.web.entity.Post;
import com.hanchak.web.services.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController {

	@Autowired
    private final PostService postService;

    @PostMapping("/save_post")
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }
}
