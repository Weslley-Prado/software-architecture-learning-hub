package com.weslleyprado.restapiapplication;

import com.weslleyprado.restapiapplication.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable String id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public String createArticle(@RequestParam String content) {
        return articleService.createArticle(content);
    }

    @PostMapping("/{id}/commentary")
    public String createCommentary(@PathVariable String id, @RequestParam String content) {
        return articleService.createCommentary(content, id);
    }
}
