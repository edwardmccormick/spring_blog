package com.codeup.springboot_blog;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

//    Post deletePostById(long id);
//@Query("from Posts p where p.")

//@SQLUpdate()

}
