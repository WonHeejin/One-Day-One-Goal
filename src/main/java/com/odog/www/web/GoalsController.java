package com.odog.www.web;

import com.odog.www.service.goals.GoalsService;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GoalsController {

    private final GoalsService goalsService;

    @ResponseBody
    @PostMapping("/goals")
    public String save(@RequestBody List<GoalsSaveRequestDto> requestDto) {
        return goalsService.save(requestDto)+"개 저장 완료";
    }
}
