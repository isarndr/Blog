package com.codewithisa.blog.service;

import com.codewithisa.blog.entity.Blog;
import com.codewithisa.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> searchBlogsBy(String text) {
        return blogRepository.findByTextContaining(text);
    }

    @Override
    public Blog updateBlog(int id, Blog blog) {
        Blog blogUpdated = blogRepository.findById(id).get();

        blogUpdated.setContent(blog.getContent());
        blogUpdated.setTitle(blog.getTitle());

        return blogRepository.save(blogUpdated);
    }

    @Override
    public void deleteBlog(int id) {

        blogRepository.deleteById(id);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }
}
