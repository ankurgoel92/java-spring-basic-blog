package com.pluralsight.blog;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

@Controller
public class BlogController {

  private PostRepository postRepository;

  public BlogController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @RequestMapping("/")
  public String listPosts(final ModelMap map) {
    List<Post> posts = postRepository.getAllPosts();
    map.put("posts", posts);
    return "home";
  }

  @RequestMapping("/post/{id}")
  public String postDetails(@PathVariable final Long id, final ModelMap map) {
    final Post post = postRepository.findById(id);
    map.put("post", post);
    return "post-details";
  }

}
