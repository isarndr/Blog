package com.codewithisa.blog.repository;

import com.codewithisa.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from blog where lower(blog.title)  like concat('%',:text,'%') " +
                    "or lower(blog.content) like concat('%',:text,'%')"
    )
    List<Blog> findByTextContaining(@Param("text") String text);
}
