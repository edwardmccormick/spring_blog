package com.codeup.springboot_blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

@GetMapping("/posts")
    public String index(Model model) {
//    List<Post> posts = new ArrayList<>();
//    for (int i = 1; i<5; i++) {
//        posts.add(new Post(i, "Here's a title for this one", "Here's a bunch of text for it"
//
//        ));
//        model.addAttribute("posts", posts);
//    }
    List<Post> posts = postDao.findAll();
    Collections.reverse(posts);
    model.addAttribute("posts", posts);
    return "posts/index";
}

@GetMapping("posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
//    Post post = new Post(id, "Here's a title for this detailed view", "Here's a bunch of text for it as well!");
//    model.addAttribute("post", post);
//    model.addAttribute("post", postDao.findAllById(id);
    model.addAttribute("post", postDao.getOne(id));
    return "posts/show";
}

@PostMapping("posts/delete")
    public String deleteIndividualPost(@RequestParam(name = "id") long id, Model model) {
    postDao.deleteById(id);
    System.out.println("id = " + id);
    model.addAttribute("alert", "<div class=\"alert alert-success\" role=\"alert\">\n" +
            "  The post was successfully deleted. </div>");
    return "redirect:/posts";
    }

@GetMapping("/posts/create")
    public String createRender(Model model) {
    return "posts/create";
}

@PostMapping("/posts/create")
    public String createToDatabase(Model model) {
    model.addAttribute("alert", "<div class=\"alert alert-success\" role=\"alert\">\n" +
            "  The post was added successfully.</div>");
    return "redirect:/posts";
}


@GetMapping("/edit/{id}")
    public String editIndividualPost ( @PathVariable long id, Model model){
    model.addAttribute("post", postDao.getOne(id));
    return "posts/edit";
    }

@PostMapping("/edit")
    public String editSaveIndividualPost(@RequestParam(name = "id") long id, @RequestParam(name = "title") String title,
                                         @RequestParam(name = "body") String body, Model model) {
//    postDao.
        model.addAttribute("alert", "<div class=\"alert alert-success\" role=\"alert\">\n" +
            "  The post was successfully updated. </div>");
        return "redirect:/posts";
}

}