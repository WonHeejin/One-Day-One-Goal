package com.odog.www.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odog.www.domain.goals.Goals;
import com.odog.www.domain.goals.GoalsRepository;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoalsControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    private GoalsRepository goalsRepository;

    @Before
    public void mock_setup() { //MockMvc 인스턴스 생성
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @After
    public void deleteAll() { //테스트 데이터 삭제
        goalsRepository.deleteAll();
        System.out.println("테스트 데이터 삭제 완료");
    }

    @Test
    public void saveAll_Test() throws Exception {
        //given
        List<GoalsSaveRequestDto> list = new ArrayList<>();
        String text = "test_text";
        String state = "goals";
        String userId = "test_user";
        String url = "http://localhost:"+port+"/goals";
        int i = 10;
        while (i --> 0) { //9~0까지
            GoalsSaveRequestDto goals = GoalsSaveRequestDto.builder()
                    .state(state)
                    .userId(userId + i)
                    .text(text + i)
                    .build();
            list.add(goals);
        }
        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(list)))
                .andExpect(status().isOk());
        //then
        List<Goals> response = goalsRepository.findAll();
        assertThat(response.get(0).getText()).isEqualTo("test_text9");
    }

}
