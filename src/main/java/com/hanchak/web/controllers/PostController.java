package com.hanchak.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hanchak.web.entity.Post;
import com.hanchak.web.services.PostService;


@RestController
@RequestMapping("/")
@CrossOrigin("http://192.168.2.151:3000")
public class PostController {
    
    @Autowired
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create_post")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @GetMapping("post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

@PutMapping("/post/{id}")
public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
    Post existingPost = postService.getPostById(id);
    if (existingPost == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Возвращаем 404, если пост не найден
    }
    post.setId(id); // Устанавливаем ID для обновляемого поста
    Post updatedPost = postService.updatePost(post);
    return ResponseEntity.ok(updatedPost);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
