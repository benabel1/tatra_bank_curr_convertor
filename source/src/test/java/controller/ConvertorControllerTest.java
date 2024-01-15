package controller;

import dto.CrossCurrencyRequest;
import dto.CrossCurrencyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import service.ConvertorService;

import java.net.http.HttpRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConvertorControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ConvertorService service;

    @Test
    public void contextLoad() {
        assertThat(service).isNotNull();
    }

//    @Test
//    public void test1(){
//        var a = new HttpEntity<CrossCurrencyRequest>("{" +
//                "}");
//        String url = "localhost:8080/services/rates" ;
//        var aa = restTemplate.exchange(url, HttpMethod.POST, a, CrossCurrencyResponse.class);
//    }
}