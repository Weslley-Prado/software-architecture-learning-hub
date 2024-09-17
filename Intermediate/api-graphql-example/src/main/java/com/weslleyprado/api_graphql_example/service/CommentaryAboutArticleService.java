package com.weslleyprado.api_graphql_example.service;
import com.weslleyprado.api_graphql_example.dtos.CommentaryAboutArticle;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentaryAboutArticleService{
    Map<String, CommentaryAboutArticle> commentaryAboutArticle = new HashMap();

    //Method to create the article
    public Collection<CommentaryAboutArticle> createCommentaryAboutArticle(String content, String articleId){
        var newCommentaryAboutArticle = new CommentaryAboutArticle(UUID.randomUUID().toString(), content, articleId);
        commentaryAboutArticle.put(newCommentaryAboutArticle.id(), newCommentaryAboutArticle);
        return commentaryAboutArticle.values();
    }

    //Method to find the article
    public Collection<CommentaryAboutArticle> findByArticleData(String articleId){
        return commentaryAboutArticle.values()
                .stream()
                .filter(commentary -> commentary
                        .articleId().equals(articleId))
                .toList();
    }
}