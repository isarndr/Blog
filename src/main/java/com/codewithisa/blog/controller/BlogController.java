package com.codewithisa.blog.controller;

import com.codewithisa.blog.entity.Blog;
import com.codewithisa.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/all")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlogById(int id){
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/search-by")
    public ResponseEntity<List<Blog>> searchBlogsBy(@RequestParam String text){
        return new ResponseEntity<>(blogService.searchBlogsBy(text), HttpStatus.OK);
    }

    @PostMapping("/add-blog")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.saveBlog(blog), HttpStatus.CREATED);
    }

    @PutMapping("/update-blog/{id}")
    public ResponseEntity<Blog> updateBlog(int id, @RequestBody Blog blog){
        return new ResponseEntity<>(blogService.updateBlog(id,blog), HttpStatus.OK);
    }

    @DeleteMapping("/delete-blog/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable("id") int id){
        blogService.deleteBlog(id);
        return new ResponseEntity<>("success", HttpStatus.NO_CONTENT);
    }
}
