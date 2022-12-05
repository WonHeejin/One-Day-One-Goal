package com.odog.www.web;

import com.odog.www.service.goals.GoalsService;
import com.odog.www.web.dto.GoalResponseDto;
import com.odog.www.web.dto.GoalsSaveRequestDto;
import com.odog.www.web.dto.StateUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class GoalsController {

    private final GoalsService goalsService;

    @ResponseBody
    @PostMapping("/goals")
    public Long save(@RequestBody GoalsSaveRequestDto requestDto) {
        return goalsService.save(requestDto);
    }

    @ResponseBody
    @PutMapping("/goals/state/{id}")
    public GoalResponseDto update(@PathVariable Long id, @RequestBody StateUpdateRequestDto requestDto) {
        return goalsService.update(id, requestDto);
    }
}
