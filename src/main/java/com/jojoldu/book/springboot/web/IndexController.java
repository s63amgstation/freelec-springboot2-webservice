package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.post.PostsService;
import com.jojoldu.book.springboot.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

/*  @RequiredArgsConstructor를 사용하지 않으면 아래와 같이 생성자를 직접 구현해야 함.

    @Autowired
    public IndexController(PostsService postsService){
        this.postsService = postsService;
    }

*/
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
