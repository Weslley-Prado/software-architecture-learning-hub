package com.weslleyprado.restapiapplication.service;

import com.weslleyprado.restapiapplication.config.GraphQLClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private GraphQLClient graphqlClient;

    public String getArticleById(String id) {
        String query = "{ \"query\": \"{ articleById(id: \\\"" + id + "\\\") { id content commentary { id content } } }\" }";
        return graphqlClient.query(query);
    }

    public String createArticle(String content) {
        String mutation = "{ \"query\": \"mutation { createArticleData(content: \\\"" + content + "\\\") { id content } }\" }";
        return graphqlClient.query(mutation);
    }

    public String createCommentary(String content, String articleId) {
        String mutation = "{ \"query\": \"mutation { createCommentaryAboutArticle(content: \\\"" + content + "\\\", articleId: \\\"" + articleId + "\\\") { id content } }\" }";
        return graphqlClient.query(mutation);
    }
}
