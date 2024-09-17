package com.weslleyprado.restapiapplication.config;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "graphqlClient", url = "http://localhost:8080/graphql")
public interface GraphQLClient {

    @PostMapping(consumes = "application/json")
    @Headers("Content-Type: application/json")
    String query(@RequestBody String graphqlQuery);
}
