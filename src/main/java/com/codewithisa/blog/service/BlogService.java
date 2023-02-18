package com.codewithisa.blog.service;

import com.codewithisa.blog.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    List<Blog> getAllBlogs();
    Blog getBlogById(int id);
    List<Blog> searchBlogsBy(String text);
    Blog updateBlog(int id, Blog blog);
    void deleteBlog(int id);
    Blog saveBlog(Blog blog);
}
