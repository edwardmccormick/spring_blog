package com.codeup.springboot_blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
@GetMapping("/posts")
@ResponseBody
public String index() {
    return "Posts an index page.";
}

@GetMapping("posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id) {
    return "This will show an individual post";
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
