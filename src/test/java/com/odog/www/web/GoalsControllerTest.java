package com.odog.www.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odog.www.domain.goals.Goals;
import com.odog.www.domain.goals.GoalsRepository;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import com.odog.www.web.dto.StateUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    public void save_Test() throws Exception {
        //given
        String text = "test_text";
        String state = "goals";
        String userId = "test_user";
        String url = "http://localhost:"+port+"/goals";
        GoalsSaveRequestDto goals = GoalsSaveRequestDto.builder()
                .state(state)
                .userId(userId)
                .text(text)
                .build();
        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(goals)))
                .andExpect(status().isOk());
        //then
        List<Goals> response = goalsRepository.findAll();

        assertThat(response.get(0).getId()).isEqualTo(1);
        assertThat(response.get(0).getText()).isEqualTo("test_text");
    }

    @Test
    public void stateUpdate_Test() throws Exception {
        //given
        String text = "test_text";
        String state = "goal";
        String userId = "test_user";
        String url = "http://localhost:"+port+"/goals/state/";
        String state2 = "success";
        Goals savedGoal = goalsRepository.save(Goals.builder()
                .text(text)
                .state(state)
                .userId(userId)
                .build());

        Long id = savedGoal.getId();

        StateUpdateRequestDto dto = StateUpdateRequestDto.builder()
                .state(state2)
                .build();
        //when
        mvc.perform(put(url+id)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(dto))
                ).andExpect(status().isOk());

        //then
        Goals response = goalsRepository.findById(id).orElseThrow();
        assertThat(response.getState()).isEqualTo(state2);
    }

    @Test
    public void delete_Test() throws Exception {
        //given
        String text = "test_text";
        String state = "goal";
        String userId = "test_user";
        String url = "http://localhost:"+port+"/goals/";
        Goals savedGoal = goalsRepository.save(Goals.builder()
                .text(text)
                .state(state)
                .userId(userId)
                .build());

        Long id = savedGoal.getId();

        //when
        mvc.perform(delete(url+id))
                .andExpect(status().isOk());

        List<Goals> response = goalsRepository.findAll();
        assertThat(response.size()).isEqualTo(0);
    }

}
