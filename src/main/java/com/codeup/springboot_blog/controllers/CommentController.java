package com.codeup.springboot_blog.controllers;

import com.codeup.springboot_blog.daos.CommentRepository;
import com.codeup.springboot_blog.daos.PostRepository;
import com.codeup.springboot_blog.daos.UserRepository;
import com.codeup.springboot_blog.models.Comment;
import com.codeup.springboot_blog.models.Post;
import com.codeup.springboot_blog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private CommentRepository commentDao;
    private PostRepository postDao;

    public CommentController(UserRepository userDao, PasswordEncoder passwordEncoder, CommentRepository commentDao, PostRepository postDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.commentDao = commentDao;
        this.postDao = postDao;
    }

    @PostMapping("/posts/{id}/comment")
//    public String editSaveIndividualPost(@RequestParam(name = "id") long id, @RequestParam(name = "title") String title,
//                                         @RequestParam(name = "body") String body, Model model) {
    public String editSaveComment(@ModelAttribute Comment comment, @PathVariable long id, Model model) {
        if (comment.getComment() == null) {
            return "redirect:/posts/" + id;
        }
        else {

        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setAuthor(author);
        comment.setPost(postDao.getOne(id));
        commentDao.save(comment);
//        model.addAttribute("alert", "<div class=\"alert alert-success\" role=\"alert\">\n" +
//                "  The post was successfully updated. </div>");
        return "redirect:/posts/" + id;
    }}

}
