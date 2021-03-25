package com.codeup.springboot_blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
@GetMapping("/posts")
    public String index(Model model) {
    List<Post> posts = new ArrayList<>();
    for (int i = 1; i<5; i++) {
        posts.add(new Post(i, "Here's a title for this one", "Here's a bunch of text for it"

        ));
        model.addAttribute("posts", posts);
    }
    return "posts/index";
}

@GetMapping("posts/{id}")
    public String individualPost(@PathVariable int id, Model model) {
    Post post = new Post(id, "Here's a title for this detailed view", "Here's a bunch of text for it as well!");
    model.addAttribute("post", post);
    return "posts/show";
}

@GetMapping("/posts/create")
    @ResponseBody
    public String createNew() {
    return "This will show the form to create a new post";
}

@PostMapping("/posts/create")
    @ResponseBody
    public String create() {
    return "This will create the new post.";
}

}
