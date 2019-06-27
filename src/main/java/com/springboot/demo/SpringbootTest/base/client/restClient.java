package com.springboot.demo.SpringbootTest.base.client;

import com.springboot.demo.SpringbootTest.base.pojo.User;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


public class restClient {
    public static void main(String[] args) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient=httpClientBuilder.build();
        HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate rest=new RestTemplate(factory);
       // String content=rest.getForObject("http://localhost:8080/json/user",String.class);

        User user=rest.getForObject("http://localhost:8080/json/user",User.class);
        System.out.println( user);


    }
}
