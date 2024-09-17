package com.weslleyprado.api_graphql_example.service;
import com.weslleyprado.api_graphql_example.dtos.ArticleData;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ArticleService{
    Map<String, ArticleData> articleData = new HashMap();

    //Method to find the article
    public ArticleData articleById(String id){
        return articleData.get(id);
    }

    //Method to create the article
    public Collection<ArticleData> createArticleData(String content){
        var newArticle = new ArticleData(UUID.randomUUID().toString(), content);
        articleData.put(newArticle.id(), newArticle);
        return articleData.values();
    }
}