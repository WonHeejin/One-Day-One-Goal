package com.odog.www.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class IndexControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void goalSave_페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/goal/save", String.class);

        //then
        assertThat(body).contains("오늘의");
    }
}
