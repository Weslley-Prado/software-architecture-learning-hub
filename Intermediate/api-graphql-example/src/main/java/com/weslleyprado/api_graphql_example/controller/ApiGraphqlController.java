package com.weslleyprado.api_graphql_example.controller;

import com.weslleyprado.api_graphql_example.dtos.ArticleData;
import com.weslleyprado.api_graphql_example.dtos.CommentaryAboutArticle;
import com.weslleyprado.api_graphql_example.service.ArticleService;
import com.weslleyprado.api_graphql_example.service.CommentaryAboutArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
class ApiGraphqlController{

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentaryAboutArticleService commentaryAboutArticleService;

    @QueryMapping
    public ArticleData articleById(@Argument String id){
        return articleService.articleById(id);
    }

    @MutationMapping
    public Collection<ArticleData> createArticleData(@Argument String content){
        return  articleService.createArticleData(content);
    }

    @MutationMapping
    public Collection<CommentaryAboutArticle> createCommentaryAboutArticle(@Argument String content, @Argument String articleId){
        return commentaryAboutArticleService.createCommentaryAboutArticle(content, articleId);
    }

    @SchemaMapping
    public Collection<CommentaryAboutArticle> commentary(ArticleData articleData){
        return commentaryAboutArticleService.findByArticleData(articleData.id());
    }
}